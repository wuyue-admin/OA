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
    
    <title>My JSP 'updateLeaveShen.jsp' starting page</title>
    
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
  <input type="text" id="leave_id" value="${leaveS.leave_id}" style="display: none;">
    <div class="form-group col-md-6">
      <label for="inputEmail4">开始时间</label>
      <input type="date" class="form-control" value="${leaveS.leave_start_time}" id="inputEmail4" readonly="readonly">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">结束时间</label>
      <input type="date" class="form-control" value="${leaveS.leave_end_time}" id="inputPassword4" readonly="readonly">
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-4">
      <label for="exampleFormControlTextarea1">请假原因</label>
    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" readonly="readonly">${leaveS.leave_context}</textarea>
   </div>
   <div class="form-group col-md-4">
      <label for="inputState">审核结果</label>
      <select id="inputState" class="form-control">
        <option selected value="1">已查看</option>
        <option value="2">已通过</option>
        <option value="3">未通过</option>
      </select>
    </div>
  </div>
  <input type="button" class="btn btn-primary btn-lg btn-block" onclick="getShenLeave()" value="Sign in">
</form>
<script type="text/javascript" src="static/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="static/js/layer.js"></script>
<script type="text/javascript" src="static/js/addLeave.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.4.1/dist/jquery.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

  </body>
</html>
