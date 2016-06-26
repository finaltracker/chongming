package com.logServices.zqs.services;

import java.util.List;

import com.san.jingtai.model.JingTaiLogInfo;
import com.san.util.Vo;

public interface ILogServicesManger {
	
	/**
	 * 查询接口日志
	 */
	
	public List<JingTaiLogInfo> getListLogInfoManager(String qu_name, String qu_state, String qu_type, String startDate, String endDate, String depart,int pageNo, int pageSize);
	
	
	public int queryCountManager(String str,String qu_name, String qu_state, String qu_type, 
			String startDate, String endDate, String depart);
	
	/**
	 * 共用查询接口
	 */
	public Vo getSQL(int page,int rows,String sql);
	
	/**
	 * 根据部门查用户
	 * @param dept
	 * @return
	 */
	public List queryAdminManger(String dept);
}
