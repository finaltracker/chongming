package com.logServices.zqs.dao;

import java.util.List;

import com.san.chengxin.common.dao.Dao;
import com.san.jingtai.model.JingTaiLogInfo;

public interface IServiceLogDao extends Dao{
	
	//获取对象
	public List<JingTaiLogInfo> queryListDao(String sql,int pageNo, int pageSize);
	
	//获取总数
	public int queryCount(String sql);
	
	//联动查询
	public List queryDepart(String dept);
}
