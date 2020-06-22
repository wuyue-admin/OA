package com.cn.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.pojo.Authority;
import com.cn.pojo.User;
import com.cn.service.AuthorityService;

@Controller
@RequestMapping("/authority")
public class AuthorityController {
	
	@Autowired
	private AuthorityService authorityService;

	@RequestMapping("/authorityList")
	public String findAuthorityList(Map<String,Object> map,HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		List<Authority> authList = authorityService.findAuthority(user.getUser_id());
		map.put("authList", authList);
		return "index";
	}
}
