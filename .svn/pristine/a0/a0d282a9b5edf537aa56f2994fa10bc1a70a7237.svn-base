package com.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.mapper.LeaveMapper;
import com.cn.pojo.Leave;
import com.cn.service.LeaveService;
@Service
public class LeaveServiceImpl implements LeaveService {
	
	@Autowired
	private LeaveMapper leaveMapper;

	@Override
	public int addLeave(Leave leave) {
		// TODO Auto-generated method stub
		return leaveMapper.addLeave(leave);
	}

	@Override
	public Leave findLeaveById(int leave_id) {
		// TODO Auto-generated method stub
		return leaveMapper.findLeaveById(leave_id);
	}

	@Override
	public int updateLeaveById(Leave leave) {
		// TODO Auto-generated method stub
		return leaveMapper.updateLeaveById(leave);
	}

	@Override
	public int delLeave(int leave_id) {
		// TODO Auto-generated method stub
		return leaveMapper.delLeave(leave_id);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return leaveMapper.count();
	}

	@Override
	public int update(int leave_id) {
		// TODO Auto-generated method stub
		return leaveMapper.update(leave_id);
	}

	@Override
	public List<Leave> findLeave(int leave_name) {
		// TODO Auto-generated method stub
		return leaveMapper.findLeave(leave_name);
	}

	@Override
	public List<Leave> findLeaveAll() {
		// TODO Auto-generated method stub
		return leaveMapper.findLeaveAll();
	}

	@Override
	public List<Leave> findLeaveByDepartment(int leave_department_id) {
		// TODO Auto-generated method stub
		return leaveMapper.findLeaveByDepartment(leave_department_id);
	}

	@Override
	public List<Leave> findLeaveByState() {
		// TODO Auto-generated method stub
		return leaveMapper.findLeaveByState();
	}

	@Override
	public Leave findLeaveByShen(int leave_id) {
		// TODO Auto-generated method stub
		return leaveMapper.findLeaveByShen(leave_id);
	}

	@Override
	public int updateLeaveByShen(Leave leave) {
		// TODO Auto-generated method stub
		return leaveMapper.updateLeaveByShen(leave);
	}

}
