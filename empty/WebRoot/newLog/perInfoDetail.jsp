<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/style.jsp"%>

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
		
		int i=1;
		
		String startDates = "";
		String endDates = "";
	
		if((null!=(String) request.getAttribute("startDates"))&&(!"".equals((String) request.getAttribute("startDates")))){
			startDates = (String) request.getAttribute("startDates");
		}
		if((null!=(String) request.getAttribute("endDates"))&&(!"".equals((String) request.getAttribute("endDates")))){
			endDates = (String) request.getAttribute("endDates");
		}
	%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
 	<link href="/web/css/css.css" rel="stylesheet" type="text/css" />
	<title>统计详细列表</title>
	<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
}
.STYLE1 {
	color: #FFFFFF;
	font-weight: bold;
}
.STYLE3 {
	font-weight: bold;
}
-->
.title_bm{width:100%;height:35px;font-size:24px;margin:30px 0 13px 0;padding:0;text-align:center;font-family: "微软雅黑";}
</style>
<script type="text/javascript" src="<%=path%>/js/jquery-1.7.1.min.js"></script>
<script language="Javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript">

	
	
	
</script>
<style >
 	.table1{width: 100%;border:1px solid #B9CCD9;border-collapse: collapse;}
 	.table1 tr td{border:1px solid #B9CCD9;}
 	.table1 tr th{border:1px solid #B9CCD9;background-color: #F0F9FF;text-align: center;}
 	.table1  tr{height: 35px;line-height: 35px;}
</style>
</head>

<body>
 <div class="title_1">
	<p class="position">
		<strong>当前位置：</strong>绩效考核&nbsp;>&nbsp;绩效统计
	</p>
</div>
<div>
<html:form action="/conditionPerAction.do?dispatch=queryConditionForm" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="">
	  <tr>
	    <td align="right" width="8%" height="35">部门：</td>
	    <td align="left" width="10%">
	    	&nbsp;<html:select property="dapartString" styleId="dapartString">
				<html:option value="">全部</html:option>
				<html:optionsCollection name="listUser" label="dapart" value="dapart"/>
			</html:select>
	    </td>
		<td align="right" width="8%">查询时间：</td>
	    <td align="left" width="25%">
			&nbsp;<input id="begintime" size="15" name="start_Date" type="text" style="cursor:hand" readonly="readonly" MAXDATE="#F{$('endtime').value}" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" value="<%=startDates%>"/>
			 到
			<input id="endtime" size="15" name="end_Date" type="text" style="cursor:hand"  readonly="readonly" MINDATE="#F{$('begintime').value}" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" value="<%=endDates%>"/>
	    </td>
	    <td width="40%">
	    &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="" style="cursor: pointer; background-image: url('<%=path%>/img/chaxun.jpg');border:0px;width:62px;height:24px;margin-bottom:-6px;"/>
	  	<!-- &nbsp;&nbsp;&nbsp;&nbsp;<u><a onclick='' style='cursor: pointer;'>导出xls</a></u> -->
	  	</td>
	  </tr>
</table>
</html:form>
<table class="table1">
	<tr>
		<th>
			序号
		</th>
		<th>
			部门
		</th>
		<th>
			总积分
		</th>
		<th>
			操作
		</th>
	</tr>
	
	<logic:iterate id="list" name="list" type="com.logServices.zqs.model.PerformaceStatisInfo">
		<tr>
			<td align="center" ><%=i++ %></td>
			<td align="center">
				<bean:write name="list" property="dapart"/>&nbsp;
			</td>
			<td align="center">
				<bean:write name="list" property="pointAll"/>&nbsp;
			</td>
			<td align="center">
				<u><li><a href="/web/detailAction.do?dispatch=queryDetailDepartForm&&flag=${list.dapart}">详情查看</a></li></u>
			</td>
		</tr>
	</logic:iterate>
	<tr>
		<td colspan="8" style="text-align: center;">
			<page:pager total="<%=totalCount%>" defaultPageSize="5">
				<page:navigator type='text' />
			</page:pager>
		</td>
	</tr>
</table>
	<h1 class="title_bm">部门及月度统计汇总</h1>
	<div style="width:49%;margin:0;float:left;">
		<iframe name="" src="/web/anCharAction.do?dispatch=queryAnyCharForm" height="400px" width="100%" src="" border="0" frameborder="0" scrolling="auto"> 浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe>
	</div>
	<div style="width:49%;margin:0;float:left;">
		<iframe name="" src="/web/anCharAction.do?dispatch=queryAnyCharForm&&flag=2" height="400px" width="100%" src="" border="0" frameborder="0" scrolling="auto"> 浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe>
	</div>

</div>
</body>
</html>
