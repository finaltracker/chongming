package com.san.mxchengxin.model.country;

import com.san.chengxin.utils.util;

public class CmPersonAd extends CmPerson {
	String stringPubData;
	String countryName;
	
	
	public CmPersonAd(CmPerson in) {
		this.setAuthor(in.getAuthor());
		this.setAddress(in.getAddress());
		this.setBirthday(in.getBirthday());
		this.setId(in.getId());
		this.setCountryId(in.getCountryId());
		this.setPartId(in.getPartId());
		this.setPhone(in.getPhone());
		this.setRemark(in.getRemark());
		this.setScore(in.getScore());
		this.setSex(in.getSex());
		this.setSsid(in.getSsid());
		this.setStat(in.getStat());
		this.setTruename(in.getTruename());
		this.setWhcd(in.getWhcd());
		this.setZzmm(in.getZzmm());
		this.setPubdate(in.getPubdate());
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

}
