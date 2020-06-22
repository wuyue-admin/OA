package com.cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.pojo.Authority;

public interface AuthorityMapper {
	
	//查询全部左侧菜单
	public List<Authority> findAuthority(@Param("user_id") int user_id);
	
	//查询按钮
	public List<Authority> findButton(@Param("user_id") int user_id,@Param("authority_gui") int authority_gui);
	
}
