
<%@ page contentType="text/html; charset=GB2312" %>
 <%@ include file="/common/taglibs.jsp"%>
<html:html>
<head>
<title>发生错误</title>

<style type="text/css">
<!--
.style1 {color: #FF0000}
-->
</style>
</head>
<body>
<h1 class="style1">发生错误</h1>
<p>
<html:errors/>
<logic:present name="message">
<b><bean:write name="message"/></b>
</logic:present>
<logic:notPresent name="message">
<b>没有进一步信息</b>
</logic:notPresent></p>
请点击 <a href="#" onclick="history.go(-1)">返回</a>
</body>
</html:html>
