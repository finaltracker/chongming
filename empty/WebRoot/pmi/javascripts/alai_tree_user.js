/*****************************************************************************************
	����Ŀ¼���ؼ�Windows2000 Explorerģ����� �������������2003��7��16�գ���������Ȩ����
******************************************************************************************/

function getScriptPath(js)
{
	js=js.toLowerCase()
	var script=document.getElementsByTagName("SCRIPT");
	for(var i=0;i<script.length;i++)
	{
		var s=script[i].src.toLowerCase()
		if(s.indexOf(js)!=-1)return s.replace(js,"")
	}
	return null
}

function alai_tree_user(toObject)
{
	var path=getScriptPath("alai_tree.js")
	if(path==null){alert("run alai_tree_user() fail, please load alai_tree.js first!");return;}
	var icons=new alai_imagelist()
	icons.path=path+"images/"
	icons.add("company","default")
	icons.add("plus","expand")
	icons.add("minus","collapse")
//	icons.add("ball1","open")
//	icons.add("ball1","close")
//	icons.add("plus_m","expand")
//	icons.add("plus_top","expand_top")
//	icons.add("plus_end","expand_end")
//	icons.add("minus_m","collapse")
//	icons.add("minus_top","collapse_top")
//	icons.add("minus_end","collapse_end")
//	icons.add("branch","leaf")
//	icons.add("branch_end","twig")
//	icons.add("vline","line")
	icons.add("department")
	icons.add("person")
	icons.add("group")
      	icons.add("subsystem")
	var tree=new alai_tree(icons,16,toObject)
	var lastNode=null
//	tree.onexpand=function(srcNode)
	{
		//srcNode.icon.src=icons.item["open"].src
	}
//	tree.oncollapse=function(srcNode)
	{
		//srcNode.icon.src=icons.item["close"].src
	}
	return tree
}
