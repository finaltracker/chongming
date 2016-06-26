package com.san.chengxin.common.dto;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * DTO抽象基类
 * @author shmilyLT
 *
 */
public abstract class BaseDto implements Serializable{
	protected final Log log = LogFactory.getLog(getClass());
	
	//当前页数
	protected int pageNo = 0;
	
	//每页显示数据
	protected int pageSize = 0;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
