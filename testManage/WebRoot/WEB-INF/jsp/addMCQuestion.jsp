<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-81">
<title>添加多选题</title>
 <script src="js/jquery.min.js"></script>
 <script src="js/bootstrap.min.js"></script>
  <script src="js/bootstrap-select.js"></script>
 <link href="css/bootstrap.min.css" rel="stylesheet">
  <script type="text/javascript">
  		/* 根据所选择的科目，查找该科目下的课程列表，并显示在select里*/
		function change(id){	    	
    		var code = $("#addSubject").val();
    		//alert(code);
    		$.ajax({
	       	   method:"post",
	         	url:"/testManage/getCourses.action",
	         	data:{"data":code},
			 	dataType:'json',
	       	   	success:function (res) {
	       	   		if(res.length == 0){
                        //如果一级没有对应的二级 则清空二级并 不往下执行
                       
                        $("#addCourse").empty();
                        $("#addCourse").selectpicker("refresh");
                        return ;
                   	 }
                   	// alert(res.length);
	          		 var str="";
	           	  	for (var i = 0; i < res.length; i++) {
	            	 	  str+="<option value='"+res[i].c_id+"'>"+res[i].c_name+"</option>";
	         	 	 } 
	           	  $("#addCourse").append(str);
	          	  $("#addCourse").find("option[text='--请选择--']").attr("selected",true);
	          }
	   	 });
    	}
    	/* 当科目改变时，获取该科目下的章节列表，给对应的下拉框赋值 */
    	function changeBook(id){
    		var kemu=$("#addCourse").val();
    		//alert(kemu);
    		$.ajax({
	       	   method:"post",
	         	url:"/testManage/getChapters.action",
	         	data:{"data":kemu},
			 	dataType:'json',
	       	   	success:function (res) {
	       	   		if(res.length == 0){
                        //如果一级没有对应的二级 则清空二级并 不往下执行
                        $("#addChapter").empty();
                        return ;
                   	 }
                  // 	 alert(res.length);
	          		 var str="";
	           	  	for (var i = 0; i < res.length; i++) {
	            	 	  str+="<option value='"+res[i].ct_id+"'>"+res[i].ct_name+"</option>";
	         	 	 } 
	           	  $("#addChapter").append(str);
	          	  $("#addChapter").find("option[text='--请选择--']").attr("selected",true);
	          }
	   	 });
    	}
    	
    	
    		
    	/*用户点击添加选项*/
    	function addXuanXiang(){
    		//alert($("#choices").children().length);
    		var choiceNum=$("#choices").children().length;
    		var str="";
    		str+=" <div class='form-group'>"+
    			"<label for='text' class='col-md-2 control-label'>选项"+(choiceNum+1)+"</label>"+
    			"<div class='col-md-8'>"+
    			"<input type='text' class='form-control'>"+
    			"</div>"+
    			"<div class='col-md-2'></div>";
    		$("#choices").append(str);
    		
		}	
		/*单选试题的提交*/
		function submitAll(){
    		var stem=$("#SCStem").val();	
    		var str="";
   			$("#choices").find("input").each(function(){
    			str+=this.value+"@@";
    		});
    		var option=str;
    		var answer=$("#answer").val();
    		var analysis=$("#analysis").val();	
    		var subject=$("#addSubject").val();
    		var c_id=$("#addCourse").val();
    		var ct_id=$("#addChapter").val();
    		var point=$("#point").val();
		   var data={mc_subject:subject,mc_point:point,mc_stem:stem,mc_option:option,mc_answer:answer,mc_analysis:analysis,mc_c_id:c_id,mc_ct_id:ct_id};
		   	$.ajax({
		       	   method:"post",
		         	url:"/testManage/addMCQuestion.action",
		         	contentType: 'application/json; charset=UTF-8',
		         	data:JSON.stringify(data),
				 	dataType:'json',
		       	   	success:function (data) {
		       	   		if(data.result=="yes"){
							alert("添加成功");
							self.location.reload();
						}else{
							alert("保存失败");
					    }
		         	 }
		   	 });
		   	 
    		
		   	
    	}	  
    	
 </script>	
