function addNewUser(){
	layer.open({
		type:2,
		title:"添加员工",
		maxmin:true,
		shadeClose: true,
		area:['600px','520px'],
		content:'/Dem/user/getDepartment',
		end:function(){
			location.reload();
		}
	})
}