function newFolder() {
   
   if (parent.right.main.checkSysFolder()) {	
   if (parent.right.main.checkAccess()=="0")
   {   
	   var newFolder=window.showModalDialog('new.htm','','dialogwidth=270px;dialogheight=160px;status=no');
	   if ((newFolder!=null)&&(newFolder[1]!="")) { 
		 parent.right.main.addDir(newFolder[1],newFolder[0]);
	   }
   }
   else {  alert("无法创建新目录\n拒绝访问"); }
   }
   else {  alert("无法创建新目录\n当前目录是系统目录");}	
}

function moveFolder() {
	
   if (parent.right.main.checkFile()!="") { 	
	if (parent.right.main.checkSysFolder()) {
	  if (parent.right.main.checkAccess()=="0") {
		 var topDepID=top.document.all.getDepID.value;
	   var moveFolder=window.showModalDialog('move.htm',topDepID,'dialogwidth=320px;dialogheight=270px;status=no')
	   if ((moveFolder!=null)&&(moveFolder!="")) { 
		 parent.right.main.moveDir(moveFolder);
	   }
      }else { alert("无法移动该目录\n拒绝访问"); }
    }
	else {  alert("无法移动该目录\n当前目录是系统目录");}	
   }
   else { alert("请至少选择一个文件进行操作");}
	
}

function copyFolder() {

   if (parent.right.main.checkFile()!="") { 	
	if (parent.right.main.checkSysFolder()) {
		if (parent.right.main.checkAccess()=="0") {
		   var topDepID=top.document.all.getDepID.value;
		   var copyFolder=window.showModalDialog('copy.htm',topDepID,'dialogwidth=320px; dialogheight=270px; status=no')
		   if ((copyFolder!=null)&&(copyFolder!="")) { 
			 parent.right.main.copyDir(copyFolder);
		   }
		}
		else {  alert("无法复制该目录\n拒绝访问");}	
    }
	else {  alert("无法复制该目录\n当前目录是系统目录");}	
   }
   else { alert("请至少选择一个文件进行操作");}
	
}


function delFolder() {
	if (parent.right.main.checkSysFolder()) {
		if (parent.right.main.checkAccess()=="0") {
           parent.right.main.delDir();
		}
		else {
		   alert("无法删除该目录\n拒绝访问");
		}
	}
	else {  alert("无法删除该目录\n当前目录是系统目录");}	
}

function openUpFolder() {
  parent.left.folder.upFolder();	 	
}

function openNextFolder() {

  parent.left.folder.nextFolder();
  	
}

function openPreFolder() {
 parent.left.folder.preFolder();		
}


function checkFrame() {
   alert(parent.left.folder.name);	
}