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
import com.cn.pojo.Attendance;
import com.cn.pojo.AttendanceState;
import com.cn.pojo.Authority;
import com.cn.pojo.User;
import com.cn.service.AttendanceService;
import com.cn.service.AuthorityService;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {
	
	@Autowired
	private AttendanceService attendanceService;
	@Autowired
	private AuthorityService authorityService;
	
	//进入打卡签到页面
	@RequestMapping("/signInTo")
	public String signInTo(HttpServletRequest req,Map<String, Object> map) {
		Date reDate = new Date(System.currentTimeMillis());
		String ft = new SimpleDateFormat("yyyy-MM-dd").format(reDate);
		String ftt = new SimpleDateFormat("HH:mm:ss").format(reDate);
		String ftts = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(reDate);
		req.setAttribute("loadtime", ft);
		req.setAttribute("loadtimes", ftt);
		req.setAttribute("loadtimeAll", ftts);
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		map.put("user", user);
		List<AttendanceState> attendanceList = attendanceService.findAttendanceState();
		map.put("attendanceList", attendanceList);
		return "signIn";
	}
	
	//打卡签到
	@RequestMapping("/signIn")
	public void signIn(Attendance attendance,HttpServletResponse rep,HttpServletRequest req) throws IOException {
		int result = attendanceService.signIn(attendance);
		print(result,rep);
		
//		System.out.println(a);
//		System.out.println("dawd");
		
	}
	
	//打卡签到
	@RequestMapping("/signOut")
	public void signOut(Attendance attendance,HttpServletResponse rep) throws IOException {
		int result = attendanceService.signOut(attendance);
		print(result,rep);
	}
	
	//查询全部考勤列表
	@RequestMapping("/findAttendanceList")
	public String findAttendanceList(Map<String,Object> map,HttpServletRequest req,int authority_gui) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		List<Authority> button = authorityService.findButton(user.getUser_id(), authority_gui);
		List<Attendance> attendanceList = attendanceService.findAttendanceList();
		map.put("attendanceList", attendanceList);
		map.put("button", button);
		return "attendanceInfo";
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
