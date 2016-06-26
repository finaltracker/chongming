package com.san.mxchengxin.model.country;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * CmCountry entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.san.mxchengxin.model.country.CmCountry
 * @author MyEclipse Persistence Tools
 */

public class CmCountryDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(CmCountryDAO.class);
	// property constants
	public static final String PARENTID = "parentid";
	public static final String DISPLAY_ORDER = "displayOrder";
	public static final String NAME = "name";
	public static final String CONTACT = "contact";
	public static final String PHONE = "phone";
	public static final String PUBDATE = "pubdate";
	public static final String AUTHOR = "author";

	protected void initDao() {
		// do nothing
	}

	public void save(CmCountry transientInstance) {
		log.debug("saving CmCountry instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CmCountry persistentInstance) {
		log.debug("deleting CmCountry instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CmCountry findById(java.lang.Short id) {
		log.debug("getting CmCountry instance with id: " + id);
		try {
			CmCountry instance = (CmCountry) getHibernateTemplate().get(
					"com.san.chengxin.model.part.CmCountry", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CmCountry instance) {
		log.debug("finding CmCountry instance by example");
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
		log.debug("finding CmCountry instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CmCountry as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByParentid(Object parentid) {
		return findByProperty(PARENTID, parentid);
	}

	public List findByDisplayOrder(Object displayOrder) {
		return findByProperty(DISPLAY_ORDER, displayOrder);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByContact(Object contact) {
		return findByProperty(CONTACT, contact);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByPubdate(Object pubdate) {
		return findByProperty(PUBDATE, pubdate);
	}

	public List findByAuthor(Object author) {
		return findByProperty(AUTHOR, author);
	}

	public List findAll() {
		log.debug("finding all CmCountry instances");
		try {
			String queryString = "from CmCountry";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CmCountry merge(CmCountry detachedInstance) {
		log.debug("merging CmCountry instance");
		try {
			CmCountry result = (CmCountry) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CmCountry instance) {
		log.debug("attaching dirty CmCountry instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CmCountry instance) {
		log.debug("attaching clean CmCountry instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CmCountryDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CmCountryDAO) ctx.getBean("CmCountryDAO");
	}
}