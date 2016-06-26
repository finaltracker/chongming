	//打开 strs div id 如：#divid1
		function open1(str){
		     setwindow(str);
			$('#'+str).window('open');
		}
		//关闭 strs div id 如：#divid1
		function close1(strs){
			$('#'+strs).window('close');
		}
		//设置窗体
		function setwindow(str){
		$('#'+str).window({   
            //width:600,   
            //height:400,   
            modal:true,
            draggable:true,
            shadow:true
           });}