package com.san.mxchengxin.model.part;

/**
 * AbstractCmPart entity provides the base persistence definition of the CmPart
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCmPart implements java.io.Serializable {

	// Fields

	private Short id;
	private String partName;

	// Constructors

	/** default constructor */
	public AbstractCmPart() {
	}

	/** full constructor */
	public AbstractCmPart(String partName) {
		this.partName = partName;
	}

	// Property accessors

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getPartName() {
		return this.partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

}