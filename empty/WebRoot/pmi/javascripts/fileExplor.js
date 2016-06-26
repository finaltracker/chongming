var totalFile=0;         //---文件总数
var inputFileArray=new Array();   //---文件的数组
var fileNameLength=20;    //---文件名长度
var keywordLength=10;     //---注释的长度
var checkAllFlag=0;       //---全部选中标记
var checkedFileLength=0;  //---已选中的文件个数
var currentCheckFile=-1;  //---当前选中的文件序号

var mouse_X=0;            //---鼠标位置X
var mouse_Y=0;            //---鼠标位置Y
var PX=0;                 //---滚动条位置X
var PY=0;                 //---滚动条位置Y

/**
 * 定义myFile类(文件类型，文件名称，文件修改时间，文件ID，文件关键字注释)
 * 文件类型
 * folder 文件夹
 * text: 文本
 * image: 图片
 * normal: 普通
 * 返回 void
*/

function myFile(fileType,fileName,fileEditTime,fileID,fileKeyWords) {
	
    this.fileType=fileType;
    if (fileName.length>fileNameLength) {  this.fileName=fileName.substr(0,fileNameLength-3)+"..."} else {
    this.fileName=fileName;}
    this.fileEditTime=fileEditTime;
    this.fileID=fileID;
    if (fileKeyWords.length>keywordLength) {  this.fileKeywords=fileKeyWords.substr(0,keywordLength-2)+".."} else {
    this.fileKeywords=fileKeyWords;}
    
    //----根据文件类型确定文件的图标
    if (fileType=="text") {
    	this.file_Ico="text"
    }
    else if (fileType=="folder") {
        this.file_Ico="folder";	
    }else if (fileType=="image") {
       this.file_Ico="image";	
    }else if (fileType=="normal") {
       this.file_Ico="normal";	
    }
        
    //---设定文件选中为0
    this.fileChecked=0;
}

/**
 * 添加文件到文件数组(文件类型，文件名称，文件修改时间，文件ID，文件关键字注释)
 * 生成文件内容行
 * 返回 void

*/

function addFile(fileType,fileName,fileEditTime,fileID,fileKeyWords) {
	 var s_file=new myFile(fileType,fileName,fileEditTime,fileID,fileKeyWords);
	 pasteFileRow(s_file);
	 inputFileArray[totalFile]=s_file;
	 totalFile++;
         
}

/**
 * 生成文件内容行的HTML（文件类）
 * 返回 void  
*/

function pasteFileRow(s_file) {
	
		document.writeln("        <tr> ");
		document.writeln("          <td width='218'> ");
		document.writeln("            <table border='0' cellpadding='0' cellspacing='0'>");
		document.writeln("              <tr>");
		document.writeln("                <td valign='middle' class='clickRow' onclick='if (event.ctrlKey){ checkIT(\""+totalFile+"\"); } else { uncheckAll();checkIT(\""+totalFile+"\")}' oncontextmenu='filePopMenu(\""+totalFile+"\")' width='21'>");
		document.writeln("                  <p style='margin-left: 3;'><img id='fileIco"+totalFile+"' src='../orgmgt/js/image/%22+s_file.file_Ico+%22.gif' border='0' >");
		document.writeln("                </td>");
		document.writeln("                <td valign='middle' align='left' class='clickRow' id='nameRow"+totalFile+"' onclick='if (event.ctrlKey){ checkIT(\""+totalFile+"\"); } else { uncheckAll();checkIT(\""+totalFile+"\")}' oncontextmenu='filePopMenu(\""+totalFile+"\")'> ");
		document.writeln("                  <p style='margin-left: 3;'><a ondblclick='javascript:openIT(\""+totalFile+"\")'><font color='#000000' id='nameText"+totalFile+"'>"+s_file.fileName+"</font></a></p>");
		document.writeln("                </td>");
		document.writeln("              </tr>");
		document.writeln("            </table>");
		document.writeln("          </td>");
		document.writeln("          <td width='120' onclick='uncheckAll()'> ");
		document.writeln("            <p style='margin-left: 15'>"+s_file.fileEditTime+"</p>");
		document.writeln("          </td>");
		document.writeln("          <td width='120' onclick='uncheckAll()'> ");
		document.writeln("            <p style='margin-left: 15'>"+s_file.fileKeywords+"</p>");
		document.writeln("          </td>");
		document.writeln("        </tr>");
		
}

