package com.cn.sleep;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DateUtils {
	/**
	 * 定义常见的时间格式
	 */
	private static String[] dateFormat = { 
			"yyyy-MM-dd HH:mm:ss", // 0
			"yyyy/MM/dd HH:mm:ss", // 1
			"yyyy年MM月dd日HH时mm分ss秒", // 2
			"yyyy-MM-dd", // 3
			"yyyy/MM/dd", // 4
			"yy-MM-dd", // 5
			"yy/MM/dd", // 6
			"yyyy年MM月dd日", // 7
			"HH:mm:ss", // 8
			"yyyyMMddHHmmss", // 9
			"yyyyMMdd", // 10
			"yyyy.MM.dd", // 11
			"yy.MM.dd", // 12
			"MM月dd日HH时mm分", // 13
			"yyyy年MM月dd日 HH:mm:ss", // 14
			"yyyy-MM-dd HH:mm", // 15
			"yyMMdd" // 16
	};

	/**
	 * 去重
	 * 
	 * @param str
	 * @return
	 */
	public static List<String> removal(List<String> str) {
		Set<String> s = new HashSet<String>(str);
		str.clear();
		str.addAll(s);
		return str;
	}

	/**
	 * 获取两个日期之间的所有日期，去掉周末
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static List<String> getDates(String startDate, String endDate) {
		List<String> result = new ArrayList<String>();
		Calendar startDay = Calendar.getInstance();
		Calendar endDay = Calendar.getInstance();

		startDay.setTime(StringToDate(startDate, 3));
		endDay.setTime(StringToDate(endDate, 3));

		while (startDay.before(endDay)) {
			int week = startDay.get(Calendar.DAY_OF_WEEK);
			if (7 != week && 1 != week) {
				result.add(dateToString(startDay.getTime(), 3));
			}
			startDay.add(Calendar.DAY_OF_YEAR, 1);
		}
		// 验证结束日期是否是周六周日
		int week = endDay.get(Calendar.DAY_OF_WEEK);
		if (7 != week && 1 != week) {
			result.add(dateToString(endDay.getTime(), 3));
		}

		return result;
	}

	/**
	 * 字符串转时间
	 * 
	 * @param dateStr
	 * @param index
	 * @return
	 */
	public static Date StringToDate(String dateStr, int index) {
		DateFormat df = null;
		try {
			df = new SimpleDateFormat(dateFormat[index]);
			return df.parse(dateStr);
		} catch (Exception aioe) {
			return null;
		}
	}

	/**
	 * 时间转字符串
	 * 
	 * @param date
	 * @param index
	 * @return
	 */
	public static String dateToString(Date date, int index) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat(dateFormat[index]).format(date);
	}

	/**
	 * 获取法定节假日或者调休
	 * 
	 * @param num
	 * @return
	 */
	public static List<String> holiday(int num) {
		if (num == 2) {
			return Arrays.asList(MyData.holiday2);
		} else {
			return Arrays.asList(MyData.holiday1);
		}
	}

	/**
	 * 获取不同部门工作时间
	 * 
	 * @param num
	 * @return
	 */
	public static String[] workTime(int num) {
		if (num == 2) {
			return MyData.workTime2;
		} else {
			return MyData.workTime1;
		}
	}

	/**
	 * 查询每个月的工作时间(天)
	 *
	 * @return
	 */
	public static double queryMonthDay(String day) {
		List<String> result = new ArrayList<String>();
		Calendar Day = Calendar.getInstance();
		Day.setTime(StringToDate(day, 3));
		// 获取该月天数
		int dayNum = Day.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 月开始
		String st = day.substring(0, 8) + "01";
		// 月结束
		String en = day.substring(0, 8) + dayNum;
		// 月份数据集合
		for (int i = 1; i < dayNum + 1; i++) {
			String d = day.substring(0, 8) + ((i < 10) ? "0" + i : "" + i);
			// 去掉周末
			Calendar startDay = Calendar.getInstance();
			startDay.setTime(StringToDate(d, 3));
			int week = startDay.get(Calendar.DAY_OF_WEEK);
			if (7 != week && 1 != week) {
				result.add(d);
			}
		}

		// 获取法定节假日
		List<String> fdList = holiday(1);
		// 获取调休
		List<String> txList = holiday(2);
		// 添加时间段中间应该上班的时间
		for (String s : txList) {
			if (s.compareTo(st) >= 0 && s.compareTo(en) <= 0) {
				result.add(s);
			}
		}
		// 去除中间所有的法定假期
		result.removeAll(fdList);
		// 去重
		result = removal(result);
		return result.size();
	}
}
