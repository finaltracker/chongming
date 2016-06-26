package com.san.chengxin.common.flex;

import java.util.List;

import com.san.chengxin.common.vo.BaseVo;

/**
 * Flex ��ѯ����Vo
 * @author shmilyLT
 *
 */
public class FlexQueryVo{
	
	/** 0 �C �����ı��� */
	public static final String shuRFS_0 = "0";
	
	/** 1 �C ������ֵ�ؼ� */
	public static final String shuRFS_1 = "1";
	
	/** 2 �C �������ڿؼ� */
	public static final String shuRFS_2 = "2";
	
	/** 3 �C �����б� */
	private static final String shuRFS_3 = "3";
	
	
	/** 0 �C ���������� */
	public static final String shuRLX_0 = "0";
	
	/** 1 �C ��Χ�������� */
	public static final String shuRLX_1 = "1";
	
	
	/** �ֶ����� */
	private String mingC;
	
	/** ��ʾ�ֶ����� */
	private String xianSMC;
	
	/** ���뷽ʽ */
	private String shuRFS;
	
	/** �������� */
	private String shuRLX;
	
	/** �����б����� */
	private List itemDatas;
	
	/**
	 * �������캯��
	 * @param mingC �ֶ�����
	 * @param xianSMC ��ʾ�ֶ�����
	 * @param shuRLX ��������
	 * @param item_data �����б�����
	 */
	public FlexQueryVo(String mingC,String xianSMC,String shuRLX,List itemDatas) {
		this.shuRFS = shuRFS_3;
		
		this.mingC = mingC;
		this.xianSMC = xianSMC;
		this.shuRLX = shuRLX;
		this.itemDatas = itemDatas;
	}
	
	/**
	 * ���������캯��
	 * @param mingC �ֶ�����
	 * @param xianSMC ��ʾ�ֶ�����
	 * @param shuRFS ���뷽ʽ
	 * @param shuRLX ��������
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
