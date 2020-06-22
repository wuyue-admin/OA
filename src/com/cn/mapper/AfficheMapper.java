package com.cn.mapper;

import java.util.List;

import com.cn.pojo.Affiche;

public interface AfficheMapper {
	//查询全部公告信息列表
	public List<Affiche> findAffiche();
	
	//查询公告信息列表到首页面
	public List<Affiche> findAfficheAll();
	
	//添加公告
	public int addAffiche(Affiche affiche);
	
	//根据编号查询公告信息
	public Affiche findAfficheById(int affiche_id);
	
	//修改公告
	public int updateAffiche(Affiche affiche);
	
	//删除公告
	public int delAffiche(int affiche_id);
}
