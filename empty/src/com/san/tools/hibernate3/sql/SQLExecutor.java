/*
 * 文件名：	SQLQuery.java
 * 功能：		
 * 创建日期：	2006-1-6
 * 作者：		盛海军
 * 版本：		0.1
 * 修订历史：	
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
 * 用于执行sql语句的类，使用的是Hibernate生成的session
 * 用法如下：
 * <code>
 *  SQLExecutor executor = new SQLExecutor("delete from test");//删除test表中数据
 *  executor.execute("hibernate.cfg.xml");
 *  //重新生成sql语句,更新user表中name值为'mike'的记录，设置其age值为25
 *  executor.setQuery("update user set age=25 where naem='mike'");
 *  executor.execute("hibernate.cfg.xml");  
 * </code>
 *
 */
public class SQLExecutor
{
    private static final String DEFAULT_HIBERNATE_CONFIG = "SessionFactoryBySpring";
    private String statement = null;        //缓存sql语句
    private String hiberanteConfig = null;  //缓存hibernate配置文件
    
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
     * 设置Hibernate配置文件
     * @param configFile
     *      需要设置的hibernate配置文件
     */
    public void setConfigFile(String configFile)
    {
        hiberanteConfig = configFile;
    }
    
    /**
     * 设置查询语句
     * @param query
     *      需要执行sql语句
     */
    public void setQuery(String query)
    {
        statement = query;
    }
    
    /**
     * 执行sql语句
     * @throws SQLException
     *      如果执行sql语句时发生错误则抛出该异常
     */
    public void execute() throws SQLException
    {
        if(!StringUtil.isValid(hiberanteConfig))
        {
            execute(DEFAULT_HIBERNATE_CONFIG);
        }
    }
    /**
     * 在指定的hibernate环境下执行sql语句
     * @param configFile
     *      hibernate配置文件名
     * @throws SQLException
     *      如果执行sql语句时发生错误则抛出该异常
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
     * 在指定的hibernate环境下执行指定的sql语句
     * @param configFile
     *      hibernate配置文件名
     * @param query
     *      需要执行sql语句
     * @throws SQLException
     *      如果执行sql语句时发生错误则抛出该异常
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
