package com.log.service;

import java.util.List;

import com.log.dao.ILogInfo;
import com.log.statistic.DataUsageStatistic;

public interface ILogInfoService {
/**
 * ��־�ӿ�
 */
	public void save(DataUsageStatistic object)  throws Exception;	
}
