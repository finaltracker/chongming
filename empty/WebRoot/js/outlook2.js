
$(function(){
	InitLeftMenu();
	tabClose();
	tabCloseEven();




	$('#tabs').tabs({
	   
        onSelect: function (title) {
            var currTab = $('#tabs').tabs('getTab', title);
            var iframe = $(currTab.panel('options').content);
			var src = iframe.attr('src');
			var href=src;
			//alert(href);
			if(src)
			
			refreshTab({tabTitle:title,url:href});
			setTimeout('removediv()',1000);
				//$('#tabs').tabs('update', {tab: currTab, options: {content: createFrame(src)}});

        }
    });

})
        //页面加载等待
        function loadwait(){
           $("<div class=\"datagrid-mask\" id=\"divlz\"></div>").css({display:"block",width:"100%",height:$(window).height()}).appendTo("body");
           $("<div class=\"datagrid-mask-msg\" id=\"divloading\"></div>").html("正在处理，请稍候。。。").appendTo("body").css({display:"block",left:($(document.body).outerWidth(true) - 190) / 2,top:($(window).height() - 45) / 2}); 
        }
        //删除DIV
         function removediv(){
            if($("#divlz").length>0){
			   $("#divlz").remove(); 
			}if($("#divloading").length>0){
			   $("#divloading").remove(); 
			}
          }
//初始化左侧
function InitLeftMenu() {
	$("#nav").accordion({animate:false});

    $.each(_menus.menus, function(i, n) {
		var menulist ='';
		var fun='';
		menulist +='<ul>';
        $.each(n.menus, function(j, o) {
            if(o.icon=='icon-nav'){
                fun="icon-funs";
            }else{
                fun=o.icon;
            }
			menulist += '<li><div><a ref="'+o.menuid+'" href="#" rel="' + o.url + '" ><span class="icon '+fun+'" >&nbsp;</span><span class="nav">' + o.menuname + '</span></a></div></li> ';
        })
		menulist += '</ul>';

		$('#nav').accordion('add', {
            title: n.menuname,
            content: menulist,
            iconCls: 'icon ' + n.icon
        });

    });

	$('.easyui-accordion li a').click(function(){
		var tabTitle = $(this).children('.nav').text();

		var url = $(this).attr("rel");
		var menuid = $(this).attr("ref");
		var icon = getIcon(menuid,icon);

		addTab(tabTitle,url,icon);
		$('.easyui-accordion li div').removeClass("selected");
		$(this).parent().addClass("selected");
	}).hover(function(){
		$(this).parent().addClass("hover");
	},function(){
		$(this).parent().removeClass("hover");
	});

	//选中第一个
	var panels = $('#nav').accordion('panels');
	var t = panels[0].panel('options').title;
    $('#nav').accordion('select', t);
}
//获取左侧导航的图标
function getIcon(menuid){
	var icon = 'icon ';
	$.each(_menus.menus, function(i, n) {
		 $.each(n.menus, function(j, o) {
		 	if(o.menuid==menuid){
				icon += o.icon;
			}
		 })
	})

	return icon;
}






//添加一个新的tab,全部以iframe的形式来加载
function addTab(title, href, icon){
        if(icon=='icon icon-nav'){
          icon="icon-tab";
        }
    var tt = $('#tabs');
    if (tt.tabs('exists', title)){//如果tab已经存在,则选中并刷新该tab
        tt.tabs('select', title);
        //alert('title'+title);
        //refreshTab({tabTitle:title, url:href});
    } else {
        if (href){
           //alert('href:'+href);
           loadwait(); //页面加载等待
           var content =  createFrame(href);
        } else {
             
            var content = 'tab页已经存在';
        }
        tt.tabs('add',{
	    style: {padding:0},
	            title:title,
	            closable:true,
	            content:content,
	             iconCls:icon||''
	        });
	    }
	}
	
/**
 * 刷新tab
 * @cfg
 *example: {tabTitle:'tabTitle',url:'refreshUrl'}
 *如果tabTitle为空，则默认刷新当前选中的tab
 *如果url为空，则默认以原来的url进行reload
 */
function refreshTab(cfg){
    var refresh_tab = cfg.tabTitle ? $('#tabs').tabs('getTab', cfg.tabTitle) : $('#tabs').tabs('getSelected');
    if(refresh_tab && refresh_tab.find('iframe').length > 0){
    var _refresh_ifram = refresh_tab.find('iframe')[0];
    var refresh_url = cfg.url ? cfg.url : _refresh_ifram.src;
     //_refresh_ifram.contentWindow.location = refresh_url;
    }
}



function createFrame(url)
{
	var s = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	return s;
}

function tabClose()
{
	/*双击关闭TAB选项卡*/
	$(".tabs-inner").dblclick(function(){
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close',subtitle);
	})
	/*为选项卡绑定右键*/
	$(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY
		});

		var subtitle =$(this).children(".tabs-closable").text();

		$('#mm').data("currtab",subtitle);
		$('#tabs').tabs('select',subtitle);
		return false;
	});
}
//绑定右键菜单事件
function tabCloseEven()
{
	//刷新
	$('#mm-tabupdate').click(function(){
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		$('#tabs').tabs('update',{
			tab:currTab,
			options:{
				content:createFrame(url)
			}
		})
	})
	//关闭当前
	$('#mm-tabclose').click(function(){
		var currtab_title = $('#mm').data("currtab");
		$('#tabs').tabs('close',currtab_title);
	})
	//全部关闭
	$('#mm-tabcloseall').click(function(){
		$('.tabs-inner span').each(function(i,n){
			var t = $(n).text();
			$('#tabs').tabs('close',t);
		});
	});
	//关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function(){
		$('#mm-tabcloseright').click();
		$('#mm-tabcloseleft').click();
	});
	//关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function(){
		var nextall = $('.tabs-selected').nextAll();
		if(nextall.length==0){
			return false;
		}
		nextall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});
	//关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		if(prevall.length==0){
			return false;
		}
		prevall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});

	//退出
	$("#mm-exit").click(function(){
		$('#mm').menu('hide');
	})
}

//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) {
	$.messager.alert(title, msgString, msgType);
}
function randomChar(length)  {   
    length = length || 32;   
    var source = "abcdefghzklmnopqrstuvwxyz";   
    var random = "";   
    for(var i = 0;i < length; i++)  {   
        random += source.charAt(Math.ceil(Math.random()*100000000)%source.length);   
    }   
    return random;   
  }