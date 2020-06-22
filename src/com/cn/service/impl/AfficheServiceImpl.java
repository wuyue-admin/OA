package com.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.mapper.AfficheMapper;
import com.cn.pojo.Affiche;
import com.cn.service.AfficheService;
@Service
public class AfficheServiceImpl implements AfficheService {
	
	@Autowired
	private AfficheMapper afficheMapper;

	@Override
	public List<Affiche> findAffiche() {
		// TODO Auto-generated method stub
		return afficheMapper.findAffiche();
	}

	@Override
	public int addAffiche(Affiche affiche) {
		// TODO Auto-generated method stub
		return afficheMapper.addAffiche(affiche);
	}

	@Override
	public Affiche findAfficheById(int affiche_id) {
		// TODO Auto-generated method stub
		return afficheMapper.findAfficheById(affiche_id);
	}

	@Override
	public int updateAffiche(Affiche affiche) {
		// TODO Auto-generated method stub
		return afficheMapper.updateAffiche(affiche);
	}

	@Override
	public int delAffiche(int affiche_id) {
		// TODO Auto-generated method stub
		return afficheMapper.delAffiche(affiche_id);
	}

	@Override
	public List<Affiche> findAfficheAll() {
		// TODO Auto-generated method stub
		return afficheMapper.findAfficheAll();
	}

}
