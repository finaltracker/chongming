
var XMLHttpReq=false;
var menu = null;
var STATEDONE = 4;
var STATUSSUCCESS = 200;


//create object
function buildXmlHttpRequest(){
   if(window.ActiveXObject){
	 try{
		XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
	 }catch(e){
		try{
		XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
		}catch(e){
		  alert("create object Exception!");
		}
	 }
   }else{
	   XMLHttpReq = new XMLHttpRequest();
   }
}

//send info
function sendRequest(url,object){
	 menu=object;
	 buildXmlHttpRequest();
	 if(!XMLHttpReq){
		return;
	 }
	 XMLHttpReq.onreadystatechange = proessRequest;
	 XMLHttpReq.open("GET",url,false);
	 XMLHttpReq.send(null);
}

//return hidden value
function proessRequest(){
	if(XMLHttpReq.readyState == 4) {
			if(XMLHttpReq.status == 200) {
			   var xml=XMLHttpReq.responseText;
				menu.value=xml;
			 } else {
				
			}
		}
}
