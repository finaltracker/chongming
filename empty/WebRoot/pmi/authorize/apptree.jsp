<%@ page contentType="text/html; charset=GB2312" %>
 <%@ include file="/common/taglibs.jsp"%>
<% response.setHeader("Expires","0");%>
<html>
<head>
<title>
用户授权
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
<script
 type="text/javascript"
 language="javascript"
 src="../javascripts/alai_tree_check.js">
</script>

<link href="../css/style.css" rel="stylesheet" type="text/css">
<base target="sysright">
</head>
<body >
<table bgcolor="#ffffff" border="0" cellpadding="0" cellspacing="0" style="border-left: 1 solid #D4D0C8; border-top: 1 solid #D4D0C8" width="100%" height="100%">
  <tr>
    <td height="22" style="border-left: 1 solid #FFFFFF; border-right: 1 solid #808080; border-top: 1 solid #FFFFFF; border-bottom: 1 solid #808080" valign="top">
      <table cellpadding="0" cellspacing="0" height="30" style="border-bottom: 1 solid #FFFFFF" width="100%">
        <tr>
          <td bgcolor="#FFFFFF" style="border-left: 1 solid #D4D0C8; border-right: 1 solid #D4D0C8; border-top: 1 solid #D4D0C8; border-bottom: 1 solid #808080" valign="middle">
            <p style="margin-left: 10; margin-top: 5; margin-bottom: 5"><b><font color="#000000"></font></b>
              <img src="../images/DocWorkNew.gif" width="32" height="32" align="absmiddle"><b><font color="#000000" size="2">用户授权</font></b>
          </td>
        </tr>
      </table><br><br>
      <div align="center">
        <table width="80%" border="0" cellpadding="0" cellspacing="0" style="margin-top:15">
          <tr>
            <td width="100%" align="center">
              <fieldset><legend>&nbsp;&nbsp;<b>用户授权</b>&nbsp;&nbsp;</legend><br>
<div
        nowrap="true"
        style="width:80%; height:100%; overflow:auto; "
        id="divTree1">
</div>
<html:form action="/pmi/authorize/doSysAppauthorizeEditAction.do" method="POST">
	<input type="hidden" id="appauthId" name="id"/>
	<input type="hidden" name="authtoId" value="<%=(String)request.getAttribute("authtoId")%>">
	<input type="hidden" name="authToType" value="<%=(String)request.getAttribute("authtotype")%>">
	<input type="hidden" id="applicationId" name="applicationId"/>
	<input type="hidden" id="dispatch" name="dispatch">
</html:form>
	<bean:define id="appauthList" name="appauthList" type="java.util.LinkedHashMap"/>
		<script language="javascript">
			var tree1=new alai_tree_user(divTree1);
			var root=tree1.root;
			<%
			int i=-1;
			int j=-1;
			String oldSubsystemName="";
			String oldWorkflowName="";
                      	boolean currentExpand = false;
			%>
			<logic:iterate id="ldapApplication" name="ldapApplicationList" type="com.san.share.pmi.LdapApplication">
            		<logic:present name="ldapApplication">
				<%
				if(i==-1||(!oldSubsystemName.equals(ldapApplication.getSubsystemName()))){
                                  	if(i!=-1){
                                %>
                                		n<%=i%><%=j%>.expand(<%=currentExpand%>);
                                <% 	}
                                	currentExpand = false;
					oldSubsystemName = ldapApplication.getSubsystemName();
					i++;
					oldWorkflowName = ldapApplication.getWorkflowName();
					j++;
				%>
					var n<%=i%>=root.add('<bean:write name="ldapApplication" property="subsystemName"/>');
						var n<%=i%><%=j%>=tree1.add(n<%=i%>,'','<bean:write name="ldapApplication" property="workflowName"/>');
				<%
				}
				if(!oldWorkflowName.equals(ldapApplication.getWorkflowName())){
                              	%>
                                      n<%=i%><%=j%>.expand(<%=currentExpand%>);
                              	<%
                                  	currentExpand = false;
					oldWorkflowName = ldapApplication.getWorkflowName();
					j++;
				%>
						var n<%=i%><%=j%>=tree1.add(n<%=i%>,'','<bean:write name="ldapApplication" property="workflowName"/>');
				<%
				}
				String theId = ldapApplication.getId();
				boolean checked = false;
				if(appauthList.containsKey(theId)){
					checked = true;
                                      	currentExpand = true;
					theId = (String)appauthList.get(theId);
				}
				%>
                                tree1.addChkNode(n<%=i%><%=j%>,'<bean:write name="ldapApplication" property="stepName"/>','<%=theId%>','','','',<%=checked%>);
			</logic:present>
			</logic:iterate>
                        n<%=i%><%=j%>.expand(<%=currentExpand%>);
			tree1.oncheck=function(srcNode){
				if(srcNode.checkBox.checked) { //添加
					document.all.dispatch.value="add";
					document.all.applicationId.value=srcNode.getKey();
				}else {   //取消
					document.all.dispatch.value="remove";
					document.all.appauthId.value=srcNode.getKey();
				}
				document.forms[0].submit();
				//window.parent.location.href="/oa/pmi/userAdmin/doLdapOulistFindAllAction.do";
			}
			//tree1.expandAll(true);
		</script>
               </fieldset>
                </td>
              </tr>
           </table>
      </div>
    </td>
  </tr>
</table>
</body>
</html>
