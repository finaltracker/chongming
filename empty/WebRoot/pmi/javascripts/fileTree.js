/* $Revision$ $Date$ $Author$ */
/***********************************************************************
* ADSTAR Distributed Storage Manager (adsm)                            *
* Server Component                                                     *
*                                                                      *
* IBM Confidential                                                     *
* (IBM Confidential-Restricted when combined with the Aggregated OCO   *
* Source Modules for this Program)                                     *
*                                                                      *
* OCO Source Materials                                                 *
*                                                                      *
* 5648-020 (C) Copyright IBM Corporation 1990, 1997 (Unpublished)      *
***********************************************************************/

/***********************************************************************
* Name:
*        JSTree.js
*
* Function:
*        Provide a Dynamic tree in a web browser.
*
* Author:
*        BJ Scheid
*        Roy Tritch
*
* Status:
*        Version 3, Release 2
*
* Environment:
*        This is a PLATFORM-INDEPENDENT source file. As such it may
*        contain no dependencies on any specific operating system
*        environment or hardware platform.
*
* Public Routines:
*
* Description:
*        ...
*
* Design Notes:
*        ...
*
* Change activity:
*        ...
*
*  $Log$
*
***********************************************************************/

/////////////////////////////////////////////////////////////
// Golbal Variables
/////////////////////////////////////////////////////////////

var tree_root = null;        // node to the root of the tree
var maxNodes = 0;            // total count of the nodes
var browser = 0;             // browser type
var nodeIndex = new Array();        // index of all the nodes in the tree
var totalWidth = 0;          // total width of the tree
var abort = null;            // Abort Url if browser doesn't support dhtml
var selected = null;         // The currently selected item
var imagePath = "../images/";    // Path to images, postpended with '/'
var expandDepth = -1;        // Depth to which we should initially expand;
                             // expand the entire tree by default
var showselect = 1;          // = 1 if we are to change icon on select
var selectedicon = "select.gif";
var saveloadInCookie = true;
var imageW = 15;
var imageH = 13;

var historyOID=new Array();   // 历史的OID记录
    historyOID[0]="-1";
var currentID= 1;         // 当前打开的历史数组ID
var isHistory = 0;        //  是否是history打开

var totalHTML="";
/////////////////////////////////////////////
///////////////The class of tree!!
///////////////////////////////////////

function Tree()
{
  this.treeRoot=null;
  this.expandAble=false;
  this.expandDepth=1;
  this.browser=0;
 
  
  this.displayTree=displayTree;
  this.addRoot=addRoot;
  this.addItem=addItem;
  this.createNodeIndex=createNodeIndex;

}


/////////////////////////////////////////////////////////////
// initalize()
//   Display the inital state of the tree.
//
// Inputs:
//   None.
// Output:
//   Tree is displayed in the browser.
// Notes:
//   The tree has already been built by the setTreeRoot and
//   addTreeNode methods.
/////////////////////////////////////////////////////////////

function outputTree(tree)
{
  //document.writeln(tree.treeRoot.content);
  tree.createNodeIndex(tree.treeRoot);
  nodeIndex1=tree.nodeIndex;
  if(tree.browser==1){
    var k;
    // Find the maximum width of the tree...
    for(k = 0; k < tree.nodeIndex.length; k++)
    {
      var ndWidth = (tree.nodeIndex[k].content.length * 7) + (22 *tree.nodeIndex[k].level);
      if(ndWidth > totalWidth)
         totalWidth = ndWidth;
    }

    // The total height is the number node multiplied by the
    // number of icons plus some rubber chicken number.
    var totalHeight = (tree.nodeIndex.length * 22) + 20;


    outTreeHTML("<layer ID=Sizer visibility=show width="+totalWidth+" height="+totalHeight+" Z-INDEX=0></LAYER>"); 
    iFontSize = 16; 
   } 
  else 
      iFontSize = 14; 
  
  tree.displayTree(tree.treeRoot,"",false,true,1); 
  outTreeHTML("<br>");

  if( tree.expandDepth != null && tree.expandDepth != 0 ) 
     { 
       tree.treeRoot.visible = true; 
       if(browser == 1) 
             tree.treeRoot.layer.visibility="show"; 
        else 
             document.all["Item"+tree.treeRoot.id].style.display="block"; 
        //tree.treeRoot.expanded = true; 
       // Show's Roots Children 
        expandChildren(tree.treeRoot,expandDepth); 
      } 
      
      //document.write(totalHTML);
   
}

