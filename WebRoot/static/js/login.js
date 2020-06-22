function getRegist(){
	var user_name = $("#user_name").val();
	var user_userName=$("#user_userName").val();
	var user_password=$("#user_password").val();
	var user_salt=$("#user_salt").val();
	var user_image="2.jpg";
	
	if(user_name==null||user_name==""){
		layer.alert("姓名不能为空",{icon: 7});
		return;
	}
	if(user_userName==null||user_userName==""){
		layer.alert("用户名不能为空",{icon: 7});
		return;
	}
	if(user_password==null||user_password==""){
		layer.alert("密码不能为空",{icon: 7});
		return;
	}
	if(user_salt==null||user_salt==""){
		layer.alert("验证一下您的密码",{icon: 7});
		return;
	}
	if(user_salt!=user_password){
		layer.alert("两次密码需要一样",{icon: 7});
		return;
	}
	
//	$("#user_userName").blur(function(){
//		$.ajax({
//			url:"/Winding/regist.userName",
//			type:"post",
//			data: {
//				user_userName:user_userName
//	        },
//	        success:function(date){
//	        	if(date==1){
//	        		layer.alert('您的用户名不能重复呦', {icon: 7});
//	        		return;
//	        	}else{
//	        		layer.alert('您的名称可以使用', {icon: 7});
//	        	}
//	        }
//		})
//	})
	
//	var fileName = getFileName(user_image);
//	function getFileName(o){
//		var pos = o.lastIndexOf("\\");
//		return o.substring(pos+1);
//	}
//	
	$.ajax({
		url:"/Dem/user/regist",
		type: "post",
		data:{
			user_name:user_name,
			user_userName:user_userName,
			user_password:user_password,
			user_salt:user_salt,
			user_image:user_image
		},
		success:function(data){
			if(data>0){
				location.href="/Dem/user/login"
			}else{
				layer.alert("注册失败",{icon: 2});
			}
		}
		
	})
	
}

