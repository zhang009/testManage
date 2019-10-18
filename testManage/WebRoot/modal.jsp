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
  <script src="js/bootstrap-select.js"></script>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <head></head>
<body>
	<form action="" method="post" class="form-horizontal" id="">
			   									   
												  <div class="form-group">
												    <label for="stem" class="col-md-2 control-label">课程名称</label>
												    <div class="col-md-8">
												      <input type="text" class="form-control" id="stem" placeholder="">
												    </div>
												    <div class="col-md-2"></div>
												  </div>
												  <div class="form-group">
												    <label for="text" class="col-md-2 control-label">章节个数</label>
												    <div class="col-md-8">
												      <select id="addChapterNum"	class=" form-control "  >
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
												  </div>
				   							</form>
</body>
</html>