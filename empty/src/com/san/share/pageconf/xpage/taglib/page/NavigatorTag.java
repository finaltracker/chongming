package com.san.share.pageconf.xpage.taglib.page;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class NavigatorTag extends TagSupport
{
  private String type = "BUTTON";

  public void setType(String newType) {
    this.type = newType;
  }

  public int doStartTag() throws JspException {
    try {
      String bar = getNavigatorBar(this.type);
      this.pageContext.getOut().write(bar);
      return 0;
    } catch (IOException ioe) {
    }
    throw new JspException();
  }

  public int doEndTag()
    throws JspException
  {
    return 6;
  }

  private String getNavigatorBar(String type)
  {
    String bar = "";
    String pageNo = ((Integer)this.pageContext.getAttribute("pageNo")).toString();
    String pages = ((Integer)this.pageContext.getAttribute("pages")).toString();
    String total = ((Integer)this.pageContext.getAttribute("total")).toString();
    String pageSize = ((Integer)this.pageContext.getAttribute("pageSize")).toString();
    String nextDisabled = "";
    String prevDisabled = ""; 
    if (Integer.parseInt(pageNo) >= Integer.parseInt(pages))
      nextDisabled = "disabled";
    if (Integer.parseInt(pageNo) <= 1)
      prevDisabled = "disabled";
    String pageSizeInputChanged = "onChange=\"document.forms.pager.choice.value='current';document.forms.pager.pageSize.value=this.value;document.forms.pager.submit();setpgsize(this.value);\">";

    String firstClicked = "onClick=\"document.forms.pager.pageNo.value=1;document.forms.pager.submit();return false;\">";
    String prevClicked = "onClick=\"document.forms.pager.pageNo.value=new Number(document.forms.pager.pageNo.value)-1;document.forms.pager.submit();return false;\">";
    String nextClicked = "onClick=\"document.forms.pager.pageNo.value=new Number(document.forms.pager.pageNo.value)+1;document.forms.pager.submit();return false;\">";
    String lastClicked = "onClick=\"document.forms.pager.pageNo.value=" + pages + ";document.forms.pager.submit();return false;\">";
    String pageNoInputChaneged = "onChange=\"this.value=(this.value>1)?this.value:1;this.value=(this.value<" + pages + ")?this.value:" + pages + ";document.forms.pager.pageNo.value=this.value\">";
    String submitButton = " <input type='submit' value='go' onClick=\"document.forms.pager.choice.value='current';\">\n";
 
    if (type.equalsIgnoreCase("BUTTON")) {
      String pageSizeInput = "<input id='pgsize' type='text' size='2' value='" + pageSize + "' " + 
        pageSizeInputChanged;
      String firstButton = "<input type='button' value='首  页' " + prevDisabled + " " + 
        firstClicked;
      String prevButton = "<input type='button' value='上一页' " + prevDisabled + " " + 
        prevClicked;
      String nextButton = "<input type='button' value='下一页' " + nextDisabled + " " + 
        nextClicked;
      String lastButton = "<input type='button' value='末  页' " + nextDisabled + " " + 
        lastClicked;
      String pageNoInput = "<input type='text' size='3' value='" + pageNo + "' " + 
        pageNoInputChaneged;

      bar = "每页" + pageSizeInput + "条记录 | \n" + 
        "共" + pages + "页/" + total + "条记录 | \n" + 
        firstButton + " \n " + prevButton + " \n " + nextButton + " \n " + lastButton + " \n | 第" + pageNoInput + "页\n" + 
        submitButton;
    }

    if (type.equalsIgnoreCase("TEXT")) {
      String pageSizeInput = "<input id='pgsize' type='text' size='2' value='" + pageSize + "' class='px1-table' " + 
        pageSizeInputChanged;
      String firstText = "首  页";
      String prevText = "上一页";
      String nextText = "下一页";
      String lastText = "末  页";
      if (prevDisabled.equalsIgnoreCase("")) {
        firstText = "<a href='javascript:{}' " + 
          firstClicked + 
          "首  页" + 
          "</a>";
        prevText = "<a href='javascript:{}' " + 
          prevClicked + 
          "上一页" + 
          "</a>";
      }
      if (nextDisabled.equalsIgnoreCase("")) {
        nextText = "<a href='javascript:{}' " + 
          nextClicked + 
          "下一页" + 
          "</a>";
        lastText = "<a href='javascript:{}' " + 
          lastClicked + 
          "末  页" + 
          "</a>";
      }
      String pageNoInput = "<input type='text' size='3' size='2' value='" + pageNo + "' class='px1-table' " + 
        pageNoInputChaneged;

      bar = "每页" + pageSizeInput + "条记录 | \n" + 
        "共" + pages + "页/" + total + "条记录 | \n" + 
        firstText + " \n " + prevText + " \n " + nextText + " \n " + lastText + " \n | 第" + pageNoInput + "页\n" + 
        submitButton;
    }

    if (type.equalsIgnoreCase("SIMPLEBUTTON")) {
      String pageSizeInput = "<input class='navbar' id='pgsize' type='text' size='1' value='" + pageSize + 
        "' " + 
        pageSizeInputChanged;
      String prevButton = "<input class='navbar' type='button' value='上一页' " + prevDisabled + 
        " " + 
        prevClicked;
      String nextButton = "<input class='navbar' type='button' value='下一页' " + nextDisabled + 
        " " + 
        nextClicked;
      String pageNoInput = "<input class='navbar' type='text' size='1' value='" + pageNo + 
        "' " + 
        pageNoInputChaneged;

      bar = "每页" + pageSizeInput + "条记录 | \n" + 
        "共" + pages + "页/" + total + "条记录 | \n" + 
        " \n " + prevButton + " \n " + nextButton + " \n | 第" + pageNoInput + "页\n" + 
        submitButton;
    }

    if (type.equalsIgnoreCase("SIMPLETEXT")) {
      String pageSizeInput = "<input type='text' id='pgsize' size='1' value='" + pageSize + "' class='px1-table' " + 
        pageSizeInputChanged;
      String firstText = "首  页";
      String prevText = "上一页";
      String nextText = "下一页";
      String lastText = "末  页";
      if (prevDisabled.equalsIgnoreCase("")) {
        firstText = "<a href='javascript:{}' " + 
          firstClicked + 
          "首  页" + 
          "</a>"; 
        prevText = "<a href='javascript:{}' " + 
          prevClicked + 
          "上一页" + 
          "</a>";
      }
      if (nextDisabled.equalsIgnoreCase("")) {
        nextText = "<a href='javascript:{}' " + 
          nextClicked + 
          "下一页" + 
          "</a>";
        lastText = "<a href='javascript:{}' " + 
          lastClicked + 
          "末  页" + 
          "</a>";
      }
      String pageNoInput = "<input type='text' size='1' value='" + pageNo + "' class='px1-table' " + 
        pageNoInputChaneged;

      bar = pageSizeInput + "条/页 | \n" + 
        "共" + pages + "页/共" + total + "条 | \n" + 
        prevText + " \n " + nextText + " \n | 第" + pageNoInput + "页\n" + 
        submitButton;
    }
    return bar;
  } 
}