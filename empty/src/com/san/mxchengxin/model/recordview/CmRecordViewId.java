package com.san.mxchengxin.model.recordview;

/**
 * CmRecordViewId entity. @author MyEclipse Persistence Tools
 */

public class CmRecordViewId implements java.io.Serializable {

	// Fields

	private Integer id;
	private Short score;
	private Boolean stat;
	private Long dateline;
	private Integer personId;
	private Integer targetId;
	private String author;
	private Long pubdate;
	private String truename;
	private String ssid;
	private Short countryId;
	private String targetName;

	// Constructors

	/** default constructor */
	public CmRecordViewId() {
	}

	/** minimal constructor */
	public CmRecordViewId(Integer id, Short score, Integer personId,
			Integer targetId, String author, Long pubdate) {
		this.id = id;
		this.score = score;
		this.personId = personId;
		this.targetId = targetId;
		this.author = author;
		this.pubdate = pubdate;
	}

	/** full constructor */
	public CmRecordViewId(Integer id, Short score, Boolean stat, Long dateline,
			Integer personId, Integer targetId, String author, Long pubdate,
			String truename, String ssid, Short countryId, String targetName) {
		this.id = id;
		this.score = score;
		this.stat = stat;
		this.dateline = dateline;
		this.personId = personId;
		this.targetId = targetId;
		this.author = author;
		this.pubdate = pubdate;
		this.truename = truename;
		this.ssid = ssid;
		this.countryId = countryId;
		this.targetName = targetName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getScore() {
		return this.score;
	}

	public void setScore(Short score) {
		this.score = score;
	}

	public Boolean getStat() {
		return this.stat;
	}

	public void setStat(Boolean stat) {
		this.stat = stat;
	}

	public Long getDateline() {
		return this.dateline;
	}

	public void setDateline(Long dateline) {
		this.dateline = dateline;
	}

	public Integer getPersonId() {
		return this.personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public Integer getTargetId() {
		return this.targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(Long pubdate) {
		this.pubdate = pubdate;
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

	public Short getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Short countryId) {
		this.countryId = countryId;
	}

	public String getTargetName() {
		return this.targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CmRecordViewId))
			return false;
		CmRecordViewId castOther = (CmRecordViewId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getScore() == castOther.getScore()) || (this
						.getScore() != null && castOther.getScore() != null && this
						.getScore().equals(castOther.getScore())))
				&& ((this.getStat() == castOther.getStat()) || (this.getStat() != null
						&& castOther.getStat() != null && this.getStat()
						.equals(castOther.getStat())))
				&& ((this.getDateline() == castOther.getDateline()) || (this
						.getDateline() != null
						&& castOther.getDateline() != null && this
						.getDateline().equals(castOther.getDateline())))
				&& ((this.getPersonId() == castOther.getPersonId()) || (this
						.getPersonId() != null
						&& castOther.getPersonId() != null && this
						.getPersonId().equals(castOther.getPersonId())))
				&& ((this.getTargetId() == castOther.getTargetId()) || (this
						.getTargetId() != null
						&& castOther.getTargetId() != null && this
						.getTargetId().equals(castOther.getTargetId())))
				&& ((this.getAuthor() == castOther.getAuthor()) || (this
						.getAuthor() != null && castOther.getAuthor() != null && this
						.getAuthor().equals(castOther.getAuthor())))
				&& ((this.getPubdate() == castOther.getPubdate()) || (this
						.getPubdate() != null && castOther.getPubdate() != null && this
						.getPubdate().equals(castOther.getPubdate())))
				&& ((this.getTruename() == castOther.getTruename()) || (this
						.getTruename() != null
						&& castOther.getTruename() != null && this
						.getTruename().equals(castOther.getTruename())))
				&& ((this.getSsid() == castOther.getSsid()) || (this.getSsid() != null
						&& castOther.getSsid() != null && this.getSsid()
						.equals(castOther.getSsid())))
				&& ((this.getCountryId() == castOther.getCountryId()) || (this
						.getCountryId() != null
						&& castOther.getCountryId() != null && this
						.getCountryId().equals(castOther.getCountryId())))
				&& ((this.getTargetName() == castOther.getTargetName()) || (this
						.getTargetName() != null
						&& castOther.getTargetName() != null && this
						.getTargetName().equals(castOther.getTargetName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getScore() == null ? 0 : this.getScore().hashCode());
		result = 37 * result
				+ (getStat() == null ? 0 : this.getStat().hashCode());
		result = 37 * result
				+ (getDateline() == null ? 0 : this.getDateline().hashCode());
		result = 37 * result
				+ (getPersonId() == null ? 0 : this.getPersonId().hashCode());
		result = 37 * result
				+ (getTargetId() == null ? 0 : this.getTargetId().hashCode());
		result = 37 * result
				+ (getAuthor() == null ? 0 : this.getAuthor().hashCode());
		result = 37 * result
				+ (getPubdate() == null ? 0 : this.getPubdate().hashCode());
		result = 37 * result
				+ (getTruename() == null ? 0 : this.getTruename().hashCode());
		result = 37 * result
				+ (getSsid() == null ? 0 : this.getSsid().hashCode());
		result = 37 * result
				+ (getCountryId() == null ? 0 : this.getCountryId().hashCode());
		result = 37
				* result
				+ (getTargetName() == null ? 0 : this.getTargetName()
						.hashCode());
		return result;
	}

}