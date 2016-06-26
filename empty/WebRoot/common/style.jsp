<%
	String style = "simpleStyle";//·ç¸ñ
	String webapp="/web";//webÓ¦ÓÃÃû£¬Ä¬ÈÏÓëwebÄ£¿éÃûÏàÍ¬£¬µ«¿ÉÒÔÍ¨¹ýjboss-web.xmlÀ´ÅäÖÃ
	webapp = request.getContextPath();
	
	Object attribute = session.getAttribute("style");
	if(attribute != null)
	{
		style = attribute.toString();
	}
//ÑùÊ½±íÂ·¾¶¶¨Òå²¿·Ö
	String styleSheet = webapp+"/common/"+style+"/stylesheet/stylesheet.css";
//±³¾°Â·¾¶¶¨Òå²¿·Ö	
	//·Ö¸ôÍ·
	String topBG= webapp+"/common/"+style+"/images/background/spice/top.jpg";
	//·Ö¸ôÁÐ
	String bottomBG=webapp+"/common/"+style+"/images/background/spice/bottom.jpg";
	//·Ö¸ôµ×Í¼
	String centerBG=webapp+"/common/"+style+"/images/background/spice/list.jpg";
//°´Å¥Â·¾¶¶¨Òå²¿·Ö	
	//È·¶¨°´Å¥
	String okButton=webapp+"/common/"+style+"/images/button/ok.gif";
	//Ìá½»°´Å¥
	String submitButton=webapp+"/common/"+style+"/images/button/submit.gif";
	//È¡Ïû°´Å¥
	String cancelButton=webapp+"/common/"+style+"/images/button/cancel.gif";
	//É¾³ý°´Å¥
	String deleteButton=webapp+"/common/"+style+"/images/button/delete.gif";
	//ÖØÖÃ°´Å¥
	String resetButton=webapp+"/common/"+style+"/images/button/reset.gif";
	//ÐÞ¸Ä°´Å¥
	String modifyButton=webapp+"/common/"+style+"/images/button/modify.gif";
	//²é¿´°´Å¥
	String viewButton=webapp+"/common/"+style+"/images/button/view.gif";
	//ÏÂÔØ°´Å¥
	String downloadButton=webapp+"/common/"+style+"/images/button/download.gif";
	//ÉÏ´«°´Å¥
	String uploadButton=webapp+"/common/"+style+"/images/button/upload.gif";
	//µ¼Èë°´Å¥
	String importButton=webapp+"/common/"+style+"/images/button/import.gif";
	//µ¼³ö°´Å¥
	String exoirtButton=webapp+"/common/"+style+"/images/button/export.gif";	
	//ä¯ÀÀ°´Å¥	
	String browseButton=webapp+"/common/"+style+"/images/button/browse.gif";
	//Ô¤ÀÀ°´Å¥
	String previewButton=webapp+"/common/"+style+"/images/button/preview.gif";
	//ÉÏÒ»²½°´Å¥
	String backButton=webapp+"/common/"+style+"/images/button/pre.gif";
	//ÏÂÒ»²½°´Å¥
	String nextButton=webapp+"/common/"+style+"/images/button/next.gif";
	//·µ»Ø°´Å¥
	String returnButton=webapp+"/common/"+style+"/images/button/return.gif";
	//²éÑ¯°´Å¥
	String searchButton=webapp+"/common/"+style+"/images/button/search.gif";
	//Ê×Ò³°´Å¥
	String homeButton=webapp+"/common/"+style+"/images/button/home.gif";
	//È·ÈÏ°´Å¥
	String confirmButton=webapp+"/common/"+style+"/images/button/confirm.gif";
	//¼ÌÐø°´Å¥
	String resumeButton=webapp+"/common/"+style+"/images/button/resume.gif";
	//´òÓ¡°´Å¥
	String printButton=webapp+"/common/"+style+"/images/button/print.gif";
	//Çå¿Õ°´Å¥
	String clearButton=webapp+"/common/"+style+"/images/button/clear.gif";
	//Ìí¼Ó°´Å¥
	String addButton=webapp+"/common/"+style+"/images/button/add.gif";
	//È«Ñ¡°´Å¥
	String selectAllButton=webapp+"/common/"+style+"/images/button/selectAll.gif";
//
%>