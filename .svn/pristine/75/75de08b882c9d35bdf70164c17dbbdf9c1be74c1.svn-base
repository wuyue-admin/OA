package com.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.mapper.FriendMapper;
import com.cn.pojo.Friend;
import com.cn.service.FriendService;
@Service
public class FriendServiceImpl implements FriendService {
	
	@Autowired
	private FriendMapper friendMapper;

	@Override
	public List<Friend> findFriend() {
		// TODO Auto-generated method stub
		return friendMapper.findFriend();
	}

	@Override
	public Friend findFriendById(int friend_id) {
		// TODO Auto-generated method stub
		return friendMapper.findFriendById(friend_id);
	}

}
