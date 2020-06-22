package com.cn.service;

import java.util.List;


import com.cn.pojo.Authority;
import com.cn.pojo.Department;
import com.cn.pojo.Technocal;
import com.cn.pojo.User;

public interface UserService {
	//ע��
	public int addUser(User user);
	
	//添加用户
	public int addUserNew(User user);
	
	//根据用户编号进行查询用户的个人详细信息
	public User findUserById(int user_id);
		
	//修改用户
	public int updateUser(User user);
		
	//删除用户
	public int delUser(int user_id);
		
	//��¼
	public User findUser(String user_userName);
		
	//��ѯְ��
	public List<Technocal> findTechnocal(int user_id);
		
	//��ѯȨ��
	public List<Authority> findAuthority(int user_id);
	
	//��ѯȫ���û���Ϣ�б�
	public List<User> findUserList();
	
	//查询部门信息列表赋值给添加用户页面
	public List<Department> findDepartment();
	//根据部门查询不含有主管的职称列表
	public List<Technocal> findTechnocalListNotAdmin();
	//根据部门查询职称列表
	public List<Technocal> findTechnocalList();
	
	//查询全部职称列表
	public List<Technocal> findTechnocall();
		
	//查询全部上级
	public List<Technocal> findUp();
		
	//查询上级
	public Technocal findTechnocalAll(int technocal_id);
	
	//查询所对应的上级
	public Technocal findTechnocalByShu(int technocal_shu);
		
	//判断是否有老板
	public int bossCount();
		
	//判断是否有主管
	public int adminCount(int department_id);
	
	//查询全部总条数
	public int userCount();
}
