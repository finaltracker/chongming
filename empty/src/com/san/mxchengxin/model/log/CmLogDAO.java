package com.san.mxchengxin.model.log;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for CmLog entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .CmLog
  * @author MyEclipse Persistence Tools 
 */

public class CmLogDAO extends HibernateDaoSupport  {
		 private static final Log log = LogFactory.getLog(CmLogDAO.class);
		//property constants
	public static final String INFO = "info";
	public static final String PUBDATE = "pubdate";
	public static final String AUTHOR = "author";
	public static final String IP = "ip";



	protected void initDao() {
		//do nothing
	}
    
    public void save(CmLog transientInstance) {
        log.debug("saving CmLog instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(CmLog persistentInstance) {
        log.debug("deleting CmLog instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
   
    
    public List findByExample(CmLog instance) {
        log.debug("finding CmLog instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding CmLog instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from CmLog as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByInfo(Object info
	) {
		return findByProperty(INFO, info
		);
	}
	
	public List findByPubdate(Object pubdate
	) {
		return findByProperty(PUBDATE, pubdate
		);
	}
	
	public List findByAuthor(Object author
	) {
		return findByProperty(AUTHOR, author
		);
	}
	
	public List findByIp(Object ip
	) {
		return findByProperty(IP, ip
		);
	}
	

	public List findAll() {
		log.debug("finding all CmLog instances");
		try {
			String queryString = "from CmLog";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public CmLog merge(CmLog detachedInstance) {
        log.debug("merging CmLog instance");
        try {
            CmLog result = (CmLog) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CmLog instance) {
        log.debug("attaching dirty CmLog instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(CmLog instance) {
        log.debug("attaching clean CmLog instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static CmLogDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (CmLogDAO) ctx.getBean("CmLogDAO");
	}
}