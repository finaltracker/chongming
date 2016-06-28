package com.san.mxchengxin.model.country;

/**
 * AbstractCmPerson entity provides the base persistence definition of the
 * CmPerson entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCmPerson implements java.io.Serializable {

	// Fields

	private Integer id;
	private String truename;
	private String ssid;
	private String sex;
	private String zzmm;
	private String whcd;
	private Short countryId;
	private String phone;
	private String birthday;
	private String address;
	private Integer score;
	private Long pubdate;
	private String author;
	private Boolean stat;
	private String remark;
	private Long partId;

	// Constructors

	/** default constructor */
	public AbstractCmPerson() {
	}

	/** minimal constructor */
	public AbstractCmPerson(String truename, String ssid, String author) {
		this.truename = truename;
		this.ssid = ssid;
		this.author = author;
	}

	/** full constructor */
	public AbstractCmPerson(String truename, String ssid, String sex,
			String zzmm, String whcd, Short countryId, String phone,
			String birthday, String address, Integer score, Long pubdate,
			String author, Boolean stat, String remark, Long partId) {
		this.truename = truename;
		this.ssid = ssid;
		this.sex = sex;
		this.zzmm = zzmm;
		this.whcd = whcd;
		this.countryId = countryId;
		this.phone = phone;
		this.birthday = birthday;
		this.address = address;
		this.score = score;
		this.pubdate = pubdate;
		this.author = author;
		this.stat = stat;
		this.remark = remark;
		this.partId = partId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTruename() {
		return this.truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getSsid() {
		return this.ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getZzmm() {
		return this.zzmm;
	}

	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}

	public String getWhcd() {
		return this.whcd;
	}

	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}

	public Short getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Short countryId) {
		this.countryId = countryId;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Long getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(Long pubdate) {
		this.pubdate = pubdate;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Boolean getStat() {
		return this.stat;
	}

	public void setStat(Boolean stat) {
		this.stat = stat;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getPartId() {
		return this.partId;
	}

	public void setPartId(Long partId) {
		this.partId = partId;
	}

}