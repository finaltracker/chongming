
<%@ page contentType="text/html; charset=GB2312" %>
 <%@ include file="/common/taglibs.jsp"%>
<html:html>
<head>
<title>��������</title>

<style type="text/css">
<!--
.style1 {color: #FF0000}
-->
</style>
</head>
<body>
<h1 class="style1">��������</h1>
<p>
<html:errors/>
<logic:present name="message">
<b><bean:write name="message"/></b>
</logic:present>
<logic:notPresent name="message">
<b>û�н�һ����Ϣ</b>
</logic:notPresent></p>
���� <a href="#" onclick="history.go(-1)">����</a>
</body>
</html:html>
