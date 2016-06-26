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
     * 初始化Hibernate
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
            logger.error("initialize() - 初始化Hibernate时发生错误！", e);
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
		vo.setLogInfo("添加一个用户");
		vo.setLogtype("0");
		vo.setLogsql("add sysUser");
		logwrit.writeLog(vo);
    }

    /**
     * 更新
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
     * 删除
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
     * 根据主键值删除
     * 
     * @param id
     *            主键值
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
     * 获取
     * 
     * @param filter
     *            查询条件
     * @param order
     *            排序条件
     * @return List:数据对象列表
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
     * 获取记录数
     * 
     * @param filter
     *            查询条件
     * @return int:符合条件的记录数
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
            logger.error("错误发生在：getQueryCount(filter = " + filter + ")", e);
            throw new FindException(e);
        }

        return count;
    }
    
    
    /**
     * 更新密码 是加密以后的更新
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
