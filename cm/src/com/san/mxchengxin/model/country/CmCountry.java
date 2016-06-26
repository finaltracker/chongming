package com.san.mxchengxin.model.country;

/**
 * CmCountry entity. @author MyEclipse Persistence Tools
 */
public class CmCountry extends AbstractCmCountry implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public CmCountry() {
	}

	/** minimal constructor */
	public CmCountry(String name, String contact, Long pubdate) {
		super(name, contact, pubdate);
	}

	/** full constructor */
	public CmCountry(Short parentid, Short displayOrder, String name,
			String contact, String phone, Long pubdate, String author) {
		super(parentid, displayOrder, name, contact, phone, pubdate, author);
	}

}
