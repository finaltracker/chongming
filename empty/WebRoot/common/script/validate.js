
var today = new Date();
var sError="";
String.prototype.trim = function(){
	return this.replace(/(^\s*)|(\s*$)/g, "");
}
String.prototype.ltrim = function(){
	return this.replace(/^\s*/g,"");
}
String.prototype.rtrim = function(){
	return this.replace(/\s*$/g,"");
}


function trim(){
	if(arguments.length<1)
		return null;
	if(typeof(arguments[0])=="string")
		return arguments[0].replace(/(^\s*)|(\s*$)/g, "");
	else
		return "";
}
function ltrim(){
	if(arguments.length<1)
		return null;
	if(typeof(arguments[0])=="string")
		return arguments[0].replace(/(^\s*)/g, "");
	else
		return "";
}
//字符去除左右空格函数
function rtrim(){
	if(arguments.length<1)
		return null;
	if(typeof(arguments[0])=="string")
		return arguments[0].replace(/(\s*$)/g, "");
	else
		return "";
}
//数字校验函数  是否是数字 
function __isNum(s)
{
	var re = /^[+|-]*[0-9]+$/;
	return re.test(s);
}
//是否是Float
function __isFloat(s)
{
	if (__isNum(s)) return true;
	var re = /^[+|-]{0,1}\d*\.\d*$/;
	return re.test(s);
}
//是否是科学计数法Float
function __isEFloat(s)
{
    var re = /^[+|-]{0,1}\d*\.[\.\d+]{0,1}\e[-|+]{0,1}\d+$/;
    return re.test(s);
}
//是否有特殊符号
function __isQuoteIn(s)
{
	var re = /\"|\'|\“|\”|\‘|\’|\%|\$|\￥|\……|\·|\—|\-|\——|\!|\！|\#|\@|\~|\^|\*|\,|\.|\，|\。|\?|\？|\;|\；|\:|\：|\{|\}|\\|\/|\[|\]|\(|\)|\+|\-|\、|\||\<|\>/;
	return re.test(s);
}
//整数 并且小于max，大于min 参数 对象object ，max，min
function isIntegerMaxMin(ob,max,min){
	var value=parseInt(ob.value);
	return ((value==ob.value)&&(value<max)&&(value>min));
}
//是否是整数  参数  对象
function isInteger(ob){
	var value=parseInt(ob.value);
	return (value==ob.value);
}
//判断对象的值是否是数字 参数  对象
function checkNum(eSrc)
{
	var value = eSrc.value;
	return __isNum(value);

}
//判断对象的值是否是小数数字  参数 对象
function checkFloat(eSrc)
{
	var value = eSrc.value;
	return __isFloat(value);
}
//判断对象的值是否是科学计数数字  参数 对象
function checkEFloat(eSrc)
{
	var value = eSrc.value;
	return __isEFloat(value);
}
//字符是否？
function __isNumChar(ch)
{
	return (ch >= '0' && ch <= '9');
}
//是否是空格，转行等
function __isBlankChar(ch)
{
	//去掉了'\v';20020522   
	return (ch == ' ' || ch == '\f' || ch == '\n' || ch == '\r' || ch=='\t');
}
//获得字符串的长度   一个汉字占2个字节
function byteLength(str)
{
	var x=0;
	for (i=0; i<str.length; i++) {
		if(str.charCodeAt(i) > 128){
			x=x+2;
		}else{
			x=x+1;
		}
	}
	return x;
}
//校验字符长度公共函数 对象ob,最大长度maxLen，消息message
function stringLengthCheck(ob,maxLen,message){
	if(byteLength(trim(ob.value))>maxLen){
		alert(message);
		return false;
	}
	return true;
}
//获得当前日期
function __getCurrentDate()
{
	var date = new Date();
	var year = ""+date.getFullYear();
	var month = date.getMonth()+1;
	if(month<10){ month="0"+month;}
	var day = date.getDate();
	if(day<10){ day = "0"+day;}
	return year+month+day;
}
//获得当前日期 格式为yyyy-MM-dd
function __getCurrentDateBar()
{
	var date = new Date();
	var year = ""+date.getFullYear();
	var month = date.getMonth()+1;
	if(month<10){ month="0"+month;}
	var day = date.getDate();
	if(day<10){ day = "0"+day;}
	return year+"-"+month+"-"+day;
}
//数学函数 格式化数据(截取小数四舍五入)   参数 对象值value，小数位
function __formatNum(value,scale){
	var f = parseFloat(value);
	if(scale<0)scale=0;
	return f.toFixed(scale);
}
//数学函数 格式化数据   参数 对象值value，小数位
function __setScale( value , scale )
{
	if( isNaN( value ) || isNaN( scale ) || parseInt( scale ) < 0 )
		return new String( value ) ;

	var strValue = new String( value ) ;
	var fValue = parseFloat( value ) ;
	var iScale = parseInt( scale ) ;
	
	if( iScale == 0 )
		return new String( ( fValue < 0.0 ? "-" : "" ) + Math.round( Math.abs( fValue ) ) ) ;
		
	if( fValue == parseInt( strValue ) )  //传入的参数没有小数部分
	{	
		strValue = new String( parseInt( strValue ) ) + "." ;

		for( var i = 0 ; i < iScale ; i ++ )
			strValue += "0" ;
	}
	else 
	{
		var fDecimal = Math.abs( fValue - parseInt( strValue ) ) ;
		fDecimal = Math.round( fDecimal * Math.pow( 10 , iScale ) ) ;
		var strDecimal = new String( fDecimal ) ;
		//对于像 new String( Math.round( 0.07 * Math.pow( 10 , 2 ) ) ) == "7" but not "07" 这样的情况需要作以下补零处理
		if( strDecimal.length < iScale ) 
		{
			var iDecimalLength = strDecimal.length ;
			
			for( var i = 0 ; i < iScale - iDecimalLength ; i ++ )
				strDecimal = "0" + strDecimal ;
	
			strValue = new String( parseInt( strValue ) ) + "." + strDecimal ;
		}
		//对于像 new String( Math.round( 0.995 * Math.pow( 10 , 2 ) ) ) == "100" 这样的情况需要作以下补零处理
		else if( strDecimal.length > iScale ) 
		{
			strValue = new String( parseInt( strValue ) + 1 ) ;			
			
			strValue += "." ;
			for( var i = 0 ; i < iScale ; i ++ )
				strValue += "0" ;
		}
		else
			strValue = new String( parseInt( strValue ) ) + "." + strDecimal ;
	}
	
	return strValue ;
}


