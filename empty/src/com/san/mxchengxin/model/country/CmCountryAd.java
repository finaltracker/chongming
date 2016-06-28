package com.san.mxchengxin.model.country;

public class CmCountryAd extends CmCountry {
	String parentName;
	
	
	public CmCountryAd(CmCountry in) {
		this.setAuthor(in.getAuthor());
		this.setContact(in.getContact());
		this.setDisplayOrder(in.getDisplayOrder());
		this.setId(in.getId());
		this.setName(in.getName());
		this.setParentid(in.getParentid());
		this.setPhone(in.getPhone());
		this.setPubdate(in.getPubdate());
	}
	
	
	public void setParentName(String v) {
		parentName = v;
	}
	
	public String getParentName() {
		return parentName;
	}

}
