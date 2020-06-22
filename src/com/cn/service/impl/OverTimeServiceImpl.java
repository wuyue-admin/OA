package com.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.mapper.OverTimeMapper;
import com.cn.pojo.OverTime;
import com.cn.service.OverTimeService;
@Service
public class OverTimeServiceImpl implements OverTimeService {
	
	@Autowired
	private OverTimeMapper overTimeMapper;

	@Override
	public int addOverTime(OverTime overTime) {
		// TODO Auto-generated method stub
		return overTimeMapper.addOverTime(overTime);
	}

	@Override
	public OverTime findOverTimeById(int overtime_id) {
		// TODO Auto-generated method stub
		return overTimeMapper.findOverTimeById(overtime_id);
	}

	@Override
	public int updateOverTime(OverTime overTime) {
		// TODO Auto-generated method stub
		return overTimeMapper.updateOverTime(overTime);
	}

	@Override
	public int delOverTime(int overtime_id) {
		// TODO Auto-generated method stub
		return overTimeMapper.delOverTime(overtime_id);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return overTimeMapper.count();
	}

	@Override
	public int update(int overtime_id) {
		// TODO Auto-generated method stub
		return overTimeMapper.update(overtime_id);
	}

	@Override
	public int countById(int overtime_user_id) {
		// TODO Auto-generated method stub
		return overTimeMapper.countById(overtime_user_id);
	}

	@Override
	public List<OverTime> findOverTime(int overtime_user_id) {
		// TODO Auto-generated method stub
		return overTimeMapper.findOverTime(overtime_user_id);
	}

	@Override
	public List<OverTime> findOverTimeAll() {
		// TODO Auto-generated method stub
		return overTimeMapper.findOverTimeAll();
	}

	@Override
	public List<OverTime> findOverTimeByDepartment(int overtime_department_id) {
		// TODO Auto-generated method stub
		return overTimeMapper.findOverTimeByDepartment(overtime_department_id);
	}

	@Override
	public List<OverTime> findOverTimeByShen() {
		// TODO Auto-generated method stub
		return overTimeMapper.findOverTimeByShen();
	}

	@Override
	public OverTime findOverTimeByS(int overtime_id) {
		// TODO Auto-generated method stub
		return overTimeMapper.findOverTimeByS(overtime_id);
	}

	@Override
	public int updateOverTimeBySh(OverTime overTime) {
		// TODO Auto-generated method stub
		return overTimeMapper.updateOverTimeBySh(overTime);
	}

}
