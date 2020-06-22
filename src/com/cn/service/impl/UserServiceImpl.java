package com.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.mapper.UserMapper;
import com.cn.pojo.Authority;
import com.cn.pojo.Department;
import com.cn.pojo.Technocal;
import com.cn.pojo.User;
import com.cn.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.addUser(user);
	}

	@Override
	public User findUser(String user_userName) {
		// TODO Auto-generated method stub
		return userMapper.findUser(user_userName);
	}

	@Override
	public List<Technocal> findTechnocal(int user_id) {
		// TODO Auto-generated method stub
		return userMapper.findTechnocal(user_id);
	}

	@Override
	public List<Authority> findAuthority(int user_id) {
		// TODO Auto-generated method stub
		return userMapper.findAuthority(user_id);
	}

	@Override
	public List<User> findUserList() {
		// TODO Auto-generated method stub
		return userMapper.findUserList();
	}

	@Override
	public List<Department> findDepartment() {
		// TODO Auto-generated method stub
		return userMapper.findDepartment();
	}

	@Override
	public List<Technocal> findTechnocalList() {
		// TODO Auto-generated method stub
		return userMapper.findTechnocalList();
	}

	@Override
	public Technocal findTechnocalAll(int technocal_id) {
		// TODO Auto-generated method stub
		return userMapper.findTechnocalAll(technocal_id);
	}

	@Override
	public int bossCount() {
		// TODO Auto-generated method stub
		return userMapper.bossCount();
	}

	@Override
	public int adminCount(int department_id) {
		// TODO Auto-generated method stub
		return userMapper.adminCount(department_id);
	}

	@Override
	public List<Technocal> findTechnocalListNotAdmin() {
		// TODO Auto-generated method stub
		return userMapper.findTechnocalListNotAdmin();
	}

	@Override
	public Technocal findTechnocalByShu(int technocal_shu) {
		// TODO Auto-generated method stub
		return userMapper.findTechnocalByShu(technocal_shu);
	}

	@Override
	public int addUserNew(User user) {
		// TODO Auto-generated method stub
		return userMapper.addUserNew(user);
	}

	@Override
	public User findUserById(int user_id) {
		// TODO Auto-generated method stub
		return userMapper.findUserById(user_id);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}

	@Override
	public int delUser(int user_id) {
		// TODO Auto-generated method stub
		return userMapper.delUser(user_id);
	}

	@Override
	public List<Technocal> findTechnocall() {
		// TODO Auto-generated method stub
		return userMapper.findTechnocall();
	}

	@Override
	public List<Technocal> findUp() {
		// TODO Auto-generated method stub
		return userMapper.findUp();
	}

	@Override
	public int userCount() {
		// TODO Auto-generated method stub
		return userMapper.userCount();
	}

}