/**
 * 打开文件（文件序号）
 * 返回 void  
*/

function openIT(fileNo) {
     uncheckAll();
     checkIT(fileNo);	
     var openFile=inputFileArray[fileNo];
     if (openFile.fileType=="folder") {
     	 self.location="file.po?folder="+openFile.fileID;
     	 parent.parent.left.folder.openFolder(openFile.fileID);
         refreshTree();
     	}
     if (openFile.fileType=="text")  {
     	    //alert("打开文本文件"+openFile.fileID);	
     	    window.open("file.po?event=open&fileID="+openFile.fileID,"","height=400,width=600,left=20,top=20,status=no,toolbar=no,menubar=no,location=no,scrollbars=yes,resizable");
     	 }
     
     if (openFile.fileType=="image") 
       {   
       	 window.open("file.po?event=openImg&fileID="+openFile.fileID,"","height=100,width=200,left=800,top=600,status=no,toolbar=no,menubar=no,location=no,scrollbars=yes,resizable");
       }
     
     if (openFile.fileType=="normal") 
       {   
       	 window.open("file.po?event=openFile&fileID="+openFile.fileID,"","height=100,width=200,left=800,top=600,status=no,toolbar=no,menubar=no,location=no,scrollbars=yes,resizable");
       }     
	
}

/**
 * 编辑文件（文件序号）
 * 返回 void  
*/

function editIT(fileNo) {


     var openFile=inputFileArray[fileNo];
	 var parentID= document.submitform.currentFolderID.value;
     if (openFile.fileType=="folder") {
     	 self.location="file.po?folder="+openFile.fileID;
     	 parent.parent.left.folder.openFolder(openFile.fileID);
     	}
     if (openFile.fileType=="text") {
     	var editTxt=openEdit(openFile.fileID);
		self.location="file.po?folder="+parentID;
     	//alert("编辑文本文件"+openFile.fileID);
     	}
     if (openFile.fileType=="image") { 
     	var editImg=openEditImg(openFile.fileID);
     	//alert("编辑图片文件"+openFile.fileID);	
     }
     
     if (openFile.fileType=="normal") { 
     	var editFile=openEditFile(openFile.fileID);
		//alert("编辑图片文件"+openFile.fileID);	
     }
          
	
}

/**
 * 选中文件（文件序号）
 * 返回 void  
*/

function checkIT(fileNo) {

    var checkFile=inputFileArray[fileNo];
    
    var fileIcoName="fileIco"+fileNo;
    var icoObj=eval(fileIcoName);
    var fileNameRow="nameRow"+fileNo;
    var nameRowObj=eval(fileNameRow);
    var fileNameText="nameText"+fileNo;
    var nameTextObj=eval(fileNameText);
    //alert(checkFile.fileChecked);
    if (checkFile.fileChecked==0) 
       { 
       //alert("文件未选中");       
         //---修改图标
       icoObj.src="image/"+checkFile.file_Ico+"_check.gif";
         //---修改文字背景色
       nameRowObj.bgColor="#0A246A";
         //---修改文字颜色
       nameTextObj.color="#FFFFFF";    
       
       inputFileArray[fileNo].fileChecked=1;	
    } else {
       //alert("文件已选中");
       
       icoObj.src="image/"+checkFile.file_Ico+".gif";
       nameRowObj.bgColor="";
       nameTextObj.color="#000000";  
       inputFileArray[fileNo].fileChecked=0;	
    }
	
}

/**
 * 选中所有文件（）
 * 返回 void  
*/

