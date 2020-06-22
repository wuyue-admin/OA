package com.cn.mapper;

import java.util.List;

import com.cn.pojo.Leave;

public interface LeaveMapper {
	
	//查询当前用户的请假单
	public List<Leave> findLeave(int leave_name);
	
	//查询全部请假单
	public List<Leave> findLeaveAll();
	
	//查询当前用户的部门的请假单
	public List<Leave> findLeaveByDepartment(int leave_department_id);
	
	//创建请假单
	public int addLeave(Leave leave);
	
	//查看请假单
	public Leave findLeaveById(int leave_id);
	
	//编辑请假单
	public int updateLeaveById(Leave leave);
	
	//删除请假单
	public int delLeave(int leave_id);
	
	//查询请假单总条数
	public int count();
	
	//提交请假申请
	public int update(int leave_id);
	
	//查询需审核的请假单
	public List<Leave> findLeaveByState();
	
	//查询进行审核的信息
	public Leave findLeaveByShen(int leave_id);
	
	//进行审核
	public int updateLeaveByShen(Leave leave);
	
}