//身份证的验证  参数 值
function __isIdCardNo(num)
{
	var a=null;
	var len = num.length, re; 
	if (isNaN(num)) {	
		//x结尾
		re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})([xX])$/);
		a=num.match(re);
		if(a!=null){			
		}else{
			alert("输入的身份证号含有不合法编号!");
			return false;
		}
	}else{	
	if (len == 15)
		re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/);
	else if (len == 18)
	re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\d)$/);
	else {alert("输入的身份证号位数有误！"); return false;}
	var a = num.match(re);
	}
	if (a != null)
	{
	if (len==15)
	{
		var D = new Date("19"+a[3]+"/"+a[4]+"/"+a[5]);
		var B = D.getYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5];
	}
	else
	{
		var D = new Date(a[3]+"/"+a[4]+"/"+a[5]);
		var B = D.getFullYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5];
	}
	if (!B) {alert("输入的身份证号 "+ a[0] +" 里出生日期不对！"); return false;}
}
return true;
}
//校验金额是否合格  like 9.9999
function __checkMoney(str){
	if (trim(str)==""){
		sError="请输入金额！";		
		return false;
	}
	if(isNaN(trim(str))){
		sError="输入金额数值不是数字！";		
		return false;
	}
	var nreg = /(^[0-9]+$)|(^[0-9]+)(.[0-9]+$)/;
	var nr = str.match(nreg); 
	if(nr==null){
		sError="输入的金额格式不对！";		
		return false;
	}else{
		return true;
	}	
}
//通常金额是两位  like 9.99
function __checkMoneyFix(str,n){
	if (trim(str)==""){
		sError="请输入金额！";		
		return false;
	}
	if(isNaN(trim(str))){
		sError="输入金额数值不是数字！";		
		return false;
	}
	var nreg = /(^[0-9]+$)|(^[0-9]+)(.[0-9]+$)/;
	var nr = str.match(nreg); 
	if(nr==null){
		sError="输入的金额格式不对！";		
		return false;
	}else{
		var index=str.indexOf(".")+1;
		var ss=str.substring(index);
		if(ss.length==n || index == 0){
		return true;
		}else{
		sError="输入的金额格式不对！";		
			return false;
		}
	}	
}
//校验邮箱  参数 对象.value
function __checkEmail(email)
{
// a very simple email validation checking. 
// you can add more complex email checking if it helps 
    var splitted = email.match("^(.+)@(.+)$");
    if(splitted == null) return false;
    if(splitted[1] != null )
    {
      var regexp_user=/^\"?[\w-_\.]*\"?$/;
      if(splitted[1].match(regexp_user) == null) return false;
    }
    if(splitted[2] != null)
    {
      var regexp_domain=/^[\w-\.]*\.[A-Za-z]{2,4}$/;
      if(splitted[2].match(regexp_domain) == null) 
      {
	    var regexp_ip =/^\[\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}\]$/;
	    if(splitted[2].match(regexp_ip) == null) return false;
      }// if
      return true;
    }
