function upload(path,type)
{
	var id = window.showModalDialog("/upload/Upload.po?uploadpath="+path,type,
		'dialogWidth:330px; dialogHeight:280px; status:no;');
    return id;
}