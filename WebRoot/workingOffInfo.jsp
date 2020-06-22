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
    
    <title>My JSP 'workingOffInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
		<input type="text" id="count" value="${count}" style="display: none;">
		
			<!-- 导航 -->
			<blockquote class="layui-elem-quote">
				员工管理
			</blockquote>
			
			<form class="layui-form" action="">
					<table>
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
					  <th>开始时间</th>
					  <th>结束时间</th>
					  <th>所属部门</th>
					  <th>原因</th>
					  <th>申请时间</th>
					  <th>审核状态</th>
					</tr> 
				  </thead>
				  <tbody>
				  	<c:forEach var="workingOffList" items="${workingOffList}" varStatus="status">
				  		<tr>
					  		<th><input type="checkbox" name="user_id" title="" value="${workingOffList.workingoff_id}"></th>
					  		<th>${workingOffList.workingoff_name}</th>
					  		<th>${workingOffList.workingoff_begin_time}</th>
					  		<th>${workingOffList.workingoff_end_time}</th>
					  		<th>${workingOffList.department.department_name}</th>
					  		<th>${workingOffList.workingoff_context}</th>
					  		<th>${workingOffList.workingoff_time}</th>
					  		<th>${workingOffList.state.state_name}</th>
					</tr>
				  	</c:forEach>
				  </tbody>
				 </table>
				 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  				<div align="center">
                  	<p >当前 <span th:text="${pageInfo.pageNum}"></span> 页,总 <span th:text="${pageInfo.pages}"></span> 页,共 <span th:text="${pageInfo.total}"></span> 条记录</p>
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
	
	function addWorkingOff(){
	var count = $("#count").val();
	if(count==0){
		layer.alert("您当前不具备调休资格",{icon: 7});
		return;
	}else{
		layer.open({
			type:2,
			title:"申请调休信息",
			maxmin:true,
			shadeClose: true,
			area:['600px','400px'],
			content:'/Dem/workingoff/addWorkingOddTo',
			end:function(){
				location.reload();
			}
		})
	}
	}
	
	function excel(){
		location.href="/Dem/workingoff/excel"
	}
	
	function findWorkingOffByShen(){
		var workingoff_id = $("input[name='user_id']:checked").val();
		var num = $("input[name='user_id']:checked").length;
		
		if(num==0){
			layer.alert("请选择一个调休申请",{icon: 7});
			return;
		}
		
		if(num>1){
			layer.alert("只能选择一个调休申请",{icon: 7});
			return;
		}
	
		layer.open({
			type:2,
			title:"审核调休",
			maxmin:true,
			shadeClose: true,
			area:['800px','600px'],
			content:'/Dem/workingoff/findWorkingOffByShen?workingoff_id='+workingoff_id,
			end:function(){
				location.reload();
			}
		})
	}
		
	function findWorkingOffById(){
	
		var workingoff_id = $("input[name='user_id']:checked").val();
		var num = $("input[name='user_id']:checked").length;
		
		if(num==0){
			layer.alert("请选择一个调休申请",{icon: 7});
			return;
		}
		
		if(num>1){
			layer.alert("只能选择一个调休申请",{icon: 7});
			return;
		}
	
		layer.open({
			type:2,
			title:"修改用户信息",
			maxmin:true,
			shadeClose: true,
			area:['800px','600px'],
			content:'/Dem/workingoff/findWorkingOffById?workingoff_id='+workingoff_id,
			end:function(){
				location.reload();
			}
		})
	}
	
	function update(){
		var workingoff_id = $("input[name='user_id']:checked").val();
		var num = $("input[name='user_id']:checked").length;
		
		if(num==0){
			layer.alert("请选择一个调休申请",{icon: 7});
			return;
		}
		
		if(num>1){
			layer.alert("只能选择一个调休申请",{icon: 7});
			return;
		}
		$.ajax({
			url:"/Dem/workingoff/updateWorkingOff",
			type: "post",
			data:{
				workingoff_id:workingoff_id
			},
			success:function(data){
				if(data==1){
					layer.alert("提交成功",{icon: 1});
					setTimeout(function(){
						location.reload();
					},1000);
				}else{
					layer.alert("提交失败",{icon: 2});
					setTimeout(function(){
						location.reload();
					},1000);
				}
			}
		})
	}
	
	function findWorkingOffByShen(){
		var workingoff_id = $("input[name='user_id']:checked").val();
		var num = $("input[name='user_id']:checked").length;
		
		if(num==0){
			layer.alert("请选择一个调休申请",{icon: 7});
			return;
		}
		
		if(num>1){
			layer.alert("只能选择一个调休申请",{icon: 7});
			return;
		}
		layer.open({
			type:2,
			title:"审核调休",
			maxmin:true,
			shadeClose: true,
			area:['800px','600px'],
			content:'/Dem/workingoff/findWorkingOffByShen?workingoff_id='+workingoff_id,
			end:function(){
				location.reload();
			}
		})
	}
	
	function getUserExcel(){
		location.href="/Dem/user/excel";
	}
	
	function delWorkingOff(){
		var workingoff_id = $("input[name='user_id']:checked").val();
		var num = $("input[name='user_id']:checked").length;
		
		if(num==0){
			layer.alert("请选择一个调休申请",{icon: 7});
			return;
		}
		
		if(num>1){
			layer.alert("只能选择一个调休申请",{icon: 7});
			return;
		}
		
		$.ajax({
			url:"/Dem/workingoff/delWorkingOff",
			type: "post",
			data:{
				workingoff_id:workingoff_id
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
