package com.log.statistic.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the T608_Data_Usage_Statistic table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="T608_Data_Usage_Statistic"
 */

public abstract class BaseDataUsageStatistic  implements Comparable, Serializable {

	public static String REF = "DataUsageStatistic";
	public static String PROP_SUCCESS_FLAG = "SuccessFlag";
	public static String PROP_CHARGE = "Charge";
	public static String PROP_USAGE_METHOD = "UsageMethod";
	public static String PROP_USER_ID = "UserId";
	public static String PROP_OPERATE_DESC = "OperateDesc";
	public static String PROP_DEPARTMENT_NAME = "DepartmentName";
	public static String PROP_OPERATE_DATE = "OperateDate";
	public static String PROP_RESOURCE_TYPE = "ResourceType";
	public static String PROP_BYTE_COUNT = "ByteCount";
	public static String PROP_FIELD_NUM = "FieldNum";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_RESOURCE_ID = "ResourceId";
	public static String PROP_USER_NAME = "UserName";
	public static String PROP_ID = "Id";
	public static String PROP_LOGTYPE="logtype";
	public static String PROP_SQLINFO="sqlinfo";
	public static String PROP_POP1="pop1";
	public static String PROP_POP2="pop2";
	public static String PROP_POP3="pop3";

	// constructors
	public BaseDataUsageStatistic () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDataUsageStatistic (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer byteCount;
	private java.lang.Float charge;
	private java.lang.String departmentId;
	private java.lang.String departmentName;
	private java.lang.Integer fieldNum;
	private java.util.Date operateDate;
	private java.lang.String operateDesc;
	private java.lang.String resourceId;
	private java.lang.Short resourceType;
	private java.lang.Short successFlag;
	private java.lang.Short usageMethod;
	private java.lang.String userId;
	private java.lang.String userName;

	private java.lang.String logtype;

	private java.lang.String sqlinfo;
	private java.lang.String pop1;
	private java.lang.String pop2;
	private java.lang.String pop3;

	/**
	 * Return the value associated with the column: LOGTYPE
	 */
	public java.lang.String getLogtype () {
		return logtype;
	}

	/**
	 * Set the value related to the column: LOGTYPE
	 * @param logtype the LOGTYPE value
	 */
	public void setLogtype (java.lang.String logtype) {
		this.logtype = logtype;
	}

	
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="STATISTIC_ID"
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
	 * Return the value associated with the column: BYTE_COUNT
	 */
	public java.lang.Integer getByteCount () {
		return byteCount;
	}

	/**
	 * Set the value related to the column: BYTE_COUNT
	 * @param byteCount the BYTE_COUNT value
	 */
	public void setByteCount (java.lang.Integer byteCount) {
		this.byteCount = byteCount;
	}



	/**
	 * Return the value associated with the column: CHARGE
	 */
	public java.lang.Float getCharge () {
		return charge;
	}

	/**
	 * Set the value related to the column: CHARGE
	 * @param charge the CHARGE value
	 */
	public void setCharge (java.lang.Float charge) {
		this.charge = charge;
	}



	/**
	 * Return the value associated with the column: DEPARTMENT_ID
	 */
	public java.lang.String getDepartmentId () {
		return departmentId;
	}

	/**
	 * Set the value related to the column: DEPARTMENT_ID
	 * @param departmentId the DEPARTMENT_ID value
	 */
	public void setDepartmentId (java.lang.String departmentId) {
		this.departmentId = departmentId;
	}



	/**
	 * Return the value associated with the column: DEPARTMENT_NAME
	 */
	public java.lang.String getDepartmentName () {
		return departmentName;
	}

	/**
	 * Set the value related to the column: DEPARTMENT_NAME
	 * @param departmentName the DEPARTMENT_NAME value
	 */
	public void setDepartmentName (java.lang.String departmentName) {
		this.departmentName = departmentName;
	}



	/**
	 * Return the value associated with the column: FIELD_NUM
	 */
	public java.lang.Integer getFieldNum () {
		return fieldNum;
	}

	/**
	 * Set the value related to the column: FIELD_NUM
	 * @param fieldNum the FIELD_NUM value
	 */
	public void setFieldNum (java.lang.Integer fieldNum) {
		this.fieldNum = fieldNum;
	}



	/**
	 * Return the value associated with the column: OPERATE_DATE
	 */
	public java.util.Date getOperateDate () {
		return operateDate;
	}

	/**
	 * Set the value related to the column: OPERATE_DATE
	 * @param operateDate the OPERATE_DATE value
	 */
	public void setOperateDate (java.util.Date operateDate) {
		this.operateDate = operateDate;
	}



	/**
	 * Return the value associated with the column: OPERATE_DESC
	 */
	public java.lang.String getOperateDesc () {
		return operateDesc;
	}

	/**
	 * Set the value related to the column: OPERATE_DESC
	 * @param operateDesc the OPERATE_DESC value
	 */
	public void setOperateDesc (java.lang.String operateDesc) {
		this.operateDesc = operateDesc;
	}



	/**
	 * Return the value associated with the column: RESOURCE_ID
	 */
	public java.lang.String getResourceId () {
		return resourceId;
	}

	/**
	 * Set the value related to the column: RESOURCE_ID
	 * @param resourceId the RESOURCE_ID value
	 */
	public void setResourceId (java.lang.String resourceId) {
		this.resourceId = resourceId;
	}



	/**
	 * Return the value associated with the column: RESOURCE_TYPE
	 */
	public java.lang.Short getResourceType () {
		return resourceType;
	}

	/**
	 * Set the value related to the column: RESOURCE_TYPE
	 * @param resourceType the RESOURCE_TYPE value
	 */
	public void setResourceType (java.lang.Short resourceType) {
		this.resourceType = resourceType;
	}



	/**
	 * Return the value associated with the column: SUCCESS_FLAG
	 */
	public java.lang.Short getSuccessFlag () {
		return successFlag;
	}

	/**
	 * Set the value related to the column: SUCCESS_FLAG
	 * @param successFlag the SUCCESS_FLAG value
	 */
	public void setSuccessFlag (java.lang.Short successFlag) {
		this.successFlag = successFlag;
	}



	/**
	 * Return the value associated with the column: USAGE_METHOD
	 */
	public java.lang.Short getUsageMethod () {
		return usageMethod;
	}

	/**
	 * Set the value related to the column: USAGE_METHOD
	 * @param usageMethod the USAGE_METHOD value
	 */
	public void setUsageMethod (java.lang.Short usageMethod) {
		this.usageMethod = usageMethod;
	}



	/**
	 * Return the value associated with the column: USER_ID
	 */
	public java.lang.String getUserId () {
		return userId;
	}

	/**
	 * Set the value related to the column: USER_ID
	 * @param userId the USER_ID value
	 */
	public void setUserId (java.lang.String userId) {
		this.userId = userId;
	}



	/**
	 * Return the value associated with the column: USER_NAME
	 */
	public java.lang.String getUserName () {
		return userName;
	}

	/**
	 * Set the value related to the column: USER_NAME
	 * @param userName the USER_NAME value
	 */
	public void setUserName (java.lang.String userName) {
		this.userName = userName;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.log.statistic.DataUsageStatistic)) return false;
		else {
			com.log.statistic.DataUsageStatistic dataUsageStatistic = (com.log.statistic.DataUsageStatistic) obj;
			if (null == this.getId() || null == dataUsageStatistic.getId()) return false;
			else return (this.getId().equals(dataUsageStatistic.getId()));
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

	/**
	 * Return the value associated with the column: SQLINFO
	 */
	public java.lang.String getSqlinfo() {
		return sqlinfo;
	}

	/**
	 * Set the value related to the column: SQLINFO
	 * @param sqlinfo the SQLINFO value
	 */
	public void setSqlinfo(java.lang.String sqlinfo) {
		this.sqlinfo = sqlinfo;
	}

	/**
	 * Return the value associated with the column: POP1
	 */
	public java.lang.String getPop1() {
		return pop1;
	}

	/**
	 * Set the value related to the column: POP1
	 * @param pop1 the POP1 value
	 */
	public void setPop1(java.lang.String pop1) {
		this.pop1 = pop1;
	}

	/**
	 * Return the value associated with the column: POP2
	 */
	public java.lang.String getPop2() {
		return pop2;
	}

	/**
	 * Set the value related to the column: POP2
	 * @param pop2 the POP2 value
	 */
	public void setPop2(java.lang.String pop2) {
		this.pop2 = pop2;
	}

	
	/**
	 * Return the value associated with the column: POP3
	 */
	public java.lang.String getPop3() {
		return pop3;
	}

	/**
	 * Set the value related to the column: POP3
	 * @param pop3 the POP3 value
	 */
	public void setPop3(java.lang.String pop3) {
		this.pop3 = pop3;
	}


}