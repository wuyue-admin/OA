var jq=jQuery.noConflict();
function getAddAffiche(){
	var affiche_name = $("#exampleFormControlTextarea1").val();
	var affiche_time = $("#inputPassword4").val();
	var affiche_user_id = $("#inputAddress").val();
	if(affiche_name==null||affiche_name==""){
		layer.alert("公告的内容怎么能为空呢",{icon: 7});
		return;
	}
	jq.ajax({
		url:"/Dem/affiche/addAffiche",
		type: "post",
		data:{
			affiche_name:affiche_name,
			affiche_time:affiche_time,
			affiche_user_id:affiche_user_id
		},
		success:function(data){
			if(data==1){
				layer.alert("公告添加成功",{icon: 1});
			}else{
				layer.alert("公告添加失败",{icon: 2});
			}
		}
	})
}

function getUpdateAffiche(){
	var affiche_name = $("#exampleFormControlTextarea1").val();
	var affiche_id = $("#affiche_id").val();
	if(affiche_name==null||affiche_name==""){
		layer.alert("公告的内容怎么能为空呢",{icon: 7});
		return;
	}
	jq.ajax({
		url:"/Dem/affiche/updateAffiche",
		type: "post",
		data:{
			affiche_name:affiche_name,
			affiche_id:affiche_id
		},
		success:function(data){
			if(data==1){
				layer.alert("公告修改成功",{icon: 1});
			}else{
				layer.alert("公告修改失败",{icon: 2});
			}
		}
	})
}