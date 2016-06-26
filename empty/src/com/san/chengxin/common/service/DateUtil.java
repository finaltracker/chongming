/*
 * Copyright (c)  2006, 上海三零卫士安全技术有限公司
 * All rights reserved.
 *
 * $Id: DateUtil.java 3121 2007-09-06 06:55:15Z 吕海涛 $
 */
package com.san.chengxin.common.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.log4j.Logger;


/**
 * <p>
 * Title: common.util-日期处理
 * </p>
 * <p>
 * Description:日期处理
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company:
 * 
 * @author David Gan
 * @version 1.0
 */
public class DateUtil {
	private static Logger log = Logger.getLogger(DateUtil.class);
	public static final long DAY_MILLI = 24 * 60 * 60 * 1000;

	// 一天的MilliSecond 数
	/**
	 * 要用到的DATE Format的定义
	 */
	public static String DATE_FORMAT_DATEONLY = "yyyy-MM-dd"; // 年/月/日

	// public static String DATE_FORMAT_DATETIME = "yyyy/MM/dd HH:mm:ss"; //
	// 年/月/日 时:分:秒
	public static String DATE_FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

	public static String DATE_FORMAT_DATEMSEL = "yyyy-MM-dd HH:mm:ss:SS";

	public static String DATE_FORMAT_DATETIME5 = "yyyy-mm-dd hh:mm:ss.fffff";

	// 年/月/日 时:分:秒
	// public final static String DATE_FORMAT_DATEHOURMIN = "yyyy/MM/dd HH:mm";
	// // 年/月/日 时:分
	// public final static String DATE_FORMAT_SESSION = "yyyyMMddHHmm"; // 年/月/日
	// 时:分:秒
	/**
	 * Global SimpleDateFormat object
	 */
	private static SimpleDateFormat sdfDateOnly = new SimpleDateFormat(
			DateUtil.DATE_FORMAT_DATEONLY);

	private static SimpleDateFormat sdfDateTime = new SimpleDateFormat(
			DateUtil.DATE_FORMAT_DATETIME);

	private static SimpleDateFormat sdfDateMsel = new SimpleDateFormat(
			DateUtil.DATE_FORMAT_DATEMSEL);

	// private static SimpleDateFormat sdfDateSession = new
	// SimpleDateFormat(DateUtil.DATE_FORMAT_SESSION );

	/**
	 * Calendar Object
	 * 
	 * private GregorianCalendar gcal = null;
	 */

	// private Timestamp time = null;
	/***************************************************************************
	 * private attribute
	 **************************************************************************/
	/**
	 * 节假日情报的汉字名：如国庆节
	 */
	private String holidayString;

