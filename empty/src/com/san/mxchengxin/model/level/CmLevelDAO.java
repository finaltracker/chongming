package com.san.mxchengxin.model.level;


import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for CmLevel entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .CmLevel
  * @author MyEclipse Persistence Tools 
 */

public class CmLevelDAO extends HibernateDaoSupport  {
		 private static final Log log = LogFactory.getLog(CmLevelDAO.class);
	// property constants
	public static final String LEVEL_SCORE = "levelScore";
	public static final String LEVEL_NAME = "levelName";
	public static final String AUTHOR = "author";
	public static final String PUBDATE = "pubdate";

	protected void initDao() {
		//do nothing
	}
    
    public void save(CmLevel transientInstance) {
        log.debug("saving CmLevel instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
    public void update(CmLevel transientInstance) {
		log.debug("updating CmLevel instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public void delete(CmLevel persistentInstance) {
        log.debug("deleting CmLevel instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public CmLevel findById( java.lang.Short id) {
        log.debug("getting CmLevel instance with id: " + id);
        try {
            CmLevel instance = (CmLevel) getHibernateTemplate()
                    .get("com.san.mxchengxin.model.level.CmLevel", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(CmLevel instance) {
        log.debug("finding CmLevel instance by example");
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
      log.debug("finding CmLevel instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from CmLevel as model where model." 
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLevelScore(Object levelScore) {
		return findByProperty(LEVEL_SCORE, levelScore);
	}

	public List findByLevelName(Object levelName) {
		return findByProperty(LEVEL_NAME, levelName);
	}

	public List findByAuthor(Object author) {
		return findByProperty(AUTHOR, author);
	}

	public List findByPubdate(Object pubdate) {
		return findByProperty(PUBDATE, pubdate);
	}

	public List findAll() {
		log.debug("finding all CmLevel instances");
		try {
			String queryString = "from CmLevel";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public CmLevel merge(CmLevel detachedInstance) {
        log.debug("merging CmLevel instance");
        try {
            CmLevel result = (CmLevel) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CmLevel instance) {
        log.debug("attaching dirty CmLevel instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(CmLevel instance) {
        log.debug("attaching clean CmLevel instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static CmLevelDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (CmLevelDAO) ctx.getBean("CmLevelDAO");
	}
	
	
}