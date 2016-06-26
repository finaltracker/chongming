var copyToClipboard;

function copyXML(path) {
	var data = getRawXMLFileData(path);
	copyToClipboard(data);
	alert ("XML file was copied to your clipboard");
}

function openReference(event) {
	var e = event;
	if (e == null)
		e = window.event;
	
	var width = 800;
	var height = 600;
	
	var left = (screen.width) ? (screen.width - width)/2 : 0;
	var top = (screen.height) ? (screen.height - height)/2 : 0;
	
	var params = 'scrollbars=1,width='+width+',height='+height+',left='+left+',top='+top;
	params += ',menubar=1,resizable=1,status=1,toolbar=1';
	var w = window.open('./../help/docs/index.html?'+event.currentTarget.rel,'Reference',params);
	return null;
	
	if (window.event) {
		window.event.returnValue = false;
		window.event.cancelBubble = true;
	}else if (event) {
		event.stopPropagation();
		event.preventDefault();
	}
}

function getRawXMLFileData(path) {
	var xmlhttp = false;
	/*@cc_on @*/
	/*@if (@_jscript_version >= 5)
	// JScript gives us Conditional compilation, we can cope with old IE versions.
	// and security blocked creation of the objects.
	try {
	  xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
	try {
	  xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	} catch (E) {
	xmlhttp = false;
	}
	}
	@end @*/
	if (!xmlhttp && typeof XMLHttpRequest!='undefined') {
		try {
		  xmlhttp = new XMLHttpRequest();
		} catch (e) {
		  xmlhttp=false;
		}
	}
	if (!xmlhttp && window.createRequest) {
		try {
			xmlhttp = window.createRequest();
		}catch (e) {
			xmlhttp=false;
		}
	}
	xmlhttp.open("GET", path,false);
	xmlhttp.send(null);
	if (xmlhttp.readyState==4 && (xmlhttp.status == 200 || xmlhttp.status == 0)) {
		return xmlhttp.responseText;
	}
	return null;
}

function init() {
	initClipboard();
}

function initClipboard() {
	//init clipboard
	if (BrowserTypeInformation.isIE) {
		copyToClipboard = function(data) {
			window.clipboardData.setData("Text", data);
		}
	}else {
		var source = '<embed type="application/x-shockwave-flash" pluginspage="http://www.adobe.com/go/getflashplayer" ';
		source += 'src="./../../img/ClipboardManager.swf" ';
		source += 'width="0" ';
		source += 'height="0" ';
		source += 'id="clipboardManager" ';
		source += 'name="clipboardManager" ';
		source += 'bgColor="#FFFFFF" ';
		source += 'allowScriptAccess="always" />';
		
		document.write(source);
		
		var manager = document.getElementById('clipboardManager');
		
		copyToClipboard = function(data) {
			manager.copy(data);
		}
	}
}