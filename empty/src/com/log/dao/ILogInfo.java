package com.log.dao;

import com.san.chengxin.common.dao.Dao;

/**
 * ��־dao�ӿ���Ϣ
 * @author wuwh
 *
 */
public interface ILogInfo extends Dao {
	
	public void saveObject(Object object,String sql) throws Exception;
	
}
