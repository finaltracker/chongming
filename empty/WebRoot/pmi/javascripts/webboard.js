var webBoardTitle="WebFX Webboard";
var cgiFile="index.cgi";
var jsPath="js/";
var adminPath="admin/";
var webBoardDomain="webfx.eae.net";
var messageDomain="eae.net";
var errorString="Error!\n";
var codeStyle="font-family: courier new; font-size: 12px;";
var elementCodeStyle="color: navy;";
var minusString='<img class="icon" src="../orgmgt/js/images/minusicon.gif">';
var plusString='<img class="icon" src="../orgmgt/js/images/plusicon.gif">';
var replysStartTag=" <span style='color: blue'>(";
var replysEndTag=")</span>";
var expandedTree=false;
var showNumberOfReplys=true;
var waitForViewerError=errorString+"The message viewer has not finished loading.\nPlease wait for it to finish.";
var timeBeforeRead=3000;
var startMessageURL='about:<span style="color: red; font-family: verdana; font-size: 12;">Select a message in the list to read it.</span>';
var extLinkTitle="Drag or copy this link to create an external link to this message.";
var extLinkAlert="This link has been disabled!\\nDrag or copy this link to create an external link to this message.";
var defaultEmptyText="<Click here to edit this field>";
var activeCSS="border: 1 solid buttonface; color: windowtext; cursor: text;";
var inactiveCSS="border: 1 solid window; cursor: hand; color: red;";
var validTextColor="windowtext";
var invalidTextColor="buttonshadow";
var editContactError=errorString+"This window needs to communicate with the main window and this wasn't found.\nPress OK to close this window";
var emptySubjectText="<Click here to enter the subject>";
var emptyNameText="<Click here to enter your name>";
var emptyEmailText="<Click here to enter your email>";
var newMessageTitle="New Message"
var months=new Array('January','Feburary','March','April','May','June','July','August','September','October','November','December');
var quotedStyle='border-left: 2px solid black; margin-left: 15px; padding-left: 5px;';
var fromWord="From";
var subjectWord="Subject";
var sentWord="Sent";
var allowSendFromHtml=true;
var htmlModeError="You can't send from HTML mode due to possible errors in the HTML structure.\nSwitch to WYSIWYG mode before posting the message.\n";
var emptyNameError="You must enter a name!\n";
var emptySubjectError="You must enter a subject!\n";
var emptyMessageError="The message is empty!\n";
var invalidEmailAdressError="Invalid Email adress! (You don't have to enter an email adress.)\n";
var sourceCodeModeLabel="Source Code Mode";
var wysiwygModeLabel="WYSIWYG Mode"

function ieVersion(){
	var ua=window.navigator.userAgent;var msieIndex=ua.indexOf("MSIE")
if(msieIndex== -1)return 0;return ua.substring(msieIndex+5,msieIndex+6);

}

function include(fileName){
	document.write('<script type="text/javascript" src="../orgmgt/js/%27+jsPath+fileName+%27"></script>');
}

function replaceSpecial(str){
	return str.replace(/\&/g,"&").replace(/</g,"&lt;").replace(/>/g,">");
}
include("error.js");

function initToolBar(){
	
	include("about.js");
	include("coolbuttons.js");
	include("toolbar.js");
}

var adminMode=false;

function initAdminToolBar(){
	adminMode=true;include("coolbuttons.js");
	include("about.js");
	include("toolbar.js");
}

function getReal(el,type,value){
	temp=el;
	while((temp!=null)&&(temp.tagName!="BODY")){
		if(eval("temp."+type)==value){el=temp;return el;
	}
	
	temp=temp.parentElement;
}

return el;
}


function switchLayout(){
	
	//if(parent.zy.cols=="0,*")
	//parent.zy.cols="*,150";
	//else
	//parent.zy.cols="0,*";
}

function toggleTree(){
	
	//if(layout.cols=="*"){
	//	if(layout.rows=="0, *")
	//	layout.rows="30%, *";
	//	else
	//	layout.rows="0, *";
	//}else{
	//	if(layout.cols=="0, *")
	//	layout.cols="30%, *";
	//	else
	//layout.cols="0, *";
	//}
}


var mLoaded=false;
var tLoaded=false;
var xLoaded=false;
var trLoaded=false;

function setXLoaded(){
	xLoaded=true;
}

function messageLoaded(){
	mLoaded=true;
	if(tLoaded)window.frames("toolFrame").checkMessage();
	else
	window.setTimeout("messageLoaded()",100);
	
}

function toolbarLoaded(){
	tLoaded=true;
}

function treeLoaded(){
	trLoaded=true;
}

function preload(sourceArray,pre,pro){
	imageArray=new Array();
	if(pre==null)pre="";
	if(pro==null)pro="";
	for(i in sourceArray){
		imageArray[i]=new Image();
		imageArray[i].src=pre+sourceArray[i]+pro;
	}
}

function initMessageTree(){
	include("msgtree.js");
}

function initMessageViewer(){
	include("msgviewer.js");
}

function fixEditorSize(){
	document.all.edit1.style.height=Math.max(document.body.clientHeight-document.all.edit1.offsetTop-switchDiv.offsetHeight,0);
}

function initReplyEditorPrime(){
	fixEditorSize();
	loadCookies();
	loadReplyToMessage();
	
}

function initEditor(){
	include("coolbuttons.js");
	fixEditorSize();
	window.onresize=fixEditorSize;
	document.all.editbar._editor=window.frames[document.all.edit1.id];
}

function initReplyEditor(){
	initEditor();
	window.onload=initReplyEditorPrime;
}

function initNewEditor(){
	initEditor();
	window.onload=initNewEditorPrime;
}

function initNewEditorPrime(){
	fixEditorSize();
	loadCookies();
	document.all.group.value=opener.parent.treeframe.document.body.group;
	updateToField();
}

function initEditEditor(){
	document.all.pwd.value=opener.parent.treeframe.document.body.password;initEditor();
	window.onload=initEditEditorPrime;
}

function initEditEditorPrime(){
	fixEditorSize();
	loadOriginalMessage();
}

function initRichTextEditor(){
	include("richedit.js");
}

var scrollTimer;var paddingOrg=2;
var scrollInterval=200;
var scrollAmount=49;

function initOeBar(){
	include("oebar.js");
}