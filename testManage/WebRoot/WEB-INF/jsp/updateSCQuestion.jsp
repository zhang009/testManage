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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="js/xadmin.js"></script>
	 <script src="js/jquery.min.js"></script>
 	<script src="js/bootstrap.min.js"></script>
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
		/*点击修改按钮*/
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
		   var data={sc_subject:subject,sc_point:point,sc_stem:stem,sc_option:option,sc_answer:answer,sc_analysis:analysis,sc_c_id:c_id,sc_ct_id:ct_id};
		   	$.ajax({
		       	   method:"post",
		         	url:"/testManage/addSCQuestion.action",
		         	contentType: 'application/json; charset=UTF-8',
		         	data:JSON.stringify(data),
				 	dataType:'json',
		       	   	success:function (data) {
		       	   		if(data.result=="yes"){
							alert("修改成功");
							self.location.reload();
						}else{
							alert("修改失败");
					    }
		         	 }
		   	 });
		   	}
		   	 
 		window.onload =function() {
 		//从model中得到选项内容，填入文本框
 			var options=$("#hiddenOption").val().split("@@");
 			var i=0;
 			//alert(options);
 			$("#choices").find("input").each(function(){
 			//	alert(options[i]);
    			this.value=options[i];
    			i=i+1;
    		});
    		var subject=$("#hiddenSubject").val();
    		var book=$("#hiddenBook").val();
    		var chapter=$("#hiddenChapter").val(); 
    		$("#addSubject").find("option[text='"+subject+"']").attr("selected",true);
    		$("#addChapter").find("option[text='"+chapter+"']").attr("selected",true);
 			$("#addCourse").find("option[text='"+book+"']").attr("selected",true);
 			//alert(subject);
 			 
 		};
 
 
 </script>
 
</head>
<body>

	<hr>
	<ul class="breadcrumb">
    <li><a href="#">我的试题</a></li>
    <li class="active">单选题修改</li>
	</ul>
	<%-- <jsp:include page="../jsp/selectTop.jsp" /> --%>
	
	
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
				    <label for="stem" class="col-md-2 control-label">题目</label>
				   
				     <div class="col-md-8">
				       <textarea id="SCStem" class="form-control" rows="3">${scquestion.sc_stem }</textarea>
				    </div>
				    <div class="col-md-2"></div>
				  </div>
				 <input type="hidden" id="hiddenOption" value='${scquestion.sc_option}'><!-- 隐藏的选项 -->
				  <input type="hidden" id="hiddenSubject" value='${scquestion.sc_subject}'><!-- 隐藏的选项 -->
				   <input type="hidden" id="hiddenBook" value='${scquestion.sc_c_id}'><!-- 隐藏的选项 -->
				    <input type="hidden" id="hiddenChapter" value='${scquestion.sc_ct_id}'><!-- 隐藏的选项 -->
				 
				  <div id="choices"><!-- -------选项开始 -->
				  <div class="form-group">
				    <label for="text" class="col-md-2 control-label">选项1</label>
				    <div class="col-md-8">
				      <input type="text" class="form-control"  placeholder="" >
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
				      <input id="answer" type="text" class="form-control"  value="${scquestion.sc_answer }">
				    </div>
				    <div class="col-md-2"></div>
				  </div>
				  
				  <div class="form-group">
				    <label for="stem" class="col-md-2 control-label">答案解析：</label>
				   
				     <div class="col-md-8">
				       <textarea id="analysis" class="form-control" rows="3" >${scquestion.sc_analysis }</textarea>
				    </div>
				    <div class="col-md-2"></div>
				  </div>
				   <div class="form-group">
				    <label for="stem" class="col-md-2 control-label">考查知识点：</label>
				   
				     <div class="col-md-8">
				       <textarea id="point" class="form-control" rows="2">${scquestion.sc_point }</textarea>
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
				       <a type="" class="btn btn-primary" onclick="submitAll()" >修改</a>
				    </div>
				  </div>
				 
				</form>
			</div>
		</div>
		</div>
	
</body>
</html>