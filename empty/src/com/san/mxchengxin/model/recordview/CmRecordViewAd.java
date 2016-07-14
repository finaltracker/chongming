package com.san.mxchengxin.model.recordview;
import com.san.mxchengxin.utils.util;

public class CmRecordViewAd extends CmRecordViewId {

	String stringPubData;
	String countryName;
	String levelName;
	
	public CmRecordViewAd(CmRecordViewId in) {
		this.setAuthor(in.getAuthor());
		this.setId(in.getId());
		this.setCountryId(in.getCountryId());
		this.setScore(in.getScore());
		this.setSsid(in.getSsid());
		this.setStat(in.getStat());
		this.setTruename(in.getTruename());
		this.setPubdate(in.getPubdate());
		this.setDateline(in.getDateline());
		this.setPersonId(in.getPersonId());
		this.setStat(in.getStat());
		this.setTargetId(in.getTargetId());
		this.setTargetName(in.getTargetName());
	}
	
	public String getstringPubData() {
		return util.dateLongToString( this.getPubdate());
	}

	public void setstringPubData(String stringPubData) {
		this.stringPubData = stringPubData;
	}
	
	public String getCountryName() {
		return countryName;
	}
	
	public void setCountryName(String v) {
		this.countryName = v;
	}
	
	public String getLevelName() {
		return levelName;
	}
	
	public void setLevelName(String v) {
		this.levelName = v;
	}

}
