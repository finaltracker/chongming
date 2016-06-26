/*
 * �ļ�����	PageFinder.java
 * ���ܣ�		��ҳ��ѯ�ĸ�����
 * �������ڣ� 2004-11-17
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
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * ��ҳ��ѯ����
 *  
 */
public class PageFinder
{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PageFinder.class);

	private int m_pageNo = 0;			//ҳ��
	private int m_pageSize = 0;		//ÿҳ����
	
	/**
	 * ��ѯ
	 * @param session
	 * 		���ݷ��ʶ���
	 * @param sqlClause
	 * 		��ѯ���
	 * @return
	 * 		List�������ݱ��Ӧ��VO������б�
	 */
	public List find(Session session, String sqlClause)
	{
		List list = new ArrayList();
		Query query = null;
        
        if(session == null)
        {
            return list;
        }
		
		try
		{
			query = session.createQuery(sqlClause);
			query.setFirstResult(m_pageSize*(m_pageNo-1));
			query.setMaxResults(m_pageSize);
			list = query.list();
		}
		catch (HibernateException e)
		{
			logger.error("find(sqlClause = " + sqlClause + ") - ��ҳ��ѯʱ��������", e);
		}

		return list;
	}
	
	/**
	 * �趨ҳ��
	 * @param pageNo
	 * 		ҳ��
	 * @return
	 * 		void
	 */
	public void setPageNo(int pageNo)
	{
		this.m_pageNo = pageNo;
	}
	/**
	 * �趨ÿҳ��ѯ����
	 * @param pageSize 
	 * 		ÿҳ����
	 * @return
	 * 		void
	 */
	public void setPageSize(int pageSize)
	{
		this.m_pageSize = pageSize;
	}
	
}
