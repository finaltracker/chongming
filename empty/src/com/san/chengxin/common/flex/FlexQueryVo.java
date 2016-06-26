package com.san.chengxin.common.flex;

import java.util.List;

import com.san.chengxin.common.vo.BaseVo;

/**
 * Flex 查询条件Vo
 * @author shmilyLT
 *
 */
public class FlexQueryVo{
	
	/** 0 – 输入文本框 */
	public static final String shuRFS_0 = "0";
	
	/** 1 – 输入数值控件 */
	public static final String shuRFS_1 = "1";
	
	/** 2 – 输入日期控件 */
	public static final String shuRFS_2 = "2";
	
	/** 3 – 下拉列表 */
	private static final String shuRFS_3 = "3";
	
	
	/** 0 – 单条件输入 */
	public static final String shuRLX_0 = "0";
	
	/** 1 – 范围条件输入 */
	public static final String shuRLX_1 = "1";
	
	
	/** 字段名称 */
	private String mingC;
	
	/** 显示字段名称 */
	private String xianSMC;
	
	/** 输入方式 */
	private String shuRFS;
	
	/** 输入类型 */
	private String shuRLX;
	
	/** 下拉列表数据 */
	private List itemDatas;
	
	/**
	 * 下拉框构造函数
	 * @param mingC 字段名称
	 * @param xianSMC 显示字段名称
	 * @param shuRLX 输入类型
	 * @param item_data 下拉列表数据
	 */
	public FlexQueryVo(String mingC,String xianSMC,String shuRLX,List itemDatas) {
		this.shuRFS = shuRFS_3;
		
		this.mingC = mingC;
		this.xianSMC = xianSMC;
		this.shuRLX = shuRLX;
		this.itemDatas = itemDatas;
	}
	
	/**
	 * 非下拉框构造函数
	 * @param mingC 字段名称
	 * @param xianSMC 显示字段名称
	 * @param shuRFS 输入方式
	 * @param shuRLX 输入类型
	 */
	public FlexQueryVo(String mingC,String xianSMC,String shuRFS,String shuRLX) {
		this.mingC = mingC;
		this.xianSMC = xianSMC;
		this.shuRFS = shuRFS;
		this.shuRLX = shuRLX;
	}

	public String getMingC() {
		return mingC;
	}

	public void setMingC(String mingC) {
		this.mingC = mingC;
	}

	public String getXianSMC() {
		return xianSMC;
	}

	public void setXianSMC(String xianSMC) {
		this.xianSMC = xianSMC;
	}

	public String getShuRFS() {
		return shuRFS;
	}

	public void setShuRFS(String shuRFS) {
		this.shuRFS = shuRFS;
	}

	public String getShuRLX() {
		return shuRLX;
	}

	public void setShuRLX(String shuRLX) {
		this.shuRLX = shuRLX;
	}

	public List getItemDatas() {
		return itemDatas;
	}

	public void setItemDatas(List itemDatas) {
		this.itemDatas = itemDatas;
	}

	
}
