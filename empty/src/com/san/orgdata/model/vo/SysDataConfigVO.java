package com.san.orgdata.model.vo;

public class SysDataConfigVO {

	
	/**
	 * 机构编码
	 */
	String ouid;
	/**
	 * 机构名称
	 */
	String ouname;
	/**
	 * 顺序
	 */
	String displayorder;
	/**
	 * 表id
	 */
	String tableid;
	
	
	/**
	 * 业务类别('1登记类','2 管理类','3 监管类','4 资质类' )
	 */
	String ywlb;  
	/**
	 * 数据类型（1 自然人，0 法人）
	 */
	String sjlx;  
	/**
	 * 开放等级
	 */
	String kfdj; 
	/**
	 * 顺序
	 */
	String shunx;  
	/**
	 * 字段编号
	 */
	String fieldid;   


	/**
	 * 是否显示
	 */
	String sfxs;
	
	/**
	 * 是否主键    
	 */
	String sfzj;
	
	/**
	 * 显示顺序
	 */
	String xsxx;

	
	/**
	 * 表、字段中文名	
	 */
	String cname;
	/**
	 * 表、字段英文名	
	 */
	String ename;
	
	
	public String getOuid() {
		return ouid;
	}

	public void setOuid(String ouid) {
		this.ouid = ouid;
	}

	public String getOuname() {
		return ouname;
	}

	public void setOuname(String ouname) {
		this.ouname = ouname;
	}

	public String getDisplayorder() {
		return displayorder;
	}

	public void setDisplayorder(String displayorder) {
		this.displayorder = displayorder;
	}

	public String getTableid() {
		return tableid;
	}

	public void setTableid(String tableid) {
		this.tableid = tableid;
	}

	

	public String getYwlb() {
		return ywlb;
	}

	public void setYwlb(String ywlb) {
		this.ywlb = ywlb;
	}

	public String getSjlx() {
		return sjlx;
	}

	public void setSjlx(String sjlx) {
		this.sjlx = sjlx;
	}

	public String getKfdj() {
		return kfdj;
	}

	public void setKfdj(String kfdj) {
		this.kfdj = kfdj;
	}

	public String getShunx() {
		return shunx;
	}

	public void setShunx(String shunx) {
		this.shunx = shunx;
	}

	public String getFieldid() {
		return fieldid;
	}

	public void setFieldid(String fieldid) {
		this.fieldid = fieldid;
	}

	public String getSfxs() {
		return sfxs;
	}

	public void setSfxs(String sfxs) {
		this.sfxs = sfxs;
	}

	public String getSfzj() {
		return sfzj;
	}

	public void setSfzj(String sfzj) {
		this.sfzj = sfzj;
	}

	public String getXsxx() {
		return xsxx;
	}

	public void setXsxx(String xsxx) {
		this.xsxx = xsxx;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	} 
	
	
}
