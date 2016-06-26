//var gbDftYear = <%=Year(Now)%>;
//var gbDftMonth = <%=Month(Now)%>;
//var gbThisYear = <%=Year(Now)%>;
//var gbThisMonth = <%=Month(Now)%>;
var theDate = new Date();
var gbDftYear = theDate.getYear();
var gbDftMonth = theDate.getMonth()+1;
var gbThisYear = gbDftYear;
var gbThisMonth = gbDftMonth;
//var gbDftDay = <%=Day(Now)%>;
//var gbThisDay = <%=Day(Now)%>;


var gbDivOrgLeft, gbDivOrgTop;
var gbBodytopMargin;

var gbobjDiv;

var gbtxtDftMonth;	


var gbobjSelectYear;
var gbobjSelectMonth;


function fncCal(txtObj, cmdObj, frmObj)
{
	gbtxtDftDate = txtObj;		//获取控件的日期值
	var DefaultMonth = gbtxtDftDate.value;
	var DefaultYear;
	if (DefaultMonth == "")
	{
		gbDftMonth = 0;
	}
	else
	{
//		gbDftYear =  <%=Year(Now)%>;
//		gbDftMonth = <%=Month(Now)%>;
		gbDftYear =  theDate.getYear();
		gbDftMonth = theDate.getMonth()+1;
	}
	
	fncCalDivINIT(divCale);
	
	fncCalDivShow(divCale, cmdObj, frmObj.year, frmObj.month, gbDftYear, gbDftMonth);
}

function fncCalDivINIT(objDiv)
{
	var strTemp = "";

	strTemp += "<table style='font-size:2pt' border=1 bordercolor=336699 cellpadding=0 cellspacing=0>";
	strTemp += "<tr><td>                                                                             ";
	strTemp += "<table style='font-size:2pt' cellpadding=0 cellspacing=0 width=150 bgcolor='#e4e9f1'>";
	strTemp += "<tr><td class='tdCalHead'>                                                           ";
	strTemp += "<input type='text' value='' id='years' onchange='fncChangeYear(year)' style='border:1px solid #0000; height:18;cursor:hand;width:40'  alt='跳转年份'><br>";

	strTemp += "<img src='../common/img/calprevyear.gif' onclick='fncPrevYear(year)' style='cursor:hand' alt='上一年'> ";
	//strTemp += "<img src='../common/img/calprevmonth.gif' onclick='fncPrevMonth(year, month)' style='cursor:hand' alt='上一月' > ";
	strTemp += "<input type=hidden name=year value='" + gbDftYear + "'" + 
	"onpropertychange='oaYear.innerText=this.value;fncMakeCal(year, month, gbDftYear, gbDftMonth)'>";
	strTemp += "<a name='oaYear'>" + gbDftYear + "</a>";
	strTemp += "年";
	strTemp += "&nbsp;"
	strTemp += "<input type=hidden name=month value='" + gbDftMonth + "'" + 
	"onpropertychange='oaMonth.innerText=(parseInt(this.value)<10 ? \"&nbsp;\" + this.value: this.value);fncMakeCal(year, month, gbDftYear, gbDftMonth, gbDftDay)'>"
	//strTemp += "<a name='oaMonth'>" + (parseInt(gbDftMonth)<10 ? "&nbsp;" + gbDftMonth: gbDftMonth) + "</a>";
	//strTemp += "月 ";
	//strTemp += "<img src='../common/img/calnextmonth.gif' onclick='fncNextMonth(year, month)' style='cursor:hand' alt='下一月'> "
	strTemp += "<img src='../common/img/calnextyear.gif' onclick='fncNextYear(year)' style='cursor:hand' alt='下一年'> "
	strTemp += "</td>                                                                                ";
	strTemp += "<td valign='top' align=right><img src='../common/img/calclose.gif' onclick='fncHideDiv(divCale)' alt='关闭'></td>";
	strTemp += "</tr></table>                                                                        ";
	strTemp += "                                                                                     ";
	strTemp += "                                                                                     ";
	strTemp += "<a name='aCalendarTable'></a>";
	strTemp += "<div align='center'><table cellpadding=1 cellspacing=0 class='tableCalBottom'><tr><td  class='tdCalBottom'>";
	//strTemp += "<img src='../common/img/calsettoday.gif' alt='今天' onclick='fncSetToday()' class='imgSetDate'> ";
	strTemp += "<img src='../common/img/lookup.gif' alt='置空' onclick='fncSetNone()' class='imgSetDate' > ";
	strTemp += "</td></tr></table></div>"

	strTemp += "</td></tr>";
	strTemp += "</table>                                      ";
	objDiv.style.display = "none";
	objDiv.innerHTML = strTemp;
}

