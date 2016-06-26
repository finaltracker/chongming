/*
 * �ļ�����	HibernateFinder.java
 * ���ܣ�		
 * �������ڣ� 2004-11-18
 * ���ߣ� 	ʢ����
 * �汾��		0.1
 * �޶���ʷ��
 * 			
 * 
 * ���汾��
 * 
 * Copyright 2004 - Shanghai 30Wish Infomation Security Co. Ltd.
 * 
 */
package com.san.tools.hibernate3.finder;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.san.tools.collection.util.CollectionUtil;
import com.san.tools.hibernate.dao.SimpleDao;
import com.san.tools.hibernate.dao.IDao;
import com.san.tools.hibernate.exception.FindException;
import com.san.tools.hibernate.exception.InitializationException;
import com.san.tools.hibernate3.session.SessionManager;
import com.san.tools.sql.SQLExpression;
import com.san.tools.sql.SQLOrderClause;

/**
 * һ��Hibernate��ѯ��,���Ը������ݶ���������ȡ���ݣ�Ҳ�����Զ�HQL�����в�ѯ
 * ͬʱ���Խ��з�ҳ��ѯ
 */
public class HibernateFinder
{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HibernateFinder.class);

	private static final String DEFAULT_ALIAS = "item";
	private SQLExpression sqlExpression = new SQLExpression();		//where �־乹����
	private SQLOrderClause orderClause = new SQLOrderClause();		//order by �Ӿ乹����
	private String m_alias = DEFAULT_ALIAS;							//����
	private String m_poName = null;									//�־ö��������
	private String selector = null;
	private String countSelector = null;
	private int m_pageNo = 0;											//ҳ��
	private int m_pageSize = 0;										//ÿҳ����
	private String configFile = "SessionFactoryBySpring";
	private IDao dao = new SimpleDao();
	private PageFinder pageFinder = new PageFinder();
	
	/**
	 * ȱʡ���캯��
	 *
	 */
	public HibernateFinder()
	{
		try
		{
			dao.initialize(configFile);
		}
		catch (InitializationException e)
		{
			logger.error("OrderFinder() - ��ʼ��Hibernateʱ��������", e);
		}
	}
	
	/**
	 * �������Ĺ��캯��
	 * @param poname
	 * 		�־ö��������
	 */
	public HibernateFinder(String poname)
	{
		try
		{
			dao.initialize(configFile);
		}
		catch (InitializationException e)
		{
			logger.error("OrderFinder() - ��ʼ��Hibernateʱ��������", e);
		}
		
		setPoName(poname);
	}
	/**
	 * ����order by����
	 * @param field
	 * 		�ֶ���
	 */
	public void setOrderCondition(String field)
	{
		orderClause.clearCondition();
		orderClause.addOrderCondition(getAliasField(field));
	}
	/**
	 * �趨��������
	 * @param field
	 * 		�ֶ���
	 * @param value
	 * 		�ֶ�ֵ������ֶ����ַ����͵Ļ��������õ�����������
	 * @param compareOperator
	 * 		�Ƚϲ�����
	 */
	public void setOrFilter(String field, String value, String compareOperator)
	{
		String operator = getCompareOperator(compareOperator);
		
		sqlExpression.orWhereClause(getAliasField(field), value, compareOperator);		
	}
	
	/**
	 * 
	 * @param field
	 * 		�ֶ���
	 * @param value
	 * 		�ֶ�ֵ������ֶ����ַ����͵Ļ��������õ�����������
	 * @param compareOperator
	 * 		�Ƚϲ�����
	 */
	public void setAndFilter(String field, String value, String compareOperator)
	{
		String operator = getCompareOperator(compareOperator);
		
		sqlExpression.andWhereClause(getAliasField(field), value, compareOperator);
	}
	

	/**
	 * ��չ�����
	 * @return
	 * 		void
	 *
	 */
	public void clearFilter()
	{
		sqlExpression.clear();
	}
	
	/**
	 * �����趨�������������ݶ���
	 * @return
	 * 		List�����ݶ�����б�
	 */
	public List findVOs()
	{
		List list = new ArrayList();
		String sqlClause = selector + sqlExpression.getWhereClause() + " "  + orderClause.getOrderClause();
		
		try
		{
			list = dao.find(sqlClause);
		}
		catch (FindException e)
		{
			logger.error("findVOs() - ��ѯ��ʱ�������� : sqlClause = " + sqlClause, e);
		}
		
		return list;
	}

	public List findVOs(String select)
	{
		List list = new ArrayList();
		String sqlClause = select; //+ sqlExpression.getWhereClause() + " "  + orderClause.getOrderClause();
		
		try
		{
			list = dao.find(sqlClause);
		}
		catch (FindException e)
		{
			logger.error("findVOs() - ��ѯ��ʱ�������� : sqlClause = " + sqlClause, e);
		}
		
		return list;
	}
	
	
	/**
	 * �����趨��������ҳ�������ݶ���
	 * @return
	 * 		List�����ݶ�����б�,�鲻���򷵻ؿյ��б�
	 */
	public List findVOsPage()
	{
		List list = new ArrayList();
		String sqlClause = selector + sqlExpression.getWhereClause();
		pageFinder.setPageNo(m_pageNo);
		pageFinder.setPageSize(m_pageSize);
        
        Session session = null; 
        try
        {
            session = SessionManager.getInstance().getSession(configFile);
            list = pageFinder.find(session, sqlClause);
        }
        catch (HibernateException e)
        {
            logger.error("findVOsPage() - ��ѯ��ʱ��������",e);
        }
        finally
        {
            closeSession(session);
        }
		
		return list;
	}

	/**
     * @param session
     */
    private void closeSession(Session session)
    {
        try
        {
            SessionManager.closeSession(session);
        }
        catch(HibernateException e)
        {
            logger.error(e);
        }
    }

    /**
     * 
     * @param select
     * @return list
     */
	public List findVOsPage(String select)
	{
		List list = new ArrayList();
		String sqlClause = select + sqlExpression.getWhereClause();
		pageFinder.setPageNo(m_pageNo);
		pageFinder.setPageSize(m_pageSize);
        Session session = null;
        try
        {
            session = SessionManager.getInstance().getSession(configFile);
            list = pageFinder.find(session, sqlClause);
        }
        catch (HibernateException e)
        {
            logger.error("findVOsPage(String select = "+select+")",e);
        }
        finally
        {
            closeSession(session);
        }
		
		return list;
	}

	/**
	 * ����������ȡ��������
	 * @return
	 * 		��������
	 */
	public int getVOCount()
	{
		int count = 0;
		List list = null;
		String sqlClause = countSelector + sqlExpression.getWhereClause();
		try
		{
			list = dao.find(sqlClause);
			if(!list.isEmpty())
			{
				count = Integer.parseInt(list.get(0).toString().trim());
			}
		}
		catch (FindException e)
		{
			logger.error("getVOCount() - ��ȡ��¼����ʱ�������� : String sqlClause = "
					+ sqlClause, e);
		}
        
		return count;
	}
    
    /**
     * ��ȡ��¼��
     * @param query
     * @return
     */
    public int getCount(String query)
    {
        int count = 0;
        List list = null;
        
        try
        {
            list = dao.find(query);
            
            if(CollectionUtil.isValid(list))
            {
                count = list.size();
            }
        }
        catch(FindException e)
        {
            logger.error("getCount() - ��ȡ��¼����ʱ��������: String query = " + query, e);
        }
        
        return count;
    }
	/**
	 * ������һ�εķ�ҳ��ѯ�����Ͳ���������һҳ�����ݶ����б�
	 * @return
	 * 		List�����ݶ�����б�
	 */
	public List nextPage()
	{
		m_pageNo += 1;
		return findVOsPage();
	}
	
	/**
	 * �õ�����˱�������ֶ���
	 * @param field
	 * 		�ֶ���
	 * @return
	 * 		String������˱�������ֶ���
	 */
	private String getAliasField(String field)
	{
		String aliasName = "";
		if(field==null || field.trim().length()<=0)
		{
			return null;
		}
		int lastIndex = field.lastIndexOf(".");
		//�Ƿ����'.'
		if(lastIndex != -1)
		{
			field = field.substring(lastIndex);
		}
		
		aliasName = m_alias+"."+field;
		return aliasName;
	}
	/**
	 * ��ȡ�Ƚϲ�����
	 * @param compareOperator
	 * 		����ıȽϲ�����
	 * @return
	 * 		�ַ����͵ıȽϲ���������"=",">","like"��
	 */
	private String getCompareOperator(String compareOperator)
	{
		String operator = compareOperator;
		if(operator == null || operator.trim().length() <=0)
		{
			operator = "=";
		}
		return operator;
	}

	
	
	/**
	 * ���÷�ҳ��ѯʱ��ҳ��
	 * @param pageNo The pageNo to set.
	 * @return
	 * 		void
	 */
	public void setPageNo(int pageNo)
	{
		this.m_pageNo = pageNo;
	}
	
	/**
	 * ���÷�ҳ��ѯʱÿҳ��ѯ����
	 * @param pageSize 
	 * 		The pageSize to set.
	 * @return
	 * 		 void
	 */
	public void setPageSize(int pageSize)
	{
		this.m_pageSize = pageSize;
	}

	/**
	 * ���ñ���
	 * @param alias The alias to set.
	 * @return
	 * 		void
	 */
	public void setAlias(String alias)
	{
		this.m_alias = alias;
		if(this.m_poName != null && this.m_poName.trim().length() >0)
		{
			selector = " from " + this.m_poName + " as " + this.m_alias + " ";			
			countSelector = " select count(*) from " + m_poName + " as " + this.m_alias + " ";
		}
	}
	
	/**
	 * @param poName 
	 * 		�־ö�������ƣ��ڵ��ò��ҷ���֮ǰ������ø÷���
	 * @return
	 * 		void
	 */
	public void setPoName(String poName)
	{
		this.m_poName = poName;
		selector = " from " + poName + " as " + this.m_alias + " ";
		countSelector = " select count(*) from " + poName + " as " + this.m_alias + " ";
	}
	/**
	 * @return Returns the alias.
	 */
	public String getAlias()
	{
		return m_alias;
	}
}
