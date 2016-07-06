package com.san.mxchengxin.model.target;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.san.mxchengxin.model.country.CmCountry;
import com.san.mxchengxin.objects.CountryMapObj;

/**
 * A data access object (DAO) providing persistence and search support for
 * CmTarget entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.san.mxchengxin.model.target.CmTarget
 * @author MyEclipse Persistence Tools
 */

public class CmTargetDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(CmTargetDAO.class);
	// property constants
	public static final String TARGET_NAME = "targetName";
	public static final String TARGET_SCORE = "targetScore";
	public static final String AUTHOR = "author";
	public static final String PUBDATE = "pubdate";
	public static final String DATELINE = "dateline";
	public static final String PART_ID = "partId";

	protected void initDao() {
		// do nothing
	}

	public void save(CmTarget transientInstance) {
		log.debug("saving CmTarget instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(CmTarget transientInstance) {
		log.debug("updating CmTarget instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public void delete(CmTarget persistentInstance) {
		log.debug("deleting CmTarget instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CmTarget findById(java.lang.Short id) {
		log.debug("getting CmTarget instance with id: " + id);
		try {
			CmTarget instance = (CmTarget) getHibernateTemplate().get(
					"com.san.mxchengxin.model.target.CmTarget", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CmTarget instance) {
		log.debug("finding CmTarget instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CmTarget instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CmTarget as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTargetName(Object targetName) {
		return findByProperty(TARGET_NAME, targetName);
	}

	public List findByTargetScore(Object targetScore) {
		return findByProperty(TARGET_SCORE, targetScore);
	}

	public List findByAuthor(Object author) {
		return findByProperty(AUTHOR, author);
	}

	public List findByPubdate(Object pubdate) {
		return findByProperty(PUBDATE, pubdate);
	}

	public List findByDateline(Object dateline) {
		return findByProperty(DATELINE, dateline);
	}

	public List findByPartId(Object partId) {
		return findByProperty(PART_ID, partId);
	}

	public List findAll() {
		log.debug("finding all CmTarget instances");
		try {
			String queryString = "from CmTarget";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CmTarget merge(CmTarget detachedInstance) {
		log.debug("merging CmTarget instance");
		try {
			CmTarget result = (CmTarget) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CmTarget instance) {
		log.debug("attaching dirty CmTarget instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CmTarget instance) {
		log.debug("attaching clean CmTarget instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CmTargetDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CmTargetDAO) ctx.getBean("CmTargetDAO");
	}
	
	public Map< Short , CmTarget > listAsMap()
	{
		Map< Short , CmTarget > ret = new HashMap<Short , CmTarget >();
		
		List<CmTarget> all = findAll();
		
		for( int i = 0 ; i < all.size() ; i++ )
		{
			ret.put( all.get(i).getId(), all.get(i) );
		}
		
		return ret;
	}
	
	public String formatToJspString( List<CmTarget> all, Short selectId )
	{
		StringBuffer sb = new StringBuffer();
		
		/*
		 * option value='12'  target_score='100'>义务献血</option>
		*/
		
		 for ( int i = 0 ; i < all.size() ; i++ ) 
		 {
			 String s;
			 CmTarget ct = all.get(i);
			 
			 if( ( selectId != null ) && ( selectId == ct.getId() ) )
			 {
				 s = String.format("<option value='%d'  target_score='%d' selected >%s</option>", ct.getId() , ct.getTargetScore() , ct.getTargetName() );
			 }
			 else
			 {
				 s = String.format("<option value='%d'  target_score='%d' >%s</option>", ct.getId() , ct.getTargetScore() , ct.getTargetName() );
			 }
			 sb.append(s);
			 
		 }
		 

		return sb.toString();
	}
	
}