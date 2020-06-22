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
    
    <title>My JSP 'phone.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="static/dist/css/layui.css" media="all">
	<link rel="stylesheet" href="static/dist/css/modules/layer/default/layer.css">
	<link rel="stylesheet" href="static/dist/css/modules/layim/layim.css">
	<link rel="stylesheet" href="static/dist/css/modules/code.css">
	<link rel="stylesheet" href="static/dist/css/modules/layim/mobile/layim.css">
	<script src="static/js/jquery.1.12.4.js"></script>
	<script src="static/dist/layui.js"></script>
	<script src="static/dist/lay/modules/layer.js"></script>
	<script src="static/dist/lay/modules/layim.js"></script>
	<!-- <script src="static/js/friendTell.js"></script> -->
	
  </head>
  
  <body>
  <div class="layui-layer layui-layer-page layui-box layui-layim" id="layui-layer2" type="page" times="2" showtime="0" contype="string" style="z-index: 19891016; width: 260px; height: 419px; left: 380px; background-image: url(static/dist/css/modules/layim/skin/3.jpg);">
  	<div class="layui-layer-title" style="cursor: move;">​</div>
  	<div id="layui-layim" class="layui-layer-content">
  		<div class="layui-layim-main">
  			<div class="layui-layim-info">
  			<div class="layui-layim-user">纸飞机</div>
  				<div class="layui-layim-status">
  					<span class="layui-icon layim-status-online" layim-event="status" lay-type="show"></span>
  					<ul class="layui-anim layim-menu-box" style="display: none;">
  						<li class="layim-this" layim-event="status" lay-type="online">
  							<i class="layui-icon"></i>
  							<cite class="layui-icon layim-status-online"></cite>在线
  						</li>
  						<li layim-event="status" lay-type="hide">
  							<i class="layui-icon"></i>
  							<cite class="layui-icon layim-status-hide"></cite>隐身
  						</li>
  					</ul>
  				</div>
  			<input class="layui-layim-remark" placeholder="编辑签名" value="在深邃的编码世界，做一枚轻盈的纸飞机">
  		</div>
  		<ul class="layui-unselect layim-tab-content layui-show layim-list-friend">
  			<li><h5 layim-event="spread" lay-type="true">
  					<i class="layui-icon"></i>
  					<span>知名人物</span>
  					<em>(<cite class="layim-count"> 5</cite>)</em>
  				</h5>
  				<ul class="layui-layim-list  layui-show">
  				<c:forEach var="friendList" items="${friendList}" varStatus="status">
  					<li layim-event="chat" onclick="findFriend()" data-type="friend" data-index="0" class="layim-friend100001 ">
  						<input type="text" id="friend_id" value="${friendList.friend_id}" style="display: none;">
  						<img src="${friendList.friend_image}">
  						<span>${friendList.friend_name}</span>
  						<p>${friendList.friend_context}</p>
  						<span class="layim-msg-status">new</span>
  					</li>
  				</c:forEach>
  				</ul>
  			</li>
  		</ul>
  	</div>
  </div>
</div>
    	
</body>
</html>
