package com.san.jingtai.model;

import java.util.Date;

public class JingTaiLogInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 主键
	public String sys_id;

	// 查询人
	public String qu_name;

	// 查询条件
	public String qu_condtition;

	// 查询时间
	public Date qu_date;

	// 查询状态（0：已查询;1：未查询）
	public String qu_state;

	// 查询类型（0：个人;1：法人）
	public String qu_type;

	// 部门
	public String qu_dept;

	// 备用
	public String qu_ex_2;

	// 备用
	public String qu_ex_3;

	public JingTaiLogInfo() {
	}

	public JingTaiLogInfo(String qu_name, String qu_condtition,
			String qu_state, String qu_type, String qu_dept) {
		this.qu_name = qu_name;
		this.qu_condtition = qu_condtition;
		this.qu_state = qu_state;
		this.qu_type = qu_type;
		this.qu_dept = qu_dept;
	}

	public String getQu_condtition() {
		return qu_condtition;
	}

	public void setQu_condtition(String qu_condtition) {
		this.qu_condtition = qu_condtition;
	}

	public Date getQu_date() {
		return qu_date;
	}

	public void setQu_date(Date qu_date) {
		this.qu_date = qu_date;
	}

	public String getQu_dept() {
		return qu_dept;
	}

	public void setQu_dept(String qu_dept) {
		this.qu_dept = qu_dept;
	}

	public String getQu_ex_2() {
		return qu_ex_2;
	}

	public void setQu_ex_2(String qu_ex_2) {
		this.qu_ex_2 = qu_ex_2;
	}

	public String getQu_ex_3() {
		return qu_ex_3;
	}

	public void setQu_ex_3(String qu_ex_3) {
		this.qu_ex_3 = qu_ex_3;
	}

	public String getQu_name() {
		return qu_name;
	}

	public void setQu_name(String qu_name) {
		this.qu_name = qu_name;
	}

	public String getQu_state() {
		return qu_state;
	}

	public void setQu_state(String qu_state) {
		this.qu_state = qu_state;
	}

	public String getQu_type() {
		return qu_type;
	}

	public void setQu_type(String qu_type) {
		this.qu_type = qu_type;
	}

	public String getSys_id() {
		return sys_id;
	}

	public void setSys_id(String sys_id) {
		this.sys_id = sys_id;
	}

	
}
