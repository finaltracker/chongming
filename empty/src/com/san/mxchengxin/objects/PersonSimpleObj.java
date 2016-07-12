package com.san.mxchengxin.objects;

public class PersonSimpleObj {

	private String truename;
	private String ssid;
	private String id;
	private String countryName;
	
	
	
	public PersonSimpleObj(String truename, String ssid, String id,
			String countryName) {
		super();
		this.truename = truename;
		this.ssid = ssid;
		this.id = id;
		this.countryName = countryName;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
