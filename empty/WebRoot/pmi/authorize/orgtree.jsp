<%@ page contentType="text/html; charset=GB2312" %>
 <%@ include file="/common/taglibs.jsp"%>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="com.san.share.pmi.SysOulist" %>
<%@ page import="com.san.share.pmi.SysUser" %>
<% response.setHeader("Expires","0");%>
<html>
<head>
<title>
orgtree
</title>
<script
 type="text/javascript"
 language="javascript"
 src="../javascripts/alai_tree_user.js">
</script>
<script
 type="text/javascript"
 language="javascript"
 src="../javascripts/alai_tree.js">
</script>
<script language="javaScript">
function selectWindowLoad(theCn){
//	var theUrl = "/web/pmi/orgmgt/doSysUserFinderByPrimaryKeyAction.do?cn=" + theCn + "&dispatch=update";
//	window.open(theUrl,"m_iFrameSetUser");
}
</script>
<!-- Modify this file to change the way the tree looks -->
<link href="../css/style.css" rel="stylesheet" type="text/css">
<base target="sysright">
</head>
<body >
<!-- js file containing the tree content, edit this file to alter the menu,
     the menu will be inserted where this tag is located in the document -->
<div
        nowrap="true"
        style="width:100%; height:100%; overflow:auto; font-family: &quot;ÐÂËÎÌå;&quot;, &quot;ËÎÌå;&quot;; font-size: 9px;"
        id="divTree1">
</div>
<script language="javascript">
    var tree1=new alai_tree_user(divTree1);
    var root=tree1.root;
    <%
    int i=0;
    int j=0;
    %>
	
    <logic:iterate id="sysOrglist" name="sysOrglists" type="com.san.share.pmi.SysOrglist">
    <logic:present name="sysOrglist">
      	var n<%=i%>=tree1.add(root,'','<bean:write name="sysOrglist" property="orgName"/>','<bean:write name="sysOrglist" property="id"/>');
        <logic:iterate id="sysOulist" name="sysOrglist" property="sysOulist" type="com.san.share.pmi.SysOulist">
        <logic:present name="sysOulist">
        	var n<%=i%><%=j%>=tree1.add(n<%=i%>,'','<bean:write name="sysOulist" property="ouName"/>','<bean:write name="sysOulist" property="id"/>','department');
        	<logic:iterate id="sysUser" name="sysOulist" property="sysUser" type="com.san.share.pmi.SysUser">
        	<logic:present name="sysUser">
                	tree1.add(n<%=i%><%=j%>,'','<bean:write name="sysUser" property="sn"/>','<bean:write name="sysUser" property="id"/>','person','url:sysright','/web/pmi/authorize/doSysAppauthorizeFindByUserAction.do?authtoId=<bean:write name="sysUser" property="id"/>&authtotype=0');
		</logic:present>
    		</logic:iterate>
       		<% j++; %>
	</logic:present>
    	</logic:iterate>
       <% i++; %>
    </logic:present>
    </logic:iterate>
//    tree1.ondblclick=function(srcNode){
//            //alert("ondblclick");
//            if(srcNode.parent=tree1.root){
//
//            }
//            if(srcNode.parent.parent=tree1.root){
//
//            }
//            else{
//
//            }
//    }
    tree1.expandAll(false);
    tree1.nodes[0].expand(true,false);
</script>
</body>
</html>
