<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <a href="login.jsp">Login</a>
    This is my JSP page. <br>
    <form id="defaultForm" method="post" action="/login/home/target/add.do" class="form-horizontal bv-form">
    	<div class="col-lg-7 col-lg-offset-3">
    		<button type="submit" class="btn btn-success">submit</button> 
    		<!-- <button class="btn btn-default back" data-url="/home/target">·µ»Ø</button> -->
		</div>
    </form>
  </body>
</html:html>
