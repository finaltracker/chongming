package com.logServices.zqs.model;

import java.util.Date;


public class TotleRuleInfo {
	
	//主键
	public String tid;
	
	//积分类型(0:登录;1:法人查询;2:自然人查询;3:数据导入);
	public String ruleType;
	
	//模块名称;
	public String ruleName;
	
	//创建用户
	public String userNamer;
	
	//积分限制描述
	public String ruleDesc;
	
	//积分规则（0:分钟;1:小时)
	public String integralRule;
	
	//积分分数
	public int integral;
	
	//创建时间
	public Date newDate;
	
	//备用
	public String ex_3;

	public String getEx_3() {
		return ex_3;
	}
	
	public TotleRuleInfo(){}
	
	public TotleRuleInfo(String tid, String ruleType, String ruleName,String userNamer, String ruleDesc, String integralRule,
			int integral,Date newDate){
		
		this.tid = tid;
		this.ruleType = ruleType;
		this.ruleName = ruleName;
		this.userNamer = userNamer;
		this.ruleDesc = ruleDesc;
		this.integralRule = integralRule;
		this.integral = integral;
		this.newDate = newDate;
	}

	public int getIntegral() {
		return integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}

	public String getIntegralRule() {
		return integralRule;
	}

	public void setIntegralRule(String integralRule) {
		this.integralRule = integralRule;
	}

	public Date getNewDate() {
		return newDate;
	}

	public void setNewDate(Date newDate) {
		this.newDate = newDate;
	}

	public String getRuleDesc() {
		return ruleDesc;
	}

	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getUserNamer() {
		return userNamer;
	}

	public void setUserNamer(String userNamer) {
		this.userNamer = userNamer;
	}

	public void setEx_3(String ex_3) {
		this.ex_3 = ex_3;
	}

	
	
	
}
