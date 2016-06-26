/*
 * �ļ�����	DaoObserver.java
 * ���ܣ�		
 * �������ڣ�	2005-12-12
 * ���ߣ�		ʢ����
 * �汾��		0.1
 * �޶���ʷ��	
 *
 * Copyright 2005 - Shanghai 30wish Infomation Security Co. Ltd.
 */

package com.san.tools.hibernate.dao;

import java.util.Observable;
import java.util.Observer;

public class DaoObserver implements Observer
{

    /**
     * ����״̬
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
     * �ڲ����¼֮ǰ������
     * @param entity
     *      ���ݶ���
     */
    protected void beforeInsert(Object entity)
    {
        
    }
    
    /**
     * �ڲ����¼֮��������
     * @param entity
     *      ���ݶ���
     */
    protected void afterInsert(Object entity)
    {
        
    }
    
    /**
     * 
     * @param entity
     *      ���ݶ���
     */
    protected void beforeUpdate(Object entity)
    {
        
    }
    
    /**
     * 
     * @param entity
     *      ���ݶ���
     */
    protected void afterUpdate(Object entity)
    {
        
    }
    
    /**
     * 
     * @param entity
     *      ���ݶ���
     */
    protected void beforeDelete(Object entity)
    {
        
    }
    
    /**
     * 
     * @param entity
     *      ���ݶ���
     */
    protected void afterDelete(Object entity)
    {
        
    }
    
    /**
     * 
     * @param entity
     *      ���ݶ���
     */
    protected void beforeSaveUpdate(Object entity)
    {
        
    }
    
    /**
     * 
     * @param entity
     *      ���ݶ���
     */
    protected void afterSaveUpdate(Object entity)
    {
        
    }

}