return false;
}

//checkbox 全选中 参数 checkbox的name, 是否ture,false
function __checkAll(name,tf)
{
  var a = document.getElementsByName(name);
  var n = a.length;
  for (var i=0; i<n; i++)
  a[i].checked = tf;
}
//checkbox 是否有选中 参数 checkbox的name  返回值为选中的个数，没有选中时返回 0
function __checkSelectCheckbox(name)
{
  var a = document.getElementsByName(name);
  var n = a.length;
  var isCheck=0;
  for (var i=0; i<n; i++){
	  if(a[i].checked){
		  isCheck++;
	  }
  }
  return isCheck;
}
//日期校验函数  20040501

function __checkStdDate(eSrc)
{
	var value = eSrc.value;
	if (!__isNum(value)) {
		sError = "不是合法的日期";
		return false;
	}
	if (value.length != 8) {
		sError = "日期长度不对";
		return false;
	}

	var year = value.substring(0,4);
	var month = value.substring(4,6);
	var day = value.substring(6,8);
	var y = year * 1;
	var m = month * 1;
	var d = day * 1;
	var bReturn = __isLegalDate(y,m,d);
	return bReturn;
}
//日期校验函数  200405
function __checkStdMonth(eSrc)
{
	var value = eSrc.value;
	if (!__isNum(value)) {
		sError = "不是合法的日期";
		return false;
	}
	if (value.length != 6) {
		sError = "日期长度不对";
		return false;
	}

    var year = value.substring(0,4);
	var month = value.substring(4,6) - 1;
	var bReturn = __isLegalMonth(year,month);
	return bReturn;
}
//月份校验 0--12
function __checkMonth(eSrc)
{
    var value = eSrc.value;
    if (!__isNum(value)) {
		sError = "必须是整数";
		return false;
	}
    if(value < 0 || value > 12)
     {
     	sError = "月份不能小于1，也不能大于12";
     	return false;
     }
   	return true;
}
//年份校验
function __checkStdYear(eSrc)
{
	var value = eSrc.value;
	if (value.length != 4) {
		sError = "日期长度不对";
		return false;
	}
	if (!__isNum(value)) {
		sError = "不是合法的日期";
		return false;
	}
	var year = value;
	var bReturn = __isLegalYear(year);
	return bReturn;
}
//121212   12点12分12秒
function __checkStdTime(eSrc)
{
		var value = eSrc.value;
	if (value.length != 6) {
		sError = "时间长度不对";
		return false;
	}
	if (!__isNum(value)) {
		sError = "不是合法的时间";
		return false;
	}
	var hour = value.substring(0,2);
	var minute = value.substring(2,4);
	var second = value.substring(4,6);
	var bReturn = __isLegalTime(hour, minute, second);
	return bReturn;
}
//时间格式的检验  适合于20:30:59格式
function __checkTime(eSrc){
   var value=eSrc.value;
   var rs= /^d{2}\:d{2}\:d{2}$/;
   if(!rs.test(value)){
     	alert("请输入正确的时间格式！");
     	return fasle;
   }	
   var arr = rs.split(":");
   if(parseInt(arr[0])>24||parseInt(arr[1])>59||parseInt(arr[2])>59){
   	alert("请输入正确的时间格式！");
   	return fasle;
   }
   return true;
}
//年月日校验2004/05/01
function __checkSlashStdDate(eSrc)
{
	var value = eSrc.value;
	if (value.length != 10) {
		sError = "日期长度不对";
		return false;
	}
	var re = /\d{4}\/\d{2}\/\d{2}/;
	if (!re.test(value)) {
		sError = "不正确的日期格式，正确格式为YYYY/MM/DD";
		return false;
	}
	var year = value.substring(0,4);
	var month = value.substring(5,7) - 1;
	var day = value.substring(8,10);
	var bReturn = __isLegalDate(year,month,day);
	if (false == bReturn)
		return false;
	return true;
}

