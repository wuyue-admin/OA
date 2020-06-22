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
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="static/css/style.css"/>
	<link rel="stylesheet" type="text/css" href="static/css/rili.css">
	<link href="static/bootstrap-3.3.5-dist/css/bootstrap.min.css" title="" rel="stylesheet" />
	<script src="static/bootstrap-3.3.5-dist/js/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="static/js/rili.js"></script>
  </head>
  
  <body>
    <!---title----->
         	<!--content-list--> 
            <div class="content-list">
               <div class="row">
                 <div class="col-md-3">
                    <div class="content">
                       <div class="w30 left-icon pull-left">
                          <img src="static/image/ic_assignment_black_48dp.png">
                       </div>
                       <div class="w70 right-title pull-right">
                       <div class="title-content">
                           <p>请假单</p>
                           <h3 class="number">${countLeave}</h3>
                       </div>
                       </div>
                       <div class="clearfix"></div>
                    </div>
                 </div>
                  <div class="col-md-3">
                    <div class="content">
                       <div class="w30 left-icon pull-left">
                          <img src="static/image/ic_assignment_black_48dp.png">
                       </div>
                       <div class="w70 right-title pull-right">
                       <div class="title-content">
                           <p>调休单</p>
                           <h3 class="number">${countWorkingDays}</h3>
                       </div>
                       </div>
                       <div class="clearfix"></div>
                    </div>
                 </div>
                  <div class="col-md-3">
                    <div class="content">
                       <div class="w30 left-icon pull-left">
                          <img src="static/image/ic_assignment_black_48dp.png">
                       </div>
                       <div class="w70 right-title pull-right">
                       <div class="title-content">
                           <p>加班申请</p>
                           <h3 class="number">${countOverTime}</h3>
                       </div>
                       </div>
                       <div class="clearfix"></div>
                    </div>
                 </div>
               </div>
               <!-------信息列表------->
               <div class="row newslist" style="margin-top:20px;">
                 <div class="col-md-8" style="width: 760px;">
                   <div class="panel panel-default">
                      <div class="panel-heading">
                       	公司公告
                       <div class="caret"></div>
                       		<a href="#" class="pull-right"><span class="glyphicon glyphicon-refresh"></span></a>
                       </div>     
                       <div class="panel-body">
                      	<c:forEach var="afficheList" items="${afficheList}" varStatus="status">
                      		<div class="w55 pull-left"><img src="static/image/ic_announcement_black_36dp.png"><u>${afficheList.affiche_name}</u></div>
                      	</c:forEach>
                       </div>
                    </div>
                 </div>
               </div>
               <div class="col-md-4" style="float: right;margin-top: -240px;">
               		<div class="all">
    					<div class="rili">
        					<div class="riliTop">
            					<span  id="previous" class="fl">&lt;</span>
            					<span class="showTime" id="showTime">0000-00</span>
            					<span id="next" class="fr">&gt;</span>
        					</div>
        					<ul class="riliHeader">
            					<li>日</li>
            					<li>一</li>
            					<li>二</li>
            					<li>三</li>
            					<li>四</li>
            					<li>五</li>
            					<li>六</li>
        					</ul>
        					<ul class="riliContent" id="riliContent">

        					</ul>
    					</div>
               </div>
            </div>
  </body>
</html>