function createTree()
{
  // Determine the browser type
  // Browser Types:
  // 0 - Not supported
  // 1 - Netscape Communicator
  // 2 - IE 4.0
  var browserVer = parseInt(navigator.appVersion);
  var browserNam = navigator.appName;

  if(browserNam == "Netscape" && browserVer >= 4)
    browser = 1;
  else if(browserVer >= 4)
    browser = 2;
 
  var tempTree=new Tree();
  tempTree.browser=browser;  
  return tempTree;  
}



/////////////////////////////////////////////////////////////
// Define a tree node
//
// Inputs:
//   icon - name of the icon eg. /file/btn.gif
//   content - node or foler content (can be HTML text)
//   link - link for the name and icon
//   parent - parent node
//   id - id assigned to the node
/////////////////////////////////////////////////////////////
function TreeNode(icon, icon2, content, link, parent, id, level, is_selectable , oid)
{
  // Class Variables
  this.browser = 0;             // Browser Type
  this.icon   = icon;             // Content Icon
  this.icon2 = icon2;             // Content Icon
  this.link = link;             // Content Link
  this.level = level;           // Nodes Level wrt root node
  this.content = content;       // Content to be displayed
  this.parent = parent;         // Parent TreeNode
  this.children = new Array;    // Children of the current TreeNode
  this.childCount = 0;          // Number of children of this TreeNode
  this.id = id;                 // TreeNode Id number
  this.layer = null;            // Layer refering to the content displayed
  this.width = 0;               // Width of the layer
  this.height = 0;              // Height of the layer
  this.expanded = false;        // Are the children visible
  this.visible = false;         // Is the node itself visiable
  this.PSrc = null;             // Plus icon source url
  this.MSrc = null;             // Minus icon source url
  this.button = null;           // Browser image object to the PM button
  this.img = null;              // Browser image object to the icon
  this.selectable = is_selectable; // Item is Selectable?
  this.oid = oid;                //the oid of treenode.
  // Class Methods
  this.layout = JSTree_Layout;

}


/////////////////////////////////////////////////////////////
// createNodeIndex()
//   Create an index of all the nodes in the tree to speedup
//   lookup work.
//
// Inputs:
//   The root of the tree.
// Output:
//   The nodeIndex is created.
/////////////////////////////////////////////////////////////
function createNodeIndex(node)
{
  nodeIndex[node.id] = node;

  var i;
  for(i = 0; i < node.childCount; i++)
  {
      this.createNodeIndex(node.children[i]);
  }
  

}

