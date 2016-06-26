var theDate = new Date();
var gbDftYear = theDate.getYear();
var gbDftMonth = theDate.getMonth()+1;
var gbDftDay = theDate.getDate();
var gbThisYear = gbDftYear;
var gbThisMonth = gbDftMonth;
var gbThisDay = gbDftDay;

var gbDivOrgLeft, gbDivOrgTop;
var gbBodytopMargin;

var gbobjDiv;

var gbtxtDftDate;


var gbobjSelectYear;
var gbobjSelectMonth;

function fncCal(txtObj, cmdObj, frmObj)
{
	gbtxtDftDate = txtObj;
	var DefaultDate = gbtxtDftDate.value;
	var DefaultYear, DefaultMonth, DefaultDay;
	if (DefaultDate == "")
	{
		gbDftDay = 0;
	}
	else
	{
		//gbDftYear = jsYear(DefaultDate);
		//gbDftMonth = jsMonth(DefaultDate);
		//gbDftDay = jsDay(DefaultDate);
		gbDftYear =  theDate.getYear();
		gbDftMonth = theDate.getMonth()+1;
		gbDftDay = theDate.getDate();
	}
//var divCale=cmdObj;
	fncCalDivINIT(divCale);

	fncCalDivShow(divCale, cmdObj, frmObj.year, frmObj.month, gbDftYear, gbDftMonth, gbDftDay);
	//fncCalDivShow(txtObj, cmdObj, frmObj.year, frmObj.month, gbDftYear, gbDftMonth, gbDftDay);
}

function fncCalDivINIT(objDiv)
{
	var strbusiness = "";

	strbusiness=strbusiness+ "<table style='font-size:9pt' border=1 bgcolor='#68C2FF' cellpadding=0 cellspacing=0 align='center' width=150 >";
	strbusiness=strbusiness+ "<tr align='center'><td>                                                               ";
	strbusiness=strbusiness+ "<table style='font-size:9pt' cellpadding=0 cellspacing=0 width=150 bgcolor='#DDF1FF' align='center'>";
	//strbusiness=strbusiness+ "<table style='font-size:9pt' cellpadding=0 cellspacing=0 width=150 bgcolor='#FFFFFF'>";
	strbusiness=strbusiness+ "<tr align=center height='25'><td class='tdCalHead'>                                                           ";
	//strbusiness=strbusiness+ "<input type='text' value='' id='years' onchange='fncChangeYear(year)' style='border:1px solid #0000; height:18;cursor:hand;width:40'  alt='跳转年份'><br>";

	strbusiness=strbusiness+ "<img src='/web/common/img/calprevyear.gif' onclick='fncPrevYear(year)' style='cursor:hand' alt='上一年'> ";
	strbusiness=strbusiness+ "<img src='/web/common/img/calprevmonth.gif' onclick='fncPrevMonth(year, month)' style='cursor:hand' alt='上一月' > ";
	strbusiness=strbusiness+ "<input type=hidden name=year value='" + gbDftYear + "'" + 
	"onpropertychange='oaYear.innerText=this.value;fncMakeCal(year, month, gbDftYear, gbDftMonth, gbDftDay)'>";
	strbusiness=strbusiness+ "<a name='oaYear'>" + gbDftYear + "</a>";
	strbusiness=strbusiness+ "年";
	strbusiness=strbusiness+ "<input type=hidden name=month value='" + gbDftMonth + "'" + 
	"onpropertychange='oaMonth.innerText=(parseInt(this.value)<10 ? \"&nbsp;\" + this.value: this.value);fncMakeCal(year, month, gbDftYear, gbDftMonth, gbDftDay)'>"
	strbusiness=strbusiness+ "<a name='oaMonth'>" + (parseInt(gbDftMonth)<10 ? "&nbsp;" + gbDftMonth: gbDftMonth) + "</a>";
	strbusiness=strbusiness+ "月";
	strbusiness=strbusiness+ " ";
	strbusiness=strbusiness+ "<img src='/web/common/img/calnextmonth.gif' onclick='fncNextMonth(year, month)' style='cursor:hand' alt='下一月'> "
	strbusiness=strbusiness+ "<img src='/web/common/img/calnextyear.gif' onclick='fncNextYear(year)' style='cursor:hand' alt='下一年'> "
	strbusiness=strbusiness+ "</td>                                                                                ";
	strbusiness=strbusiness+ "<td valign='top' align=right><img src='/web/common/img/calclose.gif' onclick='fncHideDiv(divCale)' alt='关闭'></td>";
	strbusiness=strbusiness+ "</tr></table> <hr size=1>                                                                       ";
	strbusiness=strbusiness+ "                                                                                     ";
	strbusiness=strbusiness+ "                                                                                     ";
	strbusiness=strbusiness+ "<a name='aCalendarTable'></a>";
	strbusiness=strbusiness+ "<div align='center'><table cellpadding=1 cellspacing=0 class='tableCalBottom'><tr><td  class='tdCalBottom'>";
	strbusiness=strbusiness+ "<img src='/web/common/img/calsettoday.gif' alt='Today' onclick='fncSetToday()' class='imgSetDate'> ";

	strbusiness=strbusiness+ "<img src='/web/common/img/calsetnone.gif' alt='Blank' onclick='fncSetNone()' class='imgSetDate' > ";
	strbusiness=strbusiness+ "</td></tr></table></div>"

	strbusiness=strbusiness+ "</td></tr>";
	strbusiness=strbusiness+ "</table>                                      ";
	objDiv.style.position = "absolute";
//	objDiv.style.zIndex = 1;
//	objDiv.style.display = "none";
	objDiv.innerHTML = strbusiness;
}


