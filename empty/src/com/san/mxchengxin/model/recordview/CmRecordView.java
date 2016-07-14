package com.san.mxchengxin.model.recordview;

/**
 * CmRecordView entity. @author MyEclipse Persistence Tools
 */

public class CmRecordView implements java.io.Serializable {

	// Fields

	private CmRecordViewId id;
	
	// Constructors

	/** default constructor */
	public CmRecordView() {
	}

	/** full constructor */
	public CmRecordView(CmRecordViewId id) {
		this.id = id;
	}

	// Property accessors

	public CmRecordViewId getId() {
		return this.id;
	}

	public void setId(CmRecordViewId id) {
		this.id = id;
	}

}