</head>
<body >
	<!-- 从session获取科目种类 -->
	<div>
	<div>
	<hr>
	<ul class="breadcrumb">
    <li><a href="#">我的题库</a></li>
    <li><a href="#">上传试题</a></li>
    <li class="active">添加多选题</li>
	</ul>
		<div class="panel panel-default">
			<div class="panel-body">
				<div>
					
				</div>
				<form class="form-horizontal" id="totalForm">
				
					 <div class="form-group">
						<label class=" col-md-2 control-label">科目</label> 
						<div class="col-md-8">
						<!-- 一级下拉框 -->
						<select	class=" form-control " id="addSubject" name="subject" onchange="change(this.id)">
							<option value="">--请选择--</option>
							<c:forEach items="${sessionScope.SUBJECTS_SESSION}" var="item">
								<option	 value="${item.s_id}">${item.s_name}</option>
							</c:forEach>
						</select>
						</div>
						 <div class="col-md-2">
						 	
				   		 </div>
						
					</div>
					<div class="form-group">
						<label class=" col-md-2 control-label">课程</label> 
						<div class="col-md-8">
						<!-- 二级下拉框 -->
						<select id="addCourse"	class=" form-control " id="addCourse" name="Course" onchange="changeBook(this.id)">
							<option value="">--请选择--</option>
						</select>
						</div>
						<div class="col-md-2">
						 <div id ="addChoice" class="btn btn-default btn-md"  data-toggle="modal" data-target="#myModal"  role="button">
				    		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
				    	</div>
				   		添加课程
				   		
				   		</div>
					</div>
					 
					<div class="form-group">
						<label   for="text" class=" col-md-2 control-label">选择章节</label> 
						<div class="col-md-8">
						<!-- 一级下拉框 -->
						<select id="addChapter"	class=" form-control"  >
							<option value="">--请选择--</option>
						</select>
						</div>
						<div class="col-md-2">
							 
				    	</div>
				    </div>
				
				  <div class="form-group">
				    <label for="stem" class="col-md-2 control-label">请填写题目</label>
				   
				     <div class="col-md-8">
				       <textarea id="SCStem" class="form-control" rows="3"></textarea>
				    </div>
				    <div class="col-md-2"></div>
				  </div>
				 
				  <div id="choices"><!-- -------选项开始 -->
				  <div class="form-group">
				    <label for="text" class="col-md-2 control-label">选项1</label>
				    <div class="col-md-8">
				      <input type="text" class="form-control"  placeholder="">
				    </div>
				    <div class="col-md-2"></div>
				  </div>
				  <div class="form-group">
				    <label for="text" class="col-md-2 control-label">选项2</label>
				    <div class="col-md-8">
				      <input type="text" class="form-control"  placeholder="">
				    </div>
				    <div class="col-md-2"></div>
				  </div>
				   <div class="form-group">
				    <label for="text" class="col-md-2 control-label">选项3</label>
				    <div class="col-md-8">
				      <input type="text" class="form-control"  placeholder="">
				    </div>
				    <div class="col-md-2"></div>
				  </div>
				   <div class="form-group">
				    <label for="text" class="col-md-2 control-label">选项4</label>
				    <div class="col-md-8">
				      <input type="text" class="form-control"  placeholder="">
				    </div>
				    <div class="col-md-2">
				    	<a id ="addClick" class="btn btn-default btn-md"   onclick="addXuanXiang()">
				    		<span class="glyphicon glyphicon-plus" ></span>添加选项
				    	</a>
				   		
				    </div>
				    
				  </div>
				  </div><!-- /选项结束 -->
				  <div class="form-group">
				    <label for="text" class="col-md-2 control-label">正确答案：</label>
				    <div class="col-md-8">
				      <input id="answer" type="text" class="form-control"  placeholder="">
				    </div>
				    <div class="col-md-2"></div>
				  </div>
				  
				  <div class="form-group">
				    <label for="stem" class="col-md-2 control-label">答案解析：</label>
				   
				     <div class="col-md-8">
				       <textarea id="analysis" class="form-control" rows="3"></textarea>
				    </div>
				    <div class="col-md-2"></div>
				  </div>
				   <div class="form-group">
				    <label for="stem" class="col-md-2 control-label">考查知识点：</label>
				   
				     <div class="col-md-8">
				       <textarea id="point" class="form-control" rows="2"></textarea>
				    </div>
				    <div class="col-md-2"></div>
				  </div>
				  <!-- <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <div class="checkbox">
				        <label>
				          <input type="checkbox"> Remember me
				        </label>
				      </div>
				    </div>
				  </div> -->
				 
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <a type="" class="btn btn-default" onclick="submitAll()">保存</a>
				    </div>
				  </div>
				  <!-- -----------------------------添加课程的模态框---------------------------------------------- -->
				   			<div class="modal fade" id="myModal"  tabindex="-1" role="diaog" aria-labelledby="myModalLabel" aria-hidden="true">
				   				
				   				<div class="modal-dialog">
				   					<div class="modal-content">
				   						<div class="modal-header">
				   							<button type="button" class="close" data-dismiss="modal"  aria-hidden="true">&times;</button>
				   							<h5 class="modal-title" id="myModalLabel">添加课程</h5>
				   						</div>
				   						<div class="modal-body">
				   						<form class="form-horizontal" role="form" id="addTB">
				   								<div class="form-group">
													<label class=" col-md-2 control-label">科目</label> 
													<div class="col-md-8">
													<!-- 一级下拉框 -->
													<select	class=" form-control " id="addSubject2" name="subject" ">
														<option value="">--请选择--</option>
														<c:forEach items="${sessionScope.SUBJECTS_SESSION}" var="item">
															<option	 value="${item.s_id}">${item.s_name}</option>
														</c:forEach>
													</select>
													</div>
													 <div class="col-md-2">
													 	
											   		 </div>
												</div><!-- /form-gromp -->	
												
											  <div class="form-group">
											    <label for="stem" class="col-md-2 control-label">课程名称</label>
											    <div class="col-md-8">
											      <input type="text" class="form-control" id="addTBName" placeholder="">
											    </div>
											    <div class="col-md-2"></div>
											  </div><!-- /form-gromp -->	
											  <div class="form-group" id="chapter-num">
											    <label for="text" class="col-md-2 control-label">章节个数</label>
											    <div class="col-md-8">
											      <select id="addChapterNum"	class=" form-control "  onchange="change2(this.id)" >
														<option value="">--请选择--</option>
														<option value="1">1</option>
														<option value="2">2</option>
														<option value="3">3</option>
														<option value="4">4</option>
														<option value="5">5</option>
														<option value="6">6</option>
														<option value="7">7</option>
														<option value="8">8</option>
														<option value="9">9</option>
														<option value="10">10</option>
														<option value="11">11</option>
														<option value="12">12</option>
														<option value="13">13</option>
														<option value="14">14</option>
														<option value="15">15</option>
														<option value="16">16</option>
														<option value="17">17</option>
														<option value="18">18</option>
														<option value="19">19</option>
													</select>
											    </div>
											    <div class="col-md-2">
											    	<!-- <a id ="addChoice" class="btn btn-default btn-md"  href="#" role="button" onclick="addCt">
											    		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
											    	</a> -->
											    	
											    </div>
											  </div><!-- /form-gromp -->
											  <script type="text/javascript">
											  /*用户点击添加课程*/
											  function addBook(){	    	
										    		var c_s_id = $("#addSubject2").val();
										    		var c_name=$("#addTBName").val();
										    		var c_chapter_num=$("#addChapterNum").val();
										    		var str="";
										    		//children()方法：获取该元素下的直接子集元素
													//find()方法：获取该元素下的所有子集元素
										    		$("#addChapterHeader").find("input").each(function(){
										    			//alert(this.value);
										    			str+=this.value+"@@";
										    		});
										    		var c_chapter_headers=str;
										    		//alert(str);
										    		//alert("c_s_id:"+c_s_id+" c_name:"+c_name+" c_chapter_num:"+c_chapter_num+" c_chapter_headers:"+c_chapter_headers);
										    		var data={c_name:c_name,c_chapter_num:c_chapter_num,c_chapter_headers:c_chapter_headers,c_s_id:c_s_id};
										    		$.ajax({
												       	   method:"post",
												         	url:"/testManage/addCourse.action",
												         	contentType: 'application/json; charset=UTF-8',
												         	data:JSON.stringify(data),
														 	dataType:'json',
														 	
												       	   	success:function (data) {
												       	   		if(data.result=="yes"){
																alert("添加成功");
																$("#myModal").modal('hide');  //手动关闭
																$("#addTB").reset();
																}else{
																	alert("保存失败");
															    }
												          	  
												         	 }
												   	 });
											   	
											   	 };
											   	 /*用户选择章节数目之后，添加章节到模态框*/
											  	function change2(id){
											  		var num = $("#addChapterNum").val();
											  			var str="<div>请输入各章节标题</div>";
											  			//alert(num);		
										           	  	for (var i = 1; i <= num; i++) {
										           	  		  str+="<div class='form-group'>"+
										           	  		  "<label for='text' class='col-md-2 control-label'>第"+i+"章</label>"+
										           	  		  "<div class='col-md-10'>"+
										           	  		  "<input type='text' class='form-control' >"+
										           	  		  "</div>"+
										           	  		  "</div>";
										         	 	 } 
										           	 	 
											  			/* $("#chapter-num").after(str); */
											  			$("#addChapterHeader").append(str);
											  			
											  			//alert();
											  	};
											  	function reset(){
											  		
											  		/* $("#addTB")[0].reset(); */
											  		 $("#addSubject2").find("option[text='--请选择--']").attr("selected",true);
											  		 $("#addChapterNum").find("option[text='--请选择--']").attr("selected",true);
											  		 $("#addTBName").val("");
											  		
											  		 $("#addChapterHeader").empty();
											  		  $("#addChapterHeader").html();
											  	};
											  	$('body').on('hidden.bs.modal', '.modal', function () {
												    $(this).removeData('bs.modal');
												});
											  </script>	
											  <!-- <div>请输入各章节标题</div>
											  <div class="form-group" id="chapter-header" >
											  		<label for="text" class="col-md-2 control-label"></label>
											  		<div class="col-md-10">
												      <input type="text" class="form-control" >
												    </div>
											  </div> -->
											  <div id="addChapterHeader">
											  		<!-- js动态填充内容 -->
											  </div>
											</form>  
				   						</div>
				   						<div class="modal-footer">
				   							<div class="form-group">
											    <div class="col-sm-offset-2 col-sm-10">
											      <button type="button" class="btn btn-default" onclick="addBook()">提交</button>
											      <button type="button" class="btn btn-default" onclick="reset()" >重置</button>
				   								
											    </div>
											  </div>
				   						</div>
				   					</div><!--/ model-content -->
				   				</div><!--/ model-dialog -->
				   			</div><!--/ model -->
				   			<!-- --------------结束---------------添加课程的模态框---------------------------------------------- -->
				</form>
			</div>
		</div>
	</div>
</body>
</html>