function fncCalDivShow(objDiv, objButton, objYear, objMonth, DftYearValue, DftMonthValue, DftDayValue)
{
	var objBtnParent = objButton;
	var objBtnLeft = 0;
	var objBtnTop = 0;

	gbobjDiv = objDiv;
	
	gbobjSelectYear = objYear;
	gbobjSelectYear = objMonth;

//	gbobjDiv.style.left = window.event.srcElement.offsetLeft +
//	 	 window.event.srcElement.offsetParent.offsetLeft + 65;
	y = 0;
	while (objBtnParent.tagName.toUpperCase() != "BODY")
	{
		objBtnLeft  =objBtnLeft+ objBtnParent.offsetLeft;
		objBtnTop   =objBtnTop+ objBtnParent.offsetTop;
		objBtnParent = objBtnParent.offsetParent;
	}
	x = objBtnLeft + 10;
	y = objBtnTop;
	

	if (divCale.style.display == "none")
	//if (objDiv.style.display == "none")
	{

		fncMakeCal(objYear, objMonth, DftYearValue, DftMonthValue, DftDayValue);
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
		window.setTimeout("hideElement('SELECT')", 2);
		window.setTimeout("hideElement('OBJECT')", 2);
	}
	else
	{
		fncHideDiv(gbobjDiv);
	}
}

function fncMakeCal(objYear, objMonth, DftYearValue, DftMonthValue, DftDayValue)
{
	var SelectYear = objYear.value;
	var SelectMonth = objMonth.value;
	aCalendarTable.innerHTML = fncGetCaleTable(objYear, objMonth, DftYearValue, DftMonthValue, DftDayValue);
}

function GetInt(n1, n2)
{
	if (n2 != null && n2 != 0)
	{
		return Math.floor(n1 / n2);
	}
}


