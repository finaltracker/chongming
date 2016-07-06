package com.san.mxchengxin.objects;

import java.util.HashMap;
import java.util.Map;

import com.san.mxchengxin.model.country.CmCountry;
import com.san.mxchengxin.model.record.CmRecord;

public class CountryMapObj {
	public CmCountry   country;
	public Map< Short , CmCountry > sonList = new HashMap < Short , CmCountry >();
	
	
	public CountryMapObj( CmCountry   country )
	{
		this.country = country;
	}
	
	public void addSon( CmCountry son )
	{
		sonList.put( son.getId() , son );
	}
}
