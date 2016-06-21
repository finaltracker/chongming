package com.san.chengxin.model.target;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.san.chengxin.utils.util;

public class CmTargetEnhance extends CmTarget {
	String partName;
	String stringPubData;
	
	public CmTargetEnhance( CmTarget in )
	{
		this.setId( in.getId() );
		this.setTargetName( in.getTargetName() );
		this.setTargetScore( in.getTargetScore() );
		this.setAuthor( in.getAuthor() );
		this.setPubdate( in.getPubdate() );
		this.setDateline( in.getDateline() );
		this.setPartId( in.getPartId());
	}
	
	
	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getstringPubData() {
		return util.dateLongToString( this.getPubdate());
	}

	public void setstringPubData(String stringPubData) {
		this.stringPubData = stringPubData;
	}

}
