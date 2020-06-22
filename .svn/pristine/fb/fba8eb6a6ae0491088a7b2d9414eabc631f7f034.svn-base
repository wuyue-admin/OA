package com.cn.mapper;

import java.util.List;

import com.cn.pojo.OverTime;

public interface OverTimeMapper {
	//查询全部加班信息列表
	public List<OverTime> findOverTime(int overtime_user_id);
	
	//查询全部加班信息列表
	public List<OverTime> findOverTimeAll();
	
	//查询部门下加班信息列表
	public List<OverTime> findOverTimeByDepartment(int overtime_department_id);
	
	//查询需要审核的加班申请
	public List<OverTime> findOverTimeByShen();
	
	//根据编号进行查询审核信息
	public OverTime findOverTimeByS(int overtime_id);
	
	//进行审核
	public int updateOverTimeBySh(OverTime overTime);
	
	//申请加班
	public int addOverTime(OverTime overTime);
	
	//根据编号进行查询单个加班申请的信息
	public OverTime findOverTimeById(int overtime_id);
	
	//修改加班申请
	public int updateOverTime(OverTime overTime);
	
	//删除加班申请
	public int delOverTime(int overtime_id);
	
	//查询全部申请加班的总条数
	public int count();
	
	//提交审核
	public int update(int overtime_id);
	
	//查询此用户是否可以进行调休
	public int countById(int overtime_user_id);
	
	
}
