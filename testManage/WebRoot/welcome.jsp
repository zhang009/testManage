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
</head>
<body style="background: url(img/background.jpg)no-repeat;margin-top:-20px;background-size: 100% 100%;">

	<div style="text-align: center; padding-top: 100px">
				<p>
					<font size="7">试题库管理系统</font>
				</p>
				<br />
	</div>
	<div>
	<div class="layui-card" style="opacity: 0.8;margin-left: 400px;margin-right: 400px; ">
	  <div class="layui-card-body">
                <div class="layui-carousel x-admin-carousel x-admin-backlog" lay-anim="" lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 90px;">
                    <div carousel-item="">
                        <ul class="layui-row layui-col-space10 layui-this">
                            <li class="layui-col-xs4">
                                <a href="javascript:;" class="x-admin-backlog-body">
                                    <h3>试题数</h3>
                                    <p>
                                        <cite>66</cite></p>
                                </a>
                            </li>
                            <li class="layui-col-xs4">
                                <a href="javascript:;" class="x-admin-backlog-body">
                                    <h3>试卷数</h3>
                                    <p>
                                        <cite>12</cite></p>
                                </a>
                            </li>
                            <li class="layui-col-xs4">
                                <a href="javascript:;" class="x-admin-backlog-body">
                                    <h3>用户数</h3>
                                    <p>
                                        <cite>99</cite></p>
                                </a>
                            </li>
                            
                        </ul>
                    </div>
                </div>
            </div>
           </div>
	</div>

</body>
</html>