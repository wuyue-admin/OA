package com.cn.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.cn.pojo.Authority;
import com.cn.pojo.Department;
import com.cn.pojo.User;
import com.cn.pojo.WorkingOff;
import com.cn.service.AuthorityService;
import com.cn.service.OverTimeService;
import com.cn.service.UserService;
import com.cn.service.WorkingOffService;

@Controller
@RequestMapping("/workingoff")
public class WorkingOffController {
	
	@Autowired
	private WorkingOffService workingOffService;
	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private UserService userService;
	@Autowired
	private OverTimeService overTimeService;
	
	//查询当前用户下的全部信息列表
	@RequestMapping("/findWorkingOffList")
	public String workingOffList(Map<String,Object> map,HttpServletRequest req,int authority_gui) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		int count = overTimeService.countById(user.getUser_id());
		List<Authority> button = authorityService.findButton(user.getUser_id(), authority_gui);
		List<WorkingOff> workingOffList = workingOffService.findWorkingOff(user.getUser_id());
		map.put("workingOffList", workingOffList);
		map.put("button", button);
		map.put("count", count);
		return "workingOffInfo";
	}
	
	//查询全部信息列表
	@RequestMapping("/findWorkingOffListAll")
	public String workingOffListAll(Map<String,Object> map,HttpServletRequest req,int authority_gui) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		int count = overTimeService.countById(user.getUser_id());
		List<Authority> button = authorityService.findButton(user.getUser_id(), authority_gui);
		List<WorkingOff> workingOffListAll = workingOffService.findWorkingOffAll();
		map.put("workingOffList", workingOffListAll);
		map.put("button", button);
		map.put("count", count);
		return "workingOffInfo";
	}
	
	//查询当前登录用户部门下的全部信息列表
	@RequestMapping("/findWorkingOffListByDepartment")
	public String workingOffListByDepartment(Map<String,Object> map,HttpServletRequest req,int authority_gui) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		int count = overTimeService.countById(user.getUser_id());
		List<Authority> button = authorityService.findButton(user.getUser_id(), authority_gui);
		List<WorkingOff> workingOffListByDepartment = workingOffService.findWorkingOffByDepartment(user.getUser_department_id());
		map.put("workingOffList", workingOffListByDepartment);
		map.put("button", button);
		map.put("count", count);
		return "workingOffInfo";
	}
	
	//查询需要进行调休的全部信息列表
	@RequestMapping("/findWorkingOffListByState")
	public String workingOffListByShen(Map<String,Object> map,HttpServletRequest req,int authority_gui) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		int count = overTimeService.countById(user.getUser_id());
		List<Authority> button = authorityService.findButton(user.getUser_id(), authority_gui);
		List<WorkingOff> workingOffListByState = workingOffService.findWorkingOffByState();
		map.put("workingOffList", workingOffListByState);
		map.put("button", button);
		map.put("count", count);
		return "workingOffInfo";
	}
	
	//根据编号查询单个需要审核的申请信息
	@RequestMapping("/findWorkingOffByShen")
	public String findWorkingOffByOneShen(int workingoff_id,Map<String,Object> map) {
		WorkingOff workingoff = workingOffService.findWorkingOffByShen(workingoff_id);
		map.put("workingoff", workingoff);
		return "updateWorkingOffShen";
	}
	
	//审核调休
	@RequestMapping("/updateWorkingOffByShen")
	public void updateWorkingOffByShen(WorkingOff workingoff,HttpServletResponse rep) throws IOException {
		int result = workingOffService.updateWorkingOffByShen(workingoff);
		print(result,rep);
	}
	
	//提交调休审核
	@RequestMapping("/updateWorkingOff")
	public void update(int workingoff_id,HttpServletResponse rep) throws IOException {
		int result = workingOffService.update(workingoff_id);
		print(result,rep);
	}
	
	//查询调休单应有的信息到申请页面
	@RequestMapping("/addWorkingOddTo")
	public String findAdd(Map<String,Object> map,HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		map.put("user", user);
		List<Department> departmentList = userService.findDepartment();
		Date reDate = new Date(System.currentTimeMillis());
		String ft = new SimpleDateFormat("yyyy-MM-dd").format(reDate);
		map.put("departmentList", departmentList);
		map.put("ft", ft);
		return "addWorkingOff";
	}
	
	//添加调休申请
	@RequestMapping("/addWorkingOff")
	public void addWorkingOff(WorkingOff workingOff,HttpServletResponse rep) throws IOException {
		int result = workingOffService.addWorkingOff(workingOff);
		print(result,rep);
	}
	
	//删除调休审核
	@RequestMapping("/delWorkingOff")
	public void delWorkingOff(int workingoff_id,HttpServletResponse rep) throws IOException {
		int result = workingOffService.deleteWorkingOff(workingoff_id);
		print(result,rep);
	}
	
	//根据编号获取调休审核的信息进行修改
	@RequestMapping("/findWorkingOffById")
	public String findWorkingOffById(int workingoff_id,Map<String,Object> map) {
		WorkingOff workingOff = workingOffService.findWorkingOffById(workingoff_id);
		map.put("workingOff", workingOff);
		return "updateWorkingOff";
	}
	
	//修改调休申请
	@RequestMapping("/update")
	public void updateWorkingOff(WorkingOff workingoff,HttpServletResponse rep) throws IOException {
		int result = workingOffService.updateWorkingOff(workingoff);
		print(result,rep);
	}
	
	//导出Excel表格
	@RequestMapping("/excel")
	public void ecxel(HttpServletResponse rep) throws IOException {
		rep.setCharacterEncoding("UTF-8");
		List<WorkingOff> list = workingOffService.findWorkingOffAll();
		System.out.println(list);
		//创建Excel表格
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建sheet页
		HSSFSheet sheet = wb.createSheet("请假单列表");
		//创建标题行
		HSSFRow titleRow = sheet.createRow(0);
		titleRow.createCell(0).setCellValue("调休编号");
		titleRow.createCell(1).setCellValue("申请人姓名");
		titleRow.createCell(2).setCellValue("申请部门编号");
		titleRow.createCell(3).setCellValue("调休开始时间");
		titleRow.createCell(4).setCellValue("调休结束时间");
		titleRow.createCell(5).setCellValue("请假原因");
		titleRow.createCell(6).setCellValue("申请日期");
		titleRow.createCell(7).setCellValue("请假审核状态");
		for(WorkingOff leave:list) {
		   HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
		   dataRow.createCell(0).setCellValue(leave.getWorkingoff_id()); 
		   dataRow.createCell(1).setCellValue(leave.getUser().getUser_name());
		   dataRow.createCell(2).setCellValue(leave.getDepartment().getDepartment_name());
		   // 日期格式转为字符串输出
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		   String begin_time= sdf.format(leave.getWorkingoff_begin_time());
		   dataRow.createCell(3).setCellValue(begin_time);
		   String end_time= sdf.format(leave.getWorkingoff_end_time());
		   dataRow.createCell(4).setCellValue(end_time);
		   dataRow.createCell(5).setCellValue(leave.getWorkingoff_context());
		   String leave_time = sdf.format(leave.getWorkingoff_time());
		   dataRow.createCell(6).setCellValue(leave_time);
		   dataRow.createCell(7).setCellValue(leave.getState().getState_name());
		}
		// 设置下载时客户端Excel的名称   （上面注释的改进版本，上面的中文不支持）
		rep.setContentType("application/octet-stream;charset=utf-8");
		rep.setHeader("Content-Disposition", "attachment;filename="
		    + new String("调休记录".getBytes(),"iso-8859-1") + ".xls");


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