function checkAll() {
    hiddenFastMenu();	
    for (var i=0;i<totalFile;i++) {
       	var checkFile=inputFileArray[i];
       	checkFile.fileChecked=0;
       	checkIT(i);
    }
	
}

/**
 * 取消所有选中文件（）
 * 返回 void  
*/

function uncheckAll() {
	hiddenFastMenu();
	for (var i=0;i<totalFile;i++) {
       	  var checkFile=inputFileArray[i];
       	  checkFile.fileChecked=1;
       	checkIT(i);
    }
}

/**
 * 递交增加目录表单（目录名称，目录类型）
 * 返回 void  
*/   
   
function addDir(dirName,dirType) {
    document.all.submitform.dirName.value=dirName;
    document.all.submitform.dirType.value=dirType;
    document.all.submitform.submit();
    if (dirType=="folder")
    {
		refreshTree();
    }	
}

/**
 * 初始化页面Event（）
 * 返回 void  
*/
function initPage() {
    document.onmousemove = doMouseMove;
    window.onscroll = doscroll;
    //refreshTree();
}

/**
 * 定义mouseMove事件
 * 返回 void  
*/

function doMouseMove() {
   mouse_X=window.event.clientX + PX;
   mouse_Y=window.event.clientY + PY;	
   //window.status="x="+mouse_X+"  y="+mouse_Y;	
}

/**
 * 定义scroll事件
 * 返回 void  
*/

function doscroll(){
      PY = document.body.scrollTop;
      PX = document.body.scrollLeft;
}

/**
 * 刷新左边树型
 * 返回 void  
*/

function refreshTree() {
    var topDepID=top.document.all.getDepID.value;
	if (topDepID!=null&&topDepID!="") 
	{
		parent.parent.left.folder.location="folder.po?getDepID="+topDepID;	
	}
	else {
	    parent.parent.left.folder.location="folder.po";
	}
    
}

/**
 * 右键打开菜单
 * 返回 void  
*/   

function filePopMenu(fileNo) {
      var checkFile=inputFileArray[fileNo];	
      if (checkFile.fileChecked!=1) {
         checkIT(fileNo);	
      }
      currentCheckFile=fileNo;
      showFastMenu();	
      event.returnValue=false;
      //alert("请使用左键打开菜单");	
} 

/**
 * 递交删除目录表单
 * 删除所有选中目录
 * 返回 void  
*/  
function delDir() {
   var delDirID=checkFile();   
   if (delDirID!="") { 
   	if (confirm("确认要删除这"+checkedFileLength+"项文件吗?   ")) {
   	         document.submitform.dirID.value=delDirID;
             document.submitform.event.value="del";
             document.submitform.submit();
			 refreshTree();  	
   	}   	
   } 
   else { alert("请至少选择一个文件进行操作");}	
}

/**
 * 递交移动目录表单
 * 移动所有选中目录到指定目录
 * 返回 void  
*/ 

function moveDir(folderID) {
   var moveDirID=checkFile();
    document.submitform.dirID.value=moveDirID;
    document.submitform.toDirID.value=folderID;
    document.submitform.event.value="move";
    document.submitform.submit();
    refreshTree();   
      
}

/**
 * 递交拷贝目录表单
 * 拷贝所有选中目录到指定目录
 * 返回 void  
*/ 

function copyDir(folderID) {
   var copyDirID=checkFile();
    document.submitform.dirID.value=copyDirID;
    document.submitform.toDirID.value=folderID;
    document.submitform.event.value="copy";
    document.submitform.submit();   
    refreshTree();
   
}

/**
 * 获得选中目录
 * 选中文件数组赋值
 * 返回 选中目录ID的字符串 "1111,2222,3333"  
*/ 

function checkFile() {
   var checkFileID="";
   var checkFile=null;
   var checkFileLength=0;
   for (var i=0;i<totalFile;i++) {
      checkFile=inputFileArray[i];
      if (checkFile.fileChecked==1) {checkFileID+=checkFile.fileID+",";checkFileLength+=1;}	
   }
   checkedFileLength = checkFileLength;
   return checkFileID;  	
}

