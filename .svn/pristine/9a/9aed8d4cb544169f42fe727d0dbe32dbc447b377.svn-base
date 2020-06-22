package com.cn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.cn.pojo.Affiche;
import com.cn.pojo.Authority;
import com.cn.pojo.User;
import com.cn.service.AfficheService;
import com.cn.service.AuthorityService;

@Controller
@RequestMapping("/affiche")
public class AfficheController {
	
	@Autowired
	private AfficheService afficheService;
	@Autowired
	private AuthorityService authorityService;
	
	//查询全部公告信息列表
	@RequestMapping("/findAffiche")
	public String afficheList(Map<String,Object> map,HttpServletRequest req,int authority_gui) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		List<Authority> button = authorityService.findButton(user.getUser_id(), authority_gui);
		List<Affiche> afficheList = afficheService.findAffiche();
		map.put("button", button);
		map.put("afficheList", afficheList);
		return "afficheInfo";
	}
	
	//获取用户信息添加到添加公告页面中
	@RequestMapping("/addAffi")
	public String findUserToAffiche(Map<String,Object> map,HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		map.put("user",user);
		Date reDate = new Date(System.currentTimeMillis());
		String ft = new SimpleDateFormat("yyyy-MM-dd").format(reDate);
		req.setAttribute("loadtime", ft);
		return "addAffiche";
	}
	
	//添加新的公告
	@RequestMapping("/addAffiche")
	public void addAffiche(Affiche affiche,HttpServletResponse rep) throws IOException {
		int result = afficheService.addAffiche(affiche);
		print(result,rep);
	}
	
	//根据编号获取单个公告的信息
	@RequestMapping("/findAfficheById")
	public String findAfficheById(int affiche_id,Map<String,Object> map) {
		Affiche affiche = afficheService.findAfficheById(affiche_id);
		map.put("affiche", affiche);
		return "updateAffiche";
	}
	
	//修改公告信息
	@RequestMapping("/updateAffiche")
	public void updateAffiche(Affiche affiche,HttpServletResponse rep) throws IOException {
		int result = afficheService.updateAffiche(affiche);
		print(result,rep);
	}
	
	//删除公告信息
	@RequestMapping("/delAffiche")
	public void delAffiche(int affiche_id,HttpServletResponse rep) throws IOException {
		int result = afficheService.delAffiche(affiche_id);
		print(result,rep);
	}
	
	//转换json字符串
	public void print(Object mag,HttpServletResponse rep) throws IOException {
		rep.setContentType("text/html;charset=utf-8;");
		String info=JSON.toJSONString(mag);
		PrintWriter out=rep.getWriter();
		out.print(info);
		out.flush();
	}
	
}
