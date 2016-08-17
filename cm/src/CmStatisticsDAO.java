// default package

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for CmStatistics entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .CmStatistics
  * @author MyEclipse Persistence Tools 
 */

public class CmStatisticsDAO extends HibernateDaoSupport  {
		 private static final Log log = LogFactory.getLog(CmStatisticsDAO.class);
		//property constants
	public static final String PERSON_ID = "personId";
	public static final String COUNTRY_ID = "countryId";
	public static final String SCORE_BASE = "scoreBase";
	public static final String SCORE_ADD = "scoreAdd";
	public static final String SCORE_SUB = "scoreSub";



	protected void initDao() {
		//do nothing
	}
    
    public void save(CmStatistics transientInstance) {
        log.debug("saving CmStatistics instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(CmStatistics persistentInstance) {
        log.debug("deleting CmStatistics instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public CmStatistics findById( java.lang.Integer id) {
        log.debug("getting CmStatistics instance with id: " + id);
        try {
            CmStatistics instance = (CmStatistics) getHibernateTemplate()
                    .get("CmStatistics", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(CmStatistics instance) {
        log.debug("finding CmStatistics instance by example");
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
      log.debug("finding CmStatistics instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from CmStatistics as model where model." 
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
	
	public List findByCountryId(Object countryId
	) {
		return findByProperty(COUNTRY_ID, countryId
		);
	}
	
	public List findByScoreBase(Object scoreBase
	) {
		return findByProperty(SCORE_BASE, scoreBase
		);
	}
	
	public List findByScoreAdd(Object scoreAdd
	) {
		return findByProperty(SCORE_ADD, scoreAdd
		);
	}
	
	public List findByScoreSub(Object scoreSub
	) {
		return findByProperty(SCORE_SUB, scoreSub
		);
	}
	

	public List findAll() {
		log.debug("finding all CmStatistics instances");
		try {
			String queryString = "from CmStatistics";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public CmStatistics merge(CmStatistics detachedInstance) {
        log.debug("merging CmStatistics instance");
        try {
            CmStatistics result = (CmStatistics) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CmStatistics instance) {
        log.debug("attaching dirty CmStatistics instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(CmStatistics instance) {
        log.debug("attaching clean CmStatistics instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static CmStatisticsDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (CmStatisticsDAO) ctx.getBean("CmStatisticsDAO");
	}
}