/**
 * 判断是否为系统文件夹
 * 是，返回 flase
 * 否, 返回 true  
*/ 

function checkSysFolder() {
   if(document.submitform.sysFolder.value=="0"){
      return false; 	
   }else{	
     return true;
  }  
}

function checkAccess() {
   var accessInfo=document.submitform.currentAccessInfo.value;
   if (accessInfo=="-1") return 0;
   else {
       if (accessInfo.charAt(0)=='1') return 0;
	   else if (accessInfo.charAt(1)=='1') return 1;
	   else return 2;
   }   
}


/**
 * 打开属性window
 * 
 * 返回 void  
*/ 

function openProperties(fileNo) {
    var checkFile=inputFileArray[fileNo];
    var fileProperties=window.showModalDialog('file.po?event=ShowProperties&fileID='+checkFile.fileID,'','dialogwidth=380px; dialogheight=400px; status=no');	
    if (fileProperties!=null) {
    	var parentID= document.submitform.currentFolderID.value;
    	self.location="file.po?folder="+parentID;
    }
}

/**
 * 显示上下文菜单
 * 返回 void  
*/ 

function showFastMenu(theFile) {
    var fastMenu=eval("popMenu");
    
    if (window.event.clientY>120&&window.event.clientY<190) mouse_Y=mouse_Y- 80;
    if (window.event.clientY>190) mouse_Y=mouse_Y- 163;
    
    
    fastMenu.style.posLeft=mouse_X;
    fastMenu.style.posTop=mouse_Y;
    fastMenu.style.visibility = "visible";    
}

/**
 * 隐藏上下文菜单
 * 返回void 
*/ 

function hiddenFastMenu() {
    var fastMenu=eval("popMenu");
    fastMenu.style.visibility = "hidden";  	
}

/**
 * 打开属性菜单
 *  
*/ 

function openFileProperties() {
 
     openProperties(currentCheckFile);
}

/**
 * 打开文件
 * 返回 void  
*/ 

function openFilePop(){
     openIT(currentCheckFile);	
}

/**
 * 编辑文件
 * 返回 void  
*/ 

function editFilePop() {
		if (checkSysFolder())
	{
		if (checkAccess()!="2") editIT(currentCheckFile);
		else {  alert("无法重命名目录\n拒绝访问");}
	}
   else { alert("无法重命名目录\n该目录是系统目录"); }
     
}

/**
 * 移动文件
 * 返回 void  
*/ 
function moveFilePop() {
    parent.parent.toolbar.moveFolder();
}

/**
 * 复制文件
 * 返回 void  
*/ 

function copyFilePop() {
    parent.parent.toolbar.copyFolder();
}

/**
 * 删除文件
 * 返回 void  
*/ 

function delFilePop() {
    parent.parent.toolbar.delFolder();
}

/**
 * 重命名文件
 * 返回 void  
*/ 

function renameFilePop() {
	if (checkSysFolder())
	{
		if (checkAccess()!="2")
		{
		 var checkFile=inputFileArray[currentCheckFile];
		 var fileName=window.showModalDialog('rename.htm',checkFile.fileName,'dialogwidth=270px; dialogheight=140px; status=no');	
		 if ((fileName!=null)&&(fileName!="")&&(fileName!=checkFile.fileName)) renameDir(checkFile.fileID,fileName);
		}
		else {  alert("无法重命名目录\n拒绝访问");}
	}
   else { alert("无法重命名目录\n该目录是系统目录"); }
}

/**
 * 递交重命名表单（文件ID，文件名称）
 * 返回 void  
*/ 

function renameDir(fileID,fileName) {
    document.submitform.dirID.value=fileID;
    document.submitform.dirName.value=fileName;
    document.submitform.event.value="rename";
    document.submitform.submit();
    refreshTree();   	
}
