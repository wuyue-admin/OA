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
    
    <title>My JSP 'signIn.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="static/css/style.css"/>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous" >
	<link rel="stylesheet" type="text/css" href="static/css/layer.css">
	<!-- 
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form>
  <div class="form-row">
  	<input class="form-control" id="inputPassword2" value="${loadtimeAll}" style="display: none;">
    <div class="form-group col-md-6">
      <label for="inputPassword4">打卡时间</label>
      <input class="form-control" id="inputPassword4" value="${loadtimes}" readonly>
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">今天的日期</label>
      <input type="date" class="form-control" value="${loadtime}" id="inputPassword3" readonly>
    </div>
  </div>
  <div class="form-group">
    <input type="text" style="display: none;" value="${user.user_id}" class="form-control" id="inputAddress" readonly>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="disabledSelect">打卡状态</label>
      <select id="disabledSelect" class="form-control">
      	<c:forEach var="attendanceList" items="${attendanceList}" varStatus="status">
        <option class="attendance${attendance_state_id}" value="${attendanceList.attendance_state_id}">${attendanceList.attendance_state_name}</option>
        </c:forEach>
      </select>
    </div>
   </div>
  <input type="button" class="btn btn-primary btn-lg btn-block" onclick="getAddSignIn()" value="Sign in">
</form>
<script type="text/javascript" src="static/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="static/js/layer.js"></script>
<script type="text/javascript" src="static/js/addSignIn.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.4.1/dist/jquery.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script type="text/javascript">
	/* function datetime() {
		 var now = new Date();
		 document.getElementById("inputPassword4").value = now.getFullYear() + "-"
		 + (now.getMonth() + 1) + "-" + now.getDate();
		 document.getElementById("inputPassword4").value += " " + now.getHours() + ":"
		 + now.getMinutes() + ":" + now.getSeconds();
		 }
		 window.setInterval("datetime()"); */
		 
	function changeState(){
		var nowTime = $("#inputPassword4").val();
		var a = "9:00:";
		var b = "9:30";
		var c = "12:00";
		var d = "13:00";
		var e = "13:30";
		var f = "15:00";
		var nowTime1 = new Date(nowTime).getTime();
		var a1 = new Date(a).getTime();
		var b1 = new Date(b).getTime();
		var c1 = new Date(c).getTime();
		var d1 = new Date(d).getTime();
		var e1 = new Date(e).getTime();
		var f1 = new Date(f).getTime();
		if(nowTime1<a1){
			$(".attendance1").prop("selected",true)
		}
		if(nowTime1>a1&&nowTime1<b1){
			$(".attendance2").prop("selected",true)
		}
		if(nowTime1>b1){
			$(".attendance4").prop("selected",true)
		}
		if(nowTime1<c1){
			$(".attendance3").prop("selected",true)
		}
		if(nowTime1>c1){
			$(".attendance1").prop("selected",true)
		}
		
		if(nowTime1<d1){
			$(".attendance1").prop("selected",true)
		}
		if(nowTime1>d1&&nowTime1<e1){
			$(".attendance2").prop("selected",true)
		}
		if(nowTime1>e1){
			$(".attendance4").prop("selected",true)
		}
		if(nowTime1<f1){
			$(".attendance3").prop("selected",true)
		}
		if(nowTime1>f1){
			$(".attendance1").prop("selected",true)
		}
	}
	
</script>
  </body>
</html>
