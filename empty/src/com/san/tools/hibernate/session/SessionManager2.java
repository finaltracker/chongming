/*
 * 文件名：	SessionManager2.java
 * 功能：		实现了一个Hibernate数据库session的管理类
 * 创建日期：	2005-6-24
 * 作者：		盛海军
 * 版本：		0.1
 * 修订历史：	
 *
 * Copyright 2005 - Shanghai 30wish Infomation Security Co. Ltd.
 */
package com.san.tools.hibernate.session;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.san.tools.file.exception.InvalidFileName;
import com.san.tools.file.util.FileUtil;
import com.san.tools.string.StringUtil;

public class SessionManager2
{

    private static final String HIBERNATE_CFG_XML = "SessionFactoryBySpring";

    protected Map sessionFactoryMap = new HashMap();

    private static SessionManager2 instance = null;
    
    private List configureFileList = new ArrayList();

    /**
     * 
     *
     */
    protected SessionManager2() {
    }

    public static SessionManager2 getInstance()
    {
        if (instance == null)
        {
            synchronized (SessionManager2.class)
            {
                instance = new SessionManager2();
            }
        }

        return instance;
    }

    /**
     * 默认初始化方法，使用/hibernate.cfg.xml作为配置文件
     * @throws HibernateException
     */
    public void initialize() throws HibernateException
    {
        initialize(null);
    }
    /**
     * Configure the session factory by reading hibernate config file
     * @param configFileName the name of the configuration file
     */
    public void initialize(String configFileName) throws HibernateException
    {
        //如果配置文件为空,则使用默认配置文件hibernate.cfg.xml
        if(!StringUtil.isValid(configFileName))
        {
            configFileName = HIBERNATE_CFG_XML;
        }
        String url = getURLString(configFileName);
        
        if (null != sessionFactoryMap.get(url))
            return;
        else
        {
            reInitialize(configFileName);
        }
    }

    /**
     * 重新初始化
     * @param configFileName
     * @throws HibernateException
     */
    public void reInitialize(String configFileName) throws HibernateException
    {
        Configuration cfg = new Configuration();
        URL url = null;
        
        if (null == configFileName)
            configFileName=HIBERNATE_CFG_XML;

        url = getURL(configFileName);

        if(url==null)
        {
            throw new HibernateException("初始化Hibernate失败！");         
        }
        
        cfg.configure(url);                
        String urlString = url.toString();
        setSessionFactory(urlString, cfg.buildSessionFactory());
    }

    /**
     * 获取指定文件的url
     * @param configFileName
     *      文件名
     * @return
     *      如果文件存在则返回该文件对应的url
     * @throws HibernateException
     */
    private URL getURL(String configFileName) throws HibernateException
    {
        URL url;
        
        try
        {
            url = FileUtil.toURL(configFileName);
        }
        catch (InvalidFileName e)
        {
            throw new HibernateException("无效的文件路径: "+configFileName);
        }
        
        return url;
    }

    /**
     * 返回文件对应的url的字符串形式
     * @param configFileName
     *      文件名
     * @return
     *      如果文件存在则返回该文件对应的url的字符串
     * @throws HibernateException
     */
    private String getURLString(String configFileName) throws HibernateException
    {
        String urlStr = null;
        URL url = getURL(configFileName);
        
        if(url != null)
        {
            urlStr = url.toString();
        }
        
        return urlStr;
    }
    /**
     * 将会话工厂放到会话工厂表中
     */
    protected void setSessionFactory(String urlString,
            SessionFactory sessionFactory)
    {
        sessionFactoryMap.put(urlString, sessionFactory);
    }

    /**
     * 获取会话工厂
     * @param configFile
     *      配置文件的url路径
     * @return
     * @throws HibernateException
     */
    private SessionFactory getSessionFactory(String configFile)
            throws HibernateException
    {
        String url = getURLString(configFile);
        SessionFactory sessionFactory = (SessionFactory) sessionFactoryMap.get(url);
        
        if (null == sessionFactory)
        {
            if (null == configFile)

                throw new RuntimeException( "session factory 没有初始化.");
            else
                throw new RuntimeException("配置文件"+ configFile + "的session factory 没有初始化.");
        }
        else
            return sessionFactory;
    }

    /**
     * Return a new Session object that must be closed when the work has been completed.
     * @return the active Session
     */
    public Session getSession(String configFile) throws HibernateException
    {
        return createSession(configFile);
    }

    /**
     * Return a new Session object that must be closed when the work has been completed.
     * @param configFile the config file must match the meta attribute "config-file" in the hibernate mapping file
     * @return the active Session
     */
    public Session createSession(String configFile) throws HibernateException
    {
        //如果配置文件为空,则使用默认配置文件hibernate.cfg.xml
        if(!StringUtil.isValid(configFile))
        {
            configFile = HIBERNATE_CFG_XML;
        }
        
        initialize(configFile);
//        String url = getURLString(configFile);
        return getSessionFactory(configFile).openSession();
    }

    /**
     * Close the given session
     */
    public static void closeSession(Session s) throws HibernateException
    {
        if (null != s)
            s.close();
    }

    /**
     * Begin the transaction related to the session
     */
    public static Transaction beginTransaction(Session s) throws HibernateException
    {
        return s.beginTransaction();
    }

    /**
     * Commit the given transaction
     */
    public static void commitTransaction(Transaction t) throws HibernateException
    {
        t.commit();
    }

}