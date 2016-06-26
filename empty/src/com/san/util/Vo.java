package com.san.util;

import com.san.chengxin.common.vo.BaseVo;
import java.util.List;

public class Vo extends BaseVo
{
  private List list;
public Vo(){}
  public List getList()
  {
    return this.list;
  }

  public void setList(List list) {
    this.list = list;
  }
}