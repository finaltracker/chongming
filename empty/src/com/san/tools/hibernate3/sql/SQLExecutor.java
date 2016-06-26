/*
 * �ļ�����	SQLQuery.java
 * ���ܣ�		
 * �������ڣ�	2006-1-6
 * ���ߣ�		ʢ����
 * �汾��		0.1
 * �޶���ʷ��	
 *
 * Copyright 2005 - Shanghai 30wish Infomation Security Co. Ltd.
 */

package com.san.tools.hibernate3.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.san.tools.hibernate3.session.SessionManager;
import com.san.tools.string.StringUtil;


/**
 * ����ִ��sql�����࣬ʹ�õ���Hibernate���ɵ�session
 * �÷����£�
 * <code>
 *  SQLExecutor executor = new SQLExecutor("delete from test");//ɾ��test��������
 *  executor.execute("hibernate.cfg.xml");
 *  //��������sql���,����user����nameֵΪ'mike'�ļ�¼��������ageֵΪ25
 *  executor.setQuery("update user set age=25 where naem='mike'");
 *  executor.execute("hibernate.cfg.xml");  
 * </code>
 *
 */
public class SQLExecutor
{
    private static final String DEFAULT_HIBERNATE_CONFIG = "SessionFactoryBySpring";
    private String statement = null;        //����sql���
    private String hiberanteConfig = null;  //����hibernate�����ļ�
    
    /**
     * 
     *
     */
    public SQLExecutor()
    {        
    }
    
    /**
     * 
     * @param query
     */
    public SQLExecutor(String query)
    {
        statement = query;
    }
    
    /**
     * ����Hibernate�����ļ�
     * @param configFile
     *      ��Ҫ���õ�hibernate�����ļ�
     */
    public void setConfigFile(String configFile)
    {
        hiberanteConfig = configFile;
    }
    
    /**
     * ���ò�ѯ���
     * @param query
     *      ��Ҫִ��sql���
     */
    public void setQuery(String query)
    {
        statement = query;
    }
    
    /**
     * ִ��sql���
     * @throws SQLException
     *      ���ִ��sql���ʱ�����������׳����쳣
     */
    public void execute() throws SQLException
    {
        if(!StringUtil.isValid(hiberanteConfig))
        {
            execute(DEFAULT_HIBERNATE_CONFIG);
        }
    }
    /**
     * ��ָ����hibernate������ִ��sql���
     * @param configFile
     *      hibernate�����ļ���
     * @throws SQLException
     *      ���ִ��sql���ʱ�����������׳����쳣
     */
    public void execute(String configFile) throws SQLException
    {
        hiberanteConfig = configFile;
        Session session = null;
        Connection connection = null;
        Transaction transaction = null;
        PreparedStatement preparedStatement = null;
        
        try
        {
            session = SessionManager.getInstance().getSession(configFile);
            
            connection = session.connection();            
            preparedStatement = connection.prepareStatement(statement);
            transaction = SessionManager.beginTransaction(session);
            preparedStatement.execute();
            SessionManager.commitTransaction(transaction);
        }
        catch(HibernateException e)
        {
            try
            {
                transaction.rollback();
            }
            catch(HibernateException e1)
            {
                throw new SQLException(e1.getMessage());
            }
        }
        finally
        {
            try
            {
                SessionManager.closeSession(session);
            }
            catch(HibernateException e)
            {
                throw new SQLException(e.getMessage());
            }
        }
    }
    
    /**
     * ��ָ����hibernate������ִ��ָ����sql���
     * @param configFile
     *      hibernate�����ļ���
     * @param query
     *      ��Ҫִ��sql���
     * @throws SQLException
     *      ���ִ��sql���ʱ�����������׳����쳣
     */
    public static void execute(String configFile,String query) throws SQLException
    {
        Session session = null;
        Connection connection = null;
        Transaction transaction = null;
        PreparedStatement preparedStatement = null;
        
        try
        {
            session = SessionManager.getInstance().getSession(configFile);            
            connection = session.connection();            
            preparedStatement = connection.prepareStatement(query);
            transaction = SessionManager.beginTransaction(session);
            preparedStatement.execute();
            SessionManager.commitTransaction(transaction);
        }
        catch(HibernateException e)
        {
            try
            {
                transaction.rollback();
            }
            catch(HibernateException e1)
            {
                throw new SQLException(e1.getMessage());
            }
        }
        finally
        {
            try
            {
                SessionManager.closeSession(session);
            }
            catch(HibernateException e)
            {
                throw new SQLException(e.getMessage());
            }
        }
    }
}