function isHoliday(Year, Month , Day, Week) 
{
	Year = parseInt(Year);
	Month = parseInt(Month);
	Day = parseInt(Day);
	Week = parseInt(Week);

	if (Week == 0 || Week ==6)
	{
		return true;
	}
	if (Day == 1 && (Month == 1 || Month == 5 || Month == 10))
	{
		return true;
	}
	return false;
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

function isLeapYear(Year)
{
	// return 1 means true
	// return 0 means false
	// return -1 means error
	Year = parseInt(Year);

	if (Year < 0)
	{
		return -1; // return -1 to indicate an error 
	}

	if (Year % 400 == 0)
	{
		return 1;
	}
	// Year % 400 != 0
	if (Year % 100 == 0 )
	{
		return 0;
	}
	// Year % 400 != 0 &&  Year % 100 != 0
	if (Year % 4 == 0)
	{
		return 1;
	}
	else
	{
		return 0;
	}
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

function fncGetCaleTable(objYear, objMonth, DftYearValue, DftMonthValue, DftDayValue)
{
	// Year是在div里选择的年
	// Month是在div里选择的月
	// DefaultY是传来的默认年


	// DefaultM是传来的默认月


	// DefaultD是传来的默认日



	Year = parseInt(objYear.value);
	Month = parseInt(objMonth.value);

	DefaultY = parseInt(DftYearValue);
	DefaultM = parseInt(DftMonthValue);
	DefaultD = parseInt(DftDayValue);
	var CaleStr = "";
	CaleStr=CaleStr+ "<table cellpadding=1 cellspacing=1 class='tableCal'>";
	CaleStr=CaleStr+ "<tr>";
	CaleStr=CaleStr+ "<td class='tdCalWeekHead'><a class='aCalHoliday'>日</a></td>";
	CaleStr=CaleStr+ "<td class='tdCalWeekHead'><a class='aCalNormal'>一</a></td>";
	CaleStr=CaleStr+ "<td class='tdCalWeekHead'><a class='aCalNormal'>二</a></td>";
	CaleStr=CaleStr+ "<td class='tdCalWeekHead'><a class='aCalNormal'>三</a></td>";
	CaleStr=CaleStr+ "<td class='tdCalWeekHead'><a class='aCalNormal'>四</a></td>";
	CaleStr=CaleStr+ "<td class='tdCalWeekHead'><a class='aCalNormal'>五</a></td>";
	CaleStr=CaleStr+ "<td class='tdCalWeekHead'><a class='aCalHoliday'>六</a></td>";
	CaleStr=CaleStr+ "</tr>";

	var DayNumOfMonth = parseInt(CalcDayOfMonth(Year, Month)); // 得到当月有多少天
	var WeekDayOfFirstDay = parseInt(CalcDayOfWeek(Year, Month, 1)); // 得到当月1号星期几
	var WeekNumOfMonth = 0; //当月星期数


	// 画空日期格


	for (var i=0; i < WeekDayOfFirstDay; i++) 
	{
		if (i == 0)
		{
			CaleStr=CaleStr+ "<tr>";
			WeekNumOfMonth =WeekNumOfMonth+1;
		}
		CaleStr=CaleStr+ "<td  class='tdCalSpace'>&nbsp;</td>";
	}
	// 画空日期格完成



	// 画当月日期格
	var WeekDayOfNow = parseInt(WeekDayOfFirstDay);
	for (i = 1; i <= DayNumOfMonth; i++)
	{
		if (WeekDayOfNow == 0) // 当天是周日，新的一行开始


		{
			CaleStr=CaleStr+ "<tr>";
			WeekNumOfMonth=WeekNumOfMonth+ 1;
		}
		// 画当月日期格
		if (i == DefaultD && Year == DefaultY && Month == DefaultM) //此天是默认选择的日期


		{
			if (Year == gbThisYear && Month == gbThisMonth && i == gbThisDay)
			{
				CaleStr=CaleStr+ "<td  class='tdCalDftToday' onclick='Feedback(" + Year + "," + Month + "," + i + ")'>";
			}
			else
			{
				CaleStr=CaleStr+ "<td  class='tdCalDftDay' onclick='Feedback(" + Year + "," + Month + "," + i + ")'>";
			}
			if (isHoliday(Year, Month, i, WeekDayOfNow) ) // 当天是假日


			{
				CaleStr=CaleStr+ "<a class='aCalHoliday'>" + i + "</a>";
			}
			else
			{
				CaleStr=CaleStr+ "<a class='aCalNormal'>" + i + "</a>";
			}
			CaleStr=CaleStr+ "</td>";
		}
		else // 此天不是默认选择的日期


		{
			if (Year == gbThisYear && Month == gbThisMonth && i == gbThisDay)
			{
				CaleStr=CaleStr+ "<td  class='tdCalNormalToday' onclick='Feedback(" + Year + "," + Month + "," + i + ")'>";
			}
			else
			{
				CaleStr=CaleStr+ "<td  class='tdCalNormal' onclick='Feedback(" + Year + "," + Month + "," + i + ")'>";
			}
			if (isHoliday(Year, Month, i, WeekDayOfNow) ) // 当天是假日


			{
				CaleStr=CaleStr+ "<a class='aCalHoliday' >" + i + "</a>";
			}
			else
			{
				CaleStr=CaleStr+ "<a class='aHormal'>" + i + "</a>";
			}
			CaleStr=CaleStr+ "</td>";
		}

		if (WeekDayOfNow == 6) // 当天是周六，旧的一行结束


		{
			CaleStr=CaleStr+ "</tr>";
		}
		WeekDayOfNow = (WeekDayOfNow + 1) % 7
	}
	// 画当月日期格完


	
	// 补齐空日期格
	if (WeekDayOfNow != 0)
	{
		for (var i=WeekDayOfNow; i < 7; i++) 
		{
			CaleStr=CaleStr+ "<td  class='tdCalSpace'>&nbsp;</td>";
			if (i == 6)
			{
				CaleStr=CaleStr+ "</tr>";
			}
		}
	}
	if (WeekNumOfMonth <=5) //还差一个空星期
	{
		for (; WeekNumOfMonth < 6; WeekNumOfMonth++)
		{
			CaleStr=CaleStr+ "<tr>";
			for (i=0; i < 7; i++)
			{
				CaleStr=CaleStr+ "<td  class='tdCalSpace'>&nbsp;</td>";
			}
			CaleStr=CaleStr+ "</tr>";
		}
	}
	// 补齐空日期格完



	CaleStr=CaleStr+ "</table>";

	return CaleStr;
}

function Feedback(YearValue, MonthValue, DayValue)
{
	YearValue = YearValue.toString();
	MonthValue = MonthValue.toString();
	DayValue = DayValue.toString();
	if (MonthValue.length == 1)
	{
		MonthValue = "0" + MonthValue;
	}
	if (DayValue.length == 1)
	{
		DayValue = "0" + DayValue;
	}

	fncHideDiv(gbobjDiv);

	gbtxtDftDate.value = YearValue + "-" + MonthValue + "-" + DayValue;
	//gbtxtDftDate.value = YearValue + MonthValue + DayValue;
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
			objLeft  =objLeft+objParent.offsetLeft;
			objTop   =objTop+objParent.offsetTop;
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

function fncHideDiv(objDiv)
{
	objDiv.style.display = "none";
	showElement("SELECT");
	showElement("OBJECT");
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

	gbtxtDftDate.value = YearValue + "-" + MonthValue + "-" + DayValue;
	//gbtxtDftDate.value = YearValue + MonthValue + DayValue;
}

function fncSetNone()
{
	fncHideDiv(gbobjDiv);
	gbtxtDftDate.value = "";
}