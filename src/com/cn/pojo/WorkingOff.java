package com.cn.pojo;

import java.sql.Date;

public class WorkingOff {
	//编号
	private int workingoff_id;
	//申请人姓名
	private String workingoff_name;
	//调休人员所属部门
	private int workingoff_department_id;
	//调休开始时间
	private Date workingoff_begin_time;
	//调休结束时间
	private Date workingoff_end_time;
	//调休原因
	private String workingoff_context;
	//申请调休的日期
	private Date workingoff_time;
	//审核调休状态
	private int workingoff_state;
	//部门
	private Department department;
	//状态
	private State state;
	//用户
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getWorkingoff_id() {
		return workingoff_id;
	}
	public void setWorkingoff_id(int workingoff_id) {
		this.workingoff_id = workingoff_id;
	}
	public String getWorkingoff_name() {
		return workingoff_name;
	}
	public void setWorkingoff_name(String workingoff_name) {
		this.workingoff_name = workingoff_name;
	}
	public int getWorkingoff_department_id() {
		return workingoff_department_id;
	}
	public void setWorkingoff_department_id(int workingoff_department_id) {
		this.workingoff_department_id = workingoff_department_id;
	}
	public Date getWorkingoff_begin_time() {
		return workingoff_begin_time;
	}
	public void setWorkingoff_begin_time(Date workingoff_begin_time) {
		this.workingoff_begin_time = workingoff_begin_time;
	}
	public Date getWorkingoff_end_time() {
		return workingoff_end_time;
	}
	public void setWorkingoff_end_time(Date workingoff_end_time) {
		this.workingoff_end_time = workingoff_end_time;
	}
	public String getWorkingoff_context() {
		return workingoff_context;
	}
	public void setWorkingoff_context(String workingoff_context) {
		this.workingoff_context = workingoff_context;
	}
	public Date getWorkingoff_time() {
		return workingoff_time;
	}
	public void setWorkingoff_time(Date workingoff_time) {
		this.workingoff_time = workingoff_time;
	}
	public int getWorkingoff_state() {
		return workingoff_state;
	}
	public void setWorkingoff_state(int workingoff_state) {
		this.workingoff_state = workingoff_state;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}	
}
