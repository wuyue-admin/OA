var jq=jQuery.noConflict();
function getAddWorkingOff(){
	var workingoff_name=$("#inputAddress").val();
	var workingoff_department_id = $("#disabledSelect").val();
	var workingoff_begin_time = $("#inputEmail4").val();
	var workingoff_end_time = $("#inputPassword4").val();
	var workingoff_context = $("#exampleFormControlTextarea1").val();
	var workingoff_time = $("#user_time").val();
	
	if(workingoff_begin_time==null||workingoff_begin_time==""){
		layer.alert("调休开始时间不能为空");
		return;
	}
	if(workingoff_end_time==null||workingoff_end_time==""){
		layer.alert("调休结束时间不能为空");
		return;
	}
	if(workingoff_context==null||workingoff_context==""){
		layer.alert("调休原因不能为空");
		return;
	}
	var begin = new Date(workingoff_begin_time).getTime();
	var end = new Date(workingoff_end_time).getTime();
	
	if(begin>end){
		layer.alert("请正确填写请假的开始结束时间",{icon: 7});
		return;
	}
	
	var workingOff = {
			workingoff_name:workingoff_name,
			workingoff_department_id:workingoff_department_id,
			workingoff_begin_time:workingoff_begin_time,
			workingoff_end_time:workingoff_end_time,
			workingoff_context:workingoff_context,
			workingoff_time:workingoff_time
	}
	
	jq.ajax({
		url:"/Dem/workingoff/addWorkingOff",
		type: "post",
		data:workingOff,
		success:function(data){
			if(data==1){
				layer.alert("添加成功",{icon: 1});
			}else{
				layer.alert("添加成功",{icon: 2});
			}
		}
	})
	
}

function getUpdateWorkingOff(){
	var workingoff_id=$("#leave_id").val();
	var workingoff_begin_time=$("#inputEmail4").val();
	var workingoff_end_time=$("#inputPassword4").val();
	var workingoff_context=$("#exampleFormControlTextarea1").val();
	if(workingoff_begin_time==null||workingoff_begin_time==""){
		layer.alert("调休开始时间不能为空");
		return;
	}
	if(workingoff_end_time==null||workingoff_end_time==""){
		layer.alert("调休结束时间不能为空");
		return;
	}
	if(workingoff_context==null||workingoff_context==""){
		layer.alert("调休原因不能为空");
		return;
	}
	var begin = new Date(workingoff_begin_time).getTime();
	var end = new Date(workingoff_end_time).getTime();
	
	if(begin>end){
		layer.alert("请正确填写请假的开始结束时间",{icon: 7});
		return;
	}
	var workingOff = {
			workingoff_id:workingoff_id,
			workingoff_begin_time:workingoff_begin_time,
			workingoff_end_time:workingoff_end_time,
			workingoff_context:workingoff_context
	}
	
	jq.ajax({
		url:"/Dem/workingoff/update",
		type: "post",
		data:workingOff,
		success:function(data){
			if(data==1){
				layer.alert("修改成功",{icon: 1});
			}else{
				layer.alert("修改成功",{icon: 2});
			}
		}
	})
}
function getShenWorkingOff(){
	var workingoff_id = $("#leave_id").val();
	var workingoff_state = $("#inputState").val();
	jq.ajax({
		url:"/Dem/workingoff/updateWorkingOffByShen",
		type: "post",
		data:{
			workingoff_id:workingoff_id,
			workingoff_state:workingoff_state
		},
		success:function(json){
			if(json==1){
				layer.alert("审核成功",{icon: 1});
			}else{
				layer.alert("审核失败",{icon: 1});
			}
		}
	})
}
