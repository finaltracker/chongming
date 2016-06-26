var totalFile=0;         //---�ļ�����
var inputFileArray=new Array();   //---�ļ�������
var fileNameLength=20;    //---�ļ�������
var keywordLength=10;     //---ע�͵ĳ���
var checkAllFlag=0;       //---ȫ��ѡ�б��
var checkedFileLength=0;  //---��ѡ�е��ļ�����
var currentCheckFile=-1;  //---��ǰѡ�е��ļ����

var mouse_X=0;            //---���λ��X
var mouse_Y=0;            //---���λ��Y
var PX=0;                 //---������λ��X
var PY=0;                 //---������λ��Y

/**
 * ����myFile��(�ļ����ͣ��ļ����ƣ��ļ��޸�ʱ�䣬�ļ�ID���ļ��ؼ���ע��)
 * �ļ�����
 * folder �ļ���
 * text: �ı�
 * image: ͼƬ
 * normal: ��ͨ
 * ���� void
*/

function myFile(fileType,fileName,fileEditTime,fileID,fileKeyWords) {
	
    this.fileType=fileType;
    if (fileName.length>fileNameLength) {  this.fileName=fileName.substr(0,fileNameLength-3)+"..."} else {
    this.fileName=fileName;}
    this.fileEditTime=fileEditTime;
    this.fileID=fileID;
    if (fileKeyWords.length>keywordLength) {  this.fileKeywords=fileKeyWords.substr(0,keywordLength-2)+".."} else {
    this.fileKeywords=fileKeyWords;}
    
    //----�����ļ�����ȷ���ļ���ͼ��
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
        
    //---�趨�ļ�ѡ��Ϊ0
    this.fileChecked=0;
}

/**
 * ����ļ����ļ�����(�ļ����ͣ��ļ����ƣ��ļ��޸�ʱ�䣬�ļ�ID���ļ��ؼ���ע��)
 * �����ļ�������
 * ���� void

*/

function addFile(fileType,fileName,fileEditTime,fileID,fileKeyWords) {
	 var s_file=new myFile(fileType,fileName,fileEditTime,fileID,fileKeyWords);
	 pasteFileRow(s_file);
	 inputFileArray[totalFile]=s_file;
	 totalFile++;
         
}

/**
 * �����ļ������е�HTML���ļ��ࣩ
 * ���� void  
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
 * ���ļ����ļ���ţ�
 * ���� void  
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
     	    //alert("���ı��ļ�"+openFile.fileID);	
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
 * �༭�ļ����ļ���ţ�
 * ���� void  
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
     	//alert("�༭�ı��ļ�"+openFile.fileID);
     	}
     if (openFile.fileType=="image") { 
     	var editImg=openEditImg(openFile.fileID);
     	//alert("�༭ͼƬ�ļ�"+openFile.fileID);	
     }
     
     if (openFile.fileType=="normal") { 
     	var editFile=openEditFile(openFile.fileID);
		//alert("�༭ͼƬ�ļ�"+openFile.fileID);	
     }
          
	
}

/**
 * ѡ���ļ����ļ���ţ�
 * ���� void  
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
       //alert("�ļ�δѡ��");       
         //---�޸�ͼ��
       icoObj.src="image/"+checkFile.file_Ico+"_check.gif";
         //---�޸����ֱ���ɫ
       nameRowObj.bgColor="#0A246A";
         //---�޸�������ɫ
       nameTextObj.color="#FFFFFF";    
       
       inputFileArray[fileNo].fileChecked=1;	
    } else {
       //alert("�ļ���ѡ��");
       
       icoObj.src="image/"+checkFile.file_Ico+".gif";
       nameRowObj.bgColor="";
       nameTextObj.color="#000000";  
       inputFileArray[fileNo].fileChecked=0;	
    }
	
}

/**
 * ѡ�������ļ�����
 * ���� void  
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
 * ȡ������ѡ���ļ�����
 * ���� void  
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
 * �ݽ�����Ŀ¼����Ŀ¼���ƣ�Ŀ¼���ͣ�
 * ���� void  
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
 * ��ʼ��ҳ��Event����
 * ���� void  
*/
function initPage() {
    document.onmousemove = doMouseMove;
    window.onscroll = doscroll;
    //refreshTree();
}

