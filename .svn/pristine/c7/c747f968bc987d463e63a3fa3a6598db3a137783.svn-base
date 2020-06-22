var jq=jQuery.noConflict();
function findTechnocal(){
var department_id = jq("#inputStat").val();
		 jq.ajax({
		 	url:"/Dem/user/adminCount",
		 	async: false,
		 	type:"post",
		 	data:{
		 		department_id:department_id
		 	},
		 	success:function(data){
		 		if(data==1){
		 			jq("#cheng").load("/Dem/user/getTechnocalList.admin #inputState1");
		 		}else{
		 			jq("#cheng").load("/Dem/user/getTechnocalList #inputState1");
		 		}
		 	}
		 })
}

function getZhi(){
	var technocal_id = jq("#inputState1").val();
	 jq.ajax({
	 	url:"/Dem/user/getTechnocalAllById",
	 	async: false,
	 	type:"post",
	 	data:{
	 		technocal_id:technocal_id
	 	},
	 	success:function(technocal_shu){
	 	var date=technocal_shu;
	 	var data={
	 			date:date	
	 	};
	 		if(technocal_shu>0){
	 			jq("#boss").load("/Dem/user/getTechnocalById #inputState2",data);
	 		}else{
	 			jq("#technocalType").css("display","none");
	 		}
	 	}
	 })
	
}

function getAddUser(){
	var user_name = $("#inputEmail4").val();
	var user_userName = $("#inputPassword4").val();
	var user_password = $("#inputAddress").val();
	var user_salt = $("#inputAddress2").val();
	var user_sex = $("input[type='radio']:selected").val();
	var user_department_id = $("#inputStat").val();
	var user_technical_id = $("#inputState1").val();
	var user_up = $("#inputState2").val();
	var user_time = $("#user_time").val();
	var user_sarly= $("#user_sarly").val();
	var user_image = $("#user_image").val();
	
	if(user_name==null||user_name==""){
		layer.alert("用户姓名不能为空",{icon: 7});
		return;
	}
	
	if(user_userName==null||user_userName==""){
		layer.alert("用户名不能为空",{icon: 7});
		return;
	}
	
	if(user_password==null||user_password==""){
		layer.alert("用户密码不能为空",{icon: 7});
		return;
	}
	
	if(user_salt==null||user_salt==""){
		layer.alert("请确认您的密码",{icon: 7});
		return;
	}
	
	if(user_sex==null||user_sex==""){
		layer.alert("用户性别不能为空",{icon: 7});
		return;
	}
	
	if(user_department_id==0){
		layer.alert("用户职位不能为空",{icon: 7});
		return;
	}
	
	if(user_technical_id==0){
		layer.alert("用户职称不能为空",{icon: 7});
		return;
	}
	
	if(user_time==null||user_time==""){
		layer.alert("用户入职时间不能为空",{icon: 7});
		return;
	}
	
	if(user_sarly==null||user_sarly==""){
		layer.alert("用户工资不能为空",{icon: 7});
		return;
	}
	
	if(user_image==null||user_image==""){
		layer.alert("用户头像不能为空",{icon: 7});
		return;
	}
	
	var fileName = getFileName(user_image);
	function getFileName(o){
		var pos = o.lastIndexOf("\\");
		return o.substring(pos+1);
	}
	
	var userData = {
			user_name:user_name,
			user_userName:user_userName,
			user_password:user_password,
			user_salt:user_salt,
			user_sex:user_sex,
			user_department_id:user_department_id,
			user_technical_id:user_technical_id,
			user_time:user_time,
			user_sarly:user_sarly,
			user_image:fileName,
			user_up:user_up
	}
	
	jq.ajax({
		url:"/Dem/user/addUserNew",
		type: "post",
		data:userData,
		success:function(json){
			if(json==1){
				layer.alert("添加成功",{icon: 1});
				location.href="javascript:clickLeft('/Dem/user/userInfo?authority_gui=2')";
			}else{
				layer.alert("添加失败",{icon: 2});
			}
		}
		
	})
	
}