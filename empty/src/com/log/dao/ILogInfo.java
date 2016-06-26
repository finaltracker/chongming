package com.log.dao;

import com.san.chengxin.common.dao.Dao;

/**
 * 日志dao接口信息
 * @author wuwh
 *
 */
public interface ILogInfo extends Dao {
	
	public void saveObject(Object object,String sql) throws Exception;
	
}
