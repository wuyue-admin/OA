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
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.cn.pojo.Authority;
import com.cn.pojo.Department;
import com.cn.pojo.Leave;
import com.cn.pojo.User;
import com.cn.service.AuthorityService;
import com.cn.service.LeaveService;
import com.cn.service.UserService;

@Controller
@RequestMapping("/leave")
public class LeaveController {
	
	@Autowired
	private LeaveService leaveService;
	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private UserService userService;
	
	//查询当前用户的请假单信息列表
	@RequestMapping("/leaveInfo")
	public String findLeave(Map<String,Object> map,HttpServletRequest req,@RequestParam("authority_gui") int authority_gui) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		List<Authority> button = authorityService.findButton(user.getUser_id(), authority_gui);
		List<Leave> leaveList = leaveService.findLeave(user.getUser_id());
		map.put("leaveList", leaveList);
		map.put("button", button);
		return "leaveInfo";
	}
	
	//查询全部请假单信息列表
	@RequestMapping("/findLeaveAll")
	public String findLeaveAll(Map<String,Object> map,HttpServletRequest req,@RequestParam("authority_gui") int authority_gui) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		List<Authority> button = authorityService.findButton(user.getUser_id(), authority_gui);
		List<Leave> leaveListAll = leaveService.findLeaveAll();
		map.put("leaveList", leaveListAll);
		map.put("button", button);
		return "leaveInfo";
	}
	
	//查询全部请假单信息列表
	@RequestMapping("/findLeaveByDepartment")
	public String findLeaveByDepartment(Map<String,Object> map,HttpServletRequest req,@RequestParam("authority_gui") int authority_gui) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		List<Authority> button = authorityService.findButton(user.getUser_id(), authority_gui);
		List<Leave> leaveListDepartment = leaveService.findLeaveByDepartment(user.getUser_department_id());
		map.put("leaveList", leaveListDepartment);
		map.put("button", button);
		return "leaveInfo";
	}
	
	//查询全部请假单信息列表
	@RequestMapping("/findLeaveByState")
	public String findLeaveByShen(Map<String,Object> map,HttpServletRequest req,@RequestParam("authority_gui") int authority_gui) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		List<Authority> button = authorityService.findButton(user.getUser_id(), authority_gui);
		List<Leave> leaveListShen = leaveService.findLeaveByState();
		map.put("leaveList", leaveListShen);
		map.put("button", button);
		return "leaveInfo";
	}
	
	//根据编号查询需要进行审核的申请信息
	@RequestMapping("/findLeaveByShen")
	public String findLeaveByS(int leave_id,Map<String,Object> map) {
		Leave leaveS = leaveService.findLeaveByShen(leave_id);
		map.put("leaveS", leaveS);
		return "updateLeaveShen";
	}
	
	//进行审核并给出审核结果
	@RequestMapping("/updateLeaveByShen")
	public void updateShenLeave(Leave leave,HttpServletResponse rep) throws IOException {
		int result = leaveService.updateLeaveByShen(leave);
		print(result,rep);
	}
	
	//查询全部的部门信息赋值到添加用户页面
	@RequestMapping("/getDepartment")
	public String departmentList(Map<String,Object> map,HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		List<Department> departmentList = userService.findDepartment();
		Date reDate = new Date(System.currentTimeMillis());
		String ft = new SimpleDateFormat("yyyy-MM-dd").format(reDate);
		req.setAttribute("loadtime", ft);
		map.put("departmentList", departmentList);
		map.put("user", user);
		return "addLeave";
	}
	
	//创建请假单
	@RequestMapping("/addLeave")
	public void addLeave(Leave leave,HttpServletResponse rep) throws IOException {
		int result = leaveService.addLeave(leave);
		print(result,rep);
	}
	
	//删除请假单
	@RequestMapping("/delLeave")
	public void delLeave(int leave_id,HttpServletResponse rep) throws IOException {
		int result = leaveService.delLeave(leave_id);
		print(result,rep);
	}
	
	//通过请假单编号获取单个请假单的信息可进行修改
	@RequestMapping("/findLeaveById")
	public String findLeaveBy(@RequestParam("leave_id") int leave_id,Map<String,Object> map) {
		Leave leaveById = leaveService.findLeaveById(leave_id);
		map.put("leaveById", leaveById);
		return "updateLeave";
	}
	
	//修改请假单信息
	@RequestMapping("/updateLeave")
	public void updateLeave(Leave leave,HttpServletResponse rep) throws IOException {
		int result = leaveService.updateLeaveById(leave);
		print(result,rep);
	}
	
	//提交请假申请
	@RequestMapping("/update")
	public void update(int leave_id,HttpServletResponse rep) throws IOException {
		int result = leaveService.update(leave_id);
		print(result,rep);
	}
	
	//导出Excel表格
	@RequestMapping("/excel")
	public void ecxel(HttpServletResponse rep) throws IOException {
		rep.setCharacterEncoding("UTF-8");
		List<Leave> list = leaveService.findLeaveAll();
		System.out.println(list);
		//创建Excel表格
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建sheet页
		HSSFSheet sheet = wb.createSheet("请假单列表");
		//创建标题行
		HSSFRow titleRow = sheet.createRow(0);
		titleRow.createCell(0).setCellValue("请假单编号");
	    titleRow.createCell(1).setCellValue("申请人姓名");
	    titleRow.createCell(2).setCellValue("申请部门编号");
	    titleRow.createCell(3).setCellValue("请假开始时间");
	    titleRow.createCell(4).setCellValue("请假结束时间");
	    titleRow.createCell(5).setCellValue("请假类型");
	    titleRow.createCell(6).setCellValue("请假原因");
	    titleRow.createCell(7).setCellValue("申请日期");
	    titleRow.createCell(8).setCellValue("请假审核状态");
	    for(Leave leave:list) {
	       HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
	       dataRow.createCell(0).setCellValue(leave.getLeave_id());
	       dataRow.createCell(1).setCellValue(leave.getLeave_name());
	       dataRow.createCell(2).setCellValue(leave.getDepartment().getDepartment_name());
	       // 日期格式转为字符串输出
	       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	       String begin_time= sdf.format(leave.getLeave_start_time());
	       dataRow.createCell(3).setCellValue(begin_time);
	       String end_time= sdf.format(leave.getLeave_end_time());
	       dataRow.createCell(4).setCellValue(end_time);
	       dataRow.createCell(5).setCellValue(leave.getLeaveState().getLeave_state_name());
	       dataRow.createCell(6).setCellValue(leave.getLeave_context());
	       String leave_time = sdf.format(leave.getLeave_time());
	       dataRow.createCell(7).setCellValue(leave_time);
	       dataRow.createCell(8).setCellValue(leave.getState().getState_name());
	     }
	     // 设置下载时客户端Excel的名称   （上面注释的改进版本，上面的中文不支持）
	     rep.setContentType("application/octet-stream;charset=utf-8");
	     rep.setHeader("Content-Disposition", "attachment;filename="
	            + new String("请假单".getBytes(),"iso-8859-1") + ".xls");


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
