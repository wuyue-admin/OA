package com.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.mapper.AuthorityMapper;
import com.cn.pojo.Authority;
import com.cn.service.AuthorityService;
@Service
public class AuthorityServiceImpl implements AuthorityService {
	
	@Autowired
	private AuthorityMapper authorityMapper;

	@Override
	public List<Authority> findAuthority(int user_id) {
		// TODO Auto-generated method stub
		return authorityMapper.findAuthority(user_id);
	}

	@Override
	public List<Authority> findButton(int user_id, int authority_gui) {
		// TODO Auto-generated method stub
		return authorityMapper.findButton(user_id, authority_gui);
	}

}
