package com.san.mxchengxin;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.san.mxchengxin.action.ChengxinBaseAction;
import com.san.mxchengxin.model.country.CmPersonDAO;
import com.san.mxchengxin.model.record.CmRecord;
import com.san.mxchengxin.model.record.CmRecordDAO;
import com.san.mxchengxin.model.statistics.CmStatisticsDAO;
import com.san.mxchengxin.model.target.CmTarget;

public class DayGuardJobBean extends QuartzJobBean {

	private CmRecordDAO cmRecordDAO;
	private CmPersonDAO 	cmPersonDAO;
	private CmStatisticsDAO	cmStatisticsDAO;
	
	public CmRecordDAO getCmRecordDAO() {
		return cmRecordDAO;
	}

	public void setCmRecordDAO(CmRecordDAO cmRecordDAO) {
		this.cmRecordDAO = cmRecordDAO;
	}

	public CmPersonDAO getCmPersonDAO() {
		return cmPersonDAO;
	}

	public void setCmPersonDAO(CmPersonDAO cmPersonDAO) {
		this.cmPersonDAO = cmPersonDAO;
	}

	public CmStatisticsDAO getCmStatisticsDAO() {
		return cmStatisticsDAO;
	}

	public void setCmStatisticsDAO(CmStatisticsDAO cmStatisticsDAO) {
		this.cmStatisticsDAO = cmStatisticsDAO;
	}

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {

		Calendar   curentTime= Calendar.getInstance(); // 当前时间
		System.out.println("current time:" + curentTime.get( Calendar.HOUR_OF_DAY) + ":" + + curentTime.get( Calendar.MINUTE ) );
		//找到今天过期的那些记录
		long currentTimeForSecond = curentTime.getTimeInMillis()/1000; // 当前时间 s
		long preDaySameTimeForSecond = currentTimeForSecond - 24 * 60 * 60;// 上一天的当前时间
		
/* 设置查询target表条件 */
		DetachedCriteria searDc =	DetachedCriteria.forClass( CmRecord.class);
		
		searDc.add(Restrictions.between("dateline", preDaySameTimeForSecond , currentTimeForSecond  )); 
		
		List<CmRecord> targetList = cmRecordDAO.getHibernateTemplate ().findByCriteria( searDc );
		
		for( int i = 0 ; i < targetList.size() ; i++ )
		{
			CmRecord cr = targetList.get(i);
			ChengxinBaseAction.adjustStatisticsForPerson(cmRecordDAO , cmStatisticsDAO , cmPersonDAO , cr.getPerson().getId() );
			
		}
		
	}
	
	
}