/////////////////////////////////////////////////////////////
// displayTree()
//   display the tree built in memory
//
// Inputs:
//   node - the node to show
//   spacer - html text spacer
//   lastNode - boolean flag inidcating last child
//   root - is this node the root node.
// Outputs:
//   The tree is displayed to the browser's window
/////////////////////////////////////////////////////////////
function displayTree(node, spacer, lastnode, root, level)
{
// Build the item layer

   outTreeHTML("<div id=Item"+node.id+"  style={display:none} nowrap><table border=0 cellpadding=0 cellspacing=0><tr>");

// Add the spacer to the item

   if(!root)
      outTreeHTML(spacer);

// Set the node's layer

   if(node.browser == 1)
      node.layer = document.layers['Item'+node.id];
   else
      node.layer = document.all["Item"+node.id];

// Determine what or if plus-minus buttons are needed.

   if(node.childCount >0) {
      if(!root) {
      // add the appropate  buttons
         if(lastnode) {
             node.PSrc = imagePath + "lplus20.gif";
             node.MSrc = imagePath + "lminus20.gif";
           if( this.expandDepth == null || this.expandDepth < 0 || level <= this.expandDepth )
              useSrc = node.MSrc;
           else
              useSrc = node.PSrc;

            outTreeHTML("<td bgcolor='#FFFFFF' nowrap><a onclick='expandCompressNode("+node.id+");return false' >");
            outTreeHTML("<img src='../orgmgt/js/%22+%20useSrc%20+%22' name='PM"+node.id+"' valign=middle>");
           outTreeHTML("</A>");
           spacer += "<td bgcolor='#FFFFFF' nowrap><img src="../orgmgt/js/%20+%20imagePath%20+%20"blank20.gif  width=19 height=16 valign=middle  border=0></td>";
        }
         else {
            node.PSrc = imagePath + "tplus20.gif";
            node.MSrc = imagePath + "tminus20.gif";
           if( this.expandDepth == null || this.xpandDepth < 0 || level <= this.expandDepth )
               useSrc = node.MSrc;
            else
               useSrc = node.PSrc;

            outTreeHTML("<td bgcolor='#FFFFFF' nowrap><a onclick='expandCompressNode("+node.id+");return false' >");
            outTreeHTML("<img src='../orgmgt/js/%22+%20useSrc%20+%22' name='PM"+node.id+"' "+
             "+"  valign=middle>");
            outTreeHTML("</A>");
            spacer += "<td bgcolor='#FFFFFF' nowrap><img src="../orgmgt/js/%20+%20imagePath%20+%20"line.gif valign=middle  border=0></td>";
         }  // end if lastnode

      // Set the node button to the appropate browser image object

         if(node.browser == 1)
        node.button = node.layer.document.images['PM'+node.id];
         else
        node.button = document.all['PM'+node.id];
     }  // if (!root)

   // Write the content of the node out
   
 
      if(!root)
     {
      
	  outTreeHTML("<img src="../orgmgt/js/+node.icon+" name='icon" + node.id + "' valign=middle  border=0></td>");
      outTreeHTML("<td nowrap id='txt"+node.id+"' style='border-left: 3 solid #FFFFFF' bgcolor='#FFFFFF' ><p  style='margin-left: 2; margin-right: 2; margin-top: 2'>");
	   
	   if (node.selectable) {
		  if (showselect)
			 outTreeHTML("<a onclick=\"" + ebs(node.link) + "; Sel(" + node.id + ")\">");
		  else
			 outTreeHTML("<a onclick=\"" + ebs(node.link) + "\">");
			  }
	   else
		  outTreeHTML("<span class=greyed>");
	  
	  outTreeHTML(node.content);
       
	  if (node.selectable)
        outTreeHTML( "</a>" );
      else
        outTreeHTML( "</span>" ); 
     
        outTreeHTML("</p></td>");
      }
      else
      {
		outTreeHTML("<td bgcolor='#FFFFFF' nowrap><p style='margin-left: 5;margin-top: 3'><a onclick='expandCompressNode("+node.id+");return false' >");
      	outTreeHTML("<img src="../orgmgt/js/+node.icon+" name='icon" + node.id + "' hspace=0 vspace=0  valign=middle border=0 >");
      	outTreeHTML("</A></p></td>");
      	outTreeHTML("<td valign='middle' style='border-left: 3 solid #FFFFFF' id='txt0' bgcolor='#FFFFFF' nowrap><p style='margin-left: 2; margin-right: 2; margin-top: 2'><a onclick=\""+ebs(node.link)+"; Sel(" + node.id + ")\">" + node.content +"</A></p></td>" );
      }
      
 
   // Set the node icon to the appropriate browser image object
   if(node.browser == 1)
          node.img = node.layer.document.images['icon'+node.id];
   else
      {
      node.img = document.all['icon'+node.id];
      }

   // Close the item layer

   outTreeHTML("</tr></table></div>");

   // Loop around all the children and add them

   for(var i = 0; i < node.childCount; i++) {
      var lstnode = false;
      if(i == (node.childCount -1))
         lstnode = true;
         this.displayTree(node.children[i], spacer, lstnode, false, level+1);
      }

   } // end if( has children)
   else {

   // Add node without childern, note spacer does not change.
     if(root)
     {
		outTreeHTML("<td bgcolor='#FFFFFF' nowrap><p style='margin-left: 5;margin-top: 3'><a onclick='expandCompressNode("+node.id+");return false'>");
      	outTreeHTML("<img src="../orgmgt/js/+node.icon+" name='icon" + node.id + "'  valign=middle  border=0 >");
      	outTreeHTML("</A></p></td>");
      	outTreeHTML("<td valign='middle' style='border-left: 3 solid #FFFFFF' id='txt0'  bgcolor='#FFFFFF' nowrap><p style='margin-left: 2; margin-right: 2; margin-top: 2'><a onclick=\""+ebs(node.link)+"; Sel(" + node.id + ")\">" + node.content +"</A></p></td>" );
      }
      else
      {
      	
   //角
   if(lastnode)
      outTreeHTML("<td bgcolor='#FFFFFF' nowrap><img src="../orgmgt/js/%20+%20imagePath%20+%20"lbar20.gif "+
         "+"  valign=middle hspace=0 vspace=0 border=0>");
   else
      outTreeHTML("<td bgcolor='#FFFFFF' nowrap><img src="../orgmgt/js/%20+%20imagePath%20+%20"tbar20.gif "+
         "+"  valign=middle hspace=0 vspace=0 border=0>");

   // Write the content of the node out
 
   
   
   outTreeHTML("<img src="../orgmgt/js/+node.icon+" name='icon" + node.id + "' border=0  valign=middle></td>");
   outTreeHTML("<td bgcolor='#FFFFFF' id='txt"+node.id+"' nowrap style='border-left: 3 solid #FFFFFF'><p  style='margin-left: 2; margin-right: 2; margin-top: 2'>");
   
   if (node.selectable) {
      if (showselect)
         outTreeHTML("<a onclick=\"" + ebs(node.link) + "; Sel(" + node.id + ")\">");
      else
         outTreeHTML("<a onclick=\"" + ebs(node.link) + "\">");
   }
   else
      outTreeHTML("<span class=greyed>");
   
   outTreeHTML(node.content);
   
   if (node.selectable)
       outTreeHTML( "</a>" );
   else
       outTreeHTML( "</span>" );
   
   outTreeHTML("</p></td>");

  
   if(node.browser == 1)
      node.img = node.layer.document.images['icon'+node.id];
   else
      {
      node.img = document.all['icon'+node.id];
      }
   // Close the item layer


      outTreeHTML("</tr></table></div>");
     }// if root
 
   }

}

/////////////////////////////////////////////////////////////
// addItem()
//   Add an item to the tree
// Inputs:
//   parent - parent node
//   icon - name of the icon eg. ./file/btn.gif
//   content - node or foler content (can be HTML text)
//   link - link for the name and icon
// Output:
//   The tree node that has been created.
/////////////////////////////////////////////////////////////
function addItem(parent, icon, icon2,content, link , oid)
{
  var selectable = true;
//  if(tree_root == null)
//    alert("ERROR:\n Adding nodes to a null tree.\n"+ "Define the root first with addRoot().");

  if(parent == null)
    // assume that a null parent infers adding to the root node
    parent = this.treeRoot;


  var tempNode = new TreeNode(icon, icon2, content, link, parent, maxNodes++, parent.level + 1, selectable, oid);
  tempNode.browser = this.browser;

  parent.children[parent.childCount++] = tempNode;

  return tempNode;
}

/////////////////////////////////////////////////////////////
// addRoot()
//   Set the root of the tree to be constructed
// Inputs:
//   parent - parent node
//   icon - name of the icon eg. ./file/btn.gif
//   content - node or foler content (can be HTML text)
//   link - link for the name and icon
// Output:
//   The root tree node that has been created.
/////////////////////////////////////////////////////////////
function addRoot(icon,icon2,content, link , oid)
{
  // Determine the browser type
  // Browser Types:
  // 0 - Not supported
  // 1 - Netscape Communicator
  // 2 - IE 4.0
  var browserVer = parseInt(navigator.appVersion);
  var browserNam = navigator.appName;
  var selectable = true;


  // create a new node and set that as the root.
  var tempNode = new TreeNode(icon, icon2, content, link, null, maxNodes++, 1, selectable , oid);
  tempNode.browser = this.browser;

  this.treeRoot = tempNode;
  return tempNode;
}

/////////////////////////////////////////////////////////////
// setAbort()
//   Set the url to abort to if browser dosen't support dhtml
//
// Inputs:
//   url - url to abort to if browser does not support Dynamic
//         html.
// Output:
//   golbal abort command is set
/////////////////////////////////////////////////////////////
function setAbort(url)
{
   abort = url;
}

function setSaveloadInCookie(save)
{
   saveloadInCookie = save;
}

function setImageSize(w,h)
{
   imageW = w;
   imageH = h;
}

function setImagePath(path)
{
   imagePath = path;
}

function setExpandDepth(iDepth)
{
   if( iDepth != null && iDepth >= 0 )
       expandDepth = iDepth;
}

/////////////////////////////////////////////////////////////
// expandChildren()
//   Expand the chlidren of the node by making the chlidren
//   nodes visable.
//
// Inputs:
//   node - the node to be expanded
//   depth - the absolute depth to which to expand (optional)
//           null:  expand leaves if previously expanded
//           < 0 :  forcefully expand entire tree
//           > 0 :  forcefully expand tree n levels from root
// Output:
//   None.
/////////////////////////////////////////////////////////////
function expandChildren(node,depth)
{
  var i;
  if( depth )
     depth--;

  node.expanded = true;

  for(i = 0; i < node.childCount; i++)
  {
    var cnode = node.children[i];

    // show the layers of this node
    if(cnode.browser == 1)
      document.layers['Item'+cnode.id].visibility="show";
    else
      document.all["Item"+cnode.id].style.display = "block";

    cnode.visible = true;

    // open up any previouly open children

    if( depth == null && cnode.expanded )
         expandChildren(cnode);
   else {
      if(depth != null && depth != 0 )
         expandChildren(cnode,depth);
   }
  }
}

/////////////////////////////////////////////////////////////
// expandCompressNode()
//   Event Handler for the Plus-Minus buttons.  This procedure
//   will either expand a node or compress a node depending on
//   the current state of node.
//
// Inputs:
//   id - the id number of the node of which created the event
// Output:
//   None.
/////////////////////////////////////////////////////////////

function expandCompressNode(id)
{
  var node = nodeIndex[id];
  // determine the current state of the node
  if(!node.expanded)
  {
    // Expand the node
    if(node.button)node.button.src = node.MSrc;
    document.all["icon"+id].src = node.icon2;
    node.expanded = true;

    // Show all the children
    expandChildren(node);
  }
  else
  {
    //Compress the node
    if(node.button)node.button.src = node.PSrc;
    document.all["icon"+id].src = node.icon;
    node.expanded = false;

    // Hide all the Children
    compressChildren(node);
  }

  if(node.browser == 1)
    node.layout();
    
  //save the tree
  if(saveloadInCookie)saveTreeToCookie();   

}

/////////////////////////////////////////////////////////////
// compressChildren()
//   Compress the chlidren of the node by hiding its chlidren
//   nodes.
//
// Inputs:
//   node - the node to be compressed
// Output:
//   None.
/////////////////////////////////////////////////////////////
function compressChildren(node)
{
  var i;
  for(i = 0; i < node.childCount; i++)
  {
    var cnode = node.children[i];

    // Handle the different browser cases
    if(cnode.browser == 1)
      document.layers['Item'+cnode.id].visibility="hide";
    else
      document.all["Item"+cnode.id].style.display = "none";

    // update the node visible flag
    cnode.visible = false;

    // close up the child's children
    if(cnode.childCount > 0)
      compressChildren(cnode);
  }
}

/////////////////////////////////////////////////////////////
// JSTree_Layout()
//   Layout the layers of the tree one after another.
//
// Inputs:
//   None.  Uses document.layers to do the layout.
// Output:
//   A Laid out tree.
// Note:
//   This function is only needed for Netscape.
/////////////////////////////////////////////////////////////
function JSTree_Layout()
{
  var docLayers;

  // extract the layers of the document
  docLayers = document.layers;

  // initalize position and loop variables
  var i = 0;
  var posY = docLayers[i].pageY + docLayers[i].document.height;

  for(i = 1; i < docLayers.length; i++)
  {
    // don't layout a hidden layer
    if(docLayers[i].visibility != "hide")
    {
      // set the location of the layer
      docLayers[i].moveTo(docLayers[i].x, posY);
      posY += docLayers[i].document.height;
    }
  }
}

function Sel(id) {
  var node = nodeIndex[id];
  //alert("sel id"+id);
  if (selected != null) {
     var obj=eval("txt"+selected.id);
     obj.style.backgroundColor="";
     obj.style.color="";	
     selected.img.src = selected.icon;
   }
  if (node!=null) {
  
  selected = node;
  var obj=eval("txt"+id);
  obj.style.backgroundColor="#0A246A";
  obj.style.color="#ffffff";	
  if (id>0) {
   	  
	  selected.img.src = imagePath + selectedicon;	  
  
	    
	  
	  var node_ptr = selected.parent;
	  var need_refresh = false;

	  while (node_ptr && node_ptr != tree_root) {

		  if (!node_ptr.expanded) {
			  node_ptr.button.src = node_ptr.MSrc;
			  expandChildren(node_ptr);
			  node_ptr = node_ptr.parent;
			  need_refresh = true;
		  }
		  else
			  break;
	  }

	  if (need_refresh && node.browser == 1)
		node.layout();
  }
  else {
     
  }
   //save the tree
   //alert("isHistory"+isHistory);
  if (!isHistory) { 
   historyEdit("add",node.oid);
  }
  isHistory = 0;
  if(saveloadInCookie)saveTreeToCookie();     
  }
}

// browsers parse (and unescape) the onclick in the processing 
// of an onclick.  By the time str gets to our callback,
// it is escaped again.  This ensures our callback gets a
// string with escaped backslashes.

function ebs(str) {
  if (!str || str == null)
     return("");

  return (str.replace(/\\/g, "\\\\"));
}


function outTreeHTML(html)
{
     document.write(html);
     totalHTML+=html;
}



/////////////////////////////////////////////REM TREE/////////////////////////
/////////////////////////////////////////////zergcom/////////////////////////////
//////////////////////////////////////////
//get the OID string which is expanded node
//////////////////////////////////////////

function getExpandOIDStr()
{
    var str = '';
    for(i=0;i<nodeIndex.length;i++)
    {
      if(nodeIndex[i].parent == null)
      {
      	if(nodeIndex[i].expanded)
      	   str+="<"+nodeIndex[i].oid+"+>";
      	 else  
      	   str+="<"+nodeIndex[i].oid+"->";
      }
      else if(nodeIndex[i].expanded)
      {
      	str+=nodeIndex[i].oid;
                  str+='|';
      }
    }
    
    str+="<>";
    if (selected!=null) str+=("["+selected.id+"]");
    str+="{";
    for (var j=0;j<historyOID.length;j++) {
       str+=historyOID[j]+",";	
    }
    str+="}";
    str+="{{"+currentID+"}}"
    //alert("save Str"+str);
    return str;
}

/////////////////////////////////////////
//write the oidstr to cookie
//call it in unload event.
////////////////////////////////////////
function saveTreeToCookie()
{
       
       document.cookie = getExpandOIDStr();
        
  
}

var OIDStr = document.cookie;
/////////////////////////////////////////
//restore the tree from cookie
////////////////////////////////////////
function restoreTreeFromCookie(root)
{
     var str = OIDStr;
     var lpot = str.indexOf("<"+root.oid);
     var rpot = str.indexOf(">",lpot);
 
	 if(rpot==-1||lpot==-1) {
          var tempID=1;
	      Sel(tempID);
		  clk("",nodeIndex[tempID].oid);
          return;
	 }
       
	  var rootOpen = str.charAt(rpot-1)=='+';
	  var lastpot = str.indexOf("<",rpot);
	  if(lastpot>=0)
      {
      	root.expanded = rootOpen;
      	if(root.expanded)document.all["icon"+root.id].src = root.icon2;
      	restoreTree(str.substring(rpot+1,lastpot),rootOpen);
      }
      
      if(rootOpen)expandChildren(root,1); 
      
      lpot = str.indexOf("[");
      rpot = str.indexOf("]");
      if(lpot>0&&rpot>0) {
		  var tempID=str.substring(lpot+1,rpot);
		  Sel(tempID);
		  clk("",nodeIndex[tempID].oid);
	  }      
      lpot = str.indexOf("{");
      rpot = str.indexOf("}");
      var historyStr="";
      if(lpot>0&&rpot>0) {
         historyStr= str.substring(lpot+1,rpot);  	
      }
      //alert("get historyStr"+historyStr);
      var h_length=0;
      while (historyStr!="") {
      	 lpot = historyStr.indexOf(",");
         if (lpot>0) { 
             historyOID[h_length]=historyStr.substring(0,lpot);
             h_length ++;
             
         }
         historyStr = historyStr.substring(lpot+1);	
      }
      
      lpot = str.indexOf("{{");
      rpot = str.indexOf("}}");
      if(lpot>0&&rpot>0) {
         currentID= parseInt(str.substring(lpot+2,rpot));
      } 
     //alert("get currentID"+currentID);	
 }


////////////////////////////////////////
//expands the tree by gived OIDStr.
///////////////////////////////////////
function restoreTree(OIDStr,open)
{
    
    var str   = new String(OIDStr);
    var myid;
    var oid;
    var index1 = 0;
    var index2 = 0;
    
    index2 = str.indexOf("|");
    
    
    while(index2>=0)
    {
    	oid = str.substring(index1,index2);
    	myid= getIDByOID(oid);
    	//alert(oid+">>>>"+myid);   
    	if(myid>0)
    	{
    		if(isParentsExpannd(myid)&&open)
    		{
    		    expandCompressNode(myid);
    		    
    		 }
    		else
    		{
    		    if(nodeIndex[myid].button)nodeIndex[myid].button.src = nodeIndex[myid].MSrc
    		    document.all["icon"+myid].src = nodeIndex[myid].icon2;
    		    nodeIndex[myid].expanded = true;
    		    
    		}
    	}
    	
    	
    	index1 = index2+1;
    	if(index1>=str.length)break;
    	index2 = str.indexOf("|",index1);
    }
    

    	
}


//get the id by OID
function getIDByOID(oid)
{
    if(oid==0)return 0;
    var myid = -1; 
    for(i=0;i<nodeIndex.length;i++)
    {
      if(nodeIndex[i].oid==oid)
          {myid=nodeIndex[i].id;break;}
    }
    return myid;
}

//find the all parents of the node is expanded!
//if all parens expand ,return true ; else false.
function isParentsExpannd(myid)
{
     var canEx = true;//nodeIndex[myid].expanded;
     var parent = nodeIndex[myid].parent;
      
     while(parent!=null)
     {
     	canEx  = canEx&&parent.expanded;
     	parent = parent.parent;
     }
    
   // alert(myid+"--->"+canEx);
    
    return canEx;
   
}

function openFolder(myOID) {
	//alert("oid"+myOID);
	Sel(getIDByOID(myOID));
	clk("",myOID); 
}

function openUpFolder(myOID) {	
    if (getIDByOID(myOID)!=-1)
    {    
    
	var parentFolder=nodeIndex[getIDByOID(myOID)].parent;
   	if(parentFolder) Sel(parentFolder.id);
	}

}

function historyEdit(editType,editValue) {
    if (editType=="add") {
    	var tempOID=new Array();
       	for (var i=0;i<currentID;i++) {
       	   tempOID[i]=historyOID[i];	
       	}
       	tempOID[currentID]=editValue;
       	historyOID=tempOID;
        currentID++;
    } else { 
    if (editType=="next") {
       if (currentID<historyOID.length) { 
       	   currentID++;
           if(saveloadInCookie)saveTreeToCookie();
           isHistory = 1;
           openFolder(historyOID[currentID-1]);
           }
       else {   alert("已是历史的最后记录");}
    }
    if (editType=="pre") {
       if (currentID>2) { 
       	currentID--;
        if(saveloadInCookie)saveTreeToCookie();
        isHistory = 1;		
        openFolder(historyOID[currentID-1]);        
        }
       else {   alert("已是历史的最初记录");}	
    }
    
    }	
}


function nextFolder() {
    historyEdit("next","");
    	
}

function preFolder() {
    historyEdit("pre","");	   
}

function upFolder() {
   if (selected!=null)
   {
	   if (selected.oid=="share"||selected.oid=="root"||selected.id==0) alert("没有更高的目录");
	   else {
		var upFolderNode=selected.parent;
		openFolder(upFolderNode.oid);  
	   }	         
   }
}

