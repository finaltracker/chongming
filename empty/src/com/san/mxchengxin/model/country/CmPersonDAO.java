package com.san.mxchengxin.model.country;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * CmPerson entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.san.mxchengxin.model.country.CmPerson
 * @author MyEclipse Persistence Tools
 */

public class CmPersonDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(CmPersonDAO.class);
	// property constants
	public static final String TRUENAME = "truename";
	public static final String SSID = "ssid";
	public static final String SEX = "sex";
	public static final String ZZMM = "zzmm";
	public static final String WHCD = "whcd";
	public static final String COUNTRY_ID = "countryId";
	public static final String PHONE = "phone";
	public static final String BIRTHDAY = "birthday";
	public static final String ADDRESS = "address";
	public static final String SCORE = "score";
	public static final String PUBDATE = "pubdate";
	public static final String AUTHOR = "author";
	public static final String STAT = "stat";
	public static final String REMARK = "remark";
	public static final String PART_ID = "partId";

	protected void initDao() {
		// do nothing
	}

	public void save(CmPerson transientInstance) {
		log.debug("saving CmPerson instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	public void update(CmPerson transientInstance) {
		log.debug("updating CmPerson instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	public void delete(CmPerson persistentInstance) {
		log.debug("deleting CmPerson instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Integer getMaxId() {
		DetachedCriteria maxId = DetachedCriteria.forClass(CmPerson.class).setProjection(Projections.max("id"));
		List<CmPerson> results = getSession().createCriteria(CmPerson.class).add(Property.forName("id").eq(maxId)).list();
		return results.get(0).getId();
	}
	
	public CmPerson findById(java.lang.Integer id) {
		log.debug("getting CmPerson instance with id: " + id);
		try {
			CmPerson instance = (CmPerson) getHibernateTemplate().get(
					"com.san.mxchengxin.model.country.CmPerson", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CmPerson instance) {
		log.debug("finding CmPerson instance by example");
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
		log.debug("finding CmPerson instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CmPerson as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTruename(Object truename) {
		return findByProperty(TRUENAME, truename);
	}

	public List findBySsid(Object ssid) {
		return findByProperty(SSID, ssid);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByZzmm(Object zzmm) {
		return findByProperty(ZZMM, zzmm);
	}

	public List findByWhcd(Object whcd) {
		return findByProperty(WHCD, whcd);
	}

	public List findByCountryId(Object countryId) {
		return findByProperty(COUNTRY_ID, countryId);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByBirthday(Object birthday) {
		return findByProperty(BIRTHDAY, birthday);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByScore(Object score) {
		return findByProperty(SCORE, score);
	}

	public List findByPubdate(Object pubdate) {
		return findByProperty(PUBDATE, pubdate);
	}

	public List findByAuthor(Object author) {
		return findByProperty(AUTHOR, author);
	}

	public List findByStat(Object stat) {
		return findByProperty(STAT, stat);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByPartId(Object partId) {
		return findByProperty(PART_ID, partId);
	}

	public List findAll() {
		log.debug("finding all CmPerson instances");
		try {
			String queryString = "from CmPerson";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CmPerson merge(CmPerson detachedInstance) {
		log.debug("merging CmPerson instance");
		try {
			CmPerson result = (CmPerson) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CmPerson instance) {
		log.debug("attaching dirty CmPerson instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CmPerson instance) {
		log.debug("attaching clean CmPerson instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CmPersonDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CmPersonDAO) ctx.getBean("CmPersonDAO");
	}
}