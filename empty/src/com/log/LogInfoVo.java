package com.log;

/**
 * ��־����Ϣ�洢
 * @author wuwh
 *
 */
public class LogInfoVo {

	public static final String LOGTYPE_1="1";//��־����������־
	public static final String LOGTYPE_0="0";//��������־
	public static final String LOGTYPE_2="2";//����������־
	public static final String LOGTYPE_3="3";//��½����־����
	public static final String LOGTYPE_4="4";//���ñ����ѯ��־
	public static final String LOGTYPE_5="5";//����������Ȩ��־����
	public static final String LOGTYPE_6="6";//ϵͳ������־���� �������޸�
	
	private String logtype;//��־����
	private String logInfo;//��־������������
	private String logsql;//��־sql���洢
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
