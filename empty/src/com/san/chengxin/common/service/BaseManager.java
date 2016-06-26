/*
 * Created on 2007-3-7
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.san.chengxin.common.service;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.san.chengxin.common.dao.Dao;
import com.san.chengxin.common.service.Manager;
/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BaseManager implements Manager{
	protected final Log log = LogFactory.getLog(getClass());
    private Dao dao;
    /* (non-Javadoc)
     * @see com.san.chengxin.common.domain.Domain#setDao(com.san.chengxin.common.dao.Dao)
     */
    public void setDao(Dao dao) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see com.san.chengxin.common.domain.Domain#getObjects(java.lang.Class)
     */
    public List getObjects(Class clazz) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.san.chengxin.common.domain.Domain#getObject(java.lang.Class, java.io.Serializable)
     */
    public Object getObject(Class clazz, Serializable id) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.san.chengxin.common.domain.Domain#saveObject(java.lang.Object)
     */
    public void saveObject(Object o) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see com.san.chengxin.common.domain.Domain#removeObject(java.lang.Class, java.io.Serializable)
     */
    public void removeObject(Class clazz, Serializable id) {
        // TODO Auto-generated method stub
        
    }

    
}
