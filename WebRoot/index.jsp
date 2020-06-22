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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="static/css/style.css"/>
	<link rel="stylesheet" href="static/css/layui.css" media="all">
	<link rel="stylesheet" href="static/css/layer.css">
  </head>
  
  <body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">OA办公自动化管理---后台管理</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <input id="userId" style="display: none;" value="${us.user_id}">
          <img src="static/image/${us.user_image}" class="layui-nav-img">
          		${us.user_name}
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a type="botton" onclick="getSignIn()">打卡</a></li>
      <li class="layui-nav-item"><a href="/Dem/user/logout">退了</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
      <c:forEach var="authList" items="${authList}" varStatus="status">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="${authList.authority_url}">${authList.authority_name}</a>
        </li>
      </c:forEach>
      </ul>
    </div>
  </div>
  
  <div class="layui-body" id="two">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
    
    </div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    联系我们：QQ：2741883318；邮箱：2741883318@qq.com；电话：17398362191
  </div>
</div>
<script src="static/js/layui.js"></script>
<script src="static/js/jquery-1.12.4.js"></script>
<script src="static/js/layer.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});


function clickLeft(url){
		$("#two").load(url);
		}


function getSignIn(){
	/* location.href="/Dem/attendance/signInTo"; */
	layer.open({
			type:2,
			title:"签到",
			maxmin:true,
			shadeClose: true,
			area:['800px','600px'],
			content:'/Dem/attendance/signInTo',
			end:function(){
				location.reload();
			}
		})
}

function findFriend(){
	var friend_id = $("#friend_id").val();
	$.post("/Dem/friend/findFriendById",{friend_id:friend_id},function(str){
	layer.open({
		maxmin:true,
		shadeClose: true,
		content:str,
		end:function(){
			location.reload();
		}
	})
	})
	
}
</script>

</body>
</html>
