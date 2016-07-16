package com.san.mxchengxin.model.country;

/**
 * AbstractCmCountry entity provides the base persistence definition of the
 * CmCountry entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCmCountry implements java.io.Serializable {

	// Fields

	private Short id;
	private Short parentid;
	private Short displayOrder;
	private String name;
	private String contact;
	private String phone;
	private Long pubdate;
	private String author;

	// Constructors

	/** default constructor */
	public AbstractCmCountry() {
	}

	/** minimal constructor */
	public AbstractCmCountry(String name, String contact, Long pubdate) {
		this.name = name;
		this.contact = contact;
		this.pubdate = pubdate;
		id = -1; 
		parentid = 0;
		displayOrder = 0;
		phone = "";
		author = "";
	}

	/** full constructor */
	public AbstractCmCountry(Short parentid, Short displayOrder, String name,
			String contact, String phone, Long pubdate, String author) {
		this.parentid = parentid;
		this.displayOrder = displayOrder;
		this.name = name;
		this.contact = contact;
		this.phone = phone;
		this.pubdate = pubdate;
		this.author = author;
	}

	// Property accessors

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public Short getParentid() {
		return this.parentid;
	}

	public void setParentid(Short parentid) {
		this.parentid = parentid;
	}

	public Short getDisplayOrder() {
		return this.displayOrder;
	}

	public void setDisplayOrder(Short displayOrder) {
		this.displayOrder = displayOrder;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

}