//年月日校验2004-05-01
function __checkBarStdDate(eSrc)
{
	var value = eSrc.value;
	if (value.length != 10) {
		sError = "日期长度不对";
		return false;
	}
	var re = /\d{4}\-\d{2}\-\d{2}/;
	if (!re.test(value)) {
		sError = "不正确的日期格式，正确格式为YYYY-MM-DD";
		return false;
	}
	var year = value.substring(0,4);
	var month = value.substring(5,7) - 1;
	var day = value.substring(8,10);
	var bReturn = __isLegalDate(year,month,day);
	if (false == bReturn)
		return false;
	return true;
}

//是否合法的日期？month 基于0
function __isLegalDate(year,month,day)
{
     if(year < 1900 || year > 3000)
     {
     	sError = "年份错误";
     	return false;
     }
     if(month < 0 || month > 12)
     {
     	sError = "月份不能小于1，也不能大于12";
     	return false;
     }
     if(day < 1)
     {
     	sError = "日期不能小于1";
     	return false;
     }
     if (day > 31)
     {
     	sError = "日期不能大于31";
     	return false;
     }
     if(month == 2)
     {
     	if( __isLeapYear(year)  )
     	{
        	if(day > 29)
        	{
         		sError = "润年，2月份日期不能大于29";
         		return false;
         	}
		}
		else
		{
			if(day > 28)
			{
				sError = "非润年，2月份日期不能大于28";
				return false;
			}
		}
	} else
	{
		var d1, m1=month;
		if(m1 > 7)
			m1 = m1 + 1;
		d1 = 30 + m1 % 2;
		if(day > d1)
		{
			sError = "该月日期不能大于" + d1 +"天";
			return false;
		}
	}
	return true;
}
//是否是润年
function __isLeapYear(year)
{
	if( ( year % 400 == 0) || (( year % 4 == 0) && (year % 100 != 0)) )
		return true;
	else
		return false;
}
//是否合法的月？
function __isLegalMonth(year,month)
{
     if(year < 1900 || year > 3000)
     {
     	sError = "年份错误";
     	return false;
     }
     if(month < 0 || month > 12)
     {
     	sError = "月份不能小于1，也不能大于12";
     	return false;
     }
	return true;
}
//是否合法的年？
function __isLegalYear(year)
{
     if(year < 1900 || year > 3000)
     {
     	sError = "年份错误";
     	return false;
     }
	return true;
}
//是否是合法的时分秒
function __isLegalTime(hour, minute, second)
{
     if(hour < 0 || hour > 23)
     {
     	sError = "时钟错误";
     	return false;
     }
     if(minute < 0 || minute > 59)
     {
     	sError = "分钟错误";
     	return false;
     }
     if (second < 0 || second > 59)
     {
     	sError = "秒钟错误";
     	return false;
     }
	return true;
}

/*********************************
*判断是否是单字节a-zA-Z0-9_-之中
**********************************/
function isSingleFormat(str)
{
  var singleFormat = /^[.a-zA-Z0-9_-]+$/;
  if(!singleFormat.test(str)) 
	{
	  	return false;
	 }
	 return true;
}

/**************************************
*判断是否是负数
***************************************/
function checkNegative(arg){		
	if(isNaN(arg)){
		if(arg.value<0){
			return true;
		}
		return false;
	}
	if(arg*1<0){
		return true;
	}
	return false;
}

//时间格式的检验  适合于20:30:59格式
function __checkTime(s){
   var rs= /^\d{2}\:\d{2}\:\d{2}$/;
   if(!rs.test(s)){
     	return false;
   }	
   var arr = s.split(":");
   if(parseInt(arr[0])>24||parseInt(arr[1])>59||parseInt(arr[2])>59){
   	return false;
   }
   return true;
}

