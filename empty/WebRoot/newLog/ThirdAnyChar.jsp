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
	<title>ThirdChar</title>
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
		    <chart plot_type="CategorizedVertical">
		      <data_plot_settings default_series_type="Bar">
		        <bar_series point_padding="0.2" group_padding="1">
		         	
		          	<label_settings enabled="true">
		            <background enabled="false" />
		            <format>{%YValue}{numDecimals:0}</format>
		            <effects>
		              <drop_shadow enabled="true" opacity="1" />
		            </effects>
		          </label_settings>
		          <tooltip_settings enabled="true">
		            <format>总量: {%YValue}{numDecimals:0}次 月份:{%Name}</format>
		          </tooltip_settings>
		        </bar_series>
		      </data_plot_settings>
		      <chart_settings>
		        <title enabled="true">
		          <text>月度统计</text>
		        </title>
		        <axes>
		          <x_axis tickmarks_placement="Center">
		              <labels display_mode="Rotated" rotation="90" align="inside" allow_overlap="true" />
		              <title enabled="False" />
		          </x_axis>
		          <y_axis>
		            <title>
		              <text>统计量</text>
		            </title>
		            <labels enabled="true">
		             	<format><![CDATA[{%Value}{numDecimals:false}]]></format>
		             </labels>
		          </y_axis>
		        </axes>
		      </chart_settings>
		      <data>
		        <series name="Series 1" palette="Default">
		          <c:forEach items="${listanyChar}" var="list" >
					<point name="${list.dapart}月" y="${list.pointAll}"/>
					</c:forEach>             
		        </series>
		      </data>
		    </chart>
		  </charts>
	</anychart> 
</any:chart> 
</div>
</body>
</html>