/**
 * ����mouseMove�¼�
 * ���� void  
*/

function doMouseMove() {
   mouse_X=window.event.clientX + PX;
   mouse_Y=window.event.clientY + PY;	
   //window.status="x="+mouse_X+"  y="+mouse_Y;	
}

/**
 * ����scroll�¼�
 * ���� void  
*/

function doscroll(){
      PY = document.body.scrollTop;
      PX = document.body.scrollLeft;
}

/**
 * ˢ���������
 * ���� void  
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
 * �Ҽ��򿪲˵�
 * ���� void  
*/   

function filePopMenu(fileNo) {
      var checkFile=inputFileArray[fileNo];	
      if (checkFile.fileChecked!=1) {
         checkIT(fileNo);	
      }
      currentCheckFile=fileNo;
      showFastMenu();	
      event.returnValue=false;
      //alert("��ʹ������򿪲˵�");	
} 

/**
 * �ݽ�ɾ��Ŀ¼��
 * ɾ������ѡ��Ŀ¼
 * ���� void  
*/  
function delDir() {
   var delDirID=checkFile();   
   if (delDirID!="") { 
   	if (confirm("ȷ��Ҫɾ����"+checkedFileLength+"���ļ���?   ")) {
   	         document.submitform.dirID.value=delDirID;
             document.submitform.event.value="del";
             document.submitform.submit();
			 refreshTree();  	
   	}   	
   } 
   else { alert("������ѡ��һ���ļ����в���");}	
}

/**
 * �ݽ��ƶ�Ŀ¼��
 * �ƶ�����ѡ��Ŀ¼��ָ��Ŀ¼
 * ���� void  
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
 * �ݽ�����Ŀ¼��
 * ��������ѡ��Ŀ¼��ָ��Ŀ¼
 * ���� void  
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
 * ���ѡ��Ŀ¼
 * ѡ���ļ����鸳ֵ
 * ���� ѡ��Ŀ¼ID���ַ��� "1111,2222,3333"  
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
 * �ж��Ƿ�Ϊϵͳ�ļ���
 * �ǣ����� flase
 * ��, ���� true  
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
 * ������window
 * 
 * ���� void  
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
 * ��ʾ�����Ĳ˵�
 * ���� void  
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
 * ���������Ĳ˵�
 * ����void 
*/ 

function hiddenFastMenu() {
    var fastMenu=eval("popMenu");
    fastMenu.style.visibility = "hidden";  	
}

/**
 * �����Բ˵�
 *  
*/ 

function openFileProperties() {
 
     openProperties(currentCheckFile);
}

/**
 * ���ļ�
 * ���� void  
*/ 

function openFilePop(){
     openIT(currentCheckFile);	
}

/**
 * �༭�ļ�
 * ���� void  
*/ 

function editFilePop() {
		if (checkSysFolder())
	{
		if (checkAccess()!="2") editIT(currentCheckFile);
		else {  alert("�޷�������Ŀ¼\n�ܾ�����");}
	}
   else { alert("�޷�������Ŀ¼\n��Ŀ¼��ϵͳĿ¼"); }
     
}

/**
 * �ƶ��ļ�
 * ���� void  
*/ 
function moveFilePop() {
    parent.parent.toolbar.moveFolder();
}

/**
 * �����ļ�
 * ���� void  
*/ 

function copyFilePop() {
    parent.parent.toolbar.copyFolder();
}

/**
 * ɾ���ļ�
 * ���� void  
*/ 

function delFilePop() {
    parent.parent.toolbar.delFolder();
}

/**
 * �������ļ�
 * ���� void  
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
		else {  alert("�޷�������Ŀ¼\n�ܾ�����");}
	}
   else { alert("�޷�������Ŀ¼\n��Ŀ¼��ϵͳĿ¼"); }
}

/**
 * �ݽ������������ļ�ID���ļ����ƣ�
 * ���� void  
*/ 

function renameDir(fileID,fileName) {
    document.submitform.dirID.value=fileID;
    document.submitform.dirName.value=fileName;
    document.submitform.event.value="rename";
    document.submitform.submit();
    refreshTree();   	
}
