function newFolder() {
   
   if (parent.right.main.checkSysFolder()) {	
   if (parent.right.main.checkAccess()=="0")
   {   
	   var newFolder=window.showModalDialog('new.htm','','dialogwidth=270px;dialogheight=160px;status=no');
	   if ((newFolder!=null)&&(newFolder[1]!="")) { 
		 parent.right.main.addDir(newFolder[1],newFolder[0]);
	   }
   }
   else {  alert("�޷�������Ŀ¼\n�ܾ�����"); }
   }
   else {  alert("�޷�������Ŀ¼\n��ǰĿ¼��ϵͳĿ¼");}	
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
      }else { alert("�޷��ƶ���Ŀ¼\n�ܾ�����"); }
    }
	else {  alert("�޷��ƶ���Ŀ¼\n��ǰĿ¼��ϵͳĿ¼");}	
   }
   else { alert("������ѡ��һ���ļ����в���");}
	
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
		else {  alert("�޷����Ƹ�Ŀ¼\n�ܾ�����");}	
    }
	else {  alert("�޷����Ƹ�Ŀ¼\n��ǰĿ¼��ϵͳĿ¼");}	
   }
   else { alert("������ѡ��һ���ļ����в���");}
	
}


function delFolder() {
	if (parent.right.main.checkSysFolder()) {
		if (parent.right.main.checkAccess()=="0") {
           parent.right.main.delDir();
		}
		else {
		   alert("�޷�ɾ����Ŀ¼\n�ܾ�����");
		}
	}
	else {  alert("�޷�ɾ����Ŀ¼\n��ǰĿ¼��ϵͳĿ¼");}	
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