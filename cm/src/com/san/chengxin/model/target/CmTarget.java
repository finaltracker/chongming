package com.san.chengxin.model.target;

/**
 * CmTarget entity. @author MyEclipse Persistence Tools
 */
public class CmTarget extends AbstractCmTarget implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public CmTarget() {
	}

	/** full constructor */
	public CmTarget(String targetName, Short targetScore, String author,
			Long pubdate, Long dateline, Short partId) {
		super(targetName, targetScore, author, pubdate, dateline, partId);
	}

}
