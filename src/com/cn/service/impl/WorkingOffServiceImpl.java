package com.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.mapper.WorkingOffMapper;
import com.cn.pojo.WorkingOff;
import com.cn.service.WorkingOffService;
@Service
public class WorkingOffServiceImpl implements WorkingOffService {
	
	@Autowired
	private WorkingOffMapper workingOffMapper;

	@Override
	public List<WorkingOff> findWorkingOff(int workingoff_name) {
		// TODO Auto-generated method stub
		return workingOffMapper.findWorkingOff(workingoff_name);
	}

	@Override
	public int addWorkingOff(WorkingOff workingoff) {
		// TODO Auto-generated method stub
		return workingOffMapper.addWorkingOff(workingoff);
	}

	@Override
	public WorkingOff findWorkingOffById(int workingoff_id) {
		// TODO Auto-generated method stub
		return workingOffMapper.findWorkingOffById(workingoff_id);
	}

	@Override
	public int updateWorkingOff(WorkingOff workingoff) {
		// TODO Auto-generated method stub
		return workingOffMapper.updateWorkingOff(workingoff);
	}

	@Override
	public int deleteWorkingOff(int workingoff_id) {
		// TODO Auto-generated method stub
		return workingOffMapper.deleteWorkingOff(workingoff_id);
	}

	@Override
	public List<WorkingOff> findWorkingOffAll() {
		// TODO Auto-generated method stub
		return workingOffMapper.findWorkingOffAll();
	}

	@Override
	public List<WorkingOff> findWorkingOffByDepartment(int workingoff_department_id) {
		// TODO Auto-generated method stub
		return workingOffMapper.findWorkingOffByDepartment(workingoff_department_id);
	}

	@Override
	public List<WorkingOff> findWorkingOffByState() {
		// TODO Auto-generated method stub
		return workingOffMapper.findWorkingOffByState();
	}

	@Override
	public WorkingOff findWorkingOffByShen(int workingoff_id) {
		// TODO Auto-generated method stub
		return workingOffMapper.findWorkingOffByShen(workingoff_id);
	}

	@Override
	public int updateWorkingOffByShen(WorkingOff workingoff) {
		// TODO Auto-generated method stub
		return workingOffMapper.updateWorkingOffByShen(workingoff);
	}

	@Override
	public int update(int workingoff_id) {
		// TODO Auto-generated method stub
		return workingOffMapper.update(workingoff_id);
	}

}
