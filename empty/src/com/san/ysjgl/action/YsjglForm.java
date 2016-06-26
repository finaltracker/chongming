package com.san.ysjgl.action;

import org.apache.struts.action.ActionForm;

import com.san.ysjgl.model.SysMxzb;
import com.san.ysjgl.model.SysZd;
import com.san.ysjgl.model.SysZsgl;
import com.san.ysjgl.model.Sysfield;
import com.san.ysjgl.model.Systable;
import com.san.ysjgl.model.Xyjlmb;

public class YsjglForm extends ActionForm {
	
	Systable table=new Systable();
	Sysfield f=new Sysfield();
	Xyjlmb xyjl=new Xyjlmb(); 
	SysZsgl zsgl=new SysZsgl();
	SysZd zd=new SysZd();
	
	SysMxzb mxzb=new SysMxzb();
	
	public SysMxzb getMxzb() {
		return mxzb;
	}

	public void setMxzb(SysMxzb mxzb) {
		this.mxzb = mxzb;
	}

	public SysZd getZd() {
		return zd;
	}

	public void setZd(SysZd zd) {
		this.zd = zd;
	}

	public SysZsgl getZsgl() {
		return zsgl;
	}

	public void setZsgl(SysZsgl zsgl) {
		this.zsgl = zsgl;
	}

	public Xyjlmb getXyjl() {
		return xyjl;
	}

	public void setXyjl(Xyjlmb xyjl) {
		this.xyjl = xyjl;
	}

	public Sysfield getF() {
		return f;
	}

	public void setF(Sysfield f) {
		this.f = f;
	}

	public Systable getTable() {
		return table;
	}

	public void setTable(Systable table) {
		this.table = table;
	}
}
