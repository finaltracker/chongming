package com.san.mxchengxin.model.target;

/**
 * AbstractCmTarget entity provides the base persistence definition of the
 * CmTarget entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCmTarget implements java.io.Serializable {

	// Fields

	private Short id;
	private String targetName;
	private Short targetScore;
	private String author;
	private Long pubdate;
	private Long dateline;
	private Short partId;

	// Constructors

	/** default constructor */
	public AbstractCmTarget() {
	}

	/** full constructor */
	public AbstractCmTarget(String targetName, Short targetScore,
			String author, Long pubdate, Long dateline, Short partId) {
		this.targetName = targetName;
		this.targetScore = targetScore;
		this.author = author;
		this.pubdate = pubdate;
		this.dateline = dateline;
		this.partId = partId;
	}

	// Property accessors

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getTargetName() {
		return this.targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public Short getTargetScore() {
		return this.targetScore;
	}

	public void setTargetScore(Short targetScore) {
		this.targetScore = targetScore;
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

	public Long getDateline() {
		return this.dateline;
	}

	public void setDateline(Long dateline) {
		this.dateline = dateline;
	}

	public Short getPartId() {
		return this.partId;
	}

	public void setPartId(Short partId) {
		this.partId = partId;
	}

}