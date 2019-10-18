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
 	function search(){
 		var subjectId=$("#choseSubject").val();
 		
 		$.ajax({
	       	   method:"post",
	         	url:"/testManage/getSCQuestionAll.action",
	         	data:{"data":subjectId},
			 	dataType:'json',
	       	   	success:function (res) {
	       	   		
	          		var str="";
	          		var str2 = new Array(); //定义字符串数组
					
	           	  	for (var i = 0; i < res.length; i++) {
	           	  	
	           	  		str+="<div class='panel panel-default'>"+
	          					" <div class='panel-heading'>"+
	          					"<p><strong>"+(i+1)+". </strong>"+res[i].sc_stem+"</p>"+
	          					" </div>"+
	          					"<div class='panel-body'>"+
	          					" <ul class='list-group'>";
		          					str2 = res[i].sc_option.split("@@"); //字符分割
		          					for(var j=0;j<str2.length;j++){
		          						str+="<li class='list-group-item'>"+str2[j]+"</li>";
		          					}
	          					str+="</ul>"+
	          					"</div></div>";
	          					
	            	 	  		
	         	 	 } 
		           	 $("#sclist").append(str);
		          	
	          }
	   	 });
 	}
 
 
 
 
 </script>
 
</head>
<body>
	<%-- <jsp:include page="../jsp/selectTop.jsp" /> --%>
	
	<hr>
	<ul class="breadcrumb">
    <li><a href="#">所有试题</a></li>
    <li class="active">单选题</li>
	</ul>
	<%@ include file="../jsp/selectTop.jsp" %>
	
	<div>
		<div class="layui-col-md12" >
		
			<div id="sclist">
				
			</div>
        <!-- <div class="panel panel-default">
		  Default panel contents
		  <div class="panel-heading">
		  	<p>题目</p>
		  
		  </div>
		  <div class="panel-body">
		     List group
			  <ul class="list-group">
			    <li class="list-group-item">A. 数据化分析 面向对象分析</li>
			    <li class="list-group-item">A. 数据化分析 面向对象分析</li>
			    <li class="list-group-item">A. 数据化分析 面向对象分析</li>
			    <li class="list-group-item">A. 数据化分析 面向对象分析</li>
			    <li class="list-group-item">A. 数据化分析 面向对象分析</li>
			  </ul>
		</div>
		
		 
		</div>
		
		<div class="panel panel-default">
		  Default panel contents
		  <div class="panel-heading">
		  	<p>___是第一代软件工程常用的分析技术，____属于第二代软件工程常用的分析技术。（）</p>
		  
		  </div>
		  <div class="panel-body">
		     List group
			  <ul class="list-group">
			    <li class="list-group-item">A. 数据化分析 面向对象分析</li>
			    <li class="list-group-item">A. 数据化分析 面向对象分析</li>
			    <li class="list-group-item">A. 数据化分析 面向对象分析</li>
			    <li class="list-group-item">A. 数据化分析 面向对象分析</li>
			    <li class="list-group-item">A. 数据化分析 面向对象分析</li>
			  </ul>
		</div>
		
		 
		</div>
		
		<div class="panel panel-default">
		  Default panel contents
		  <div class="panel-heading">
		  	<p>___是第一代软件工程常用的分析技术，____属于第二代软件工程常用的分析技术。（）</p>
		  
		  </div>
		  <div class="panel-body">
		     List group
			  <ul class="list-group">
			    <li class="list-group-item">A. 数据化分析 面向对象分析</li>
			    <li class="list-group-item">A. 数据化分析 面向对象分析</li>
			    <li class="list-group-item">A. 数据化分析 面向对象分析</li>
			    <li class="list-group-item">A. 数据化分析 面向对象分析</li>
			    <li class="list-group-item">A. 数据化分析 面向对象分析</li>
			  </ul>
		</div>
		
		 
		</div> -->
		
		<!-- 分页1 -->
					 <div aria-label="Page navigation " style="text-align: right;"> 
						<ul  id="page1"></ul>
							<!-- <li>
								<a href="#" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
								</a>
							</li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li>
								<a href="#" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
								</a>
							</li> -->
						
					</div>
					
      </div>
    </div>
	
	</div>
</body>
</html>