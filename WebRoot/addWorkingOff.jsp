<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addWorkingOff.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="static/css/style.css"/>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="static/css/layer.css">
	<!-- 
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form>
    <div class="form-group">
    	<label for="inputAddress">调休人姓名</label>
    	<input type="text" value="${user.user_name}" class="form-control" id="inputAddress" placeholder="请输入请假人姓名" readonly>
  	</div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">开始时间</label>
      <input type="date" class="form-control" id="inputEmail4">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">结束时间</label>
      <input type="date" class="form-control" id="inputPassword4">
    </div>
  </div> 
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="disabledSelect">部门</label>
      <select id="disabledSelect" class="form-control" disabled>
      	<option value="0">请选择</option>
      	<c:forEach var="departmentList" items="${departmentList}" varStatus="status">
        <option selected="${user.user_department_id}==${departmentList.department_id}" value="${departmentList.department_id}">${departmentList.department_name}</option>
        </c:forEach>
      </select>
    </div>
    <div class="form-group col-md-4">
      <label for="exampleFormControlTextarea1">调休原因</label>
    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
   </div>
  </div>
  
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputState">创建调休单时间</label>
      <input type="date" name="user_time" value="${ft}" id="user_time" class="form-control" readonly>
    </div>
  </div>
  <input type="button" class="btn btn-primary btn-lg btn-block" onclick="getAddWorkingOff()" value="Sign in">
</form>
<script type="text/javascript" src="static/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="static/js/layer.js"></script>
<script type="text/javascript" src="static/js/addWorkingOff.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.4.1/dist/jquery.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

  </body>
</html>
