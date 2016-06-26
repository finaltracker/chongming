package com.san.orgdata.model.vo;

import java.util.ArrayList;
import java.util.List;

public class SysOuVO {

	/**
	 * 机构编码
	 */
	String ouid;
	/**
	 * 机构名称
	 */
	String ouName;
	/**
	 * 状态
	 */
	String status;
	
	/**
	 * 顺序
	 */
	String displayOrder;
	
	/**
	 * 表结果集
	 */
	List sysTableList = new  ArrayList() ;

	public String getOuid() {
		return ouid;
	}

	public void setOuid(String ouid) {
		this.ouid = ouid;
	}

	public String getOuName() {
		return ouName;
	}

	public void setOuName(String ouName) {
		this.ouName = ouName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(String displayOrder) {
		this.displayOrder = displayOrder;
	}

	public List getSysTableList() {
		return sysTableList;
	}

	public void setSysTableList(List sysTableList) {
		this.sysTableList = sysTableList;
	}

}
