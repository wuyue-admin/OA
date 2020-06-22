package com.cn.service;

import java.util.List;

import com.cn.pojo.Friend;

public interface FriendService {
	//查询全部好友列表
	public List<Friend> findFriend();
	
	//根据好友编号查询单个好友并打开聊天页面
	public Friend findFriendById(int friend_id);
}
