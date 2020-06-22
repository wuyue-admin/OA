package com.cn.sleep;

public class Main {
	static LeaveManage manage = LeaveManage.manage;

	public static void main(String[] args) {
		System.out.println("1、正常工作日请假：" + manage.calculationTime("2018-12-21 08:30", "2018-12-24 17:30", 1));
		System.out.println("2、带调休请假：" + manage.calculationTime("2018-12-27 08:30", "2018-12-29 17:30", 1));
		System.out.println("3、法定节假日请假：" + manage.calculationTime("2018-09-24 08:30", "2018-09-26 17:30", 1));
		System.out.println("4、跨年请假：" + manage.calculationTime("2018-12-29 08:30", "2019-01-02 17:30", 1));

		System.out.println("2018年01月上班天数：" + DateUtils.queryMonthDay("2018-01-10"));
		System.out.println("2018年02月上班天数：" + DateUtils.queryMonthDay("2018-02-10"));
		System.out.println("2018年03月上班天数：" + DateUtils.queryMonthDay("2018-03-10"));
		System.out.println("2018年04月上班天数：" + DateUtils.queryMonthDay("2018-04-10"));
		System.out.println("2018年05月上班天数：" + DateUtils.queryMonthDay("2018-05-10"));
		System.out.println("2018年06月上班天数：" + DateUtils.queryMonthDay("2018-06-10"));
		System.out.println("2018年07月上班天数：" + DateUtils.queryMonthDay("2018-07-10"));
		System.out.println("2018年08月上班天数：" + DateUtils.queryMonthDay("2018-08-10"));
		System.out.println("2018年09月上班天数：" + DateUtils.queryMonthDay("2018-09-10"));
		System.out.println("2018年10月上班天数：" + DateUtils.queryMonthDay("2018-10-10"));
		System.out.println("2018年11月上班天数：" + DateUtils.queryMonthDay("2018-11-10"));
		System.out.println("2018年12月上班天数：" + DateUtils.queryMonthDay("2018-12-10"));
	}
}
