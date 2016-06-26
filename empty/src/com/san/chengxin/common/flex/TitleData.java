package com.san.chengxin.common.flex;

/**
 * 表头信息
 * @author shmilyLT
 *
 */
public class TitleData {
	//字段英文名
	private String name;
	//字段中文名
	private String text;
	
	/**
	 * 构造函数
	 * @param name 英文名
	 * @param text 中文名
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
