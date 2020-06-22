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
    
    <title>My JSP 'phoneTell.jsp' starting page</title>
    
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
	<script src="static/js/friendTell.js"></script>
  </head>
  
  <body>
  	<div class="layui-layer layui-layer-page layui-box layui-layim-chat" id="layui-layer4" type="page" times="4" showtime="0" contype="string" style="z-index: 19891018; width: 600px; top: 116px; min-width: 500px; min-height: 420px; background-image: url(&quot;https://res.layui.com/layui/dist/css/modules/layim/skin/4.jpg&quot;);">
  		<div class="layui-layer-title" style="cursor: move;">​</div>
  		<div id="layui-layim-chat" class="layui-layer-content">
  			<ul class="layui-unselect layim-chat-list">
  				<li class="layim-friend10034001 layim-chatlist-friend10034001 layim-this" layim-event="tabChat">
  					<img src="//tva2.sinaimg.cn/crop.1.0.747.747.180/633f068fjw8f9h040n951j20ku0kr74t.jpg">
  					<span>谢小楠</span>
  					<i class="layui-icon" layim-event="closeChat">ဇ</i>
  				</li>
  			</ul>
  			<div class="layim-chat-box">
  				<div class="layim-chat layim-chat-friend layui-show">
  					<div class="layui-unselect layim-chat-title">
  						<div class="layim-chat-other">
  							<img class="layim-friend10034001" src="//tva2.sinaimg.cn/crop.1.0.747.747.180/633f068fjw8f9h040n951j20ku0kr74t.jpg">
  							<span class="layim-chat-username" layim-event="">谢小楠  </span>
  							<p class="layim-chat-status"></p>
  						</div>
  					</div>
  					<div class="layim-chat-main">
  						<ul></ul>
  					</div>
  					<div class="layim-chat-footer">
  						<div class="layui-unselect layim-chat-tool" data-json="%7B%22username%22%3A%22%E8%B0%A2%E5%B0%8F%E6%A5%A0%22%2C%22id%22%3A%2210034001%22%2C%22avatar%22%3A%22%2F%2Ftva2.sinaimg.cn%2Fcrop.1.0.747.747.180%2F633f068fjw8f9h040n951j20ku0kr74t.jpg%22%2C%22sign%22%3A%22%22%2C%22name%22%3A%22%E8%B0%A2%E5%B0%8F%E6%A5%A0%22%2C%22type%22%3A%22friend%22%7D">
  							<span class="layui-icon layim-tool-face" title="选择表情" layim-event="face"></span>
  							<span class="layui-icon layim-tool-image" title="上传图片" layim-event="image">
  								<input type="file" name="file">
  							</span>
  							<span class="layui-icon layim-tool-image" title="发送文件" layim-event="image" data-type="file">
  								<input type="file" name="file">
  							</span>
  							<span class="layui-icon layim-tool-audio" title="发送网络音频" layim-event="media" data-type="audio"></span>
  							<span class="layui-icon layim-tool-video" title="发送网络视频" layim-event="media" data-type="video"></span>
  							<span class="layui-icon layim-tool-code" title="代码" layim-event="extend" lay-filter="code"></span>
  							<span class="layim-tool-log" layim-event="chatLog">
  								<i class="layui-icon"></i>
  									聊天记录
  							</span>
  						</div>
  						<div class="layim-chat-textarea">
  							<textarea></textarea>
  						</div>
  						<div class="layim-chat-bottom">
  							<div class="layim-chat-send">
  								<span class="layim-send-close" layim-event="closeThisChat">关闭</span>
  								<span class="layim-send-btn" layim-event="send">发送</span>
  								<span class="layim-send-set" layim-event="setSend" lay-type="show">
  									<em class="layui-edge"></em>
  								</span>
  								<ul class="layui-anim layim-menu-box">
  									<li class="layim-this" layim-event="setSend" lay-type="Enter">
  										<i class="layui-icon"></i>
  											按Enter键发送消息
  									</li>
  									<li layim-event="setSend" lay-type="Ctrl+Enter">
  										<i class="layui-icon"></i>
  											按Ctrl+Enter键发送消息
  									</li>
  								</ul>
  							</div>
  						</div>
  					</div>
  				</div>
  			</div>
  		</div>
  		<span class="layui-layer-setwin">
  			<a class="layui-layer-min" href="javascript:;">
  				<cite></cite>
  			</a>
  			<a class="layui-layer-ico layui-layer-max" href="javascript:;"></a>
  			<a class="layui-layer-ico layui-layer-close layui-layer-close1" href="javascript:;"></a>
  		</span>
  		<span class="layui-layer-resize"></span>
  	</div>
  </body>
</html>
