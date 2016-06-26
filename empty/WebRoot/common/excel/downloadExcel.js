	//shmilyLT.
	var XMLHttpReqexcel = false;
	var falpha=0;
	function bgchange(){
		if(falpha!=90){
		    table1.style.filter="alpha(opacity="+falpha+")";
		    falpha=falpha+10;
		    setTimeout("bgchange()",250);
		}else{ 
		    falpha=90;
		}
	}
	function createXMLHttpexcelRequest() {
		if(window.XMLHttpRequest) {
			XMLHttpReqexcel = new XMLHttpRequest();
		} else if(window.ActiveXObject) {
			try {
				XMLHttpReqexcel = new ActiveXObject("Msxml2.XMLHTTP");
			} catch(e) {
				try {
					XMLHttpReqexcel = new ActiveXObject("Microsoft.XMLHTTP");
				} catch(e) {
				
				}
			}
		}
	}
	function sendRequestexcel(url) {
		createXMLHttpexcelRequest();
		XMLHttpReqexcel.open("POST",url,true);
		XMLHttpReqexcel.onreadystatechange = processResponseexcel;
		XMLHttpReqexcel.send(null);
	}
	function sendRequestExceltoDate(url,data) {
		//alert(data);
		createXMLHttpexcelRequest();
		XMLHttpReqexcel.open("POST",url,true);
		XMLHttpReqexcel.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		XMLHttpReqexcel.onreadystatechange = processResponseexcel;
		XMLHttpReqexcel.send(data);
	}
	function processResponseexcel() {
		if(XMLHttpReqexcel.readyState == 4) {
			if(XMLHttpReqexcel.status == 200) {
				window.location="/web/getExcel.do?dispatch=downloadExcel";
				closeWindow();
			}
		}
	}
	function getExcel(frm) {
		//shmilyLT.
		showWindow();
		var obj = document.getElementById(frm);
		var frmurl=obj.action.split("?");
		var url = frmurl[0] + "?dispatch=getExcel";
		for(var i=0;i<obj.elements.length;i++){
			var every=obj.elements[i];
			if (every.type.toLowerCase()=="text" || every.type.toLowerCase()=="hidden"  || every.type.toLowerCase()=="select" ) {
				url += "&" + every.name + "=" + every.value;
			}  
		}
		//alert(url);
		sendRequestexcel(url);
	}
	function getExcelObject(url) {
		showWindow();
		sendRequestexcel(url + "&date=" + new Date());
	}
	
	function showWindow(){
	    table1.style.height=(window.document.body.clientHeight>window.document.body.scrollHeight)?window.document.body.clientHeight:window.document.body.scrollHeight;
	    table1.style.width="100%";
	    table1.style.display='block';
	    table2.style.left=window.document.body.scrollWidth/2-100;
	    table2.style.top=window.document.body.offsetHeight/2-100; 
	    table2.style.display='block';
	    bgchange();
	}
	
	function closeWindow(){
		table1.style.display='none'
		table2.style.display='none'
	}