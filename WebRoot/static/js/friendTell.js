var jq=jQuery.noConflict();
function findFriend(){
	var friend_id = $("#friend_id").val();
	layer.open({
		type:2,
		maxmin:true,
		shadeClose: true,
		content:'/Dem/friend/findFriendById?friend+id='+friend_id,
		end:function(){
			location.reload();
		}
	})
}