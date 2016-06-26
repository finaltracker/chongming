<script language="javascript">
//--------------------------------------------------------------------------------------------------
//打开新窗口函数			: winopen(url,winWidth,winHeight) 
//url					: 新开窗体的url值，在news.asp中，可以增加“?Title=新建员工”等参数来设置新开窗体的Title名
//winWidth				: 新开窗体的宽度
//winHeight				: 新开窗体的高度
//author				: xiaye 2002-9-13
//lastmodified			: 2002-9-16
//--------------------------------------------------------------------------------------------------
function winopen(url,winWidth,winHeight)                    
{              
	 var feature = "toolbar=0,location=0,status=0,menubar=0,scrollbars=1,resizable=1,top=40,left=80,height="  
	 if (winWidth == "")
	 {
	 	feature = feature + 350;
	 	feature = feature + ",width=";
	 	feature = feature + 320; 
	 }
	 else
	 {
	 	feature = feature + winHeight;
	 	feature = feature + ",width=";
	 	feature = feature + winWidth; 
     }
	 window.open(url,"search",feature);                    
}       

function viewopen(url)
{
	//window.open(url);
	winopen(url,600,500);                   
}
</script>