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
    
    <title>My JSP 'addUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="static/css/style.css"/>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="static/css/layer.css">
	<!-- 
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">用户姓名</label>
      <input type="text" class="form-control" id="inputEmail4">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">用户名</label>
      <input type="text" class="form-control" id="inputPassword4">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">密码</label>
    <input type="password" class="form-control" id="inputAddress" placeholder="1234 Main St">
  </div>
  <div class="form-group">
    <label for="inputAddress2">确认密码</label>
    <input type="password" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
  </div>
  <fieldset class="form-group">
    <div class="row">
      <legend class="col-form-label col-sm-2 pt-0">性别</legend>
      <div class="col-sm-10">
        <div class="form-check">
          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="男" checked>
          <label class="form-check-label" for="gridRadios1">
            man
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="女">
          <label class="form-check-label" for="gridRadios2">
            woman
          </label>
        </div>
      </div>
    </div>
  </fieldset>
  <div class="form-row">
    <div class="form-group col-md-4">
      <label for="inputState">部门</label>
      <select id="inputStat" class="form-control" onchange="findTechnocal()">
      	<option value="0">请选择</option>
      	<c:forEach var="departmentList" items="${departmentList}" varStatus="status">
        <option value="${departmentList.department_id}">${departmentList.department_name}</option>
        </c:forEach>
      </select>
    </div>
    <div class="form-group col-md-4">
      <label for="inputState">职称</label>
      <span id="cheng">
      <select id="inputState1" class="form-control" name="technocal_shu" onchange="getZhi()">
      	<option value="0" selected="selected">请选择</option>
        <c:forEach var="technocalList" items="${technocalList}" varStatus="status">
        <option value="${technocalList.technocal_id}">${technocalList.technocal_name}</option>
        </c:forEach>
      </select>
      </span>
    </div>
    <div class="form-group col-md-4" id="technocalType">
      <label for="inputState">上级</label>
      <span id="boss">
      <select id="inputState2" class="form-control">
        <option value="${te.technocal_id}">${te.technocal_name}</option>
      </select>
      </span>
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-4">
      <label for="inputState">进本单位的时间</label>
      <input type="date" name="user_time" id="user_time"  class="form-control">
    </div>
    <div class="form-group col-md-4">
      <label for="inputState">工资</label>
      <input type="number" name="user_sarly" id="user_sarly" class="form-control">
    </div>
    <div class="form-group col-md-4">
      <label for="inputState">头像</label>
      <input type="file" name="user_image" id="user_image" class="form-control">
    </div>
  </div>
  <input type="button" class="btn btn-primary btn-lg btn-block" onclick="getAddUser()" value="Sign in">
</form>
<script type="text/javascript" src="static/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="static/js/layer.js"></script>
<script type="text/javascript" src="static/js/addUser.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.4.1/dist/jquery.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

  </body>
</html>
