/*
 * �ļ�����	IDao.java
 * ���ܣ�		���ݷ��ʶ���ӿ�
 * �������ڣ�	2005-6-24
 * ���ߣ�		ʢ����
 * �汾��		0.1
 * �޶���ʷ��	
 *
 * Copyright 2005 - Shanghai 30wish Infomation Security Co. Ltd.
 */
package com.san.tools.hibernate.dao;

import java.util.List;

import com.san.tools.hibernate.exception.DeleteException;
import com.san.tools.hibernate.exception.FindException;
import com.san.tools.hibernate.exception.InitializationException;
import com.san.tools.hibernate.exception.InsertException;
import com.san.tools.hibernate.exception.UpdateException;

/**
 * ���ݷ��ʽӿڣ����CRUD����
 */
public interface IDao
{
    /**
     * ��ʼ������
     * @param obj
     *      ����������Ϣ�Ķ���
     * @throws InitializationException
     */
    public void initialize(Object obj) throws InitializationException;
    
    /**
     * ��ȡ������Ϣ
     * @return
     *      ���ذ���������Ϣ�Ķ��󣬿����������ļ���������
     */
    public Object getConfig();
    
    /**
     * ִ�в�ѯ����
     * @param query
     *      ��ѯ���
     * @return
     *      ����List��ʽ�����ݼ�
     * @throws FindException
     */
    public List find(String query) throws FindException;
    
    /**
     * ��ȡ����clazz���ݶ���ļ�¼
     * @param clazz
     *      ��Ҫ��ѯ�����ݱ��Ӧ�����ݶ����Class
     * @return
     *      ����List��ʽ�����ݼ�
     * @throws FindException
     */
    public List findAll(Class clazz) throws FindException;
    
    /**
     * ��ȡ��������ΪVoName�����ݶ���ļ�¼
     * @param VoName
     *      ���ݶ�����
     * @return
     *      ����List��ʽ�����ݼ�
     * @throws FindException
     */
    public List findAll(String VoName) throws FindException;
    
    /**
     * ��������
     * @param entity
     *      �����µ����ݼ�¼
     * @throws UpdateException
     *      �������ʧ�����׳����쳣
     */
    public void update(Object entity) throws UpdateException;
    
    /**
     * ɾ�����ݼ�¼
     * @param entity
     *      ��ɾ�������ݼ�¼����
     * @throws DeleteException
     *      ���ɾ��ʧ�����׳����쳣
     */
    public void delete(Object entity) throws DeleteException;
    
    /**
     * �������ݼ�¼
     * @param entity
     *      ����������ݼ�¼����
     * @throws InsertException
     *      �������ʧ�����׳����쳣
     */
    public void insert(Object entity) throws InsertException;
    
    /**
     * �������¼�¼
     * @param entity
     *      �����������ݼ�¼����
     * 
     * @throws UpdateException
     */
    public void saveOrUpdate(Object entity) throws UpdateException;
        

    /**
     * @param clazz
     * @param condition
     * @return long
     * @throws FindException
     */
    public long getCount(Class clazz, String condition) throws FindException;
    
    /**
     * ��ȡ���ݼ��Ĵ�С
     * @param query
     *      ��ѯ���
     * @return
     *      �������ݼ��Ĵ�С��Ϊ������
     * @throws FindException
     *      �����ȡʧ�����׳����쳣
     */
    public long getCount(String query) throws FindException;
    
    public long getCountFast(String VoName) throws FindException;
    
    
    //2009-2-11�¼ӷ���
    /**
     * �������� �Ǽ����Ժ�ĸ���
     */
    public void md5update(String pwd,String cn) throws UpdateException;
    
    /**
     * sql��ѯfind
     */
    public List sqlfind(String query) throws FindException;
    
}
