/*
 * Created on 2007-3-7
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.san.chengxin.common.service;

import java.io.Serializable;
import java.util.List;

import com.san.chengxin.common.dao.Dao;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface Manager {
   
    public void setDao(Dao dao);
    
    public List getObjects(Class clazz);
    
    public Object getObject(Class clazz, Serializable id);
    
    public void saveObject(Object o);
    
    public void removeObject(Class clazz, Serializable id);
    
}
