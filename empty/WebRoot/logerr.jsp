<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow:hidden;
}
.STYLE3 {font-size: 17px; color: #adc9d9; }
-->
</style>
<SCRIPT language=javascript>
 /* $(window).resize(function(){ 
	    $(".login").css({ 
	        position: "absolute", 
	        left: ($(window).width() - $(".login").outerWidth())/2, 
	        top: ($(window).height() - $(".login").outerHeight())/2 
	    	});        
		}); */

	/*$(function(){ 
     	$(window).resize(); 
	}); */
  
  
  /*--------------------------------------*/
  function check()
  {
    var cn = document.all('cn');
    var password = document.all('password');
    if(!cn.value)
    {
      alert('用户名不能为空');
      cn.focus();
      return false;
    }
    if(!password.value)
    {
      alert('密码不能为空');
      password.focus();
      return false;
    }
    return true;
  }
  
  function chongzhi(){
  	document.all('cn').value="";
    document.all('password').value="";
  }
  
  function initPage(){
  
  	//alert(window.top+"   "+window.self);
  	
  	if(window.top != window.self ){
  		window.parent.location.href="/web/login.jsp";
  	}else{
  		
  	}
  	
  }
 </SCRIPT>
</head>

<body onload="initPage();">
<form id="submitForm" action="/web/loginAction.do" method="POST" onSubmit="return check();">
<div class="login">
		<h1></h1>
		<div class="login_1">
			<div class="login_bg">
				<dl>
					<dt><td align="center">用户登录</td></dt>
					<dd><span>用户名：</span><input type="text" id="cn" name="cn" size="29" class="text_h"></dd>
					<dd><span>密&nbsp;&nbsp;&nbsp;码：</span><input type="password" id="password" name="password" size="29" class="text_h"></dd>
					<dd style="height:20px;line-height:20px;padding-left:100px;"><td width="292" align="center"><font color="red">用户名或密码是不正确</font></td></dd>
					<dd><input type="button" value="重置" class="login_icon radius" onclick="chongzhi()"></dd>
					<dd><input type="submit" value="登录" class="login_icon radius"></dd>
				</dl>
			</div>
		</div>
</div>
</form>
</body>
</html>

