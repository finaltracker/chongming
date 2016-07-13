package com.san.mxchengxin.model.record;
// default package

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.san.mxchengxin.model.country.CmPerson;

/**
 	* A data access object (DAO) providing persistence and search support for CmRecord entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .CmRecord
  * @author MyEclipse Persistence Tools 
 */

public class CmRecordDAO extends HibernateDaoSupport  {
		 private static final Log log = LogFactory.getLog(CmRecordDAO.class);
		//property constants
	public static final String PERSON_ID = "personId";
	public static final String TARGET_ID = "targetId";
	public static final String SCORE = "score";
	public static final String AUTHOR = "author";
	public static final String PUBDATE = "pubdate";
	public static final String STAT = "stat";
	public static final String DATELINE = "dateline";
	public static final String PART_ID = "partId";



	protected void initDao() {
		//do nothing
	}
    
    public void save(CmRecord transientInstance) {
        log.debug("saving CmRecord instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(CmRecord persistentInstance) {
        log.debug("deleting CmRecord instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public CmRecord findById( java.lang.Integer id) {
        log.debug("getting CmRecord instance with id: " + id);
        try {
            CmRecord instance = (CmRecord) getHibernateTemplate()
                    .get("com.san.mxchengxin.model.record.CmRecord", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(CmRecord instance) {
        log.debug("finding CmRecord instance by example");
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
      log.debug("finding CmRecord instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from CmRecord as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByPersonId(Object personId
	) {
		return findByProperty(PERSON_ID, personId
		);
	}
	
	public List findByTargetId(Object targetId
	) {
		return findByProperty(TARGET_ID, targetId
		);
	}
	
	public List findByScore(Object score
	) {
		return findByProperty(SCORE, score
		);
	}
	
	public List findByAuthor(Object author
	) {
		return findByProperty(AUTHOR, author
		);
	}
	
	public List findByPubdate(Object pubdate
	) {
		return findByProperty(PUBDATE, pubdate
		);
	}
	
	public List findByStat(Object stat
	) {
		return findByProperty(STAT, stat
		);
	}
	
	public List findByDateline(Object dateline
	) {
		return findByProperty(DATELINE, dateline
		);
	}
	
	public List findByPartId(Object partId
	) {
		return findByProperty(PART_ID, partId
		);
	}
	

	public List findAll() {
		log.debug("finding all CmRecord instances");
		try {
			String queryString = "from CmRecord";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public CmRecord merge(CmRecord detachedInstance) {
        log.debug("merging CmRecord instance");
        try {
            CmRecord result = (CmRecord) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CmRecord instance) {
        log.debug("attaching dirty CmRecord instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(CmRecord instance) {
        log.debug("attaching clean CmRecord instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void update(CmRecord transientInstance) {
		log.debug("updating CmRecord instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	public static CmRecordDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (CmRecordDAO) ctx.getBean("CmRecordDAO");
	}
	
}