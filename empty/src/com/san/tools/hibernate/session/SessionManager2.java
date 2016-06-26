/*
 * �ļ�����	SessionManager2.java
 * ���ܣ�		ʵ����һ��Hibernate���ݿ�session�Ĺ�����
 * �������ڣ�	2005-6-24
 * ���ߣ�		ʢ����
 * �汾��		0.1
 * �޶���ʷ��	
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
     * Ĭ�ϳ�ʼ��������ʹ��/hibernate.cfg.xml��Ϊ�����ļ�
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
        //��������ļ�Ϊ��,��ʹ��Ĭ�������ļ�hibernate.cfg.xml
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
     * ���³�ʼ��
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
            throw new HibernateException("��ʼ��Hibernateʧ�ܣ�");         
        }
        
        cfg.configure(url);                
        String urlString = url.toString();
        setSessionFactory(urlString, cfg.buildSessionFactory());
    }

    /**
     * ��ȡָ���ļ���url
     * @param configFileName
     *      �ļ���
     * @return
     *      ����ļ������򷵻ظ��ļ���Ӧ��url
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
            throw new HibernateException("��Ч���ļ�·��: "+configFileName);
        }
        
        return url;
    }

    /**
     * �����ļ���Ӧ��url���ַ�����ʽ
     * @param configFileName
     *      �ļ���
     * @return
     *      ����ļ������򷵻ظ��ļ���Ӧ��url���ַ���
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
     * ���Ự�����ŵ��Ự��������
     */
    protected void setSessionFactory(String urlString,
            SessionFactory sessionFactory)
    {
        sessionFactoryMap.put(urlString, sessionFactory);
    }

    /**
     * ��ȡ�Ự����
     * @param configFile
     *      �����ļ���url·��
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

                throw new RuntimeException( "session factory û�г�ʼ��.");
            else
                throw new RuntimeException("�����ļ�"+ configFile + "��session factory û�г�ʼ��.");
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
        //��������ļ�Ϊ��,��ʹ��Ĭ�������ļ�hibernate.cfg.xml
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