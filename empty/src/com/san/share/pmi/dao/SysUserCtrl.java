package com.san.share.pmi.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.log.LogInfoVo;
import com.log.LogWriteInfo;
import com.san.share.pmi.SysUser;
import com.san.tools.hibernate.config.HibernateConfig;
import com.san.tools.hibernate.dao.IDao;
import com.san.tools.hibernate.dao.SimpleDao;
import com.san.tools.hibernate.exception.DeleteException;
import com.san.tools.hibernate.exception.FindException;
import com.san.tools.hibernate.exception.InitializationException;
import com.san.tools.hibernate.exception.InsertException;
import com.san.tools.hibernate.exception.UpdateException;
import com.san.tools.string.StringUtil;

public class SysUserCtrl
{
    private static final Logger logger = Logger.getLogger(SysUserCtrl.class);

    private static IDao dao = new SimpleDao();

    private static boolean initialized = false;
    
    private static LogInfoVo vo;
    private static LogWriteInfo logwrit=new LogWriteInfo();

    /**
     * ��ʼ��Hibernate
     */
    private static void initialize()
    {
        if(initialized)
        {
            return;
        }
        try
        {
            dao.initialize(HibernateConfig.getConfigFile());
            initialized = true;
        }
        catch(InitializationException e)
        {
            logger.error("initialize() - ��ʼ��Hibernateʱ��������", e);
        }
    }

    /**
     * 
     * @param sysUser
     * 
     * @return void
     * @throws InsertException
     */
    public static void addSysUser(SysUser sysUser) throws InsertException
    {
        initialize();
        dao.insert(sysUser);
        vo=new LogInfoVo();
		vo.setLogInfo("���һ���û�");
		vo.setLogtype("0");
		vo.setLogsql("add sysUser");
		logwrit.writeLog(vo);
    }

    /**
     * ����
     * 
     * @param sysUser
     * 
     * @return void
     * @throws UpdateException
     */
    public static void updateSysUser(SysUser sysUser) throws UpdateException
    {
        initialize();

        dao.update(sysUser);
    }

    /**
     * ɾ��
     * 
     * @param sysUser
     * @return void
     * @throws DeleteException
     */
    public static void deleteSysUser(SysUser sysUser) throws DeleteException
    {
        initialize();

        dao.delete(sysUser);
    }

    /**
     * ��������ֵɾ��
     * 
     * @param id
     *            ����ֵ
     * @return void
     * @throws DeleteException
     */
    public static void deleteSysUserByPK(String id) throws DeleteException
    {
        initialize();

        try
        {
            dao.delete(getSysUserByPK(id));
        }
        catch(FindException e)
        {
            throw new DeleteException(e);
        }
    }

    /**
     * ��ȡ
     * 
     * @param filter
     *            ��ѯ����
     * @param order
     *            ��������
     * @return List:���ݶ����б�
     * @throws FindException
     */
    public static List getSysUser(String filter, String order)
            throws FindException
    {
        initialize();
        List sysUserList = new ArrayList();

        if(order == null)
        {
            order = "";
        }

        String hqlClause = "from SysUser as item " + filter + order;

        sysUserList = dao.find(hqlClause);

        return sysUserList;
    }

    /**
     * 
     * 
     * 
     * 
     */
    public static SysUser getSysUserByPK(String id) throws FindException
    {
        SysUser sysUser = null;
        String filter = "where item." + SysUser.PROP_ID + "="
                + StringUtil.quoteString(id);
        List list = getSysUser(filter, "");

        if(list != null || !list.isEmpty())
        {
            sysUser = (SysUser) list.get(0);
        }

        return sysUser;
    }

    /**
     * ��ȡ��¼��
     * 
     * @param filter
     *            ��ѯ����
     * @return int:���������ļ�¼��
     */
    public static int getQueryCount(String filter) throws FindException
    {
        int count = 0;
        try
        {
            count = new Long(dao.getCount(SysUser.class, filter)).intValue();
        }
        catch(FindException e)
        {
            logger.error("�������ڣ�getQueryCount(filter = " + filter + ")", e);
            throw new FindException(e);
        }

        return count;
    }
    
    
    /**
     * �������� �Ǽ����Ժ�ĸ���
     * 
     * @param sysUser
     * 
     * @return void
     * @throws UpdateException
     */
    public static void md5updateSysUser(SysUser sysUser) throws UpdateException
    {
        initialize();
        dao.md5update(sysUser.getPwd(),sysUser.getId());
    }
}
