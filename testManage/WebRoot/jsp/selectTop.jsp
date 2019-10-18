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
<title></title>
 <script src="js/jquery.min.js"></script>
 <script src="js/bootstrap.min.js"></script>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 
</head>
<body>
	<!-- 从session获取科目种类 -->
	<div>
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-inline" method="get" 
				      action="${pageContext.request.contextPath }/customer/list.action">
				     <%-- 	 <c:choose>
				    <c:when test="${!empty sessionScope.SUBJECTS_SESSION }"> --%>
				     		
							<div class="form-group">
								<label for="customerFrom">请选择科目</label> 
								<select	class="form-control" id="" name="">
									<option value="">--请选择--</option>
									<c:forEach items="${sessionScope.SUBJECTS_SESSION}" var="item">
										<option value="${item.s_id}">${item.s_name}</option>
									</c:forEach>
								</select>
							</div>
							<button type="submit" class="btn btn-primary">查询</button>
							
				     <%-- 	</c:when>
				     	<c:otherwise>
				     		没有科目！
				     	</c:otherwise>			   
				   </c:choose> --%>  
				</form>
			</div>
		</div>
	</div>
</body>
</html>