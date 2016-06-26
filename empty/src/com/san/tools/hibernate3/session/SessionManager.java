/*
 * Created on 2004-10-20
 */
package com.san.tools.hibernate3.session;

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

import org.springframework.context.ApplicationContext;

import com.san.tools.file.exception.InvalidFileName;
import com.san.tools.file.util.FileUtil;
import com.san.tools.string.StringUtil;

/**
 * @author Administrator
 *
 */
public class SessionManager// implements Observer
{

    private static final String HIBERNATE_CFG_XML = "SessionFactoryBySpring";

    protected Map sessionFactoryMap = new HashMap();

    private static SessionManager instance = null;
    
    private List configureFileList = new ArrayList();

    /**
     * 
     *
     */
    protected SessionManager() {
    }

    /**
     * 获取SessionManager的实例
     * @return
     *  返回SessionManager的实例
     */
    public static SessionManager getInstance()
    {
        if (instance == null)
        {
            synchronized (SessionManager.class)
            {
                instance = new SessionManager();
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
     * 从给定配置文件中获取hibernate运行所需的配置信息，并初始化hibernate环境
     * @param configFileName 
     *      hibernate配置文件名
     */
    public void initialize(String configFileName) throws HibernateException
    {
        System.out.print("configFileName" + configFileName);
        configFileName = "SessionFactoryBySpring";
        //如果配置文件为空,则使用默认配置文件hibernate.cfg.xml
        if(!StringUtil.isValid(configFileName))
        {
            configFileName = HIBERNATE_CFG_XML;
        }
        
        //String url = getURLString(configFileName);
        
        if (null != sessionFactoryMap.get("SessionFactoryBySpring"))
        {
            System.out.print("-----------对象不为空");
            return;
        } 
        else
        {
            System.out.print("--------------对象为空");
            reInitialize(configFileName);
        }
    }

    
    public void initialize(String configFileName,SessionFactory sessionFactory) throws HibernateException{
           
        System.out.print("configFileName is" + configFileName);
        if(StringUtil.isValid(configFileName))
        {
            configFileName = HIBERNATE_CFG_XML;
        }
       // String url = getURLString(configFileName);
        
        setSessionFactory(configFileName,sessionFactory);
        System.out.print(sessionFactoryMap.size());
        if(null != sessionFactoryMap.get(configFileName)){
            return;
        }
        
        reInitialize(configFileName);
    }
    
    /**
     * 重新初始化hibernate配置
     * @param configFileName
     *      hibernate配置文件名
     * @throws HibernateException
     */
    public void reInitialize(String configFileName) throws HibernateException
    {
        System.out.print("reInitialize----------");
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
        System.out.print("configFileName"+configFileName);
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
     * @param urlString
     *      hibernate配置文件的url路径字符串
     * @param sessionFactory
     *      需要存放的会话工厂
     */
    protected void setSessionFactory(String urlString,
            SessionFactory sessionFactory)
    {
        sessionFactoryMap.put(urlString, sessionFactory);
    }

    /**
     * 根据传入的配置文件url字符串获取会话工厂
     * @param configFile
     *      配置文件的url路径
     * @return
     *      返回会话工厂实例
     * @throws HibernateException
     */
    private SessionFactory getSessionFactory(String configFile)
            throws HibernateException
    {
        //String url = getURLString(configFile);
        SessionFactory sessionFactory = (SessionFactory) sessionFactoryMap.get(configFile);
        
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
     * 根据传入的配置文件名获取一个活动的会话实例
     * @return
     *      返回一个活动的会话实例
     */
    public Session getSession(String configFile) throws HibernateException
    {
    	configFile = "SessionFactoryBySpring";
        return createSession(configFile);
    }

    /**
     * 根据配置文件创建一个会话
     * @param configFile
     *      hibernate配置文件名
     * @return 
     *      返回一个活动的会话实例
     */
    public Session createSession(String configFile) throws HibernateException
    {
        //如果配置文件为空,则使用默认配置文件hibernate.cfg.xml
        if(!StringUtil.isValid(configFile))
        {
            configFile = HIBERNATE_CFG_XML;
        }
        configFile = "SessionFactoryBySpring";
        initialize(configFile);
        return getSessionFactory(configFile).openSession();
    }

    /**
     * 关闭会话
     * @param   session
     *      需要关闭的会话实例
     */
    public static void closeSession(Session session) throws HibernateException
    {
        if (null != session)
            session.close();
    }

    /**
     * 在给定的会话上开始事务
     * @param   session
     *      需要关闭的会话实例
     */
    public static Transaction beginTransaction(Session session) throws HibernateException
    {
        return session.beginTransaction();
    }

    /**
     * 提交事务
     * @param   transaction
     *      事务实例
     */
    public static void commitTransaction(Transaction transaction) throws HibernateException
    {
        transaction.commit();
    }

}
