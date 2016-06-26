<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.san.share.pmi.service.LoginUserInfoDelegate"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>杭州信用</title>
 <link href="<%=path %>/css/css.css" rel="stylesheet" type="text/css" />
  <script type="text/javascript" src="<%=path%>/js/jquery-1.4.4.min.js"></script>
 <style>
	body{background:url(/web/img/top_bg.png) repeat-x;padding: 0px;margin: 0px;min-width: 1000px;}
	table {border-collapse: collapse;width: 100%;height: 100%;}
	img{vertical-align:middle;}
	#mainImg img{cursor: pointer;}
 </style>
</head>
<body >
	<table>
		<tr>
			<td rowspan="2" style="width: 30%;"><img src="/web/hzcx/images/logo.jpg" /></td>
			<td rowspan="2" align="center">
			</td>
			<td align="right" style="padding-right: 15px;color: white;font-size: 12px;font-weight: bold;">
				<img src="<%=path%>/img/ico_user.png"/>用户名：<%=LoginUserInfoDelegate.getSnFromRequest(request)%>
				<img src="<%=path%>/img/ico_hr.png"/>部门：<%=LoginUserInfoDelegate.getOuFromRequest(request)%>
			</td>
		</tr>
		<tr>
			<td align="right" style="padding-right: 10px;" id="mainImg">
				<img src="<%=path%>/hzcx/images/home.png" onmousemove="this.src='<%=path%>/hzcx/images/home_1.png'" onmouseout="this.src='<%=path%>/hzcx/images/home.png'" onclick="$(window.parent.document).find('#mainFrame').attr('src','center1.jsp');"/><a href="pmi/usertools/passchange.jsp" target="I2"><img src="<%=path%>/img/xgmm.jpg" onmousemove="this.src='<%=path%>/img/xgmm2.jpg'" onmouseout="this.src='<%=path%>/img/xgmm.jpg'" /></a><img src="<%=path%>/page/main/main_img/exit_2.png" onmousemove="this.src='<%=path%>/page/main/main_img/exit_1.png'" onmouseout="this.src='<%=path%>/page/main/main_img/exit_2.png'" onclick="window.location.href='/web/logoutAction.do'"/>
			</td>
		</tr>
	</table>		
</body>
</html>

