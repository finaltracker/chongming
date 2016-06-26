package com.logServices.zqs.model;

import java.util.Date;


public class PerformaceStatisInfo {
	
	//主键
	public String pid;
	
	//部门
	public String dapart;
	
	//积分用户
	public String userNamer;
	
	//积分类型(0:登陆,1:法人查询,2:自然人查询,3:上传文件)
	public String upType;
	
	//分数
	public int pointAll;
	
	//记录当前时间
	public Date saveDate;
	
	//开始积分时间
	public Date startDate;
	
	//积分截止时间
	public Date endDate;
	
	//规则状态
	public String pointType;
	
	//查询条件
	public String contStat_1;
	
	//状态(0:历史记录;1:当前记录)
	public String ex_3;
	
	public PerformaceStatisInfo(){}
	
	public PerformaceStatisInfo(String dapart,String userNamer,String upType,int pointAll,Date saveDate,Date startDate,Date endDate,String pointType,
			String contStat_1,String ex_3){
		this.dapart = dapart;
		this.userNamer = userNamer;
		this.upType = upType;
		this.pointAll = pointAll;
		this.saveDate = saveDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pointType = pointType;
		this.contStat_1 = contStat_1;
		this.ex_3 = ex_3;
	}

	public String getContStat_1() {
		return contStat_1;
	}

	public void setContStat_1(String contStat_1) {
		this.contStat_1 = contStat_1;
	}

	public String getEx_3() {
		return ex_3;
	}

	public void setEx_3(String ex_3) {
		this.ex_3 = ex_3;
	}

	public String getDapart() {
		return dapart;
	}

	public void setDapart(String dapart) {
		this.dapart = dapart;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public int getPointAll() {
		return pointAll;
	}

	public void setPointAll(int pointAll) {
		this.pointAll = pointAll;
	}

	public String getPointType() {
		return pointType;
	}

	public void setPointType(String pointType) {
		this.pointType = pointType;
	}

	public Date getSaveDate() {
		return saveDate;
	}

	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getUpType() {
		return upType;
	}

	public void setUpType(String upType) {
		this.upType = upType;
	}

	public String getUserNamer() {
		return userNamer;
	}

	public void setUserNamer(String userNamer) {
		this.userNamer = userNamer;
	}
	
}
