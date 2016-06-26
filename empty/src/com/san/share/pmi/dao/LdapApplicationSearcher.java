// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 2010/11/29 10:36:46
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   LdapApplicationSearcher.java

package com.san.share.pmi.dao;

import com.san.share.pmi.LdapApplication;
import com.san.tools.hibernate.exception.FindException;
import com.san.tools.hibernate.finder.Finder;
import com.san.tools.string.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class LdapApplicationSearcher
{

    public LdapApplicationSearcher()
    {
    }

    public static List findLdapApplication(String hql)
        throws FindException
    {
        List list = new ArrayList();
        try
        {
            list = finder.find(hql);
        }
        catch(Exception e)
        {
            logger.error((new StringBuilder("\u9519\u8BEF\u53D1\u751F\u5728:findLdapApplication(hql = ")).append(hql).append(")").toString(), e);
            throw new FindException(e);
        }
        return list;
    }

    public static List findLdapApplication(String hql, int pageNo, int pageSize)
        throws FindException
    {
        List list = new ArrayList();
        try
        {
            list = finder.find(hql, pageNo, pageSize);
        }
        catch(Exception e)
        {
            logger.error((new StringBuilder("\u9519\u8BEF\u53D1\u751F\u5728:findLdapApplication(hql = ")).append(hql).append(")").toString(), e);
            throw new FindException(e);
        }
        return list;
    }

    public static int getQueryCountByHQL(String query)
        throws FindException
    {
        List list = new ArrayList();
        int count = 0;
        try
        {
            list = findLdapApplication(query);
            count = list.size();
        }
        catch(Exception e)
        {
            logger.error((new StringBuilder("\u9519\u8BEF\u53D1\u751F\u5728:getQueryCountByHQL(query = ")).append(query).append(")").toString(), e);
            throw new FindException(e);
        }
        return count;
    }

    public static List findLdapApplicationByCondition(String queryCondition)
        throws FindException
    {
        List list = new ArrayList();
        try
        {
            list = finder.find(LdapApplication.class, queryCondition, "order by order_id ");
        }
        catch(Exception e)
        {
            logger.error((new StringBuilder("\u9519\u8BEF\u53D1\u751F\u5728:findLdapApplicationByCondition(queryCondition = ")).append(queryCondition).append(")").toString(), e);
            throw new FindException(e);
        }
        return list;
    }

    public static List findLdapApplicationByCondition(String queryCondition, int pageNo, int pageSize)
        throws FindException
    {
        List list = new ArrayList();
        try
        {
            list = finder.find(LdapApplication.class, queryCondition, "", pageNo, pageSize);
        }
        catch(Exception e)
        {
            logger.error((new StringBuilder("\u9519\u8BEF\u53D1\u751F\u5728:findLdapApplicationByCondition(queryCondition = ")).append(queryCondition).append(")").toString(), e);
            throw new FindException(e);
        }
        return list;
    }

    public static LdapApplication findLdapApplicationByPK(String id)
        throws FindException
    {
        LdapApplication ldapApplication = null;
        String hqlClause = (new StringBuilder("where item.")).append(LdapApplication.PROP_ID).append(" = ").append(StringUtil.quoteString(id)).toString();
        try
        {
            List list = finder.find(LdapApplication.class, hqlClause, "");
            if(list != null && !list.isEmpty())
                ldapApplication = (LdapApplication)list.get(0);
        }
        catch(Exception e)
        {
            logger.error((new StringBuilder("\u9519\u8BEF\u53D1\u751F\u5728:find{class.ValueObjectClassName}ByPK(id = ")).append(id).append(")").toString(), e);
            throw new FindException(e);
        }
        return ldapApplication;
    }

    public static int getQueryCount(String queryCondition)
        throws FindException
    {
        int count = 0;
        try
        {
            count = finder.getCount(LdapApplication.class, queryCondition).intValue();
        }
        catch(Exception e)
        {
            logger.error((new StringBuilder("\u9519\u8BEF\u53D1\u751F\u5728:getQueryCount(queryCondition = ")).append(queryCondition).append(")").toString(), e);
            throw new FindException(e);
        }
        return count;
    }

    private static final Logger logger = Logger.getLogger(LdapApplicationSearcher.class);
    private static Finder finder = new Finder();

}