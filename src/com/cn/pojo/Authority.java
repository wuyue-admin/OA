package com.cn.pojo;

public class Authority {
	//编号
	private int authority_id;
	//名称
	private String authority_name;
	//归属
	private int authority_gui;
	//类型
	private int authority_type;
	//路径
	private String authority_url;
	
	public int getAuthority_id() {
		return authority_id;
	}
	public void setAuthority_id(int authority_id) {
		this.authority_id = authority_id;
	}
	public String getAuthority_name() {
		return authority_name;
	}
	public void setAuthority_name(String authority_name) {
		this.authority_name = authority_name;
	}
	public int getAuthority_gui() {
		return authority_gui;
	}
	public void setAuthority_gui(int authority_gui) {
		this.authority_gui = authority_gui;
	}
	public int getAuthority_type() {
		return authority_type;
	}
	public void setAuthority_type(int authority_type) {
		this.authority_type = authority_type;
	}
	public String getAuthority_url() {
		return authority_url;
	}
	public void setAuthority_url(String authority_url) {
		this.authority_url = authority_url;
	}
}
