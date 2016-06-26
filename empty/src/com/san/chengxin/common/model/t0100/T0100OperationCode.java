package com.san.chengxin.common.model.t0100;

import com.san.chengxin.common.model.t0100.BaseT0100OperationCode;



public class T0100OperationCode extends BaseT0100OperationCode {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public T0100OperationCode () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public T0100OperationCode (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public T0100OperationCode (
		java.lang.String id,
		java.lang.String type) {

		super (
			id,
			type);
	}

/*[CONSTRUCTOR MARKER END]*/

	
	public String flag = "";

	/**
	 * @return Returns the serialVersionUID.
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
/**
 * @return Returns the flag.
 */
	public String getFlag() {
		return flag;
	}
	/**
	 * @param flag The flag to set.
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
}