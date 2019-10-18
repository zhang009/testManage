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
 		alert(subjectId);
 		$.ajax({
	       	   method:"post",
	         	url:"/testManage/getQAQuestionAll.action",
	         	data:{"data":subjectId},
			 	dataType:'json',
	       	   	success:function (res) {
	       	   		alert();
	          		var str="";
	          		var str2 = new Array(); //定义字符串数组
					
	           	  	for (var i = 0; i < res.length; i++) {
	           	  	
	           	  		str+="<div class='panel panel-default'>"+
	          					" <div class='panel-heading'>"+
	          					"<p><blockquote class='blockquote'>"+(i+1)+". "+res[i].qa_stem+"</blockquote></p>"+
	          					" </div>"+
	          					"<div class='panel-body'>"+"</div></div>"+
	          					"<blockquote class='blockquote'><strong>正确答案：</strong>"+res[i].qa_answer+
	          					"</blockquote></div></div>";
	          					
	          					
	            	 	  		
	         	 	 } 
		           	 $("#sclist").append(str);
		          	
	          }
	   	 });
 	}
 
 
 
 
 </script>
 
</head>
<body>

	<hr>
	<ul class="breadcrumb">
    <li><a href="#">所有试题</a></li>
    <li class="active">简答题</li>
	</ul>
	<%-- <jsp:include page="../jsp/selectTop.jsp" /> --%>
	<%@ include file="../jsp/selectTop.jsp" %>
	
	<div>
		<div class="layui-col-md12" >
		
			<div id="sclist">
				
			</div>
		
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