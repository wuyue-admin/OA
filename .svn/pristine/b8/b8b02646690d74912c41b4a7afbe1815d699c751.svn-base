package com.cn.service;

import java.util.List;

import com.cn.pojo.Attendance;
import com.cn.pojo.AttendanceState;

public interface AttendanceService {
	//打卡签到
	public int signIn(Attendance attendance);
		
	//打卡签退
	public int signOut(Attendance attendance);
	
	//查看全部考勤列表
	public List<Attendance> findAttendanceList();
		
	//删除
	public int delAttendance(int attendance_id);
	
	//查询全部打卡类型
	public List<AttendanceState> findAttendanceState();
}
