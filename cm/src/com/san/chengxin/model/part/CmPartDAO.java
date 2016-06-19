package com.san.chengxin.model.part;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * CmPart entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.san.chengxin.model.part.CmPart
 * @author MyEclipse Persistence Tools
 */

public class CmPartDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(CmPartDAO.class);
	// property constants
	public static final String PART_NAME = "partName";

	protected void initDao() {
		// do nothing
	}

	public void save(CmPart transientInstance) {
		log.debug("saving CmPart instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CmPart persistentInstance) {
		log.debug("deleting CmPart instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CmPart findById(java.lang.Short id) {
		log.debug("getting CmPart instance with id: " + id);
		try {
			CmPart instance = (CmPart) getHibernateTemplate().get(
					"com.san.chengxin.model.part.CmPart", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CmPart instance) {
		log.debug("finding CmPart instance by example");
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
		log.debug("finding CmPart instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CmPart as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPartName(Object partName) {
		return findByProperty(PART_NAME, partName);
	}

	public List findAll() {
		log.debug("finding all CmPart instances");
		try {
			String queryString = "from CmPart";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CmPart merge(CmPart detachedInstance) {
		log.debug("merging CmPart instance");
		try {
			CmPart result = (CmPart) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CmPart instance) {
		log.debug("attaching dirty CmPart instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CmPart instance) {
		log.debug("attaching clean CmPart instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CmPartDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CmPartDAO) ctx.getBean("CmPartDAO");
	}
}