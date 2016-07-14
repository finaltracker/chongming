package com.san.mxchengxin.model.recordview;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * CmRecordView entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.san.mxchengxin.model.recordview.CmRecordView
 * @author MyEclipse Persistence Tools
 */

public class CmRecordViewDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(CmRecordViewDAO.class);
	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(CmRecordView transientInstance) {
		log.debug("saving CmRecordView instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CmRecordView persistentInstance) {
		log.debug("deleting CmRecordView instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CmRecordView findById(com.san.mxchengxin.model.recordview.CmRecordViewId id) {
		log.debug("getting CmRecordView instance with id: " + id);
		try {
			CmRecordView instance = (CmRecordView) getHibernateTemplate().get(
					"com.san.mxchengxin.model.recordview.CmRecordView", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CmRecordView instance) {
		log.debug("finding CmRecordView instance by example");
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
		log.debug("finding CmRecordView instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CmRecordView as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all CmRecordView instances");
		try {
			String queryString = "from CmRecordView";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	

	public CmRecordView merge(CmRecordView detachedInstance) {
		log.debug("merging CmRecordView instance");
		try {
			CmRecordView result = (CmRecordView) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CmRecordView instance) {
		log.debug("attaching dirty CmRecordView instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CmRecordView instance) {
		log.debug("attaching clean CmRecordView instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CmRecordViewDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CmRecordViewDAO) ctx.getBean("CmRecordViewDAO");
	}
}