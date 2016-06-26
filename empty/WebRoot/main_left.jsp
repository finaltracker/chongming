<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@ include file="/common/style.jsp"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>崇明县公共信用信息平台</title>
<script src="/web/hzcx/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/web/hzcx/js/menu_min.js"></script>
<link rel="stylesheet" type="text/css" href="/web/hzcx/css/style.css"/>
<script type="text/javascript">
$(document).ready(function (){ 
  $(".menu ul li").menu();
  //$("a")[0].click();//选中第一个菜单
});
</script> 
<style>	
body{overflow-x:hidden;overflow-y:auto;}
</style>
</head>
<body>
<div><img src="/web/hzcx/images/menu.gif"/></div>
<div class="menu">
<ul >
 <logic:present name="userMenuList">
	 <logic:iterate name="userMenuList" id="parentMenu" length="1" offset="0">
         <bean:define name="parentMenu" id="secondMenuList" property="secondMenuSet" type="java.util.List"/>
    	 <logic:iterate name="secondMenuList" id="secondMenu">
			<li>
				<a href="javaScript:;"><bean:write name="secondMenu" property="secondMenuName"/></a>
				<bean:define name="secondMenu" id="thirdMenuList" property="thirdMenuSet" type="java.util.List"/>
				 <ul>
					  <logic:iterate name="thirdMenuList" id="thirdMenu">
			 			<logic:equal name="thirdMenu" property="menuName" value="法定代表人/负责人信用预警">
	                     <li><a href='<bean:write name="thirdMenu" property="menuUrl"/>' target="I2"><bean:write name="thirdMenu" property="menuName"/></a></li>
	                     </logic:equal>
	                     <logic:notEqual name="thirdMenu" property="menuName" value="法定代表人/负责人信用预警">
	                     	 <logic:equal name="thirdMenu" property="menuName" value="法定代表人/负责人信用档案">
		                      	<li><a href='<bean:write name="thirdMenu" property="menuUrl"/>' target="I2"><bean:write name="thirdMenu" property="menuName"/></a></li>
		                      </logic:equal>
		                      <logic:notEqual name="thirdMenu" property="menuName" value="法定代表人/负责人信用档案">
		                      	 <li><a href='<bean:write name="thirdMenu" property="menuUrl"/>' target="I2"><bean:write name="thirdMenu" property="menuName"/></a></li>
		                      </logic:notEqual>
		                 </logic:notEqual>
					 </logic:iterate>
				</ul>
			</li>
		</logic:iterate>
	</logic:iterate>
  </logic:present>
</ul>
</div>
</body></html>











