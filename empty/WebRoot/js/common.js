   function returneditorstyle(){
  var result=[
             'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy',
			'paste','plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
			'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
			'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 
			'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
			'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image',
			'multiimage','flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
			'anchor', 'link', 'unlink', '|','adduser',  'fullscreen']
   return result;
}
//将多个编辑器的内容设置到原来的textarea控件里
function editorsync(){
      var kes=KindEditor.instances;
      for(var i=0;i<kes.length;i++){
            kes[i].sync();
      }
}

//创建编辑器 ids:编辑器的id,多个id,用","分割
function createEditor(ids){
    KindEditor.create(ids, {
		 resizeType : 1,
		 allowPreviewEmoticons : false,
		 allowImageUpload : true,
		 uploadJson : $("#paths").val()+'/js/kindeditor/jsp/upload_json.jsp',
	     fileManagerJson : $("#paths").val()+'/js/kindeditor/jsp/file_manager_json.jsp',
		items : returneditorstyle()
	});
}
   
function openwindow(url,name,iWidth,iHeight) {
		  var url;                                 //转向网页的地址;
		  var name;                           //网页名称，可为空;
		  var iWidth;                          //弹出窗口的宽度;
		  var iHeight;                        //弹出窗口的高度;
		  var iTop = (window.screen.availHeight-30-iHeight)/2;       //获得窗口的垂直位置;
		  var iLeft = (window.screen.availWidth-10-iWidth)/2;           //获得窗口的水平位置;
		  window.open(url,name,'height='+iHeight+',,innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
 }
