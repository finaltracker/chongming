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
	<title>LogAnyChar</title>
	<style type="text/css">

</style>
<script type="text/javascript" src="<%=path%>/js/jquery-1.7.1.min.js"></script>

<script language="javascript">

	
	
	
</script>
<style >
 	table{width: 100%;border:1px solid #B9CCD9;border-collapse: collapse;}
 	table tr td{border:1px solid #B9CCD9;text-align: center;}
 	table tr th{border:1px solid #B9CCD9;background-color: #F0F9FF;text-align: center;}
 	table  tr{height: 35px;line-height: 35px;}
</style>
</head>

<body>
<div>
	<any:chart  height="290px" width="100%">
	<anychart>
	<settings>
    <animation enabled="false" />
  	</settings>
	<charts>
	<chart>
		<data_plot_settings plot_type="CategorizedVertical">         
			<bar_series>            
				<tooltip_settings enabled="true"><format><![CDATA[{%Name}{enabled:false} 总分: {%Value}{numDecimals:false}]]></format></tooltip_settings><!-- 鼠标提示 -->
				<label_settings enabled="true"><!-- 前端内容 -->
					<background enabled="false"/> 
					     <position anchor="Center" valign="Center" halign="Center" padding="20" />
					      <font color="Black">
					      <effects>
					      <drop_shadow enabled="true" distance="2" opacity="0.5" blur_x="2" blur_y="2" />
					      </effects>
						  </font>
						  <format><![CDATA[{%Value}{numDecimals:false}]]></format>
				</label_settings>
			</bar_series>       
		</data_plot_settings>    
		<chart_settings>
			<title>
				<text>
					<![CDATA[部门绩效考核统计]]></text>
			</title>
				<axes>
					<x_axis>
						<title>
							<text><![CDATA[部门名称]]></text>
						</title>
					</x_axis>
					<y_axis>
						<title>
							<text><![CDATA[统计量]]></text>
						</title>
						<labels enabled="true">
								<format><![CDATA[{%Value}{numDecimals:0}]]></format>
						</labels>
					</y_axis>
				</axes>
			</chart_settings>
			<data>                 
				<series>
					<c:forEach items="${listanyChar}" var="list" >
						<point name="${list.dapart}" y="${list.pointAll}" />
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