/////////////////////////////////////////////////////////////////////////////////////////
//	函数意义		：控制日历图层内容显示
//	objDiv		：显示日历的图层
//	objButton	：this对象，即被点击的图片对象
//	objYear		：form中的year input框
//	objMonth		：form中的month input框
//	DftYearValue：当天年份
//	DftMonthValue：当天月份
/////////////////////////////////////////////////////////////////////////////////////////
function fncCalDivShow(objDiv, objButton, objYear, objMonth, DftYearValue, DftMonthValue)
{
	var objBtnParent = objButton;
	var objBtnLeft = 0;
	var objBtnTop = 0;

	gbobjDiv = objDiv;
	
	gbobjSelectYear = objYear;
	gbobjSelectYear = objMonth;

	y = 0;
	while (objBtnParent.tagName.toUpperCase() != "BODY")
	{
		objBtnLeft  += objBtnParent.offsetLeft;
		objBtnTop   += objBtnParent.offsetTop;
		objBtnParent = objBtnParent.offsetParent;
	}
	x = objBtnLeft + 10;
	y = objBtnTop;
	
	if (divCale.style.display == "none")
	{

		fncMakeCal(objYear, objMonth, DftYearValue, DftMonthValue);
		gbobjDiv.style.display = "block";
		if (x + gbobjDiv.clientWidth > document.body.clientWidth)
		{
			x = document.body.clientWidth - gbobjDiv.clientWidth;
		}
		gbobjDiv.style.left = x;

		if (y + gbobjDiv.clientHeight > document.body.clientHeight)
		{
			y = document.body.clientHeight - gbobjDiv.clientHeight;
		}
		gbobjDiv.style.top = y;
		//window.setTimeout("hideElement('SELECT')", 2);
		//window.setTimeout("hideElement('OBJECT')", 2);
	}
	else
	{
		fncHideDiv(gbobjDiv);
	}
}

/////////////////////////////////////////////////////////////////////////////////////////
//	函数意义		：准备写出日历内容
//	objYear		：form中的year input框
//	objMonth		：form中的month input框
//	DftYearValue：当天年份
//	DftMonthValue：当天月份
/////////////////////////////////////////////////////////////////////////////////////////
function fncMakeCal(objYear, objMonth, DftYearValue, DftMonthValue)
{
	var SelectYear = objYear.value;
	var SelectMonth = objMonth.value;
	aCalendarTable.innerHTML = fncGetCaleTable(objYear, objMonth, DftYearValue, DftMonthValue);
}

/////////////////////////////////////////////////////////////////////////////////////////
//	函数意义		：写日历内容
//	objYear		：form中的year input框
//	objMonth		：form中的month input框
//	DftYearValue：当天年份
//	DftMonthValue：当天月份
/////////////////////////////////////////////////////////////////////////////////////////
function fncGetCaleTable(objYear, objMonth, DftYearValue, DftMonthValue)
{
	// Year是在div里选择的年
	// Month是在div里选择的月
	// DefaultY是传来的默认年
	// DefaultM是传来的默认月

	Year = parseInt(objYear.value);
	Month = parseInt(objMonth.value);

	DefaultY = parseInt(DftYearValue);
	DefaultM = parseInt(DftMonthValue);
	//DefaultD = parseInt(DftDayValue);
	var CaleStr = "";
	CaleStr += "<table cellpadding=1 cellspacing=1 class='tableCal'>";
	CaleStr += "<tr>";
	CaleStr += "<td class='tdCalNormal'><a onClick='Feedback(" + Year + ",1)'>01</a></td>";
	CaleStr += "<td class='tdCalNormal'><a onClick='Feedback(" + Year + ",2)'>02</a></td>";
	CaleStr += "<td class='tdCalNormal'><a onClick='Feedback(" + Year + ",3)'>03</a></td>";
	CaleStr += "<td class='tdCalNormal'><a onClick='Feedback(" + Year + ",4)'>04</a></td>";
	CaleStr += "<td class='tdCalNormal'><a onClick='Feedback(" + Year + ",5)'>05</a></td>";
	CaleStr += "<td class='tdCalNormal'><a onClick='Feedback(" + Year + ",6)'>06</a></td>";
	CaleStr += "</tr>";
	CaleStr += "<tr>";
	CaleStr += "<td class='tdCalNormal'><a onClick='Feedback(" + Year + ",7)'>07</a></td>";
	CaleStr += "<td class='tdCalNormal'><a onClick='Feedback(" + Year + ",8)'>08</a></td>";
	CaleStr += "<td class='tdCalNormal'><a onClick='Feedback(" + Year + ",9)'>09</a></td>";
	CaleStr += "<td class='tdCalNormal'><a onClick='Feedback(" + Year + ",10)'>10</a></td>";
	CaleStr += "<td class='tdCalNormal'><a onClick='Feedback(" + Year + ",11)'>11</a></td>";
	CaleStr += "<td class='tdCalNormal'><a onClick='Feedback(" + Year + ",12)'>12</a></td>";
	CaleStr += "</tr>";

	CaleStr += "</table>";

	return CaleStr;
}

