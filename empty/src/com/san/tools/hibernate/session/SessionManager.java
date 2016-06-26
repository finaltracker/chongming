/*
 * Created on 2004-10-20
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
     * ��ȡSessionManager��ʵ��
     * @return
     *  ����SessionManager��ʵ��
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
     * Ĭ�ϳ�ʼ��������ʹ��/hibernate.cfg.xml��Ϊ�����ļ�
     * @throws HibernateException
     */
    public void initialize() throws HibernateException
    {
        initialize(null);
    }
    
    /**
     * �Ӹ��������ļ��л�ȡhibernate���������������Ϣ������ʼ��hibernate����
     * @param configFileName 
     *      hibernate�����ļ���
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
     * ���³�ʼ��hibernate����
     * @param configFileName
     *      hibernate�����ļ���
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
     * @param urlString
     *      hibernate�����ļ���url·���ַ���
     * @param sessionFactory
     *      ��Ҫ��ŵĻỰ����
     */
    protected void setSessionFactory(String urlString,
            SessionFactory sessionFactory)
    {
        sessionFactoryMap.put(urlString, sessionFactory);
    }

    /**
     * ���ݴ���������ļ�url�ַ�����ȡ�Ự����
     * @param configFile
     *      �����ļ���url·��
     * @return
     *      ���ػỰ����ʵ��
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
     * ���ݴ���������ļ�����ȡһ����ĻỰʵ��
     * @return
     *      ����һ����ĻỰʵ��
     */
    public Session getSession(String configFile) throws HibernateException
    {
        return createSession(configFile);
    }

    /**
     * ���������ļ�����һ���Ự
     * @param configFile
     *      hibernate�����ļ���
     * @return 
     *      ����һ����ĻỰʵ��
     */
    public Session createSession(String configFile) throws HibernateException
    {
        //��������ļ�Ϊ��,��ʹ��Ĭ�������ļ�hibernate.cfg.xml
        if(!StringUtil.isValid(configFile))
        {
            configFile = HIBERNATE_CFG_XML;
        }
        
        initialize(configFile);
        return getSessionFactory(configFile).openSession();
    }

    /**
     * �رջỰ
     * @param   session
     *      ��Ҫ�رյĻỰʵ��
     */
    public static void closeSession(Session session) throws HibernateException
    {
        if (null != session)
            session.close();
    }

    /**
     * �ڸ����ĻỰ�Ͽ�ʼ����
     * @param   session
     *      ��Ҫ�رյĻỰʵ��
     */
    public static Transaction beginTransaction(Session session) throws HibernateException
    {
        return session.beginTransaction();
    }

    /**
     * �ύ����
     * @param   transaction
     *      ����ʵ��
     */
    public static void commitTransaction(Transaction transaction) throws HibernateException
    {
        transaction.commit();
    }

}
