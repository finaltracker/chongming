/*
 * 文件名：	DaoObserver.java
 * 功能：		
 * 创建日期：	2005-12-12
 * 作者：		盛海军
 * 版本：		0.1
 * 修订历史：	
 *
 * Copyright 2005 - Shanghai 30wish Infomation Security Co. Ltd.
 */

package com.san.tools.hibernate.dao;

import java.util.Observable;
import java.util.Observer;

public class DaoObserver implements Observer
{

    /**
     * 更新状态
     */
    public void update(Observable o, Object arg)
    {
        Object[] obj = (Object[])arg;
        String operation = obj[1].toString();
        
        if(operation.equalsIgnoreCase("beforeInsert"))
        {
            beforeInsert(obj[0]);
        }
        else if(operation.equalsIgnoreCase("afterInsert"))
        {
            afterInsert(obj[0]);
        }
        else if(operation.equalsIgnoreCase("beforeUpdate"))
        {
            beforeUpdate(obj[0]);
        }
        else if(operation.equalsIgnoreCase("afterUpdate"))
        {
            afterUpdate(obj[0]);
        }
        else if(operation.equalsIgnoreCase("beforeDelete"))
        {
            beforeDelete(obj[0]);
        }
        else if(operation.equalsIgnoreCase("afterDelete"))
        {
            afterDelete(obj[0]);
        }
        else if(operation.equalsIgnoreCase("beforeSaveUpdate"))
        {
            beforeSaveUpdate(obj[0]);
        }
        else if(operation.equalsIgnoreCase("afterSaveUpdate"))
        {
            afterSaveUpdate(obj[0]);
        }

    }
    
    /**
     * 在插入记录之前作处理
     * @param entity
     *      数据对象
     */
    protected void beforeInsert(Object entity)
    {
        
    }
    
    /**
     * 在插入记录之后作处理
     * @param entity
     *      数据对象
     */
    protected void afterInsert(Object entity)
    {
        
    }
    
    /**
     * 
     * @param entity
     *      数据对象
     */
    protected void beforeUpdate(Object entity)
    {
        
    }
    
    /**
     * 
     * @param entity
     *      数据对象
     */
    protected void afterUpdate(Object entity)
    {
        
    }
    
    /**
     * 
     * @param entity
     *      数据对象
     */
    protected void beforeDelete(Object entity)
    {
        
    }
    
    /**
     * 
     * @param entity
     *      数据对象
     */
    protected void afterDelete(Object entity)
    {
        
    }
    
    /**
     * 
     * @param entity
     *      数据对象
     */
    protected void beforeSaveUpdate(Object entity)
    {
        
    }
    
    /**
     * 
     * @param entity
     *      数据对象
     */
    protected void afterSaveUpdate(Object entity)
    {
        
    }

}
