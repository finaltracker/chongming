package com.san.mxchengxin.model.country;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.san.mxchengxin.model.part.CmPart;
import com.san.mxchengxin.objects.CountryMapObj;
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
	
	public void update(CmCountry transientInstance) {
		log.debug("updating CmCountry instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public List queryParentZero() {
		log.debug("query parent condition equal zero");
		Short parentId = 0;
		List ccs = getSession().createCriteria(CmCountry.class) 
				.add( Restrictions.eq("parentid", parentId) )
				.addOrder( Order.asc("displayOrder") ) 
				.addOrder( Order.asc("id") ) 
				.list(); 
		
		return ccs;
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
					"com.san.mxchengxin.model.country.CmCountry", id);
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
	
	public Map< Short , CmCountry > listAsMap()
	{
		Map< Short , CmCountry > ret = new HashMap<Short , CmCountry >();
		
		List<CmCountry> all = findAll();
		
		for( int i = 0 ; i < all.size() ; i++ )
		{
			ret.put( all.get(i).getId(), all.get(i) );
		}
		
		return ret;
	}
	

	
	
	public Map<Short, CountryMapObj > packCountryMapAsLevelByIdList( Short[] countryList )
	{
		List<CmCountry> list = new ArrayList<CmCountry>();
		
		for( int i = 0 ; i < countryList.length ; i++ )
		{
			list.add( (CmCountry)findById(countryList[i] ) );
		}
		
		return packCountryMapAsLevel( list );
	}
	
	
	public Map<Short, CountryMapObj > packCountryMapAsLevel( List list )
	{
		Map<Short, CountryMapObj> ret = new HashMap<Short, CountryMapObj>();
		Map<Short , CountryMapObj >lineCountryMap = new HashMap<Short, CountryMapObj>(); // 将对象排成一排
		
		//将 country 排成一列
		for( int i = 0 ; i < list.size() ; i++ )
		{
			CmCountry country = (CmCountry)list.get(i);
			
			if( country != null )
			{
				lineCountryMap.put( country.getId(), new CountryMapObj(country) );
			}
		}
		
		//组装成树形结构
		for( CountryMapObj cmo :  lineCountryMap.values() )
		{
			
			if( lineCountryMap.get( cmo.getCountry().getParentid() ) == null )
			{
				ret.put( cmo.getCountry().getId() , cmo );
			}
			else
			{
				lineCountryMap.get( cmo.getCountry().getParentid() ).addSon( cmo ) ;
			}
		
		}
		
		
		return ret;
	}
	
	//countryMap map by level
	public void formatToJspString( Map<Short, CountryMapObj > countryMap , Short selectId , int level , StringBuffer sb )
	{
		//StringBuffer sb = new StringBuffer();
		
		/*
		 * <option value='12' selected>乡镇</option>
		 * <option value='13' >村</option>
		*/
		String space = "";
		for( int i = 0 ; i < level ; i++ )
		{
			space += "&nbsp;&nbsp;";
		}
		
		 for (Short key : countryMap.keySet()) 
		 {
			 String s;
			 CountryMapObj cmo = countryMap.get( key );
			 
			 if( ( selectId != null ) && ( selectId == key.shortValue() ) )
			 {
				 s = String.format("<option value='%d' selected>" + space + "├─%s</option>", key , cmo.country.getName() );
			 }
			 else
			 {
				 s = String.format("<option value='%d'>" + space + "├─%s</option>", key , cmo.country.getName() );
			 }
			 sb.append(s);
			
			 if(cmo.getSonList() != null ) 
			 {
				 formatToJspString( cmo.getSonList() , selectId , level++ , sb );
			 }
		 }
		 
		 
		 return ;
	}
}