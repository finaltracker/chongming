
function openEdit(editFileID)
{
  var editTxt = window.open("/wisoftedit/edit.po?fileID="+editFileID,"", "left=10,top=10,height=500px,width=720px,center=yes,status=no,toolbar=no,menubar=no,scrollbars=yes ");
  return editTxt;
}

function openEditImg(editFileID)
{
  var editImg = upload("infobase","image");
  
  
  if (editImg!=null&&editImg!="")
  {
    editImg=editImg.replace("\\","/");
	document.submitform.dirID.value=editFileID;
    document.submitform.dirName.value=editImg;
    document.submitform.event.value="changeImg";
    document.submitform.submit();
  }

  return editImg;
}

function openEditFile(editFileID)
{
  
  var editTxt = upload("infobase","normal");
  
  if (editTxt!=null&&editTxt!="")
  {
    editTxt=editTxt.replace("\\","/");
	document.submitform.dirID.value=editFileID;
    document.submitform.dirName.value=editTxt;
    document.submitform.event.value="changeFile";
    document.submitform.submit();
  }
  return editTxt;

}