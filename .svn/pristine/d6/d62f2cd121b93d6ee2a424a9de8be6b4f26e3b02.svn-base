<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link rel="stylesheet" type="text/css" href="static/css/layer.css">
	<script src="static/js/jquery-1.12.4.js"></script>
	<script src="../js/layer.js"></script>
	<script src="static/js/login.js" type="text/javascript"></script>
		<script>
			$(document).ready(function() {
				
				$(".form").slideDown(500);
				
				$("#landing").addClass("border-btn");

				$("#registered").click(function() {
					$("#landing").removeClass("border-btn");
					$("#landing-content").hide(500);
					$(this).addClass("border-btn");
					$("#registered-content").show(500);
					
				})

				$("#landing").click(function() {
					$("#registered").removeClass("border-btn");
					$(this).addClass("border-btn");
					
					$("#landing-content").show(500);
					$("#registered-content").hide(500);
				})
			});
			
			function getLogin(){
				var user_userName=$("#user_userName1").val();
				var user_password=$("#user_password1").val();
	
				if(user_userName==null||user_userName==""){
					layer.alert("用户名不能为空",{icon: 7});
					return;
				}
	
				if(user_password==null||user_password==""){
					layer.alert("密码不能为空",{icon: 7});
					return;
				}
				$.ajax({
					url:"/Dem/user/login.do",
					type :"post",
					data:{
						user_userName:user_userName,
						user_password:user_password
					},
					success:function(json){
						if(json>0){
							location.href="/Dem/authority/authorityList"
						}else{
							layer.alert("登录失败",{icon: 2});
						}
					}
		
				})
	
			}
		</script>
		<style>
			* {
				margin: 0;
				padding: 0;
				font-family: "微软雅黑";
			}
			
			body {
				background: #F7F7F7;
			}
			
			.form {
				position: absolute;
				top: 50%;
				left: 50%;
				margin-left: -185px;
				margin-top: -210px;
				height: 420px;
				width: 340px;
				font-size: 18px;
				-webkit-box-shadow: 0px 0px 10px #A6A6A6;
				background: #fff;
			}
			
			.border-btn {
				border-bottom: 1px solid #ccc;
			}
			
			#landing,
			#registered {
				float: left;
				text-align: center;
				width: 170px;
				padding: 15px 0;
				color: #545454;
			}
			
			#landing-content {
				clear: both;
			}
			
			.inp {
				height: 30px;
				margin: 0 auto;
				margin-bottom: 30px;
				width: 200px;
			}
			
			.inp>input {
				text-align: center;
				height: 30px;
				width: 200px;
				margin: 0 auto;
				transition: all 0.3s ease-in-out;
			}
			
			.login {
				border: 1px solid #A6A6A6;
				color: #a6a6a6;
				height: 30px;
				width: 202px;
				text-align: center;
				font-size: 13.333333px;
				margin-left: 70px;
				line-height: 30px;
				margin-top: 30px;
				transition: all 0.3s ease-in-out;
			}
			
			.login:hover {
				background: #A6A6A6;
				color: #fff;
			}
			
			#bottom {
				margin-top: 30px;
				font-size: 13.333333px;
				color: #a6a6a6;
			}
			
			#registeredtxt {
				float: left;
				margin-left: 80px;
			}
			
			#forgotpassword {
				float: right;
				margin-right: 80px;
			}
			
			#photo {
				border-radius: 80px;
				border: 1px solid #ccc;
				height: 80px;
				width: 80px;
				margin: 0 auto;
				overflow: hidden;
				clear: both;
				margin-top: 30px;
				margin-bottom: 30px;
			}
			
			#photo>img:hover {
				-webkit-transform: rotateZ(360deg);
				-moz-transform: rotateZ(360deg);
				-o-transform: rotateZ(360deg);
				-ms-transform: rotateZ(360deg);
				transform: rotateZ(360deg);
			}
			
			#photo>img {
				height: 80px;
				width: 80px;
				-webkit-background-size: 220px 220px;
				border-radius: 60px;
				-webkit-transition: -webkit-transform 1s linear;
				-moz-transition: -moz-transform 1s linear;
				-o-transition: -o-transform 1s linear;
				-ms-transition: -ms-transform 1s linear;
			}
			
			
			#registered-content {
				margin-top: 20px;
				display: none;
			}
			
			.fix {
				clear: both;
			}
			.form{
				display: none;
			}
		</style>
	</head>

	<body>
		<div class="form">
			<div id="landing">登录</div>
			<div id="registered">注册</div>
			<div class="fix"></div>
			<div id="landing-content">
				<div id="photo"><img src="static/image/photo.jpg" /></div>
				<div class="inp"><input type="text" id="user_userName1" placeholder="用户名" /></div>
				<div class="inp"><input type="password" id="user_password1" placeholder="密码" /></div>
				<div class="login" onclick="getLogin()">登录</div>
				<div id="bottom"><span id="registeredtxt">立即注册</span><span id="forgotpassword">忘记密码</span></div>
			</div>
			<div id="registered-content">
				<div class="inp"><input type="text" id="user_name" placeholder="请输入姓名" /></div>
				<div class="inp"><input type="text" id="user_userName" placeholder="请输入用户名" /></div>
				<div class="inp"><input type="password" id="user_password" placeholder="请输入密码" /></div>
				<div class="inp"><input type="password" id="user_salt" placeholder="请再次输入密码" /></div>
				<div class="login" onclick="getRegist()">立即注册</div>
			</div>
		</div>
  </body>
</html>