	/**
	 * 构造函数
	 * 
	 */
	public DateUtil() {
		// gcal = new GregorianCalendar();
		// time = new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 判断今天是否是节假日
	 * 
	 * @return true : 是 false: 否
	 */
	public boolean isHoliday() {
		return false;
	}

	/**
	 * 取得节假日信息的汉字名
	 * 
	 * @return 节假日信息的汉字名
	 */
	public String getHolidayString() {
		return holidayString;
	}

	/**
	 * 设定节假日信息的汉字名
	 * 
	 * @param holidayString
	 *            节假日信息的汉字名
	 */
	public void setHolidayString(String holidayString) {
		this.holidayString = holidayString;
	}

	/***************************************************************************
	 * java.util.Date ==> String 的转换函数
	 **************************************************************************/
	/**
	 * 利用缺省的Date格式(YYYY/MM/DD)转化String到Date
	 * 
	 * @param sDate
	 *            Date string
	 * @return Date
	 */
	public static java.util.Date toDate(String sDate) {
		return toDate(sDate, DateUtil.sdfDateOnly);
	}

	/**
	 * 根据指定的Format转化String到Date
	 * 
	 * @param sDate
	 *            Date string
	 * @param sFmt
	 *            Date format , DATE_FORMAT_DATEONLY or DATE_FORMAT_DATETIME
	 * @return Date
	 */
	public static java.util.Date toDate(String sDate, String sFmt) {
		if (sFmt.equals(DateUtil.DATE_FORMAT_DATETIME)) {
			// "YYYY/MM/DD HH24:MI:SS"
			return toDate(sDate, DateUtil.sdfDateTime);
		} else if (sFmt.equals(DateUtil.DATE_FORMAT_DATEONLY)) { // YYYY/MM/DD
			return toDate(sDate, DateUtil.sdfDateOnly);
		} else if (sFmt.equals(DateUtil.DATE_FORMAT_DATEMSEL)) {
			return toDate(sDate, DateUtil.sdfDateMsel);
		} else {
			return null;
		}
	}

	/**
	 * 利用指定SimpleDateFormat instance转化String到Date
	 * 
	 * @param sDate
	 *            Date string
	 * @param formatter
	 *            SimpleDateFormat instance
	 * @return Date
	 */
	private static java.util.Date toDate(String sDate,
			SimpleDateFormat formatter) {
		java.util.Date dt = null;
		try {
			dt = formatter.parse(sDate);
		} catch (Exception e) {
			log.error("",e);
			dt = null;
		}
		return dt;
	}

	/***************************************************************************
	 * String ==> java.util.Date 的转换函数
	 **************************************************************************/
	/**
	 * 根据缺省的Format(YYYY/MM/DD)转化java.util.Date到String
	 * 
	 * @param dt
	 *            java.util.Date instance
	 * @return String
	 */
	public static String toString(java.util.Date dt) {
		return toString(dt, DateUtil.sdfDateOnly);
	}

	/**
	 * 时间操作。 String "+" 当前时间加传入时间 "-" 当前时间减传入时间
	 * 
	 * @param pStrNum
	 * @param pStrProc
	 *           
	 * @return String
	 */
	public static String curdatetimeproc(String pStrNum, String pStrProc) {
		Calendar c = Calendar.getInstance();
		long lDate = 0l;
		String strDate = "";
		if (pStrProc != null && !"".equals(pStrProc)
				&& StringUtil.isNumber(pStrNum)) {
			if (pStrNum == null || "".equals(pStrNum)) {
				pStrNum = "0";
			}
			int tmp = Integer.parseInt(pStrNum);
			if (pStrProc.equals("+")) {
				lDate = c.getTimeInMillis() + (1000L * 60L * tmp);// 加pStr分钟
			} else {
				lDate = c.getTimeInMillis() - (1000L * 60L * tmp);// 减pStr分钟
			}
			Date currentTime_1 = new Date(lDate);
			SimpleDateFormat sdfDateTime2 = new SimpleDateFormat(
					DateUtil.DATE_FORMAT_DATETIME);
			strDate = sdfDateTime2.format(currentTime_1);
		}
		return strDate;
	}

	public static void main(String args[]) {

		// DateUtil dd=new DateUtil();
		// SimpleDateFormat bartDateFormat = new SimpleDateFormat("MMMMM dd,
		// yyyy",Locale.ENGLISH);
		System.out.print(DateUtil.addDays(new java.util.Date(), 365));
		// System.out.println(DateUtil.curdatetimeproc("2", "-"));
		// System.out.print(dd.toString_CIBS(dt));
		// System.out.println(DateUtil.toSqlTimestamp(DateUtil.getSysDateStringYMDHMS(),DateUtil.DATE_FORMAT_DATETIME));

	}

	public static String toString_CIBS(java.util.Date dt) {
		String returnValue = "";
		if (dt != null) {
			String str[] = toString(dt).split("-");
			if (str.length > 1) {
				returnValue = (str[0] + str[1] + str[2]);
			}
		}
		return returnValue;
	}

	/**
	 * 根据指定的Format转化java.util.Date到String
	 * 
	 * @param dt
	 *            java.util.Date instance
	 * @param sFmt
	 *            Date format , DATE_FORMAT_DATEONLY or DATE_FORMAT_DATETIME
	 * @return String
	 */
	public static String toString(java.util.Date dt, String sFmt) {
		if (dt == null) {
			return "";
		}
		if (sFmt.equals(DateUtil.DATE_FORMAT_DATETIME)) {
			// "YYYY/MM/DD HH24:MI:SS"
			return toString(dt, DateUtil.sdfDateTime);
		} else { // Default , YYYY/MM/DD
			return toString(dt, DateUtil.sdfDateOnly);
		}
	}

	/**
	 * 利用指定SimpleDateFormat instance转换java.util.Date到String
	 * 
	 * @param dt
	 *            java.util.Date instance
	 * @param formatter
	 *            SimpleDateFormat Instance
	 * @return String
	 */
	private static String toString(java.util.Date dt, SimpleDateFormat formatter) {
		String sRet = null;

		try {
			if (dt == null)
				sRet = "";
			else
				sRet = formatter.format(dt).toString();
		} catch (Exception e) {
			log.error("",e);
			sRet = null;
		}

		return sRet;
	}

	/**
	 * java.util.Date到String
	 * 
	 * @param dt
	 *            java.util.Date instance
	 * @return String
	 */
	public static String toEnString(java.util.Date dt) {
		String sRet = null;
		try {
			if (dt == null)
				sRet = "";
			else {
				SimpleDateFormat bartDateFormat = new SimpleDateFormat(
						"MMMMM dd, yyyy", Locale.ENGLISH);
				sRet = bartDateFormat.format(dt);
				;
			}
		} catch (Exception e) {
			log.error("",e);
			sRet = null;
		}

		return sRet;
	}

	/**
	 * 比较两个java.sql.Timestamp instance 的年月日部分是否相同
	 * 
	 * @param date1 ,
	 *            java.sql.Timestamp Object
	 * @param date2 ,
	 *            java.sql.Timestamp Object
	 * @return true : 年月日部分相同 false : 不同
	 */
	public static boolean isSameDay(java.sql.Timestamp date1,
			java.sql.Timestamp date2) {
		String s1, s2 = null;
		s1 = date1.toString().substring(0,
				DateUtil.DATE_FORMAT_DATEONLY.length());
		s2 = date2.toString().substring(0,
				DateUtil.DATE_FORMAT_DATEONLY.length());
		// cat.debug("in isSameDay() , s1=" + s1 + ",s2=" + s2);
		return s1.equalsIgnoreCase(s2);
	}

	/**
	 * 取得指定日期所在周的第一天(Sunday)
	 * 
	 * @param timestamp ,
	 *            java.sql.Timestamp Object
	 * @return java.sql.Timestamp instance
	 */
	public static java.sql.Timestamp getFirstDayOfWeek(
			java.sql.Timestamp timestamp) {
		int no = DateUtil.getWeekdayOfTimestamp(timestamp);
		java.sql.Timestamp out = DateUtil.addDays(timestamp, 1 - no);
		return out;
	}

	/**
	 * 取得指定日期所在周的最后一天(Saturday)
	 * 
	 * @param timestamp ,
	 *            java.sql.Timestamp Object
	 * @return java.sql.Timestamp instance
	 */
	public static java.sql.Timestamp getLastDayOfWeek(
			java.sql.Timestamp timestamp) {
		int no = DateUtil.getWeekdayOfTimestamp(timestamp);
		java.sql.Timestamp out = DateUtil.addDays(timestamp, 7 - no);
		return out;
	}

	/**
	 * 取得指定日期所在月的1号所在周的Sunday(可能是上个月的日期)
	 * 
	 * @param timestamp ,
	 *            java.sql.Timestamp Object
	 * @return java.sql.Timestamp instance
	 */
	public static java.sql.Timestamp getFirstSundayOfMonth(
			java.sql.Timestamp timestamp) {
		java.sql.Timestamp out = null;
		if (timestamp == null)
			return null;
		out = getFirstDayOfMonth(timestamp);
		out = DateUtil.getFirstDayOfWeek(out);
		return out;
	}

	/**
	 * 取得指定日期所在月的最后一天(如31号)所在周的Saturday(可能是下个月的日期)
	 * 
	 * @param timestamp ,
	 *            java.sql.Timestamp Object
	 * @return java.sql.Timestamp instance
	 */
	public static java.sql.Timestamp getLastSaturdayOfMonth(
			java.sql.Timestamp timestamp) {
		java.sql.Timestamp out = null;
		if (timestamp == null)
			return null;
		// cat.debug("In timestamp=" + timestamp.toString() );
		out = getLastDayOfMonth(timestamp);
		// cat.debug("LastDayOfMonth=" + out.toString() );
		out = DateUtil.getLastDayOfWeek(out);
		// cat.debug("LastSaturdayOfMonth=" + out.toString() );
		return out;
	}

	/**
	 * 取得指定日期所在月的第一天
	 * 
	 * @param timestamp ,
	 *            java.sql.Timestamp Object
	 * @return java.sql.Timestamp instance
	 */
	public static java.sql.Timestamp getFirstDayOfMonth(
			java.sql.Timestamp timestamp) {
		java.sql.Timestamp out = null;
		if (timestamp == null)
			return null;
		int day = DateUtil.getDayOfTimestamp(timestamp);
		out = DateUtil.addDays(timestamp, 1 - day);
		// out = DateUtil.getFirstDayOfWeek(out);
		return out;
	}

	/**
	 * 取得两个日期之间的日数
	 * 
	 * @param t1
	 *            日期
	 * @param t2
	 *            日期
	 * @return t1到t2间的日数，如果t2 在 t1之后，返回正数，否则返回负数
	 */
	public static long daysBetween(java.sql.Timestamp t1, java.sql.Timestamp t2) {
		return (t2.getTime() - t1.getTime()) / DAY_MILLI;
	}

	/**
	 * 取得两个日期之间的日数。如：beginDate＝"2005-08-26",endDate="2005-08-29",则返回3;反之返回-3
	 * 如果beginDate或endDate为null值，则取当前时间值。
	 * t1到t2间的日数，如果t2 在 t1之后，返回正数，否则返回负数
	 * @param beginDate
	 * @param beginDate
	 * @return long
	 */
	public static long daysBetweenByDate(java.util.Date beginDate,
			java.util.Date endDate) {
		if (beginDate == null)
			beginDate = new java.util.Date();
		if (endDate == null)
			endDate = new java.util.Date();
		long beginTime = beginDate.getTime();
		long endTime = endDate.getTime();
		// long betweenDays = (long)((endTime - beginTime) / (1000 * 60 * 60
		// *24) + 0.5);//自动扑齐半天
		long betweenDays = (long) ((endTime - beginTime) / (1000 * 60 * 60 * 24));
		// betweenDays = betweenDays + 1;//朴一天

		return betweenDays;
	}

/**
 * 取得指定日期所在月的最后一天
 */
	public static int[] DAY_OF_MONTH_LEAP_YEAR = { 31, 29, 31, 30, 31, 30, 31,
			31, 30, 31, 30, 31 };

	public static int[] DAY_OF_MONTH_NON_LEAP_YEAR = { 31, 28, 31, 30, 31, 30,
			31, 31, 30, 31, 30, 31 };

	/**
	 * Format year/month/day to YYYY/MM/DD format
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @param day
	 *            日
	 * @return YYYY/MM/DD format String
	 */
	private static String formatYMD(int year, int month, int day) {
		String temp = String.valueOf(year) + "/";
		if (month < 10) {
			temp += "0" + String.valueOf(month) + "/";
		} else {
			temp += String.valueOf(month) + "/";
		}
		if (day < 10) {
			temp += "0" + String.valueOf(day);
		} else {
			temp += String.valueOf(day);
		}
		return temp;
	}

	public static java.sql.Timestamp getLastDayOfMonth(
			java.sql.Timestamp timestamp) {
		java.sql.Timestamp out = null;
		if (timestamp == null)
			return null;
		// out = (java.sql.Timestamp )timestamp.clone() ;
		// day = DateUtil.getDayOfTimestamp(timestamp);
		// int month = DateUtil.getMonthOfTimestamp(timestamp);
		GregorianCalendar obj = DateUtil.convertToCalendar(timestamp);
		// month : 0 -- 11
		int day = 0;
		int year = obj.get(GregorianCalendar.YEAR);
		int month = obj.get(GregorianCalendar.MONTH) + 1;
		if (obj.isLeapYear(obj.get(GregorianCalendar.YEAR))) {
			day = DateUtil.DAY_OF_MONTH_LEAP_YEAR[month - 1];
		} else {
			day = DateUtil.DAY_OF_MONTH_NON_LEAP_YEAR[month - 1];
		}
		out = DateUtil.toSqlTimestamp(DateUtil.formatYMD(year, month, day));

		return out;

	}

	/***************************************************************************
	 * 把java.sql.Timestamp Object 取出各部分的值
	 **************************************************************************/
	/**
	 * 从java.sql.Timestamp Object 中取出Year value
	 * 
	 * @param timestamp ,
	 *            java.sql.Timestamp Object
	 * @return year value
	 */
	public static int getYearOfTimestamp(java.sql.Timestamp timestamp) {
		GregorianCalendar obj = DateUtil.convertToCalendar(timestamp);
		return obj.get(GregorianCalendar.YEAR);
	}

	/**
	 * 从java.sql.Timestamp Object 中取出month value
	 * 
	 * @param timestamp ,
	 *            java.sql.Timestamp Object
	 * @return month value(1 -- 12 )
	 */
	public static int getMonthOfTimestamp(java.sql.Timestamp timestamp) {
		GregorianCalendar obj = DateUtil.convertToCalendar(timestamp);
		return (obj.get(GregorianCalendar.MONTH) + 1);
	}

	/**
	 * 从java.sql.Timestamp Object 中取出day-of-month value
	 * 
	 * @param timestamp ,
	 *            java.sql.Timestamp Object
	 * @return day value
	 */
	public static int getDayOfTimestamp(java.sql.Timestamp timestamp) {
		GregorianCalendar obj = DateUtil.convertToCalendar(timestamp);
		return obj.get(GregorianCalendar.DAY_OF_MONTH);
	}

	/**
	 * 从java.sql.Timestamp Object 中取出Weekday value
	 * 
	 * @param timestamp ,
	 *            java.sql.Timestamp Object
	 * @return weekday value
	 */
	public static int getWeekdayOfTimestamp(java.sql.Timestamp timestamp) {
		GregorianCalendar obj = DateUtil.convertToCalendar(timestamp);
		return obj.get(GregorianCalendar.DAY_OF_WEEK);
	}

	/**
	 * 返回当天零时的Timestamp值
	 * 
	 * @param timestamp
	 *            java.sql.Timestamp Object
	 * @return Zero time Timestamp
	 */
	public static java.sql.Timestamp getZeroTime(java.sql.Timestamp timestamp) {
		String tempStr = timestamp.toString().substring(0, 10);
		return DateUtil.toSqlTimestamp(tempStr);
	}

	/**
	 * 从java.sql.Timestamp Object 中取出hour:minute
	 * 
	 * @param timestamp ,
	 *            java.sql.Timestamp Object
	 * @return Hour:Minute format string
	 */
	public static String getHourAndMinuteString(java.sql.Timestamp timestamp) {
		String out = null;
		GregorianCalendar obj = DateUtil.convertToCalendar(timestamp);
		int hour = obj.get(GregorianCalendar.HOUR_OF_DAY);
		int minute = obj.get(GregorianCalendar.MINUTE);
		if (minute < 10) {
			out = String.valueOf(hour) + ":0" + String.valueOf(minute);
		} else {
			out = String.valueOf(hour) + ":" + String.valueOf(minute);
		}
		return out;
	}

	/**
	 * 从java.sql.Timestamp Object 中取出hour value
	 * 
	 * @param timestamp ,
	 *            java.sql.Timestamp Object
	 * @return 24小时制的hour value
	 */
	public static int getHourOfTimestamp(java.sql.Timestamp timestamp) {
		GregorianCalendar obj = DateUtil.convertToCalendar(timestamp);
		return obj.get(GregorianCalendar.HOUR_OF_DAY);
	}

	/**
	 * 从java.sql.Timestamp Object 中取出minute value
	 * 
	 * @param timestamp ,
	 *            java.sql.Timestamp Object
	 * @return minute value
	 */
	public static int getMinuteOfTimestamp(java.sql.Timestamp timestamp) {
		GregorianCalendar obj = DateUtil.convertToCalendar(timestamp);
		return obj.get(GregorianCalendar.MINUTE);
	}

	/**
	 * 从java.sql.Timestamp Object 中取出second value
	 * 
	 * @param timestamp ,
	 *            java.sql.Timestamp Object
	 * @return minute value
	 */
	public static int getSecondOfTimestamp(java.sql.Timestamp timestamp) {
		GregorianCalendar obj = DateUtil.convertToCalendar(timestamp);
		return obj.get(GregorianCalendar.SECOND);
	}

	/**
	 * 把java.sql.Timestamp Object 转换为java.util.GregorianCalendar Object
	 * 
	 * @param timestamp ,
	 *            java.sql.Timestamp Object
	 * @return java.util.GregorianCalendar Object
	 * @deprecated please use confertToCalendar(java.sql.Timestamp)
	 */
	public static java.util.GregorianCalendar convertTimestampToCalendar(
			java.sql.Timestamp timestamp) {
		return convertToCalendar(timestamp);
	}

	/**
	 * 把java.sql.Timestamp Object 转换为java.util.GregorianCalendar Object
	 * 
	 * @param timestamp ,
	 *            java.sql.Timestamp Object
	 * @return java.util.GregorianCalendar Object
	 */
	public static java.util.GregorianCalendar convertToCalendar(
			java.sql.Timestamp timestamp) {
		GregorianCalendar obj = new GregorianCalendar();
		obj.setTime(DateUtil.convertTimestampToDate(timestamp));
		// 下面的method不能用，long ==> int 精度不对
		// obj.set(GregorianCalendar.MILLISECOND , (int)timestamp.getTime() );
		return obj;
	}

	/**
	 * 把java.sql.Timestamp Object 转换为java.util.Date Object
	 * 
	 * @param timestamp ,
	 *            java.sql.Timestamp Object
	 * @return java.util.Date Object
	 */
	public static java.util.Date convertTimestampToDate(
			java.sql.Timestamp timestamp) {
		java.util.Date date = null;
		date = new Date(timestamp.getTime());
		return date;
	}

	/***************************************************************************
	 * 取系统日期、时间的函数
	 **************************************************************************/
	/**
	 * 返回long型的SYSDATE
	 * 
	 * @return long 型的SYSDATE
	 */
	public static long getSysDateLong() {
		return System.currentTimeMillis();
	}

	/**
	 * 返回java.sql.Timestamp型的SYSDATE
	 * 
	 * @return java.sql.Timestamp型的SYSDATE
	 */
	public static java.sql.Timestamp getSysDateTimestamp() {
		return new java.sql.Timestamp(System.currentTimeMillis());
	}

	/**
	 * 以YYYY/MM/DD格式返回系统日期
	 * 
	 * @return 系统日期
	 */
	public static String getSysDateString() {
		return toString(new java.util.Date(System.currentTimeMillis()),
				DateUtil.sdfDateOnly);
	}

	/**
	 * 取当前季度
	 * 
	 * @return String
	 */
	public static String getSysDateQuarter() {
		String quarter = "1";
		String strMonth = getSysDateStringMonth();
		if (StringUtil.isNumber(strMonth)) {
			int qq = Integer.parseInt(strMonth);
			if (qq == 1 || qq == 2 || qq == 3) {
				quarter = "1";
			} else if (qq == 4 || qq == 5 || qq == 6) {
				quarter = "2";
			} else if (qq == 7 || qq == 8 || qq == 9) {
				quarter = "3";
			} else if (qq == 10 || qq == 11 || qq == 12) {
				quarter = "4";
			} else {
				quarter = "1";
			}
		} else {
			quarter = "1";
		}

		return quarter;
	}

	/**
	 * 以YYYY/MM/DD HH24:MI:SS格式返回系统日期时间
	 * 
	 * @return 系统日期时间
	 */
	public static String getSysDateTimeString() {
		return toString(new java.util.Date(System.currentTimeMillis()),
				DateUtil.sdfDateTime);
	}

	/**
	 * 以YYYY返回系统日期时间
	 * 
	 * @return 系统日期时间 add by zg 2003-12-9
	 */
	public static String getSysDateY() {
		String date = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		java.util.Date dd = new java.util.Date();
		date = sdf.format(dd);

		return date;
	}

	/**
	 * 以YYYY-MM-DD HH24:MI格式返回系统日期时间
	 * 
	 * @return 系统日期时间 add by zg 2003-12-9
	 */
	public static String getSysDateStringYMDHM() {
		String date = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		java.util.Date dd = new java.util.Date();
		date = sdf.format(dd);

		return date;
	}

	/**
	 * 以YYYY-MM-DD HH24:MI格式返回系统日期时间
	 * 
	 * @return String
	 */
	public static String getSysDateStringYMDHMS() {
		String date = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date dd = new java.util.Date();
		date = sdf.format(dd);
		return date;
	}
	
	/**
	 * 以YYYY-MM-DD HH24:MI格式返回系统日期时间
	 * 
	 * @return String
	 */
	public static String getSysDateStringYMDHMSS() {
		String date = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		java.util.Date dd = new java.util.Date();
		date = sdf.format(dd);
		return date;
	}
	
	/**
	 * 返回系统日期时间yyyy-MM-dd HHmmssSS用于创建文件目录
	 * 
	 * @return String
	 */
	public static String getSysDateStringYMDHMSSFO() {
		String date = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmmssSS");
		java.util.Date dd = new java.util.Date();
		date = sdf.format(dd);
		return date;
	}

	public static String getSysDateStringMonth() {
		String date = "";
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		java.util.Date dd = new java.util.Date();
		date = sdf.format(dd);

		return date;
	}

	public static String getSysDateStringHour() {
		String date = "";
		SimpleDateFormat sdf = new SimpleDateFormat("hh");
		java.util.Date dd = new java.util.Date();
		date = sdf.format(dd);

		return date;
	}

	public static String getSysDateStringMinute() {
		String date = "";
		SimpleDateFormat sdf = new SimpleDateFormat("mm");
		java.util.Date dd = new java.util.Date();
		date = sdf.format(dd);

		return date;
	}

	public static String getSysDateStringSecond() {
		String date = "";
		SimpleDateFormat sdf = new SimpleDateFormat("ss");
		java.util.Date dd = new java.util.Date();
		date = sdf.format(dd);

		return date;
	}

	/***************************************************************************
	 * java.sql.Date ==> String 的转换函数
	 **************************************************************************/
	/**
	 * 利用缺省的Date格式(YYYY/MM/DD)转化String到java.sql.Date
	 * 
	 * @param sDate
	 *            Date string
	 * @return Date
	 */
	public static java.sql.Date toSqlDate(String sDate) {
		// return toSqlDate( sDate, this.DATE_FORMAT_DATEONLY);
		// java.sql.Date.value() 要求的格式必须为YYYY-MM-DD
		return java.sql.Date.valueOf(sDate.replace('/', '-'));
	}

	/***************************************************************************
	 * String ==> java.sql.Date 的转换函数
	 **************************************************************************/
	/**
	 * 转换java.sql.Date到String，g格式为YYYY/MM/DD
	 * 
	 * @param dt
	 *            java.sql.Date instance
	 * @return String
	 */
	public static String toSqlDateString(java.sql.Date dt) {
		String temp = null;
		temp = dt.toString();
		return temp.replace('-', '/');
	}

	/**
	 * 利用缺省的Date格式(YYYY/MM/DD)转换String到java.sql.Timestamp
	 * 
	 * @param sDate
	 *            Date string
	 * @return Timestamp
	 */
	public static java.sql.Timestamp toSqlTimestamp(String sDate) {
		if (sDate == null)
			return null;
		if (sDate.length() != DateUtil.DATE_FORMAT_DATEONLY.length())
			return null;
		return toSqlTimestamp(sDate, DateUtil.DATE_FORMAT_DATEONLY);
	}

	/**
	 * 利用缺省的Date格式(YYYY/MM/DD hh:mm:ss)转化String到java.sql.Timestamp
	 * 
	 * @param sDate
	 *            Date string
	 * @param sFmt
	 *            Date format DATE_FORMAT_DATEONLY/DATE_FORMAT_DATETIME
	 * @return Timestamp
	 */
	public static java.sql.Timestamp toSqlTimestamp(String sDate, String sFmt) {
		String temp = null;
		if (sDate == null || sFmt == null)
			return null;
		if (sDate.length() != sFmt.length())
			return null;
		if (sFmt.equals(DateUtil.DATE_FORMAT_DATETIME)) {
			temp = sDate.replace('/', '-');
			temp = temp + ".000000000";
		} else if (sFmt.equals(DateUtil.DATE_FORMAT_DATEONLY)) {
			temp = sDate.replace('/', '-');
			temp = temp + " 00:00:00.000000000";
		} else {
			return null;
		}
		// java.sql.Timestamp.value() 要求的格式必须为yyyy-mm-dd hh:mm:ss.fffffffff
		return java.sql.Timestamp.valueOf(temp);
	}

	/***************************************************************************
	 * String ==> java.sql.Date 的转换函数
	 **************************************************************************/
	/**
	 * 转换java.sql.Timestamp到String，g格式为YYYY/MM/DD
	 * 
	 * @param dt
	 *            java.sql.Timestamp instance
	 * @return String
	 */
	public static String toSqlTimestampString(java.sql.Timestamp dt) {
		if (dt == null)
			return null;
		return toSqlTimestampString(dt, DateUtil.DATE_FORMAT_DATEONLY);
	}

	/**
	 * 转换java.sql.Timestamp到String，格式为YYYY/MM/DD HH24:MI
	 * 
	 * @param dt
	 *            java.sql.Timestamp instance
	 * @return String
	 */
	public static String toSqlTimestampString2(java.sql.Timestamp dt) {
		if (dt == null)
			return null;
		String temp = toSqlTimestampString(dt, DateUtil.DATE_FORMAT_DATETIME);
		return temp.substring(0, 16);
	}

	public static String toString(java.sql.Timestamp dt) {
		return dt == null ? "" : toSqlTimestampString2(dt);
	}

	/**
	 * 将指定的java.sql.Timestamp类型的转变为指定的中文日期格式
	 * 
	 * @param timestamp
	 *            待转换时间
	 * @return String
	 */
	public static String convertTimestampToChinaCalendar(Timestamp timestamp) {
		StringBuffer sb = new StringBuffer();
		if (timestamp == null) {
			sb.append("&nbsp");
		} else {
			sb = new StringBuffer();
			sb.append(DateUtil.getYearOfTimestamp(timestamp));
			sb.append("年");
			sb.append(DateUtil.getMonthOfTimestamp(timestamp));
			sb.append("月");
			sb.append(DateUtil.getDayOfTimestamp(timestamp));
			sb.append("日");
			sb.append("　");
			sb.append(DateUtil.getHourOfTimestamp(timestamp));
			sb.append(":");
			if (DateUtil.getMinuteOfTimestamp(timestamp) < 10) {
				sb.append(0);
				sb.append(DateUtil.getMinuteOfTimestamp(timestamp));
			} else {
				sb.append(DateUtil.getMinuteOfTimestamp(timestamp));
			}
			sb.append(":");
			if (DateUtil.getSecondOfTimestamp(timestamp) < 10) {
				sb.append(0);
				sb.append(DateUtil.getSecondOfTimestamp(timestamp));
			} else {
				sb.append(DateUtil.getSecondOfTimestamp(timestamp));
			}
		}
		return sb.toString();

	}

	/**
	 * 根据指定的格式转换java.sql.Timestamp到String
	 * 
	 * @param dt
	 *            java.sql.Timestamp instance
	 * @param sFmt
	 *            Date
	 *            格式，DATE_FORMAT_DATEONLY/DATE_FORMAT_DATETIME/DATE_FORMAT_SESSION
	 * @return String
	 */
	public static String toSqlTimestampString(java.sql.Timestamp dt, String sFmt) {
		String temp = null;
		String out = null;
		if (dt == null || sFmt == null)
			return null;
		temp = dt.toString();
		if (sFmt.equals(DateUtil.DATE_FORMAT_DATETIME) || // "YYYY/MM/DD
				// HH24:MI:SS"
				sFmt.equals(DateUtil.DATE_FORMAT_DATEONLY)) { // YYYY/MM/DD
			temp = temp.substring(0, sFmt.length());
			out = temp.replace('-', '/');
		}
		return out;
	}

	/**
	 * 转换java.sql.Timestamp到HH24:MI String
	 * 
	 * @param dt
	 *            java.sql.Timestamp instance
	 * @return String
	 */
	public static String toHourMinString(java.sql.Timestamp dt) {
		String temp = null;
		temp = dt.toString();
		// int len = 0;
		// len = DateUtil.DATE_FORMAT_DATETIME.length ();
		temp = temp.substring(11, 16);
		return temp;

	}

	/***************************************************************************
	 * java.sql.Timestamp +/- 几天的计算函数
	 **************************************************************************/
	/**
	 * 判断指定的日期是否是一个月的最后一天
	 * 
	 * @param obj
	 *            时间对象
	 * @return true 是 false 否
	 */
	private static boolean isLastDayOfMonth(GregorianCalendar obj) {
		int year = obj.get(GregorianCalendar.YEAR);
		int month = obj.get(GregorianCalendar.MONTH) + 1;
		int day = obj.get(GregorianCalendar.DAY_OF_MONTH);
		if (obj.isLeapYear(year)) {
			if (day == DateUtil.DAY_OF_MONTH_LEAP_YEAR[month - 1])
				return true;
		} else {
			if (day == DateUtil.DAY_OF_MONTH_NON_LEAP_YEAR[month - 1])
				return true;
		}
		return false;
	}

	/**
	 * 在java.sql.Timestamp Object上增加/减少几个月
	 * 
	 * @param timestamp
	 *            java.sql.Timestamp instance
	 * @param mon
	 *            增加/减少的月数
	 * @return java.sql.Timestamp Object
	 */
	public static java.sql.Timestamp addMonths(java.sql.Timestamp timestamp,
			int mon) {
		java.sql.Timestamp out = null;
		GregorianCalendar obj = DateUtil.convertToCalendar(timestamp);
		// month : 0 -- 11
		int year = obj.get(GregorianCalendar.YEAR);
		int month = obj.get(GregorianCalendar.MONTH) + 1;
		int day = obj.get(GregorianCalendar.DAY_OF_MONTH);
		month += mon;
		if (month < 1) {
			month += 12;
			year--;
		} else if (month > 12) {
			month -= 12;
			year++;
		}
		if (isLastDayOfMonth(obj)) {
			if (obj.isLeapYear(year)) {
				day = DateUtil.DAY_OF_MONTH_LEAP_YEAR[month - 1];
			} else {
				day = DateUtil.DAY_OF_MONTH_NON_LEAP_YEAR[month - 1];
			}
		}
		String temp = DateUtil.formatYMD(year, month, day);
		out = DateUtil.toSqlTimestamp(temp);
		return out;
	}

	/**
	 * 在java.sql.Timestamp Object上增加/减少几天
	 * 
	 * @param timestamp
	 *            java.sql.Timestamp instance
	 * @param days
	 *            增加/减少的天数
	 * @return java.sql.Timestamp Object
	 */
	public static java.sql.Timestamp addDays(java.sql.Timestamp timestamp,
			int days) {
		java.util.Date date = DateUtil.convertTimestampToDate(timestamp);
		long temp = date.getTime();

		return new java.sql.Timestamp(temp + DateUtil.DAY_MILLI * days);
	}

	/**
	 * 在java.util.DateObject上增加/减少几天
	 * 
	 * @param date
	 *            java.util.Date instance
	 * @param days
	 *            增加/减少的天数
	 * @return java.util.Date Object
	 */
	public static java.util.Date addDays(java.util.Date date, int days) {
		long temp = date.getTime();

		return new java.util.Date(temp + DateUtil.DAY_MILLI * days);
	}

	/**
	 * 在java.util.DateObject上增加/减少几天
	 * 
	 * @param date
	 *            java.util.Date instance
	 * @return java.util.Date Object
	 */
	public static String calcAge(java.util.Date date) {
		String age = "";
		java.util.Date sysdate = new java.util.Date();
		if (date != null) {
			age = String.valueOf(sysdate.getYear() - date.getYear());
		}
		return age;
	}
	
	/**
	 * 获取N分钟以前的时间
	 * 
	 * @param date
	 *            java.util.Date instance
	 * @return java.util.Date Object
	 */
	public static java.util.Date getNfztime(long m) {
		java.util.Date sysdate = new java.util.Date();
		long time = sysdate.getTime() - m * 60 * 1000;
		Date newDate1 = new Date(time);
		return newDate1;
	}
	
}