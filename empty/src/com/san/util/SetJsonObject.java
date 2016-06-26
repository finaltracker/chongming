package com.san.util;

import java.util.List;

public class SetJsonObject{
  private int total = 0;
  private List rows;
  private List titleList;

  public SetJsonObject(Vo v){
	  this.rows=v.getList();
	  this.total=v.getPageCount();
  }
  public SetJsonObject(){}
  public int getTotal()
  {
    return this.total;
  }
  public void setTotal(int total) {
    this.total = total;
  }
  public List getRows() {
    return this.rows;
  }
  public void setRows(List rows) {
    this.rows = rows;
  }
public List getTitleList() {
	return titleList;
}
public void setTitleList(List titleList) {
	this.titleList = titleList;
}
}