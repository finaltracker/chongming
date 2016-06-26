package com.san.chengxin.common.model.t0100;

import java.lang.Comparable;
import java.io.Serializable;

import com.san.chengxin.common.model.t0100.T0100OperationCode;

/**
 * This is an object that contains data related to the T0100_OPERATION_CODE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="T0100_OPERATION_CODE"
 */

public abstract class BaseT0100OperationCode  implements Comparable, Serializable {

	public static String REF = "T0100OperationCode";
	public static String PROP_TYPE = "Type";
	public static String PROP_ATTRIBUTE = "Attribute";
	public static String PROP_CONTENT = "Content";
	public static String PROP_ID = "Id";


	// constructors
	public BaseT0100OperationCode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseT0100OperationCode (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseT0100OperationCode (
		java.lang.String id,
		java.lang.String type) {

		this.setId(id);
		this.setType(type);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String content;
	private java.lang.String type;
	private java.lang.String attribute;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="Code"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: CONTENT
	 */
	public java.lang.String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: CONTENT
	 * @param content the CONTENT value
	 */
	public void setContent (java.lang.String content) {
		this.content = content;
	}



	/**
	 * Return the value associated with the column: TYPE
	 */
	public java.lang.String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: TYPE
	 * @param type the TYPE value
	 */
	public void setType (java.lang.String type) {
		this.type = type;
	}



	/**
	 * Return the value associated with the column: ATTRIBUTE
	 */
	public java.lang.String getAttribute () {
		return attribute;
	}

	/**
	 * Set the value related to the column: ATTRIBUTE
	 * @param attribute the ATTRIBUTE value
	 */
	public void setAttribute (java.lang.String attribute) {
		this.attribute = attribute;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof T0100OperationCode)) return false;
		else {
			T0100OperationCode t0100OperationCode = (T0100OperationCode) obj;
			if (null == this.getId() || null == t0100OperationCode.getId()) return false;
			else return (this.getId().equals(t0100OperationCode.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public int compareTo (Object obj) {
		if (obj.hashCode() > hashCode()) return 1;
		else if (obj.hashCode() < hashCode()) return -1;
		else return 0;
	}

	public String toString () {
		return super.toString();
	}


}