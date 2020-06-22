var jq=jQuery.noConflict();
function getAddSignIn(){

	var nowTime = $("#inputPassword4").val();
	var a = "9:00:00";
	var b = "9:30:00";
	var b1 = "10:00:00";
	var c = "12:00:00";
	var d = "13:00:00";
	var e = "13:30:00";
	var e1 = "14:00:00";
	var f = "17:00:00";
	if(nowTime>a||nowTime>c||(c<nowTime&&nowTime<d)||nowTime>f){
		$(".attendance1").prop("selected",true);
		alert("1");
	}
	if(nowTime<a&&nowTime>b||nowTime<d&&nowTime>e){
		$(".attendance2").prop("selected",true);
		alert("2");
	}
	if(b1<nowTime&&nowTime<b||e1>nowTime&&nowTime<e){
		$(".attendance4").prop("selected",true);
		alert("3");
	}
	if(b1<nowTime&&nowTime<c||e1<nowTime&&nowTime<f){
		$(".attendance3").prop("selected",true);
		alert("4");
	}
	
var attendance_state = $("#disabledSelect").val();
var attendance_time = $("#inputPassword3").val();
var attendance_user_id = $("#inputAddress").val();

//alert(attendance_state);


jq.ajax({
	url:"/Dem/attendance/signIn",
	type: "post",
	data:{
		attendance_state:attendance_state,
		attendance_time:attendance_time,
		attendance_user_id:attendance_user_id
	},
	success:function(data){
		if(data==1){
			layer.alert("添加成功",{icon: 1});
		}else{
			layer.alert("添加失败",{icon: 2});
		}
	}
})
}