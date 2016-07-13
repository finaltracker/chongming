package com.san.mxchengxin.objects;

import java.util.HashMap;
import java.util.Map;

import com.san.mxchengxin.model.country.CmCountry;
import com.san.mxchengxin.model.record.CmRecord;

public class CountryMapObj {
	public CmCountry   country;
	public Map< Short , CountryMapObj > sonList = new HashMap < Short , CountryMapObj >();
	
	
	public CmCountry getCountry() {
		return country;
	}

	public void setCountry(CmCountry country) {
		this.country = country;
	}

	public Map<Short, CountryMapObj> getSonList() {
		return sonList;
	}

	public void setSonList(Map<Short, CountryMapObj> sonList) {
		this.sonList = sonList;
	}


	
	public CountryMapObj( CmCountry   country )
	{
		this.country = country;
	}
	
	public void addSon( CmCountry son )
	{
		sonList.put( son.getId() , new CountryMapObj(son) );
	}
	
	public void addSon( CountryMapObj son )
	{
		sonList.put( son.getCountry().getId() , son );
	}
}
