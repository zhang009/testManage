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
	
	  <script src="js/jquery.min.js"></script>
	   <script src="layui/layui.js"></script>
	   <script type="text/javascript" src="js/xadmin.js"></script>
	   <script>
   $(".panel a").on("click",function(){
		window.parent.addTab($(this));
	});
	    </script>
</head>

<body>
 <!-- 顶部开始 -->
    <div class="container ">
        <div class="logo"><a href="main.jsp">题库管理系统</a></div>
        <div class="left_open">
            <i title="展开左侧栏" class="iconfont">&#xe699;</i>
        </div>
      
        <ul class="layui-nav right ipanel" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">admin</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <dd><a onClick="x_admin_show('个人信息','http://www.baidu.com')">个人信息</a></dd>
              <dd><a onClick="x_admin_show('切换帐号','http://www.baidu.com')">切换帐号</a></dd>
              <dd><a href="login.html">退出</a></dd>
            </dl>
          </li>
          <li class="layui-nav-item to-index"><a href="#">退出</a></li>
        </ul>
        
    </div>
    <!-- 顶部结束 -->
    <!-- 中部开始 -->
     <!-- 左侧菜单开始 -->
    <div class="left-nav">
      <div id="side-nav panel">
        <ul id="nav">
             <li >
                <a href="javascript:;">
                    <i class="iconfont">&#xe6eb;</i>
                    <cite>查看所有试题</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li><a _href="toAllSCQuestion.action"><i class="iconfont">&#xe6a7;</i><cite>单选题</cite></a></li >
                
                    <%-- <li><a _href="toAddSCQuestion.action"><i class="iconfont">&#xe6a7;</i><cite>添加</cite></a></li > --%>
                </ul>
                <ul class="sub-menu">
                    <li><a _href="toAllMCQuestion.action"><i class="iconfont">&#xe6a7;</i><cite>多选题</cite></a></li >
                </ul>
                <ul class="sub-menu">
                    <li><a _href="toAllTFQuestion.action"><i class="iconfont">&#xe6a7;</i><cite>判断题</cite></a></li >
                </ul>
                <ul class="sub-menu">
                    <li><a _href="toAllFBQuestion.action"><i class="iconfont">&#xe6a7;</i><cite>填空题</cite></a></li >
                </ul>
                <ul class="sub-menu">
                    <li><a _href="toAllQAQuestion.action"><i class="iconfont">&#xe6a7;</i><cite>简答题</cite></a></li >
                </ul>
            </li>
           <!-- -------------------------------------------------------------- -->
           <li >
                <a href="javascript:;">
                    <i class="iconfont">&#xe6eb;</i>
                    <cite>我的题库</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                
                <ul class="sub-menu">
                	<li><a _href=""><i class="iconfont">&#xe6a7;</i><cite>上传试题</cite></a>
	                <ul class="sub-menu">
	                    <li><a _href="toAddSCQuestion.action"><i class="iconfont">&#xe6a7;</i><cite>单选题</cite></a></li >
	                </ul>
	                <ul class="sub-menu">
	                    <li><a _href="toAddMCQuestion.action"><i class="iconfont">&#xe6a7;</i><cite>多选题</cite></a></li >
	                </ul>
	                <ul class="sub-menu">
	                    <li><a _href="toAddTFQuestion.action"><i class="iconfont">&#xe6a7;</i><cite>判断题</cite></a></li >
	                </ul>
	                <ul class="sub-menu">
	                    <li><a _href="toAddFBQuestion.action"><i class="iconfont">&#xe6a7;</i><cite>填空题</cite></a></li >
	                </ul>
	                <ul class="sub-menu">
	                    <li><a _href="toAddQAQuestion.action"><i class="iconfont">&#xe6a7;</i><cite>简答题</cite></a></li >
	                </ul>
                   
                </ul>
                
                  
                <ul class="sub-menu">
                   <li><a _href=""><i class="iconfont">&#xe6a7;</i><cite>查看试题</cite></a>
	                <ul class="sub-menu">
	                    <li><a _href="toMySCQuestion.action"><i class="iconfont">&#xe6a7;</i><cite>单选题</cite></a></li >
	                </ul>
	                <ul class="sub-menu">
	                    <li><a _href="toMyMCQuestion.action"><i class="iconfont">&#xe6a7;</i><cite>多选题</cite></a></li >
	                </ul>
	                <ul class="sub-menu">
	                    <li><a _href="toMyTFQuestion.action"><i class="iconfont">&#xe6a7;</i><cite>判断题</cite></a></li >
	                </ul>
	                <ul class="sub-menu">
	                    <li><a _href="toMyFBQuestion.action"><i class="iconfont">&#xe6a7;</i><cite>填空题</cite></a></li >
	                </ul>
	                <ul class="sub-menu">
	                    <li><a _href="toMyQAQuestion.action"><i class="iconfont">&#xe6a7;</i><cite>简答题</cite></a></li >
	                </ul>
	                
                </ul>
            </li>
           <!-- -------------------------------------------------------------- -->
            
            <!-- -------------------------------------------------------------- -->
            
            <li>
                <a href="javascript:;"><i class="iconfont">&#xe6f6;</i><cite>我要组卷</cite><i class="iconfont nav_right">&#xe6a7;</i></a>
                <ul class="sub-menu">
                  
                    
                    <li><a _href="randomBuild"><i class="iconfont">&#xe6a7;</i><cite>随机组卷</cite></a></li>
                    <li><a _href="html/page.html"><i class="iconfont">&#xe6a7;</i><cite>自由组卷</cite></a></li>
                </ul>
            </li>
             <li >
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b4;</i>
                    <cite>我的试卷库</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li><a _href="html/grid.html"><i class="iconfont">&#xe6a7;</i><cite>我组的卷</cite></a></li>
                    <li><a _href="html/welcome2.html"><i class="iconfont">&#xe6a7;</i><cite>收藏的卷</cite></a></li>
                </ul>
            </li>
                   
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe69e;</i>
                    <cite>成绩分析</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="html/order-list.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>学生成绩</cite>
                        </a>
                    </li >
                </ul>
            </li>
            
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe726;</i>
                    <cite>个人中心</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="html/admin-list.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>个人信息</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="html/admin-role.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>基本设置</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="html/admin-cate.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>修改密码</cite>
                        </a>
                    </li >
                   
                </ul>
            </li>            
          <%--   <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>用户管理</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="html/member-list.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>会员列表</cite>
                            
                        </a>
                    </li >
                    <li>
                        <a _href="html/member-del.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>会员删除</cite>
                            
                        </a>
                    </li>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont">&#xe70b;</i>
                            <cite>会员管理</cite>
                            <i class="iconfont nav_right">&#xe6a7;</i>
                        </a>
                        <ul class="sub-menu">
                            <li>
                                <a _href="html/member-del.html">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>会员列表</cite>
                                    
                                </a>
                            </li >
                            <li>
                                <a _href="html/member-del.html">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>会员删除</cite>
                                    
                                </a>
                            </li>
                            
                        </ul>
                    </li>
                    
                </ul>
            </li> --%>             
<%-- <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6ae;</i>
                    <cite>系统统计</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="html/echarts1.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>拆线图</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="html/echarts2.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>柱状图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="html/echarts3.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>地图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="html/echarts4.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>饼图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="html/echarts5.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>雷达图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="html/echarts6.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>k线图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="html/echarts7.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>热力图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="html/echarts8.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>仪表图</cite>
                        </a>
                    </li>
                </ul>
            </li>             --%></ul>
      </div>
    </div>
    <!-- <div class="x-slide_left"></div> -->
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>系统主页</li>
          </ul>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe  src='welcome.jsp' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
          </div>
        </div>
    </div>
    <div class="page-content-bg"></div>
    <!-- 右侧主体结束 -->
    <!-- 中部结束 -->
    <!-- 底部开始 -->
    <!--<div class="footer">
        <div class="copyright">Copyright ©2019 L-admin v2.3 All Rights Reserved</div>  
    </div>-->
    <!-- 底部结束 -->
</body>
</html>