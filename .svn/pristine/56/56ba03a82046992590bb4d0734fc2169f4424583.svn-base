package com.cn.sleep;

import java.util.Date;
import java.util.List;

//import com.cn.sleep.DateUtils;
public class LeaveManage {
	public static final LeaveManage manage = new LeaveManage();

	// 判断时间大小
	public double pdTime(String startTime, String endTime, int login) {
		int num = startTime.compareTo(endTime);
		if (num > 0) {
			return calculationTime(endTime, startTime, login);
		} else if (num < 0) {
			return calculationTime(startTime, endTime, login);
		} else {
			return 0;
		}
	}

	public double calculationTime(String startTime, String endTime, int login) {
		// 获取startTime和endTime之间的所有日期，去掉周六周日
		List<String> list = DateUtils.getDates(startTime, endTime);
		// 获取法定节假日
		List<String> fdList = DateUtils.holiday(1);
		// 获取调休
		List<String> txList = DateUtils.holiday(2);
		// 上班时间
		String[] workTime = DateUtils.workTime(login);
		// 删除时间区间中的所有法定节假日
		list.removeAll(fdList);
		String st = startTime.substring(0, 10);
		String en = endTime.substring(0, 10);
		for (String s : txList) {
			if (s.compareTo(st) >= 0 && s.compareTo(en) <= 0) {
				// 添加时间区间中的所有调休日期
				list.add(s);
			}
		}
		// 去重
		list = DateUtils.removal(list);
		// 开始当天上午上班时间、上午下班时间、下午上班时间、下午下班时间
		String amWorkYes = startTime.substring(0, 11) + workTime[0];
		String amWorkNo = startTime.substring(0, 11) + workTime[1];
		String pmWorkYes = startTime.substring(0, 11) + workTime[2];
		String pmWorkNo = startTime.substring(0, 11) + workTime[3];

		// 结束当天上午上班时间、上午下班时间、下午上班时间、下午下班时间
		String amWorkYesEnd = endTime.substring(0, 11) + workTime[0];
		String amWorkNoEnd = endTime.substring(0, 11) + workTime[1];
		String pmWorkYesEnd = endTime.substring(0, 11) + workTime[2];
		String pmWorkNoEnd = endTime.substring(0, 11) + workTime[3];

		double time = 0;

		if (list.size() == 0) {
			// 申请日期是法定节假日
			return time;
		} else if (list.size() == 1) {
			// 请假一天
			if (startTime.compareTo(pmWorkNo) > 0) {
				return time;
			}
			if (endTime.compareTo(amWorkYes) < 0) {
				return time;
			}
			if (startTime.compareTo(amWorkNo) >= 0 && endTime.compareTo(pmWorkYes) <= 0) {
				return time;
			}
			if (startTime.compareTo(amWorkYes) < 0) {
				startTime = amWorkYes;
			}
			if (endTime.compareTo(pmWorkNo) > 0) {
				endTime = pmWorkNo;
			}
			if (startTime.compareTo(amWorkNo) >= 0 && startTime.compareTo(pmWorkYes) <= 0) {
				startTime = pmWorkYes;
			}
			if (endTime.compareTo(amWorkNo) >= 0 && endTime.compareTo(pmWorkYes) <= 0) {
				endTime = amWorkNo;
			}
			Date start = DateUtils.StringToDate(startTime, 15); // 0或者15
			Date end = DateUtils.StringToDate(endTime, 15);

			// 三种情况，1：请假时间全在上午，2：请假时间全在下午，3：包含午休时间
			if (startTime.compareTo(amWorkYes) >= 0 && endTime.compareTo(amWorkNo) <= 0) {
				double minute = (end.getTime() - start.getTime()) / (1000 * 60);
				time = minute / (8 * 60);
			} else if (startTime.compareTo(pmWorkYes) >= 0 && endTime.compareTo(pmWorkNo) <= 0) {
				double minute = (end.getTime() - start.getTime()) / (1000 * 60);
				time = minute / (8 * 60);
			} else if (startTime.compareTo(amWorkNo) < 0 && endTime.compareTo(pmWorkYes) > 0) {
				double minute = (end.getTime() - start.getTime()) / (1000 * 60) - 60;
				time = minute / (8 * 60);
			}
			return time;
		} else {
			// 处理请假多天的情况
			// 申请开始时间处理
			if (list.contains(st)) {
				if (startTime.compareTo(amWorkYes) < 0) {
					startTime = amWorkYes;
				}
				if (startTime.compareTo(pmWorkNo) > 0) {
					startTime = pmWorkNo;
				}
				if (startTime.compareTo(amWorkNo) >= 0 && startTime.compareTo(pmWorkYes) <= 0) {
					startTime = pmWorkYes;
				}
				Date start = DateUtils.StringToDate(startTime, 15); // 0或者15
				Date end = DateUtils.StringToDate(pmWorkNo, 15);
				if (startTime.compareTo(amWorkNo) < 0) {
					// 减去中午一小时
					double t = (end.getTime() - start.getTime()) / (1000 * 60) - 60;
					time = time + t / (8 * 60);
				} else {
					double t = (end.getTime() - start.getTime()) / (1000 * 60);
					time = time + t / (8 * 60);
				}
				list.remove(st);
			}
			// 申请结束时间处理
			if (list.contains(en)) {
				if (endTime.compareTo(amWorkYesEnd) < 0) {
					endTime = amWorkYesEnd;
				}
				if (endTime.compareTo(pmWorkNoEnd) > 0) {
					endTime = pmWorkNoEnd;
				}

				if (endTime.compareTo(amWorkNoEnd) >= 0 && endTime.compareTo(pmWorkYesEnd) <= 0) {
					endTime = amWorkNoEnd;
				}

				Date end = DateUtils.StringToDate(endTime, 15);// 0或者15
				Date start = DateUtils.StringToDate(amWorkYesEnd, 15);
				if (endTime.compareTo(pmWorkYesEnd) > 0) {
					double t = (end.getTime() - start.getTime()) / (1000 * 60) - 60;
					time = time + t / (8 * 60);
				} else {
					double t = (end.getTime() - start.getTime()) / (1000 * 60);
					time = time + t / (8 * 60);
				}
				list.remove(en);
			}
			// 天数计算集合中剩下的个数就可以
			time = time + list.size();
			return time;
		}
	}
}
