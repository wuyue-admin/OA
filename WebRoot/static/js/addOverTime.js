var jq=jQuery.noConflict();
function getAddOverTime(){
	var overtime_begin_time = $("#inputPassword").val();
	var overtime_end_time = $("#inputPassword4").val();
	var overtime_user_id = $("#inputAddress").val();
	var overtime_department_id = $("#inputAddress1").val();
	if(overtime_begin_time==null||overtime_begin_time==""){
		layer.alert("请填写加班开始时间",{icon: 7});
		return;
	}
	if(overtime_end_time==null||overtime_end_time==""){
		layer.alert("请填写加班结束时间",{icon: 7});
		return;
	}
	
	var begin = new Date(overtime_begin_time).getTime();
	var end = new Date(overtime_end_time).getTime();
	if(begin>end){
		layer.alert("请正确填写请假的开始结束时间",{icon: 7});
		return;
	}
	
	jq.ajax({
		url:"/Dem/overTime/add",
		type: "post",
		data:{
			overtime_begin_time:overtime_begin_time,
			overtime_end_time:overtime_end_time,
			overtime_user_id:overtime_user_id,
			overtime_department_id:overtime_department_id
		},
		success:function(data){
			if(data==1){
				layer.alert("加班申请创建成功",{icon: 1});
			}else{
				layer.alert("加班申请创建失败",{icon: 2});
			}
		}
	})
}

function getUpdateOverTime(){
	var overtime_begin_time = $("#inputPassword").val();
	var overtime_end_time = $("#inputPassword4").val();
	var overtime_id = $("#inputAddress").val();
	
	if(overtime_begin_time==null||overtime_begin_time==""){
		layer.alert("请填写加班开始时间",{icon: 7});
		return;
	}
	if(overtime_end_time==null||overtime_end_time==""){
		layer.alert("请填写加班结束时间",{icon: 7});
		return;
	}
	
	var begin = new Date(overtime_begin_time).getTime();
	var end = new Date(overtime_end_time).getTime();
	if(begin>end){
		layer.alert("请正确填写请假的开始结束时间",{icon: 7});
		return;
	}
	
	jq.ajax({
		url:"/Dem/overTime/update",
		type: "post",
		data:{
			overtime_begin_time:overtime_begin_time,
			overtime_end_time:overtime_end_time,
			overtime_id:overtime_id
		},
		success:function(json){
			if(json==1){
				layer.alert("加班申请修改成功",{icon: 1});
			}else{
				layer.alert("加班申请修改失败",{icon: 2});
			}
		}
	})
}
function getShenOverTime(){
	var overtime_id=$("#leave_id").val();
	var overtime_state=$("#inputState").val();
	jq.ajax({
		url:"/Dem/overTime/updateOverTimeShen",
		type:"post",
		data:{
			overtime_id:overtime_id,
			overtime_state:overtime_state
		},
		success:function(date){
			if(date==1){
				layer.alert("审核成功",{icon: 1});
			}else{
				layer.alert("审核失败",{icon: 2});
			}
		}
	})
}