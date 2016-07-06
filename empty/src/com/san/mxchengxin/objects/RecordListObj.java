package com.san.mxchengxin.objects;

public class RecordListObj {

	private int    id;
	private String truename;
	private String ssid;
	private String countryName;
	private String target_name;
	private Short score;
	private String author;
	private String part_name;
	private String pubdate;
	private String dateline;
	
	public RecordListObj( 
			int    id ,
			String truename,
			String ssid,
			String countryName,
			String target_name,
			Short score,
			String author,
			String part_name,
			String pubdate,
			String dateline
			)
	{
		this.id  = id;
		this.truename = truename;
		this.ssid = ssid;
		this.countryName = countryName;
		this.target_name = target_name;
		this.score = score;
		this.author = author;
		this.part_name = part_name;
		this.pubdate = pubdate;
		this.dateline = dateline;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getTarget_name() {
		return target_name;
	}
	public void setTarget_name(String target_name) {
		this.target_name = target_name;
	}
	public Short getScore() {
		return score;
	}
	public void setScore(Short score) {
		this.score = score;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPart_name() {
		return part_name;
	}
	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public String getDateline() {
		return dateline;
	}
	public void setDateline(String dateline) {
		this.dateline = dateline;
	}
	
}
