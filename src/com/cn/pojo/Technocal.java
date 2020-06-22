package com.cn.pojo;

public class Technocal {
	//编号
	private int technocal_id;
	//名称
	private String technocal_name;
	//上下级关系
	private int technocal_shu;
	
	public int getTechnocal_id() {
		return technocal_id;
	}
	public void setTechnocal_id(int technocal_id) {
		this.technocal_id = technocal_id;
	}
	public String getTechnocal_name() {
		return technocal_name;
	}
	public void setTechnocal_name(String technocal_name) {
		this.technocal_name = technocal_name;
	}
	public int getTechnocal_shu() {
		return technocal_shu;
	}
	public void setTechnocal_shu(int technocal_shu) {
		this.technocal_shu = technocal_shu;
	}
}
