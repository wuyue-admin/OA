package com.cn.shiro.config;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.cn.pojo.Authority;
import com.cn.pojo.Technocal;
import com.cn.pojo.User;
import com.cn.service.UserService;



public class MyRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		String user_userName = arg0.getPrimaryPrincipal().toString();
		User user = userService.findUser(user_userName);
		List<Technocal> rList = userService.findTechnocal(user.getUser_id());
		List<Authority> jList = userService.findAuthority(user.getUser_id());
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		for(Technocal role:rList) {
			simpleAuthorizationInfo.addRole(String.valueOf(role.getTechnocal_id()));
		}
		for(Authority jurisdiction:jList) {
			simpleAuthorizationInfo.addRole(String.valueOf(jurisdiction.getAuthority_id()));
		}
		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		String name = arg0.getPrincipal().toString();
		if(name==null) {
			return null;
		}
		User user = userService.findUser(name);
		if(user==null) {
			return null;
		}else {
			SimpleAuthenticationInfo sim = new SimpleAuthenticationInfo(name,user.getUser_password(),ByteSource.Util.bytes(name+user.getUser_salt()),getName());
			return sim;
		}
	}
	
}
