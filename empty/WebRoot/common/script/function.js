<script language="javascript">
//--------------------------------------------------------------------------------------------------
//���´��ں���			: winopen(url,winWidth,winHeight) 
//url					: �¿������urlֵ����news.asp�У��������ӡ�?Title=�½�Ա�����Ȳ����������¿������Title��
//winWidth				: �¿�����Ŀ��
//winHeight				: �¿�����ĸ߶�
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