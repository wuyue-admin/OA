package com.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.mapper.AttendanceMapper;
import com.cn.pojo.Attendance;
import com.cn.pojo.AttendanceState;
import com.cn.service.AttendanceService;
@Service
public class AttendanceServiceImpl implements AttendanceService {
	
	@Autowired
	private AttendanceMapper attendanceMapper;

	@Override
	public int signIn(Attendance attendance) {
		// TODO Auto-generated method stub
		return attendanceMapper.signIn(attendance);
	}

	@Override
	public int signOut(Attendance attendance) {
		// TODO Auto-generated method stub
		return attendanceMapper.signOut(attendance);
	}

	@Override
	public int delAttendance(int attendance_id) {
		// TODO Auto-generated method stub
		return attendanceMapper.delAttendance(attendance_id);
	}

	@Override
	public List<Attendance> findAttendanceList() {
		// TODO Auto-generated method stub
		return attendanceMapper.findAttendanceList();
	}

	@Override
	public List<AttendanceState> findAttendanceState() {
		// TODO Auto-generated method stub
		return attendanceMapper.findAttendanceState();
	}

}
