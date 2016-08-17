package com.san.mxchengxin.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.san.mxchengxin.model.country.CmPerson;
import com.san.mxchengxin.model.country.CmPersonDAO;
import com.san.mxchengxin.model.record.CmRecord;
import com.san.mxchengxin.model.record.CmRecordDAO;
import com.san.mxchengxin.model.statistics.CmStatistics;
import com.san.mxchengxin.model.statistics.CmStatisticsDAO;

public class util {

	static public String dateLongToString( long DataLong )
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date date= new Date(DataLong * 1000); //ms
        return sdf.format(date);
	}
	
	static public boolean isNumeric(String str){ 
		   Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
		}
	
	static public Short[] IntegerArrayToShortArray( Integer in[] )
	{
		Short[] out = new Short[in.length ];
		
		for( int i = 0 ; i < in.length ; i++ )
		{
			out[i] = in[i].shortValue();
		}
		
		return out;
	}
	
	
}
