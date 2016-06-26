/*
 * Finder.java
 * ���ܣ�		ͨ�õĲ�ѯ����
 * �������ڣ� 2005-3-25
 * ���ߣ� 	ʢ����
 * �汾��		0.1
 * �޶���ʷ��
 * 			
 * 
 * ���汾�� 0.1
 **/
package com.san.tools.hibernate.finder;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.san.tools.hibernate.dao.SimpleDao;
import com.san.tools.hibernate.dao.IDao;
import com.san.tools.hibernate.exception.InitializationException;
import com.san.tools.hibernate3.session.SessionManager;
import com.san.tools.string.StringUtil;


/**
 * һ����ѯ�࣬���Ը��ݴ�������ݶ����clazz���Ժ��������в�ѯ�����HibernateFinder������Բ�һ�㣬��ʹ�ø�����
 * �ڴ����ѯ����ʱע�⣺��Ҫ��ѯ�����ݶ���ı���ͳһ��'item'
 */
public class Finder
{
    private IDao dao = null;         //���ݷ��ʶ���
    private PageFinder pageFinder = new PageFinder();   //��ҳ��ѯ��
    private String configFile = "SessionFactoryBySpring";
    
    /**
     * ȱʡ���캯��
     *
     */
    public Finder()
    {
        dao = new SimpleDao();
        
        try
        {
            initialize();
        }
        catch (InitializationException e)
        {
            e.printStackTrace();
        }
    }
    
    public void initialize() throws InitializationException
    {
        try
        {
            dao.initialize(configFile);
        }
        catch (InitializationException e)
        {
            throw new InitializationException(e);
        }

    }
    /**
     * ���캯��
     * @param cfgFile
     *      hibernate�����ļ���
     * @throws Exception
     */
    public Finder(String cfgFile)throws Exception
    {
        dao = new SimpleDao();
        configFile = cfgFile;
        initialize();
    }
    
    /**
     * ���ι��캯��
     * @param baseDao
     *      DAO����
     */
    public Finder(IDao baseDao)
    {
        dao = baseDao;
    }
    
    /**
     * ��ȡ���е����ݶ���
     * @param clazz
     *      ��Ҫ��ѯ�����ݶ���������
     * @return
     *      ���ݶ����б�
     * @throws Exception
     */
    public List findAll(Class clazz) throws Exception
    {
        List list = new ArrayList();
        String sqlClause = "";
        sqlClause = "from "+ StringUtil.getSimpleName(clazz);
        list = dao.find(sqlClause);
        
        return list;
    }
    
    /**
     * ��ҳ��������ȡ���ݶ���
     * @param clazz
     *      ��Ҫ��ȡ�����ݶ���������
     * @param pageNo
     *      ҳ��
     * @param pageSize
     *      ÿҳ��ѯ����
     * @return
     *      List�����ݶ����б�
     * @throws Exception
     */
    public List findAll(Class clazz, int pageNo, int pageSize)
                        throws Exception
    {
        List list = new ArrayList();
        String sqlClause = "";
        sqlClause = "from "+StringUtil.getSimpleName(clazz);
        pageFinder.setPageNo(pageNo);
        pageFinder.setPageSize(pageSize);
        Session session = SessionManager.getInstance().getSession(configFile);
        try
        {
            list = pageFinder.find(session, sqlClause);
        }
        finally
        {
            SessionManager.closeSession(session);
        }
                
        return list;
    }
    
    /**
     * ���ݴ����������ȡ���ݶ���
     * @param clazz
     *      ��Ҫ��ѯ�����ݶ���������
     * @param condition
     *      ��ѯ��������Ҫ��ѯ�����ݶ���ı���ͳһ��'item'
     * @param orderProperty
     *      ��������
     * @return
     *      ���ݶ����б�
     * @throws Exception
     */
    public List find(Class clazz, String condition, String orderProperty)
                    throws Exception
    {
        List list = new ArrayList();
        String sqlClause = "";
        if(orderProperty == null)
        {
            orderProperty="";
        }
        sqlClause = "from "+StringUtil.getSimpleName(clazz)+ "  item "+condition + " "+ orderProperty;
        
        list = dao.find(sqlClause);
        
        return list;
    }
    
