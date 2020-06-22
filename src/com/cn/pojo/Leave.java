package com.cn.pojo;

import java.sql.Date;

public class Leave {
	//请假单编号
	private int leave_id;
	//请假单申请姓名
	private int leave_name;
	//申请请假单人员所属部门
	private int leave_department_id;
	//请假开始时间
	private Date leave_start_time;
	//请假结束时间
	private Date leave_end_time;
	//请假类型
	private int leave_type;
	//请假原因
	private String leave_context;
	//创建请假单时间
	private Date leave_time;
	//请假单类型
	private LeaveState leaveState;
	//部门
	private Department department;
	//审核状态
	private int leave_state;
	//审核状态
	private State state;
	//用户
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getLeave_state() {
		return leave_state;
	}
	public void setLeave_state(int leave_state) {
		this.leave_state = leave_state;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public LeaveState getLeaveState() {
		return leaveState;
	}
	public void setLeaveState(LeaveState leaveState) {
		this.leaveState = leaveState;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getLeave_id() {
		return leave_id;
	}
	public void setLeave_id(int leave_id) {
		this.leave_id = leave_id;
	}
	public int getLeave_name() {
		return leave_name;
	}
	public void setLeave_name(int leave_name) {
		this.leave_name = leave_name;
	}
	public int getLeave_department_id() {
		return leave_department_id;
	}
	public void setLeave_department_id(int leave_department_id) {
		this.leave_department_id = leave_department_id;
	}
	public Date getLeave_start_time() {
		return leave_start_time;
	}
	public void setLeave_start_time(Date leave_start_time) {
		this.leave_start_time = leave_start_time;
	}
	public Date getLeave_end_time() {
		return leave_end_time;
	}
	public void setLeave_end_time(Date leave_end_time) {
		this.leave_end_time = leave_end_time;
	}
	public int getLeave_type() {
		return leave_type;
	}
	public void setLeave_type(int leave_type) {
		this.leave_type = leave_type;
	}
	public String getLeave_context() {
		return leave_context;
	}
	public void setLeave_context(String leave_context) {
		this.leave_context = leave_context;
	}
	public Date getLeave_time() {
		return leave_time;
	}
	public void setLeave_time(Date leave_time) {
		this.leave_time = leave_time;
	}
}
