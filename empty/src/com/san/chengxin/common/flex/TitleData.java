package com.san.chengxin.common.flex;

/**
 * ��ͷ��Ϣ
 * @author shmilyLT
 *
 */
public class TitleData {
	//�ֶ�Ӣ����
	private String name;
	//�ֶ�������
	private String text;
	
	/**
	 * ���캯��
	 * @param name Ӣ����
	 * @param text ������
	 */
	public TitleData(String name,String text) {
		this.name = name;
		this.text = text;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
