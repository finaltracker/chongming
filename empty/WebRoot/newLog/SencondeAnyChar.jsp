<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/style.jsp"%>
<%@ taglib prefix="any" uri="http://www.anychart.com" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<%
		Integer count = (Integer)request.getAttribute("totalCount");
		int totalCount = 0;
		if(count!= null)
		{
			totalCount = count.intValue();
		}
		
	%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
 	<link href="/web/css/css.css" rel="stylesheet" type="text/css" />
	<title>TestAnyChar</title>
	<style type="text/css">

</style>
<script type="text/javascript" src="<%=path%>/js/jquery-1.7.1.min.js"></script>
<style >
 	table{width: 100%;border:1px solid #B9CCD9;border-collapse: collapse;}
 	table tr td{border:1px solid #B9CCD9;text-align: center;}
 	table tr th{border:1px solid #B9CCD9;background-color: #F0F9FF;text-align: center;}
 	table  tr{height: 35px;line-height: 35px;}
</style>
</head>

<body>
<div>
	<any:chart width="100%" height="383px">
	<anychart>
	  <settings>
	    <animation enabled="True" />
	  </settings>
  <charts>
    <chart plot_type="Pie">
      <data_plot_settings enable_3d_mode="false">
        <pie_series>
          <tooltip_settings enabled="true">
            <format>用户:{%Name} 总分:{%Value}{numDecimals:false}</format>
          </tooltip_settings>
          <label_settings enabled="true">
            <background enabled="false" />
            <position anchor="Center" valign="Center" halign="Center" padding="20" />
            <font color="White">
              <effects>
                <drop_shadow enabled="true" distance="2" opacity="0.5" blur_x="2" blur_y="2" />
              </effects>
            </font>
            <format></format><!-- 图形上文 -->
          </label_settings>
        </pie_series>
      </data_plot_settings>
      <data>
        <series name="Series 1" type="Pie">
          <c:forEach items="${listanyChar}" var="list" >
			<point name="${list.userNamer}" y="${list.pointAll}" />
		  </c:forEach>
        </series>
      </data>
      <chart_settings>
        <title enabled="true" padding="15">
          <text>部门用户统计</text>
        </title>
        <legend enabled="true" position="Bottom" align="Spread" ignore_auto_item="true" padding="15">
          <format>{%Icon}{%Name}({%YValue}{numDecimals:false})</format>
          <template>
          </template>
          <title enabled="true">
            <text>部门人员名称</text>
          </title>
          <columns_separator enabled="false" />
          <background>
            <inside_margin left="10" right="20" />
          </background>
          <items>
            <item source="Points" />
          </items>
        </legend>
      </chart_settings>
    </chart>
  </charts>
</anychart>
</any:chart> 
</div>
</body>
</html>
