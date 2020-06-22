package com.cn.service;

import java.util.List;

import com.cn.pojo.WorkingOff;

public interface WorkingOffService {
	//查询全部调休申请信息列表
	public List<WorkingOff> findWorkingOff(int workingoff_name);
	
	//查询全部调休申请信息列表
	public List<WorkingOff> findWorkingOffAll();
		
	//查询当前登录人的所属部门下的所有调休申请信息列表
	public List<WorkingOff> findWorkingOffByDepartment(int workingoff_department_id);
		
	//查询全部需要审核的调休信息列表
	public List<WorkingOff> findWorkingOffByState();
		
	//查询单个需要调休的具体信息并审核
	public WorkingOff findWorkingOffByShen(int workingoff_id);
		
	//进行审核
	public int updateWorkingOffByShen(WorkingOff workingoff);
		
	//添加调休申请
	public int addWorkingOff(WorkingOff workingoff);
		
	//根据编号进行查询单个调休申请的信息
	public WorkingOff findWorkingOffById(int workingoff_id);
		
	//修改调休申请
	public int updateWorkingOff(WorkingOff workingoff);
		
	//删除调休申请
	public int deleteWorkingOff(int workingoff_id);
	
	//提交调休审核
	public int update(int workingoff_id);
}
