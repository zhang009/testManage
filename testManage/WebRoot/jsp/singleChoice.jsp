<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() 
	                   + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="shortcut icon" href="icon/favicon.ico" type="image/x-icon" />
	 <link rel="stylesheet" href="layui/css/layui.css">
	 <link rel="stylesheet" href="css/font.css">
	 <link rel="stylesheet" href="css/xadmin.css">
	 <script src="layui/layui.js"></script>
	  <script src="js/jquery.min.js"></script>
	   <script type="text/javascript" src="js/xadmin.js"></script>
	   <script>
      layui.use('element', function(){
      var element = layui.element;
      });
    </script>
 <style type="text/css">
#menu li a {
  background:#F2E6E6; /* 设置背景色 */
  color: black; /* 设置文字颜色 */
  border-right: 1px solid #FFFAF4; /* 在左侧加上分隔线 */
  font-size:20px;
}
.textarea{
  font-size:17px;
  border: 0;
}
</style>
    <title>单项选择</title>
</head>
<body style="background: #F0F0F0;margin-top:-20px;background-size: 100%;">

	<!-- readonly="readonly"规定输入字段为只读 -->
	<div id="wrapper">
		
   		<div id="page-wrapper" class="gray-bg">
               <div class="row border-bottom">
				<nav class="navbar navbar-static-top" role="navigation"
					style="margin-bottom: 0">
				<div class="col-lg-10" style="margin-left: 15px;">
					<h2>查看所有试题/单选题</h2>
				</div>
				<ul class="nav navbar-top-links navbar-right">
			<!-- 	<li><a href="../servlet/teacherexamServlet?id=12"> <i class="fa  fa-file-text-o"></i>
							老师出的卷 </a></li>
					<li><a href="../servlet/teacherexamServlet?id=13"> <i class="fa  fa-file-text-o"></i>
							学生出的卷 </a></li> -->
					<li><a href="../jspIT/teacherFirst.jsp"> <i class="fa fa-sign-out"></i>
							首页 </a></li>
				</ul>

				</nav>
			</div>
 			<c:forEach items="${topTenRadio}" var="subject" varStatus="var">
				<div style="background: rgba(255, 255, 255, .15);">
					${list3[var.index]}  &nbsp;&nbsp;&nbsp;
					
                 <textarea rows="1" cols="100" readonly="readonly" class="textarea" id="input_background" >${subject.cy_subject}</textarea>
                 
					<ul class="u1">
						<li>A、&nbsp;&nbsp;&nbsp; <textarea rows="1" cols="100" readonly="readonly" class="textarea" id="input_background">${subject.cy_choice1}</textarea>
						</li>
						<br>
						
						<li>B、&nbsp;&nbsp;&nbsp; <textarea rows="1" cols="100" readonly="readonly" class="textarea" id="input_background">${subject.cy_choice2}</textarea>
						</li>
						<br>
						
						<li>C、&nbsp;&nbsp;&nbsp; <textarea rows="1" cols="100" readonly="readonly" class="textarea" id="input_background">${subject.cy_choice3}</textarea>
						</li>
						<br>
						
						<li>D、&nbsp;&nbsp;&nbsp; <textarea rows="1" cols="100" readonly="readonly" class="textarea" id="input_background">${subject.cy_choice4}</textarea>
						</li>
					</ul>

					<ul class="u2">
						<li><span class="sp">正确答案：<span> <textarea rows="1" cols="100" readonly="readonly" class="textarea" id="input_background">${subject.cy_answer}</textarea>
						</li>
						<li><span class="sp">试题解析：<span> <textarea rows="1" cols="100" readonly="readonly" class="textarea" id="input_background">${subject.cy_remark}</textarea>
						</li>
						<li><span class="sp">试题难度:</span><input type="text" 
						    id="input_background"
							readonly="readonly" value="${subject.cy_diff}" />
						</li>
						 <li><span class="sp">出题人:</span><input type="text" 
						    id="input_background"
							readonly="readonly" value="${subject.cy_name}" />
						</li>
					</ul>
				</div>
			</c:forEach>  
			
		 
            <ul id="menu">
                <li><a href="../servlet/RadioListAllServlet?select=1&pageCurrent=${pageCurrent}"/>首页</a></li>
                <li><a href="../servlet/RadioListAllServlet?select=2&pageCurrent=${pageCurrent}"/>&laquo;</a></li>
                <li> <a href="../servlet/RadioListAllServlet?select=3&pageCurrent=${pageCurrent}"/>&raquo;</a></li>
                <li><a href="../servlet/RadioListAllServlet?select=4&pageCurrent=${pageCurrent}"/>尾页</a></li>
            </ul>
             <span style="margin-left:1100px;font-size:15px;">第${pageCurrent}页/共${radioPageAll}页</span>  
		</div>
	</div>

</body>
</html>