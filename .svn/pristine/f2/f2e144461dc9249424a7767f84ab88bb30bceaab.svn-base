package com.cn.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cn.pojo.Friend;
import com.cn.service.FriendService;

@Controller
@RequestMapping("/friend")
public class FriendController {
	
	@Autowired
	private FriendService friendService;
	
	//查询全部好友列表
	@RequestMapping("/findFriend")
	public String findFriend(Map<String,Object> map) {
		List<Friend> friendList = friendService.findFriend();
		map.put("friendList", friendList);
		return "phone";
	}
	
	//根据编号查询单个好友并打开聊天页面
	@RequestMapping("/findFriendById")
	public String findFriendById(@RequestParam("friend_id") int friend_id,Map<String,Object> map) {
		Friend friend = friendService.findFriendById(friend_id);
		map.put("friend", friend);
		return "phoneTell";
	}

}
