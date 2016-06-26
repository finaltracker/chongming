/**
 * 
 */
package com.san.orgdata.action;

import org.apache.struts.action.ActionForm;

/**
 * 
 * <p>Title:[类标题] </p>
 * <p>Description: [类功能描述]</p>
 * <p>Copyright© 2014 Shanghai 30wish Information Security Co.,Ltd.</p>
 * <p>All right reserved.</p>
 * 
 * @version 1.0 
 * Created by [liangkd] [2014-12-24]
 * Midified by [修改人] [修改时间]
 * 
 */
public class OrgDataForm extends ActionForm {
	
	private String  querytype ;

	private String enterprise_id ;
	
	public String getEnterprise_id() {
		return enterprise_id;
	}

	public void setEnterprise_id(String enterprise_id) {
		this.enterprise_id = enterprise_id;
	}

	public String getQuerytype() {
		return querytype;
	}

	public void setQuerytype(String querytype) {
		this.querytype = querytype;
	}
	
}
