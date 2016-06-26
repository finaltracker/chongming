package com.san.mhcx.uploadlogs.model;

public class LogTjByDeptPO {
	private String deptName;
	private int allCount;
	private int allUpLoadSize;
	private String deptId;
	private String strdate;
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getAllCount() {
		return allCount;
	}
	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}
	public int getAllUpLoadSize() {
		return allUpLoadSize;
	}
	public void setAllUpLoadSize(int allUpLoadSize) {
		this.allUpLoadSize = allUpLoadSize;
	}
	public String getStrdate() {
		return strdate;
	}
	public void setStrdate(String strdate) {
		this.strdate = strdate;
	}
	
}
