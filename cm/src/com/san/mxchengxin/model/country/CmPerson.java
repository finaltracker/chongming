package com.san.mxchengxin.model.country;

/**
 * CmPerson entity. @author MyEclipse Persistence Tools
 */
public class CmPerson extends AbstractCmPerson implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public CmPerson() {
	}

	/** minimal constructor */
	public CmPerson(String truename, String ssid, String author) {
		super(truename, ssid, author);
	}

	/** full constructor */
	public CmPerson(String truename, String ssid, String sex, String zzmm,
			String whcd, Short countryId, String phone, String birthday,
			String address, Integer score, Long pubdate, String author,
			Boolean stat, String remark, Long partId) {
		super(truename, ssid, sex, zzmm, whcd, countryId, phone, birthday,
				address, score, pubdate, author, stat, remark, partId);
	}

}