    /**
     * ���ݴ����������ҳ��ȡ���ݶ���
     * @param clazz
     *      ��Ҫ��ѯ�����ݶ���������
     * @param condition
     *      ��ѯ��������Ҫ��ѯ�����ݶ���ı���ͳһ��'item'
     * @param orderProperty
     *      ��������
     * @param pageNo
     *      ҳ��
     * @param pageSize
     *      ÿҳ��ѯ����
     * @return
     *      ���ݶ����б�
     *      
     * @throws Exception
     */
    public List find(Class clazz, String condition, String orderProperty, int pageNo, int pageSize)
                    throws Exception
    {
        List list =  new ArrayList();
        String sqlClause = "";
        if(orderProperty == null)
        {
            orderProperty="";
        }
        sqlClause = "from "+StringUtil.getSimpleName(clazz)+ "  item "+condition + " "+ orderProperty;
        pageFinder.setPageNo(pageNo);
        pageFinder.setPageSize(pageSize);
        Session session = SessionManager.getInstance().getSession(configFile);
        
        try
        {
            list = pageFinder.find(session, sqlClause);
        }
        finally
        {
            SessionManager.closeSession(session);
        }
        
        return list;
    }
    
    /**
     * ���ݴ����HQL��ѯ����ѯ
     * @param HQL
     *      HQL��ѯ���
     * @return
     *      �������ݶ����б�
     * @throws Exception
     */
    public List find(String HQL) throws Exception
    {
        List list = new ArrayList();
        list = dao.find(HQL);
        return list;
    }
    
    
    /**
     * ���ݴ����HQL����ҳ��ѯ
     * @param HQL
     *      HQL��ѯ���
     * @param pageNo
     *      ҳ��
     * @param pageSize
     *      ÿҳ����
     * @return
     *      �������ݶ����б�
     */
    public List find(String HQL, int pageNo, int pageSize) throws Exception
    {
        List list = new ArrayList();
        pageFinder.setPageNo(pageNo);
        pageFinder.setPageSize(pageSize);
        
        Session session = SessionManager.getInstance().getSession(configFile);
        try
        {
            list = pageFinder.find(session, HQL);
        }
        finally
        {
            SessionManager.closeSession(session);
        }
        return list;
    }
    /**
     * ��ȡ�������������ݼ�¼������
     * @param clazz
     *      ��Ҫ��ѯ�����ݶ���������
     * @param condition
     *      ��ѯ��������Ҫ��ѯ�����ݶ���ı���ͳһ��'item'
     * @return
     *      Integer���������ݼ�¼����
     * @throws Exception
     */
    public Integer getCount(Class clazz, String condition) throws Exception
    {
        Integer count = new Integer(0); 
        int i = 0;
        
        i = (int)dao.getCount(clazz, condition);        
        count = new Integer(i);
        
        return count;
    }
    
    /**
     * ���ݲ�ѯ����ȡ��¼��������
     * @param query
     *      ��ѯ���
     * @return
     *      ���ؼ�¼��������
     * @throws Exception
     */
    public Integer getCount(String query) throws Exception
    {
        Integer count = new Integer(0);
        int i = 0;
        i=(int)dao.getCount(query);
        count = new Integer(i);
        return count;
    }
    
    
    /**
     * ������ϲ�ѯ���ݴ����������ȡ���ݶ���
     * @param clazz
     *      ��Ҫ��ѯ�����ݶ���������
     * @param condition
     *      ��ѯ��������Ҫ��ѯ�����ݶ���ı���ͳһ��'item'
     * @param orderProperty
     *      ��������
     * @return
     *      ���ݶ����б�
     * @throws Exception
     */
    public List sqlfind(Class clazz, String sqlClause)
                    throws Exception
    {
        List list = new ArrayList();
        list = dao.sqlfind(sqlClause);
        
        return list;
    }
    
    /**
     * �������
     * @param clazz
     * @return
     * @throws Exception
     */
    public void saveObject(Object clazz) throws Exception
    {
        dao.saveOrUpdate(clazz);
    }
}
