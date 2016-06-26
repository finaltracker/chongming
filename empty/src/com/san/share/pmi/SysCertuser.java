package com.san.share.pmi;

import java.util.Date;



public class SysCertuser implements java.io.Serializable {
	private String id;
	private String certsn;
	private String userId;
	private Date updateTime;
	private Date registerTime;
	private String pop1;
	private String pop2;
	private String pop3;
	private String dwmc;
	private String name;
	private String lxdh;
	private String cszw;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCertsn() {
		return certsn;
	}
	public void setCertsn(String certsn) {
		this.certsn = certsn;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date teTiupdateTimeme) {
		this.updateTime = teTiupdateTimeme;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public String getPop1() {
		return pop1;
	}
	public void setPop1(String pop1) {
		this.pop1 = pop1;
	}
	public String getPop2() {
		return pop2;
	}
	public void setPop2(String pop2) {
		this.pop2 = pop2;
	}
	public String getPop3() {
		return pop3;
	}
	public void setPop3(String pop3) {
		this.pop3 = pop3;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getCszw() {
		return cszw;
	}
	public void setCszw(String cszw) {
		this.cszw = cszw;
	}

}
