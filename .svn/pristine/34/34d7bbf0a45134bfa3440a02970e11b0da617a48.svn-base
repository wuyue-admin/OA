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
    
    <title>My JSP 'userInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="static/css/style.css"/>
	<link rel="stylesheet" type="text/css" href="static/css/layui.css"/>
	<link rel="stylesheet" type="text/css" href="static/css/layer.css"/>
	<script type="text/javascript" src="static/js/layui.js"></script>
	<script type="text/javascript" src="static/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="static/js/layer.js"></script>
	<script type="text/javascript" src="static/dist/lay/modules/laypage.js"></script>
	<script type="text/javascript" src="static/js/userInfo.js"></script>	
		<style type="text/css">
			.thclass{
				text-align: center;
			}
			
		</style>
		
	</head>
	<body>
		
		<div>
		
			<!-- 导航 -->
			<blockquote class="layui-elem-quote">
				员工管理
			</blockquote>
			
			<form class="layui-form" action="">
					<table style="width:1000px">
						<tr>
							<td>
							<c:forEach var="button" items="${button}" varStatus="status">
								<input type="button" class="layui-btn layui-btn-normal" onclick="${button.authority_url}" value="${button.authority_name}">
							</c:forEach>
							</td>
						</tr>
					</table>
			</form>
			
				<table class="layui-table" id="test">
				  <thead>
					<tr>
					  <th></th>
					  <th>姓名</th>
					  <th>用户名</th>
					  <th>性别</th>
					  <th>所属部门</th>
					  <th>职称</th>
					  <th>上级</th>
					  <th>进本单位时间</th>
					  <th>工资</th>
					  <th>头像</th>
					</tr> 
				  </thead>
				  <tbody>
				  	<c:forEach var="userList" items="${userList}" varStatus="status">
				  		<tr>
					  		<th><input type="checkbox" name="user_id" title="" value="${userList.user_id}"></th>
					  		<th>${userList.user_name}</th>
					  		<th>${userList.user_userName}</th>
					  		<th>${userList.user_sex}</th>
					  		<th>${userList.department.department_name}</th>
					  		<th>${userList.technocal.technocal_name}</th>
					  		<th>${userList.user_up}</th>
					  		<th>${userList.user_time}</th>
					  		<th>${userList.user_sarly}</th>
					  		<th><img src="static/image/${userList.user_image}" style="height: 50px;width: 50px"></th>
					</tr>
				  	</c:forEach>
				  </tbody>
				 </table>
				 
				 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  				<div align="center">
                  	<p >当前 <span th:text="${pageInfo.pageNum}"></span> 页,总 <span th:text="${pageInfo.pages}"></span> 页,共 <span>${count}</span> 条记录</p>
    				<a class="layui-btn layui-btn-sm" th:href="@{/findAllCake}">首页</a>
   					<a class="layui-btn layui-btn-sm" th:href="@{/findAllCake(pageNum=${pageInfo.hasPreviousPage}?${pageInfo.prePage}:1)}">上一页</a>
    				<a class="layui-btn layui-btn-sm" th:href="@{/findAllCake(pageNum=${pageInfo.hasNextPage}?${pageInfo.nextPage}:${pageInfo.pages})}">下一页</a>
    				<a class="layui-btn layui-btn-sm" th:href="@{/findAllCake(pageNum=${pageInfo.pages})}">尾页</a>
    			</div>
				 </fieldset>
				
		</div>	
		<script>
		layui.use(['laypage', 'layer' , 'form'], function(){
		  var form = layui.form;
		});
		
	function findUserById(){
	
		var user_id = $("input[name='user_id']:checked").val();
		var num = $("input[name='user_id']:checked").length;
		
		if(num==0){
			layer.alert("请选择一个用户",{icon: 7});
			return;
		}
		
		if(num>1){
			layer.alert("只能选择一个用户",{icon: 7});
			return;
		}
	
		layer.open({
			type:2,
			title:"修改用户信息",
			maxmin:true,
			shadeClose: true,
			area:['800px','600px'],
			content:'/Dem/user/findUserById?user_id='+user_id,
			end:function(){
				location.reload();
			}
		})
	}
	
	function getUserExcel(){
		location.href="/Dem/user/excel";
	}
	
	function delUser(){
		var user_id = $("input[name='user_id']:checked").val();
		var num = $("input[name='user_id']:checked").length;
		
		if(num==0){
			layer.alert("请选择一个用户",{icon: 7});
			return;
		}
		
		if(num>1){
			layer.alert("只能选择一个用户",{icon: 7});
			return;
		}
		
		$.ajax({
			url:"/Dem/user/delUser",
			type: "post",
			data:{
				user_id:user_id
			},
			success:function(json){
				if(json==1){
					layer.alert("删除成功",{icon: 1});
					setTimeout(function(){
						location.reload();
					},1000);
				}else{
					layer.alert("删除失败",{icon: 1});
					setTimeout(function(){
						location.reload();
					},1000);
				}
			}
		})
	}
		</script>
	</body>
</html>
