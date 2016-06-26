package com.log;

/**
 * 日志的信息存储
 * @author wuwh
 *
 */
public class LogInfoVo {

	public static final String LOGTYPE_1="1";//日志操作类型日志
	public static final String LOGTYPE_0="0";//功能型日志
	public static final String LOGTYPE_2="2";//其它类型日志
	public static final String LOGTYPE_3="3";//登陆型日志操作
	public static final String LOGTYPE_4="4";//信用报告查询日志
	public static final String LOGTYPE_5="5";//数据申请授权日志操作
	public static final String LOGTYPE_6="6";//系统管理日志操作 如密码修改
	
	private String logtype;//日志类型
	private String logInfo;//日志操作中文描述
	private String logsql;//日志sql语句存储
	public String getLogtype() {
		return logtype;
	}
	public void setLogtype(String logtype) {
		this.logtype = logtype;
	}
	public String getLogInfo() {
		return logInfo;
	}
	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}
	public String getLogsql() {
		return logsql;
	}
	public void setLogsql(String logsql) {
		this.logsql = logsql;
	}
	
}
