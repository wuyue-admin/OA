package com.cn.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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
import com.cn.pojo.OverTime;
import com.cn.pojo.User;
import com.cn.service.AuthorityService;
import com.cn.service.OverTimeService;

@Controller
@RequestMapping("/overTime")
public class OverTimeController {
	
	@Autowired
	private OverTimeService overTimeService;
	@Autowired
	private AuthorityService authorityService;
	
	//查询全部加班申请信息列表
	@RequestMapping("/findOverTime")
	public String overTimeList(Map<String,Object> map,HttpServletRequest req,int authority_gui) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		List<Authority> button = authorityService.findButton(user.getUser_id(), authority_gui);
		List<OverTime> overTimeList = overTimeService.findOverTime(user.getUser_id());
		map.put("button", button);
		map.put("overTimeList", overTimeList);
		return "overTimeInfo";
	}
	
	//查询全部加班申请信息列表
	@RequestMapping("/findOverTimeAll")
	public String overTimeListAll(Map<String,Object> map,HttpServletRequest req,int authority_gui) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		List<Authority> button = authorityService.findButton(user.getUser_id(), authority_gui);
		List<OverTime> overTimeListAll = overTimeService.findOverTimeAll();
		map.put("button", button);
		map.put("overTimeList", overTimeListAll);
		return "overTimeInfo";
	}
		
	//查询全部加班申请信息列表
	@RequestMapping("/findOverTimeByDepartment")
	public String overTimeListByDepartment(Map<String,Object> map,HttpServletRequest req,int authority_gui) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		List<Authority> button = authorityService.findButton(user.getUser_id(), authority_gui);
		List<OverTime> overTimeListDepartment = overTimeService.findOverTimeByDepartment(user.getUser_department_id());
		map.put("button", button);
		map.put("overTimeList", overTimeListDepartment);
		return "overTimeInfo";
	}
	
	//查询需审核加班的信息列表
	@RequestMapping("/findOverTimeShen")
	public String overTimeListByShen(Map<String,Object> map,HttpServletRequest req,int authority_gui) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		List<Authority> button = authorityService.findButton(user.getUser_id(), authority_gui);
		List<OverTime> overTimeListShen = overTimeService.findOverTimeByShen();
		map.put("button", button);
		map.put("overTimeList", overTimeListShen);
		return "overTimeInfo";
	}
	
	//根据编号查询单个需要审核的申请信息
	@RequestMapping("/findOverTimeByOneShen")
	public String findOverTimeByOneShen(int overtime_id,Map<String,Object> map) {
		OverTime overTimeShen = overTimeService.findOverTimeByS(overtime_id);
		map.put("overTimeShen", overTimeShen);
		return "updateOverTimeShen";
	}
	
	//进行审核
	@RequestMapping("/updateOverTimeShen")
	public void updateOverTimeShen(OverTime overtime,HttpServletResponse rep) throws IOException {
		int result = overTimeService.updateOverTimeBySh(overtime);
		print(result,rep);
	}
	
	//将信息添加到申请加班页面
	@RequestMapping("/addOverTime")
	public String addOverTime(Map<String,Object> map,HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("us");
		map.put("user",user);
		return "addOverTime";
	}
	
	//添加加班申请
	@RequestMapping("/add")
	public void add(OverTime overTime,HttpServletResponse rep) throws IOException {
		int result = overTimeService.addOverTime(overTime);
		print(result,rep);
	}
	
	//删除加班申请
	@RequestMapping("/del")
	public void del(int overtime_id,HttpServletResponse rep) throws IOException {
		int result = overTimeService.delOverTime(overtime_id);
		print(result,rep);
	}
	
	//修改加班申请
	@RequestMapping("/update")
	public void update(OverTime overTime,HttpServletResponse rep) throws IOException {
		int result = overTimeService.updateOverTime(overTime);
		print(result,rep);
	}
	
	//根据编号获取单个加班申请的信息
	@RequestMapping("/findOverTimeById")
	public String findById(int overtime_id,Map<String,Object> map) {
		OverTime overtime = overTimeService.findOverTimeById(overtime_id);
		map.put("overtime", overtime);
		return "updateOverTime";
	}
	
	//提交审核
	@RequestMapping("/updat")
	public void update(int overtime_id,HttpServletResponse rep) throws IOException {
		int result = overTimeService.update(overtime_id);
		print(result,rep);
	}
	
	//导出Excel表格
	@RequestMapping("/excel")
	public void ecxel(HttpServletResponse rep) throws IOException {
		rep.setCharacterEncoding("UTF-8");
		List<OverTime> list = overTimeService.findOverTimeAll();
		System.out.println(list);
		//创建Excel表格
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建sheet页
		HSSFSheet sheet = wb.createSheet("用户信息列表");
		//创建标题行
		HSSFRow titleRow = sheet.createRow(0);
		titleRow.createCell(0).setCellValue("加班编号");
        titleRow.createCell(1).setCellValue("加班人员姓名");
        titleRow.createCell(2).setCellValue("加班开始时间");
        titleRow.createCell(3).setCellValue("加班结束时间");
        titleRow.createCell(4).setCellValue("加班申请状态");
        titleRow.createCell(5).setCellValue("加班人员所属部门");
        for(OverTime user:list) {
        	HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
        	dataRow.createCell(0).setCellValue(user.getOvertime_id());
            dataRow.createCell(1).setCellValue(user.getUser().getUser_name());
            // 日期格式转为字符串输出
 	       	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 	       	String begin_time= sdf.format(user.getOvertime_begin_time());
            dataRow.createCell(2).setCellValue(begin_time);
            String end_time= sdf.format(user.getOvertime_end_time());
            dataRow.createCell(3).setCellValue(end_time);
            dataRow.createCell(4).setCellValue(user.getState().getState_name());
            dataRow.createCell(5).setCellValue(user.getDepartment().getDepartment_name());
        }
        // 设置下载时客户端Excel的名称   （上面注释的改进版本，上面的中文不支持）
        rep.setContentType("application/octet-stream;charset=utf-8");
        rep.setHeader("Content-Disposition", "attachment;filename="
                + new String("加班记录".getBytes(),"iso-8859-1") + ".xls");


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
