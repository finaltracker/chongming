var code ; //在全局 定义验证码
function createCode(){ 
code = "";
var codeLength = 4;//验证码的长度
var checkCode = document.getElementById("checkCode");
checkCode.value = "";
var selectChar = new Array(2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');
for(var i=0;i<codeLength;i++) {
   var charIndex = Math.floor(Math.random()*32);
   code +=selectChar[charIndex];
}
if(code.length != codeLength){
   createCode();
}
checkCode.value = code;
	//document.getElementById("yzcode").value=code;
	
}

function validate() {
var inputCode = document.getElementById("yzcode").value.toUpperCase();
var umobj =document.getElementById("um");
var um =umobj.value;
var pswobj =document.getElementById("psw");
var psw=pswobj.value;
if(um ==''){alert("请输入用户名！"); umobj.focus();}else if(psw==''){alert("请输入密码"); pswobj.focus();}else if(um !='' && psw!=''){
if(inputCode.length <=0) {
   alert("请输入验证码！");
   document.getElementById("yzcode").focus();
}else if(inputCode != code ){
   alert("验证码输入错误！");
   document.getElementById("yzcode").focus();
   createCode();
}if(inputCode !='' && inputCode==code){
     var url=document.getElementById("paths").value;
    var infos = "{\"um\":\""+um+"\",\"psw\":\""+psw+"\"}";
     var info = escapeparam(infos);
     window.location.href=url+"/iappuser.do?dispatch=login&info="+info+"&tim"+new Date().getTime();
}}
}
 function escapeparam(value){
             return escape(escape(value));
           }