///////////////////////////////////////////////////////////////////////////////////////
//	返回值
//////////////////////////////////////////////////////////////////////////////////////
function Feedback(YearValue, MonthValue)
{
	YearValue = YearValue.toString();
	MonthValue = MonthValue.toString();
	if (MonthValue.length == 1)
	{
		MonthValue = "0" + MonthValue;
	}

	fncHideDiv(gbobjDiv);

	gbtxtDftDate.value = YearValue + "-" + MonthValue;
}


function GetInt(n1, n2)
{
	if (n2 != null && n2 != 0)
	{
		return Math.floor(n1 / n2);
	}
}


function CalcDayOfWeek (Year, Month , Day) 
{
	Year = parseInt(Year);
	Month = parseInt(Month);
	Day = parseInt(Day);
	var Century, Holder;

	if ((Year < 0) || (Month < 1) || (Month > 12) || (Day < 1) || (Day > 31) )
	{
		return -1; // return -1 to indicate an error 
	}

	var dateObj = new Date(Year, Month -1 , Day);
	return dateObj.getDay();
}


function CalcDayOfMonth(Year, Month)
{
	Year = parseInt(Year);
	Month = parseInt(Month);

	if ((Year < 0) || (Month < 1) || (Month > 12) )
	{
		return -1; // return -1 to indicate an error 
	}
	
	if (Month != 2)
	{
		if (((Month <=7) && (Month % 2 == 1)) || (Month >=8) && (Month % 2 == 0) )
		{
			return 31;
		}
		else
		{
			return 30;
		}
	}
	// Month is Feb
	if (isLeapYear(Year) == 1)
	{
		return 29;
	}
	else
	{
		return 28;
	}
}


function hideElement(elmID)
{
	for (i = 0; i < document.all.tags(elmID).length; i++)
	{
		obj = document.all.tags(elmID)[i];
//		alert(obj.name)
		if (! obj || ! obj.offsetParent || obj.name=='year' || obj.name=='month')
			continue;

		// Find the element's offsetTop and offsetLeft relative to the BODY tag.
		objLeft   = obj.offsetLeft;
		objTop    = obj.offsetTop;
		objParent = obj.offsetParent;
		while (objParent.tagName.toUpperCase() != "BODY")
		{
			objLeft  += objParent.offsetLeft;
			objTop   += objParent.offsetTop;
			objParent = objParent.offsetParent;
		}
		// Adjust the element's offsetTop relative to the dropdown menu
		if (x > (objLeft + parseInt(obj.offsetWidth)) || objLeft > (x + divCale.offsetWidth))
			;
		else if (divCale.offsetTop > parseInt(objTop + obj.offsetHeight)|| objTop > parseInt(divCale.offsetTop + divCale.offsetHeight))
			;
		else if ((y + divCale.offsetHeight) <= 80)
			;
		else
			obj.style.visibility = "hidden";
	}
}

function showElement(elmID)
{
	for (i = 0; i < document.all.tags(elmID).length; i++)
	{
		obj = document.all.tags(elmID)[i];
		if (! obj || ! obj.offsetParent)
			continue;
		obj.style.visibility = "";
	}
}

///////////////////////////////////////////////////////////
//隐藏图层
///////////////////////////////////////////////////////////
function fncHideDiv(objDiv)
{
	objDiv.style.display = "none";
	//showElement("SELECT");
	//showElement("OBJECT");
}


function fncChangeYear(year)
{
	year.value = document.all.years.value;
}


function fncPrevYear(year)
{
	year.value -= 1 ;
}

function fncNextYear(year)
{
	year.value = parseInt(year.value) + 1;
}

function fncPrevMonth(year, month)
{
	if (parseInt(month.value) == 1)
	{
		month.value = 12;
		year.value -= 1;
	}
	else
	{
		month.value -= 1;
	}
}

function fncNextMonth(year, month)
{
	if (parseInt(month.value) == 12)
	{
		month.value = 1;
		year.value = parseInt(year.value) + 1;
	}
	else
	{
		month.value = parseInt(month.value) + 1;
	}
}

function fncSetToday()
{
	var YearValue = gbThisYear.toString();
	var MonthValue = gbThisMonth.toString();
	var DayValue = gbThisDay.toString();
	if (MonthValue.length == 1)
	{
		MonthValue = "0" + MonthValue;
	}
	if (DayValue.length == 1)
	{
		DayValue = "0" + DayValue;
	}

	fncHideDiv(gbobjDiv);

	gbtxtDftDate.value = YearValue + MonthValue;
}

function fncSetNone()
{
	fncHideDiv(gbobjDiv);
	gbtxtDftDate.value = "";
}