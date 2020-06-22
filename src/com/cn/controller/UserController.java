package com.cn.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.cn.pojo.Affiche;
import com.cn.pojo.Authority;
import com.cn.pojo.Department;
import com.cn.pojo.Technocal;
import com.cn.pojo.User;
import com.cn.service.AfficheService;
import com.cn.service.AuthorityService;
import com.cn.service.LeaveService;
import com.cn.service.OverTimeService;
import com.cn.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private RandomNumberGenerator random=new SecureRandomNumberGenerator();
	
	@Autowired
	private UserService userService;
	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private AfficheService afficheService;
	@Autowired
	private LeaveService leaveService;
	@Autowired
	private OverTimeService overTimeService;
	
	//进入登录页面
	@RequestMapping("/login")
	public String loginDO() {
		return "login";
	}
	
	//登录
	@RequestMapping("/login.do")
	public void login(User user,HttpServletResponse rep,HttpServletRequest req,Map<String,Object> map) throws IOException {
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUser_userName(),user.getUser_password());
				
		User us = userService.findUser(user.getUser_userName());	
		try {
			subject.login(token);
			req.getSession().setAttribute("us", us);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			e.printStackTrace();
			print(null, rep);
		}catch(AuthorizationException e){
			e.printStackTrace();
			print(null, rep);
		}
			print(1, rep);
		}
	
	//注册
	@RequestMapping("/regist")
	public void registdo(User user,HttpServletResponse rep) throws IOException {
		//��ȡ��ֵ
		String salt=random.nextBytes().toHex();
		user.setUser_salt(salt);
		String password=new SimpleHash("md5",user.getUser_password(),ByteSource.Util.bytes(user.getUser_userName()+user.getUser_salt()),2).toHex();
		user.setUser_password(password);
		int result = userService.addUser(user);
		print(result,rep);
	}
	
	//查询用户管理信息列表
	@RequestMapping("/userInfo")
	public String userInfo(Map<String,Object> map,HttpServletRequest req,@RequestParam("authority_gui") int authority_gui) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		List<Authority> button = authorityService.findButton(user.getUser_id(), authority_gui);
		List<User> userList = userService.findUserList();
		int count = userService.userCount();
		map.put("count", count);
		map.put("userList", userList);
		map.put("button", button);
		return "userInfo";
	}
	
	//查询全部的部门信息赋值到添加用户页面
	@RequestMapping("/getDepartment")
	public String departmentList(Map<String,Object> map) {
		List<Department> departmentList = userService.findDepartment();
		map.put("departmentList", departmentList);
		return "addUser";
	}
	
	//查询全部职称
	@RequestMapping("/getTechnocalList")
	public String technocalList(Map<String,Object> map) {
		List<Technocal> technocalList = userService.findTechnocalList();
		map.put("technocalList", technocalList);
		return "addUser";
	}
	
	//查询除了主管以外的数据
	@RequestMapping("/getTechnocalList.admin")
	public String technocalByAdmin(Map<String,Object> map) {
		List<Technocal> technocalByAdmin = userService.findTechnocalListNotAdmin();
		map.put("technocalList", technocalByAdmin);
		return "addUser";
	}
	
	//查询上级所对应的id
	@RequestMapping("/getTechnocalAllById")
	public void technocalAll(Map<String,Object> map,@RequestParam("technocal_id") int technocal_id,HttpServletResponse rep) throws IOException {
		Technocal technocalAll = userService.findTechnocalAll(technocal_id);
		//map.put("technocalAll", technocalAll);
		print(technocalAll.getTechnocal_shu(),rep);
	}
	
	//查询对应的上级
	@RequestMapping("/getTechnocalById")
	public String technocalById(Integer date,Map<String,Object> map,HttpServletRequest req) {
		Integer technocal_shu=Integer.parseInt(req.getParameter("date"));
		Technocal te = userService.findTechnocalByShu(technocal_shu);
		map.put("te",te);
		return "addUser";
	}
	
	//判断是否有主管
	@RequestMapping("/adminCount")
	public void findTechnocalByAdminId(@RequestParam("department_id") int department_id,HttpServletResponse rep) throws IOException {
		int result = userService.adminCount(department_id);
		print(result,rep);
	}
	
	//添加用户
	@RequestMapping("/addUserNew")
	public void addUserNew(User user,HttpServletResponse rep) throws IOException {
		String salt=random.nextBytes().toHex();
		user.setUser_salt(salt);
		String password=new SimpleHash("md5",user.getUser_password(),ByteSource.Util.bytes(user.getUser_userName()+user.getUser_salt()),2).toHex();
		user.setUser_password(password);
		int result = userService.addUserNew(user);
		print(result,rep);
	}
	
	//删除用户
	@RequestMapping("/delUser")
	public void delUser(int user_id,HttpServletResponse rep) throws IOException {
		int result = userService.delUser(user_id);
		print(result,rep);
	}
	
	//根据用户编号进行查询单个用户的详细信息
	@RequestMapping("/findUserById")
	public String findUserById(Map<String,Object> map,int user_id) {
		User userList = userService.findUserById(user_id);
		map.put("userList", userList);
		List<Department> departmentList = userService.findDepartment();
		map.put("departmentList", departmentList);
		List<Technocal> findTechnocal = userService.findTechnocall();
		//List<Technocal> findUp = userService.findUp();
		map.put("technocalList", findTechnocal);
		//map.put("te", findUp);
		return "updateUser";
	}
	
	//修改用户信息列表
	@RequestMapping("/updateUser")
	public void updateUser(User user,HttpServletResponse rep) throws IOException {
		String salt=random.nextBytes().toHex();
		user.setUser_salt(salt);
		String password=new SimpleHash("md5",user.getUser_password(),ByteSource.Util.bytes(user.getUser_userName()+user.getUser_salt()),2).toHex();
		user.setUser_password(password);
		int result = userService.updateUser(user);
		print(result,rep);
	}
	
	//安全登出
	@RequestMapping("/logout")
	public String logout(HttpSession session,Model model) {
		Subject sub = SecurityUtils.getSubject();
		sub.logout();
		model.addAttribute("msg","安全退出" );
		return "login";
	}
	
	//进入首页面
	@RequestMapping("/main")
	public String main(Map<String,Object> map) {
		List<Affiche> afficheList = afficheService.findAfficheAll();
		map.put("afficheList", afficheList);
		int countLeave = leaveService.count();
		map.put("countLeave", countLeave);
		int countOverTime = overTimeService.count();
		map.put("countOverTime", countOverTime);
//		int countWorkingDays = workingDaysService.count();
//		map.put("countWorkingDays", countWorkingDays);
		return "main";
	}
	
	//导出Excel表格
	@RequestMapping("/excel")
	public void ecxel(HttpServletResponse rep) throws IOException {
		rep.setCharacterEncoding("UTF-8");
		List<User> list = userService.findUserList();
		System.out.println(list);
		//创建Excel表格
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建sheet页
		HSSFSheet sheet = wb.createSheet("用户信息列表");
		//创建标题行
		HSSFRow titleRow = sheet.createRow(0);
		titleRow.createCell(0).setCellValue("用户编号");
        titleRow.createCell(1).setCellValue("用户姓名");
        titleRow.createCell(2).setCellValue("用户名");
        titleRow.createCell(3).setCellValue("密码");
        titleRow.createCell(4).setCellValue("盐值");
        titleRow.createCell(5).setCellValue("性别");
        titleRow.createCell(6).setCellValue("部门编号");
        titleRow.createCell(7).setCellValue("职称编号");
        titleRow.createCell(8).setCellValue("进入本单位的时间");
        titleRow.createCell(9).setCellValue("工资");
        titleRow.createCell(10).setCellValue("上级");
        for(User user:list) {
        	HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
        	dataRow.createCell(0).setCellValue(user.getUser_id());
            dataRow.createCell(1).setCellValue(user.getUser_name());
            dataRow.createCell(2).setCellValue(user.getUser_userName());
            dataRow.createCell(3).setCellValue(user.getUser_password());
            dataRow.createCell(4).setCellValue(user.getUser_salt());
            dataRow.createCell(5).setCellValue(user.getUser_sex());
            dataRow.createCell(6).setCellValue(user.getUser_department_id());
            dataRow.createCell(7).setCellValue(user.getUser_technical_id());
            dataRow.createCell(8).setCellValue(user.getUser_time());
            dataRow.createCell(9).setCellValue(user.getUser_sarly());
            dataRow.createCell(10).setCellValue(user.getUser_up());
        }
        // 设置下载时客户端Excel的名称   （上面注释的改进版本，上面的中文不支持）
        rep.setContentType("application/octet-stream;charset=utf-8");
        rep.setHeader("Content-Disposition", "attachment;filename="
                + new String("客户名单".getBytes(),"iso-8859-1") + ".xls");


    OutputStream ouputStream = rep.getOutputStream();  
    wb.write(ouputStream);  
    ouputStream.flush();  
    ouputStream.close();
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
