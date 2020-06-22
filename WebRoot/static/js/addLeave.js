var jq=jQuery.noConflict();
function getAddLeave(){
	var leave_name = $("#inputAddress").val();
	var leave_start_time = $("#inputEmail4").val();
	var leave_end_time = $("#inputPassword4").val();
	var leave_type = $("input[type='radio']:checked").val();
	var leave_department_id = $("#disabledSelect").val();
	var leave_context = $("#exampleFormControlTextarea1").val();
	var leave_time = $("#user_time").val();
	
	if(leave_name==null||leave_name==""){
		layer.alert("请假人姓名不能为空",{icon: 7});
		return;
	}
	
	if(leave_start_time==null||leave_start_time==""){
		layer.alert("请填写请假开始时间",{icon: 7});
		return;
	}
	
	if(leave_end_time==null||leave_end_time==""){
		layer.alert("请填写请假结束时间",{icon: 7});
		return;
	}
	
	if(leave_type==null||leave_type==""){
		layer.alert("请填写请假类型",{icon: 7});
		return;
	}
	
	if(leave_department_id==0){
		layer.alert("请填写申请人所属部门",{icon: 7});
		return;
	}
	
	if(leave_context==null||leave_context==""){
		layer.alert("请说明请假的原由",{icon: 7});
		return;
	}
	
	if(leave_time==null||leave_time==""){
		layer.alert("请填写创建请假单的时间",{icon: 7});
		return;
	}
	
	var begin = new Date(leave_start_time).getTime();
	var end = new Date(leave_end_time).getTime();
	
	if(begin>end){
		layer.alert("请正确填写请假的开始结束时间",{icon: 7});
		return;
	}
	
	var leave = {
			leave_name:leave_name,
			leave_start_time:leave_start_time,
			leave_end_time:leave_end_time,
			leave_type:leave_type,
			leave_department_id:leave_department_id,
			leave_context:leave_context,
			leave_time:leave_time
	}
	
	jq.ajax({
		url:"/Dem/leave/addLeave",
		type: "post",
		data:leave,
		success:function(data){
			if(data==1){
				layer.alert("请假单创建成功",{icon: 1});
			}else{
				layer.alert("请假单创建失败",{icon: 2});
			}
		}
	})
}

function getUpdateLeave(){
	var leave_start_time = $("#inputEmail4").val();
	var leave_end_time = $("#inputPassword4").val();
	var leave_id = $("#leave_id").val();
	var begin = new Date(leave_start_time).getTime();
	var end = new Date(leave_end_time).getTime();
	var leave_context = $("#exampleFormControlTextarea1").val();
	
	if(leave_start_time==null||leave_start_time==""){
		layer.alert("请填写请假开始时间",{icon: 7});
		return;
	}
	
	if(leave_end_time==null||leave_end_time==""){
		layer.alert("请填写请假结束时间",{icon: 7});
		return;
	}
	
	if(leave_context==null||leave_context==""){
		layer.alert("请说明请假的原由",{icon: 7});
		return;
	}
	
	if(begin>end){
		layer.alert("请正确填写请假的开始结束时间",{icon: 7});
		return;
	}
	
	var updateLeave = {
			leave_id:leave_id,
			leave_start_time:leave_start_time,
			leave_end_time:leave_end_time,
			leave_context:leave_context
	}
	
	jq.ajax({
		url:"/Dem/leave/updateLeave",
		type: "post",
		data:updateLeave,
		success:function(json){
			if(json==1){
				layer.alert("请假单修改成功",{icon: 1});
			}else{
				layer.alert("请假单修改失败",{icon: 2});
			}
		}
	})
}

function getShenLeave(){
	var leave_id = $("#leave_id").val();
	var leave_state = $("#inputState").val();
	jq.ajax({
		url:"/Dem/leave/updateLeaveByShen",
		type: "post",
		data:{
			leave_id:leave_id,
			leave_state:leave_state
		},
		success:function(jsons){
			if(jsons==1){
				layer.alert("请假单审核成功",{icon: 1});
			}else{
				layer.alert("请假单审核失败",{icon: 2});
			}
		}
	})
}