//检验代码格式  一般情况下代码只能由英文字符或数字组成,不能含有中文
function __checkCode(s){
 	var rs = /^([0-9]|[a-z]|[A-Z])+$/;
 	if(!rs.test(s)){
 		return false;
 	}
 	return true;
}

//检验IP地址的合法性 例如:10.162.11.104是正确的IP地址
function __checkIp(s){
  var re = /^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/;
  if(!re.test(s)){
     return false;
  }
  var ips=s.split(".");
  if((ips[0].indexOf("0")==0)||(ips[1].indexOf("0")==0)||(ips[2].indexOf("0")==0)||(ips[3].indexOf("0")==0)){
     return false; 
  }
  if(ips[0]>255 || ips[1]>255|| ips[2]>255 || ips[3]>255 ){
     return false;
  }
  return true;
}

//检验中国邮编 只能是6位数字
function __checkChinaPostCode(s){
	var rs=/\d{6}/;
	if(!re.test(s)){
		return false;
	}
        return true;
}
/**
* XMLHTTP 提交,调用某方法
**/
//通过xmlhttp取值，返回字符串
function getHtmlStringByXmlhttp(url)
	{
	if(url==null)
	{
	alert("传递的URL不能为空！");
	return;
	}
	try
		{
		var xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		if(xmlhttp==null)
		{
		alert("创建XMLHTTP对象失败!"+ex.description);
		return ;
		}
		xmlhttp.open("POST",url,false);
		xmlhttp.send();
		return xmlhttp.responseText;
		}catch(ex)
		{
		alert("XMLHTTP对象传递数据失败!"+ex.description);
		return "";
		}
	}
	
function getArrayByXmlHttp(urll){
	 var values=getHtmlStringByXmlhttp(urll);	
     if(values.indexOf("noresult")>-1){
       return -1;
     }
	 var arr=new Array();
	 var obs=values.split("@|@");	 
	 for(var i=0;i<obs.length;i++){	 
	 	 obsv=obs[i].split("@,@");	
	 	 arr[i]=obsv;		 	
	 } 
	 return arr;
}
//比较开始日期和结束日期 baixch添加20050416
function __compareDate(startDate,endDate){
	var startD  = startDate.value;
	var endD	= endDate.value;

	if(startD==endD){
		return 0;
	}
	else if(startD>endD){
		return -1	
	}
	else if(startD<endD){
		return 1;	
	}			
}

//企业帮助框
function openQyFind(){
//	alert("calling openQyfind");
	var strRtn = window.showModalDialog('../codeConversion/qyFindFrame.htm','','dialogWidth:500px;dialogheight:600px');
	if(strRtn!=null&&strRtn!=""&&strRtn!="undefined"){
		if(strRtn.indexOf("+")>0){
        var arrValue = strRtn.split("+");
        // orgCode,enterpriseName,enterpriseId,busCode,taxCode,dsdjh,sbbh,fddbr,jgcxzb,qydz
        //返回值示例
				//document.forms[0].orgCode.value=arrValue[0];
				//document.forms[0].enterpriseName.value=arrValue[1];
				//document.forms[0].enterpriseId.value=arrValue[2];
				//document.forms[0].busCode.value=arrValue[3];
				//document.forms[0].taxCode.value=arrValue[4];
				//document.forms[0].dsdjh.value=arrValue[5];
				//document.forms[0].sbbh.value=arrValue[6];
				//document.forms[0].fddbr.value=arrValue[7];
				//document.forms[0].jgcxzb.value=arrValue[8];
				//document.forms[0].qydz.value=arrValue[9];
				
				//写判断条件，给与值 
				//机构内码 id
				//alert(arrValue[0])
				if(document.all.id!=undefined){
					document.all.id.value=arrValue[0];
				}
				//企业名称
				if(document.all.jgmc!=undefined){
					document.all.jgmc.value=arrValue[1];
				}
				//组织机构代码
				if(document.all.zzjgdm!=undefined){
					document.all.zzjgdm.value=arrValue[0];
				}
				//法人代表身份证号
				if(document.all.sfzh!=undefined){
					document.all.sfzh.value=arrValue[7];
				}
				//企业地址
				if(document.all.qydz!=undefined){
					document.all.qydz.value=arrValue[9];
				}
		}
	} 
	
}