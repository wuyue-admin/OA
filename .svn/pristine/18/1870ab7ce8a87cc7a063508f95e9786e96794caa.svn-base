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
    
    <title>My JSP 'leaveInfo.jsp' starting page</title>
    
    
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
				请假单管理
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
					  <th>申请人姓名</th>
					  <th>所属部门</th>
					  <th>请假开始时间</th>
					  <th>请假结束时间</th>
					  <th>请假单状态</th>
					  <th>请假原因</th>
					  <th>创建请假单时间</th>
					  <th>审核状态</th>
					</tr> 
				  </thead>
				  <tbody>
				  	<c:forEach var="leaveList" items="${leaveList}" varStatus="status">
				  		<tr>
					  		<th><input type="checkbox" name="leave_id" title="" value="${leaveList.leave_id}"></th>
					  		<th>${leaveList.user.user_name}</th>
					  		<th>${leaveList.department.department_name}</th>
					  		<th>${leaveList.leave_start_time}</th>
					  		<th>${leaveList.leave_end_time}</th>
					  		<th>${leaveList.leaveState.leave_state_name}</th>
					  		<th>${leaveList.leave_context}</th>
					  		<th>${leaveList.leave_time}</th>
					  		<th>${leaveList.state.state_name}</th>
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
		
	function addLeave(){
		layer.open({
			type:2,
			title:"申请请假单",
			maxmin:true,
			shadeClose: true,
			area:['800px','600px'],
			content:'/Dem/leave/getDepartment',
			end:function(){
				location.reload();
			}
		})
	}
	
	function getLeaveExcel(){
		location.href="/Dem/leave/excel"
	}
		
	function findLeaveById(){
	
		var leave_id = $("input[name='leave_id']:checked").val();
		var num = $("input[name='leave_id']:checked").length;
		
		if(num==0){
			layer.alert("请选择一个请假单",{icon: 7});
			return;
		}
		
		if(num>1){
			layer.alert("只能选择一个请假单",{icon: 7});
			return;
		}
	
		layer.open({
			type:2,
			title:"修改请假单信息",
			maxmin:true,
			shadeClose: true,
			area:['800px','600px'],
			content:'/Dem/leave/findLeaveById?leave_id='+leave_id,
			end:function(){
				location.reload();
			}
		})
	}
	
	function findLeaveShen(){
	
		var leave_id = $("input[name='leave_id']:checked").val();
		var num = $("input[name='leave_id']:checked").length;
		
		if(num==0){
			layer.alert("请选择一个请假单",{icon: 7});
			return;
		}
		
		if(num>1){
			layer.alert("只能选择一个请假单",{icon: 7});
			return;
		}
	
		layer.open({
			type:2,
			title:"修改请假单信息",
			maxmin:true,
			shadeClose: true,
			area:['800px','600px'],
			content:'/Dem/leave/findLeaveByShen?leave_id='+leave_id,
			end:function(){
				location.reload();
			}
		})
	}
	
	function findLeave(){
		var leave_id = $("input[name='leave_id']:checked").val();
		var num = $("input[name='leave_id']:checked").length;
		
		if(num==0){
			layer.alert("请选择一个请假单",{icon: 7});
			return;
		}
		
		if(num>1){
			layer.alert("只能选择一个请假单",{icon: 7});
			return;
		}
	
		layer.open({
			type:2,
			title:"修改请假单信息",
			maxmin:true,
			shadeClose: true,
			area:['800px','600px'],
			content:'/Dem/leave/findLeaveById?leave_id='+leave_id,
			end:function(){
				location.reload();
			}
		})
	}
	
	function update(){
		var leave_id = $("input[name='leave_id']:checked").val();
		var num = $("input[name='leave_id']:checked").length;
		
		if(num==0){
			layer.alert("请选择一个请假单",{icon: 7});
			return;
		}
		
		if(num>1){
			layer.alert("只能选择一个请假单",{icon: 7});
			return;
		}
		$.ajax({
			url:"/Dem/leave/update",
			type:"post",
			data:{
				leave_id:leave_id
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
	
	function delLeave(){
		var leave_id = $("input[name='leave_id']:checked").val();
		var num = $("input[name='leave_id']:checked").length;
		
		if(num==0){
			layer.alert("请选择一个请假单",{icon: 7});
			return;
		}
		
		if(num>1){
			layer.alert("只能选择一个请假单",{icon: 7});
			return;
		}
		
		$.ajax({
			url:"/Dem/leave/delLeave",
			type: "post",
			data:{
				leave_id:leave_id
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
