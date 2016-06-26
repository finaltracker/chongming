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
		<chart plot_type="CategorizedVertical">
		<data_plot_settings default_series_type="Bar">         
			<bar_series group_padding="0.2">
				<!-- 高粱显示 -->
				<marker_settings enabled="true" color="Gold">
		            <marker type="None" size="10" />
		            <states>
		              <hover>
		                <marker type="Square" />
		                <border thickness="2" />
		              </hover>
		              <pushed>
		                <marker type="Square" size="6" />
		                <border thickness="2" />
		              </pushed>
		              <selected_normal>
		                <marker type="Star5" size="16" />
		                <border thickness="1" />
		              </selected_normal>
		              <selected_hover>
		                <marker type="Star5" size="12" />
		                <border thickness="1" />
		              </selected_hover>
		            </states>
	          	</marker_settings>          
				<tooltip_settings enabled="true">
				<format><![CDATA[{%Name}{enabled:false} 总分: {%Value}{numDecimals:false}]]></format>
				</tooltip_settings><!-- 鼠标提示 -->
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
						<![CDATA[部门统计]]>
					</text>
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
							<point name="${list.dapart}" y="${list.pointAll}"/>
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
