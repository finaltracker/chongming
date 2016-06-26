(function($) {
	$.fn.showInstallCertControlMessage = function(options) {
		var defaults = {
			background : "#888",
			borderColor : "#000",
			foreColor : "#000",
			height : "40px",
			fontSize : "16px",
			close : "click"
		};
		var options = $.extend(defaults, options);

		var barStyle = " width: 100%;position: fixed;height: " + options.height
				+ ";top: 0px;left: 0px;right: 0px;margin: 0px;display: none;";
		var overlayStyle = "height: "
				+ options.height
				+ ";filter: alpha(opacity=50);-moz-opacity: 0.5;-khtml-opacity: 0.5;opacity: 0.5;background-color: "
				+ options.background + ";border-bottom: solid 5px "
				+ options.borderColor + ";";
		var messageStyle = " width: 100%;position: absolute;height: "
				+ options.height
				+ ";top: 0px;left: 0px;right: 0px;margin: 0px;color: "
				+ options.foreColor
				+ ";font-weight: bold;font-size: "
				+ options.fontSize
				+ ";text-align: center;padding: 10px 0px;font-family:\"Microsoft YaHei\"!important";

		return this
				.each(function() {
					obj = $(this);

					if ($(".topbarBox").length > 0) {
						// Hide already existing bars
						$(".topbarBox").hide()
						$(".topbarBox").slideUp(200, function() {
							$(".topbarBox").remove();
						});
					}

					var html = ""
							+ "<div class='topbarBox' style='"
							+ barStyle
							+ "'>"
							+ "  <div style='"
							+ overlayStyle
							+ "'>&nbsp;</div>"
							+ "  <div style='"
							+ messageStyle
							+ "'>"
							+ obj.html()
							+ "<button style='float:right;cursor:pointer;border:0;background:url(js/close.png) no-repeat;' id='clickX'>&nbsp;</button></div>"
							+ "</div>"

					if (options.close == "click") {
						$(html).click(function() {
							$(this).slideUp(200, function() {
								$(this).remove();
							});
						}).appendTo($('body')).slideDown(200);
					} else if (options.close == "clickX") {
						$(html).appendTo($('body')).slideDown(200).find(
								"button").click(function() {
							$(".topbarBox").slideUp(200, function() {
								$(this).remove();
							});
						});
					} else {
						$(html).appendTo($('body')).slideDown(200).delay(
								options.close).slideUp(200, function() {
							$(this).remove();
						});
					}

				});
	};
})(jQuery);

var iTrusPTA = null;
var cenroll = null;

var INPUT_BASE64 = 0x1;
var INPUT_HEX = 0x2;
var OUTPUT_BASE64 = 0x4;
var OUTPUT_HEX = 0x8;
var INNER_CONTENT = 0x10;
var PLAINTEXT_UTF8 = 0x20;

var _pta_OverlapPeriod = 30;

$(function() {
	iTrusPTA = loadItrusPTA();
	cenroll = loadItrusEnroll();
	if (typeof (iTrusPTA.Version) == "undefined"
			|| typeof (cenroll.ProviderType) == "undefined") {
		$(
				"<div id='divInstallCertControl' style='display:none;'>您还没有安装证书控件，<a href='js/TopCaCertUtil.exe' target='_blank'>请点击此处下载</a>安装。安装成功后请重新启动浏览器！</div>")
				.appendTo(document.body)[0];
		$("#divInstallCertControl").showInstallCertControlMessage({
			background : "yellow",
			close : "clickX",
			foreColor : "red"
		});
	}
});

function loadItrusPTA() {
	if (iTrusPTA != null)
		return iTrusPTA;
	var iTrusPTA = null;
	var iePtaObject = "<object id='iTrusPTA' classid='clsid:F1F0506B-E2DC-4910-9CFC-4D7B18FEA5F9'></object>";
	var ffPtaObject = "<embed  id='iTrusPTA' type='application/iTrusPTA.iTrusPTA.Version.1' width='0' height='0'></embed>";
	if ($.browser.msie || !!navigator.userAgent.match(/Trident/)) {
		iTrusPTA = $(iePtaObject).appendTo(document.body)[0];
	} else {
		iTrusPTA = $(ffPtaObject).appendTo(document.body)[0];
	}
	return iTrusPTA;
}

function loadItrusEnroll() {
	if (cenroll != null)
		return cenroll;
	var cenroll = null;
	var ieCenrollObject = "<object id='cenroll' classid='clsid:DD2257CE-4FEE-455A-AD8B-860BEEE25ED6'></object>";
	var ffCenrollObject = "<embed id='cenroll' type='application/iTrusCertEnroll.CertEnroll.Version.1' width='0' height='0'></embed>";
	if ($.browser.msie || !!navigator.userAgent.match(/Trident/)) {
		cenroll = $(ieCenrollObject).appendTo(document.body)[0];
	} else {
		cenroll = $(ffCenrollObject).appendTo(document.body)[0];
	}
	return cenroll;
}

/**
 * installCert 安装CA颁发下来的证书
 * @param certChain(mandatory) 包含用户证书及证书链的Base64格式P7字符串
 */
function installCert(certChain) {
    try {
        cenroll.Reset();
        cenroll.DeleteRequestCert = false;
        cenroll.WriteCertToCSP = true;
        cenroll.acceptPKCS7(certChain);
        return true;
    } catch (e) {
        if (-2147023673 == e.number) {
            alert("您取消了我们为您颁发的数字证书安装，证书安装失败！\n在您还未离开本页面前，您还可以点击“安装数字证书”按钮安装。");
            return false;
        } else if (-2146885628 == e.number) {
            alert("您的证书已经成功安装过了！");
            return false;
        } else {
            alert("安装证书发生错误！\n错误号: " + e.number + "\n错误描述: " + e.description);
            return false;
        }
    }
}

/**
 * installCAChain 安装CA证书链
 * @param cACertSignBufP7(mandatory) PKCS7格式证书链
 */
function installCAChain(cACertSignBufP7) {
    try {
        //cenroll.InstallPKCS7(cACertSignBufP7);acceptPKCS7
        cenroll.acceptPKCS7(cACertSignBufP7);
        return true
    } catch (e) {
        alert(e.description);
        if (-2147023673 == e.number) {
            return false;
        } else {
            alert("安装证书链时发生错误！\n错误原因：" + e.description + "\n错误代码：" + toHex(e.number));
            return false;
        }
    }
}

/**
 * findProviders 查询本地计算机的密钥服务提供者，并显示在指定的<select>中
 * 
 * @param objProviderList(mandatory)
 *            密钥服务提供者列表<select>对象
 * @param defaultProvider(optional)
 *            缺省密钥服务提供者名称
 * @param allowedProviders(optional)
 *            允许的密钥服务提供者Array
 */
function findProviders(objProviderList, defaultProvider, allowedProviders) {
	if (cenroll.ProviderType == null) {
		$(objProviderList).append(
				"<option value=''>CERT CONTROL ERROR</option>");
		return;
	}
	$(objProviderList).find('option').remove();

	if (typeof (defaultProvider) == "undefined" || defaultProvider == "")
		defaultProvider = "Microsoft Enhanced Cryptographic Provider v1.0";
	var i = 0;
	nIndex = 0;
	var providerType = 1;// The default value for this property is 1
	var maxProviderType = 1; // max is 24

	var providerName;
	while (providerType <= maxProviderType) {
		i = 0; // 从0开始枚举
		cenroll.providerType = providerType;
		while (true) {
			try {
				providerName = cenroll.enumProviders(i, 0);
			} catch (e) {
				break;
			}
			if (providerName == null || providerName.length == 0) {
				break;
			} else {
				if (typeof (allowedProviders) == "string") {
					if (providerName == allowedProviders) {
						$(objProviderList).append(
								"<option value='" + providerType + "'>"
										+ providerName + "</option>");
						nIndex++; // 总索引
					}
				} else if (typeof (allowedProviders) == "object"
						&& allowedProviders.length != 0) {
					for (var j = 0; j < allowedProviders.length; j++) {
						if (providerName == allowedProviders[j]) {
							$(objProviderList).append(
									"<option value='" + providerType + "'>"
											+ providerName + "</option>");
							nIndex++; // 总索引
						}
					}
				} else { // typeof(allowedProviders)=="undefined" ||
							// allowedProviders == ""
					$(objProviderList).append(
							"<option value='" + providerType + "'>"
									+ providerName + "</option>");
					nIndex++; // 总索引
				}
				i++;
			}
		}
		providerType++;
	}

	$(objProviderList).children("option").filter(function() {
		return $(this).text() == defaultProvider;
	}).attr('selected', true);
}

/**
 * genEnrollCSR 申请证书，创建密钥对并生成证书签名请求
 * @param objProviderList(mandatory) 加密服务提供者列表的<select>对象
 * @param cryptFlag(optional)
 *        0x0表示私钥既不可以导出，又不要求强私钥保护
 *        0x1表示私钥可导出，默认值
 *        0x2表示强私钥保护
 *        0x3(0x1|0x2)表示私钥既可以导出，又要求强私钥保护
 */
function genEnrollCSR(objProviderList, cryptFlag) {
    var selectedItem = $("option:selected", objProviderList);
    var providerName = selectedItem.text();
    var providerType = selectedItem.val();
    return genKeyAndCSR(providerName, providerType, cryptFlag);
}

/**
 * genRenewCSR 更新证书，生成更新证书的证书签名请求
 * @param objProviderList(mandatory) 加密服务提供者列表的<select>对象
 * @param cryptFlag(mandatory)
 *        0x0表示私钥既不可以导出，又不要求强私钥保护
 *        0x1表示私钥可导出，默认值
 *        0x2表示强私钥保护
 *        0x3(0x1|0x2)表示私钥既可以导出，又要求强私钥保护
 * @param objOldCert(mandatory) 要更新的证书对象（PTALib.Certificate）
 */
function genRenewCSR(objProviderList, cryptFlag, objOldCert) {
    var oldCertCSP = objOldCert.CSP; //旧证书CSP
    var providerName, providerType;
    if (typeof(objProviderList) == "string") {
    	providerName = objProviderList;
        providerType = 1;
    } else if (typeof(objProviderList) == "object") {
    	providerName = $(objProviderList).find("option:selected").text();
        providerType = $(objProviderList).find("option:selected").val();
    } else {
        alert("Paramter [objProviderList] is not correct.");
        return "";
    }

    var useOldKey = true;
    if (oldCertCSP != providerName) {
        var info = "您选择的密钥服务提供者与您正在更新的证书不匹配！"
            + "\n如果您点击“确定”，将会生成新的密钥对进行更新，点击“取消”重新选择密钥服务提供者。";

        if (!window.confirm(info)) {
            return "";
        } else
            useOldKey = false;
    }
    if (useOldKey) {
        //使用旧的密钥对，更新后的证书只是更新了证书有效期
        return genKeyAndCSR(providerName, providerType, cryptFlag, objOldCert.KeyContainer);
    } else {
        //生成新的密钥对，更新后的证书不仅更新了证书有效期，而且换了密钥对
        return genKeyAndCSR(providerName, providerType, cryptFlag);
    }
}

/**
 * genKeyAndCSR()必须包含xenroll_install.js和xenroll_function.js
 * genKeyAndCSR 产生密钥对，并返回证书签名请求CSR
 * @param providerFullName(mandatory) 密钥服务提供者名称
 * @param providerType(mandatory) 密钥服务提供者类型
 * @param cryptFlag(optional)
 *        0x0表示私钥既不可以导出，又不要求强私钥保护
 *        0x1表示私钥可导出，默认值
 *        0x2表示强私钥保护
 *        0x3(0x1|0x2)表示私钥既可以导出，又要求强私钥保护
 * @param keyContainer(optional)
 *        可使用PTALib.Certificate对象的.KeyContainer方法获取原证书的密钥容器
 *        密钥容器名称，更新证书时需要设置，会使用原来的密钥对发出签名请求。
 *        如果在原证书存储在USB KEY中，更新的证书会自动覆盖老证书
 * @return 证书申请请求CSR
 */
function genKeyAndCSR(providerName, providerType, cryptFlag, keyContainer) {

    try {
        cenroll.Reset(); //首先Reset
        cenroll.ProviderName = providerName;
        cenroll.ProviderType = providerType;
        cenroll.DeleteRequestCert = false;
        var keyflags = 0;
        if (typeof(cryptFlag) != "number") {
            cryptFlag = 0x00000001; //表示私钥可导出，默认值
        }
        keyflags = keyflags | cryptFlag;

        if (typeof(keyContainer) == "string" && keyContainer != "") {//适用于更新证书
            cenroll.UseExistingKeySet = true;
            cenroll.ContainerName = keyContainer;
        }
        cenroll.HashAlgorithm = "SHA1"; //SHA1
        cenroll.KeySpec = 1;

        var csr = "";
        cenroll.GenKeyFlags = 0x04000000 | keyflags; //1024bits
        //objCEnroll.GenKeyFlags = 0x02000000 | keyflags; //512bits，一旦出错，不再尝试512bits的密钥对
        csr = cenroll.createPKCS10("CN=itrus_enroll", "1.3.6.1.5.5.7.3.2");
        return csr.replace(/\r*\n/g, "");
    } catch (e) {
        var keyNotPresent = "指定的密钥服务提供者不能提供服务！可能出现的原因："
            + "\n1、您没有插入USB KEY，或者插入的USB KEY不能识别。"
            + "\n2、您的USB KEY还没有初始化。";
        var keyContainerNotPresent = "指定的KeyContainer不能提供服务！\n如果您正在更新证书，请选择原证书的密钥服务提供者(CSP)。";
        if (-2147023673 == e.number //800704C7 User Canceled
            || -2147418113 == e.number || -2146893795 == e.number //Zhong chao USB key User Canceled when input PIN
            || -2146434962 == e.number //FT ePass2001 USB key User Canceld
            ) {
            return "";
        } else if (-2146893802 == e.number) { //80090016
            if (providerFullName.indexOf("SafeSign") != -1)
                alert(keyNotPresent); //捷德的KEY没插KEY会报这个错误
            else
                alert(keyContainerNotPresent); //当KeyContainer无法提供服务时，其他KEY会报这个错误
            return "";
        } else if (-2146435060 == e.number //8010000C FTSafe ePass2000没插KEY会报
            || -2146893792 == e.number //80090020 FEITIAN ePassNG没插KEY会报
            ) {
            alert(keyNotPresent); //捷德的KEY没插KEY会报这个错误
            return "";
        } else if (-2146955245 == e.number) {
            alert("创建新密钥容器错误:0x80081013(00000005)\n提示：请将当前站点加入可信站点！");
            return "";
        }
        else {//创建1024位密钥对或产生CSR时发生其他未知错误，将错误报告给用户
            alert("在证书请求过程中发生错误！\n错误原因：" + e.description + "\n错误代码：" + e.number);
            return "";
        }
    }
}

/**
 * setOverlapPeriod 设置允许更新的证书到期天数
 * 
 * @param days
 *            整型
 */
function setOverlapPeriod(days) {
	_pta_OverlapPeriod = days;
}

/**
 * JSDateAdd Javascript 计算给定日期+天数
 * 
 * @param theDate:
 *            给定日期，Date类型
 * @param days:
 *            整型
 * @return 计算结果，Date类型
 */
function JSDateAdd(theDate, days) {
	var dateValue = theDate.valueOf();
	dateValue += days * 1000 * 60 * 60 * 24;
	var newDate = new Date(dateValue);
	return newDate;
}
/**
 * JSDateDiffByDays Javascript 计算两个日期之间的间隔天数
 * 
 * @param date1:
 *            给定日期1，Date类型
 * @param date2:
 *            给定日期2，Date类型
 * @return 天数，整型
 */
function JSDateDiffByDays(date1, date2) {
	var mill = date1.valueOf() - date2.valueOf();
	var millStr = new String(mill / 1000 / 60 / 60 / 24)
	return parseInt(millStr);
}

function blurFilterCerts(subjectDN, dateFlag, serialNumber) {
	var m_certs = filterCerts("", dateFlag, "")
	var f_certs = new Array();
	if (m_certs.length <= 0 || (subjectDN == null && serialNumber == null)
			|| (subjectDN == "" && serialNumber == ""))
		return m_certs;
	var tmpDN = null;
	var tmpSerialNumber = null;
	for (var k = 0; k < m_certs.length; k++) {
		tmpDN = m_certs[k].Subject;
		tmpSerialNumber = m_certs[k].SerialNumber;
		if (eval("tmpDN.search(/"
				+ ((subjectDN != null && subjectDN != "") ? subjectDN : ".")
				+ "/i)") >= 0
				&& eval("tmpSerialNumber.search(/"
						+ ((serialNumber != null && serialNumber != "") ? serialNumber
								: ".") + "/i)") >= 0)
			f_certs.push(m_certs[k])
	}
	return f_certs
}

/**
 * filterCerts 根据所设置条件过滤证书
 * 
 * @param arrayIssuerDN(optional)
 *            Array() or string，缺省为""，证书的颁发者字符串和字符串数组，支持多个CA时使用字符串数组
 * @param dateFlag(optional)
 *            缺省为0，0表示所有证书，1表示处于有效期内的证书，2表示待更新证书，3表示未生效或已过期证书
 * @param serialNumber(optional)
 *            缺省为""，证书序列号（微软格式）
 * @return Array(), PTALib.Certificate
 */
function filterCerts(arrayIssuerDN, dateFlag, serialNumber) {
	var m_certs = new Array();
	var i = 0;
	if (arrayIssuerDN == null) {
		arrayIssuerDN = new Array("");
	} else if (typeof (arrayIssuerDN) == "string") {
		arrayIssuerDN = new Array(arrayIssuerDN);
	}
	if (typeof (serialNumber) == "undefined")
		serialNumber = "";
	for (i = 0; i < arrayIssuerDN.length; i++) {
		var CertFilter = iTrusPTA.Filter;
		if (typeof (CertFilter) == "undefined")
			return m_certs;
		CertFilter.Clear();
		CertFilter.Issuer = arrayIssuerDN[i];
		CertFilter.SerialNumber = serialNumber;
		var t_Certs = iTrusPTA.MyCertificates; // 临时变量
		var now = new Date();
		if (parseInt(t_Certs.Count) > 0) { // 找到了证书
			for (var j = 1; j <= parseInt(t_Certs.Count); j++) {
				var validFrom = new Date(eval(t_Certs(j).ValidFrom));
				var validTo = new Date(eval(t_Certs(j).ValidTo));
				var keyUsage = t_Certs(j).KeyUsage;
				switch (dateFlag) {
				case 0:// 所有证书
					m_certs.push(t_Certs(j));
					break;
				case 1:// 处于有效期内的证书
					// validFrom validTo
					// now
					if (validFrom < now && now < validTo)
						m_certs.push(t_Certs(j));
					break;
				case 2:// 待更新证书
					// validFrom validTo-30 validTo
					// now
					if (JSDateAdd(validTo, -_pta_OverlapPeriod) < now
							&& now < validTo) {
						// KEY_USAGE_KEY_AGREEMENT = &H08
						// KEY_USAGE_DATA_ENCIPHERMENT=&H10
						// KEY_USAGE_KEY_ENCIPHERMENT= &H20
						keyUsage = keyUsage & ~0x08;
						keyUsage = keyUsage & ~0x10;
						keyUsage = keyUsage & ~0x20;
						if (keyUsage != 0) {
							m_certs.push(t_Certs(j));
						}
					}
					break;
				case 3:// 未生效或已过期证书
					// validFrom validTo
					// now now
					if (now < validFrom || validTo < now)
						m_certs.push(t_Certs(j));
					break;
				default:// 缺省当作所有证书处理
					m_certs.push(t_Certs(j));
					break;
				}
			}
		}
	}

	return m_certs;
}

/**
 * signLogonData 登陆签名
 * 
 * @param certList
 *            证书列表<select>对象
 * @param inputToSign:
 *            用于签名登陆的被签名<input>对象
 * @return 成功返回签名值，失败返回""
 */
function signLogonData(signer, inputToSign) {
	try {
		var signedData;
		var ptaVersion = iTrusPTA.Version;
		if (ptaVersion == null) {
			// PTA Version = 1.0.0.3
			signedData = signer.SignMessage(inputToSign.value, OUTPUT_BASE64);
		} else {
			// PTA Version > 2
			if (inputToSign.value.indexOf("LOGONDATA:") == -1)
				inputToSign.value = "LOGONDATA:" + inputToSign.value;
			signedData = signer.SignLogonData(inputToSign.value, OUTPUT_BASE64);
		}
		return signedData;
	} catch (e) {
		if (-2147483135 == e.number || -2146434962 == e.number // 天威盾0301(海泰)
		) {
			// 用户取消签名
			return "";
		} else if (e.number == -2146885621) {
			alert("您不拥有证书“" + CurCert.CommonName + "”的私钥，签名失败。");
			return "";
		} else {
			if ($.browser.msie)
				alert("PTA签名时发生错误\n错误号: " + e.number + "\n错误描述: "
						+ e.description);
			else
				alert("PTA签名时发生错误！");
			return "";
		}
	}
}

/**
 * verifySignature 验证签名
 * 
 * @param strToSign:
 *            原文
 * @param base64StrSignature:
 *            签名值
 * @return 成功: 返回签名证书对象，失败: 返回null
 */
function verifySignature(strToSign, base64StrSignature) {
	try {
		var signCert = iTrusPTA.VerifySignature(strToSign, base64StrSignature,
				INPUT_BASE64);
		alert("签名验证成功。签名者为“" + signCert.CommonName + "”。");
		return true;
	} catch (e) {
		if (e.number == -2146893818)
			alert("签名验证失败。\n签名值与原文不匹配，内容已遭篡改。");
		else
			alert("PTA模块发生错误\n错误号: " + e.number + "\n错误描述: " + e.description);
		return false;
	}
}

/**
 * signMessage 数字签名
 * 
 * @param plainText:
 *            原文
 * @param signCert
 *            用于签名的证书对象，可以使用GetSingleCertificate函数获得证书对象
 *            ，或者使用SelectSingleCertificate函数选择<select>中列出的证书
 * @return 成功: 返回签名值，失败: 返回""
 */
function signMessage(signCert, plainText, opt) {
	var signedStr;
	var signCert;
	try {
        plainText = plainText.replace(/\r\n/g, "\n").replace(/\n/g, "\r\n");
		opt = typeof(opt) == "number" ? opt | OUTPUT_BASE64 : OUTPUT_BASE64;
		signedStr = signCert.SignMessage(plainText, opt);
	} catch (e) {
		if (e.number == -2147483135 || e.number == -2146881278 // sign
				// confirm
				// canceled
				|| e.number == -2146434962 // FT2001, 天威盾0301(海泰) Login
				|| e.number == -2146951166 // 软证书
		// canceled
		) {
			return "";// User canceled
		} else if (e.number == -2146885621)
			alert("您不拥有证书“" + signCert.CommonName + "”的私钥，签名失败。");
		else {
			alert("PTA签名时发生错误\n错误号: " + e.number + "\n错误描述: "
					+ e.description);
		}
		return "";
	}
	return signedStr;
}

/**
 * signCSR 更新证书时需要调用，对更新证书的CSR
 * 
 * @param objOldCert(mandatory)
 *            要更新的证书对象（PTALib.Certificate）
 * @param csr(mandatory)
 *            证书签名请求
 */
function signCSR(objOldCert, csr) {
	try {
		var signedData = "";
		var ptaVersion = iTrusPTA.Version;
		if(ptaVersion == null){ 
			//PTA Version = 1.0.0.3
			signedData = objOldCert.SignMessage("LOGONDATA:" + csr, OUTPUT_BASE64);
		} else {
			//PTA Version > 2
			signedData = objOldCert.SignLogonData("LOGONDATA:" + csr, OUTPUT_BASE64);
		}
		return signedData;
	} catch (e) {
		if(-2147483135 == e.number) {
			//用户取消签名
			return "";
		}	else if(e.number == -2146885621) {
			alert("您不拥有证书“" + objOldCert.CommonName + "”的私钥，签名失败。");
			return "";
		} else {
			alert("PTA签名时发生错误\n错误号: " + e.number + "\n错误描述: " + e.description);
			return "";
		}
	}
}

/*
 * toDefaultDateFormat 格式化日期格式，主要用于兼容chrome下日期格式不正确 @param date(mandatory)
 * Date对象 @return String格式,如：2012年12月21日 00:00:00
 */
function toDefaultDateFormat(date) {
	var year = $.browser.msie ? date.getFullYear() : (date.getYear() + 1900);
	var month = date.getMonth() + 1;
	var day = date.getDate();
	var hour = date.getHours();
	var min = date.getMinutes();
	var sec = date.getSeconds();

	var fillTwo = function(number) {
		if (number < 10) {
			return "0" + number;
		} else {
			return number;
		}
	};
	return year + "年" + month + "月" + day + "日";
	// return year + "年" + month + "月" + day + "日 " + fillTwo(hour) + ":" +
	// fillTwo(min) + ":" + fillTwo(sec);
	// return year + "-" + month + "-" + day + " " + fillTwo(hour) + ":" +
	// fillTwo(min) + ":" + fillTwo(sec);
}

/*******************************************************************************
 * Object: Hashtable Description: Implementation of hashtable Author: Uzi
 * Refaeli
 ******************************************************************************/

/**
 * class Names
 * 
 * @method getItem(name) return names' first value
 * @method getItems(name) return names' value sting array object
 */
function Names(distinguishName) {
	this.names = init(distinguishName);

	this.getItem = function(name) {
		var values = this.names.get(name);
		if (null == values) {
			return null;
		} else {
			return values[0];
		}
	}

	this.getItems = function(name) {
		return this.names.get(name);
	}

	function init(dn) {
		dn = $.browser.msie ? dn.substring(0, dn.length - 1) : dn;
		var _names = new Hashtable();
		var partition = ", ";

		var Items = dn.split(partition);
		var itemString = "";
		for (var i = Items.length - 1; i >= 0; i--) {
			if (itemString != "") {
				itemString = Items[i] + itemString;
			} else {
				itemString = Items[i];
			}

			var pos = itemString.indexOf("=");
			if (-1 == pos) {
				itemString = partition + itemString;
				continue;
			} else {
				var name = itemString.substring(0, pos);
				var value = itemString.substring(pos + 1, itemString.length);
				// wipe off the limitrophe quotation marks
				if (value.indexOf("\"") == 0
						&& (value.length - 1) == value.lastIndexOf("\"")) {
					value = value.substring(1, value.length);
					value = value.substring(0, value.length - 1);
				}

				if (_names.containsKey(name)) {
					var array = _names.get(name);

					array.push(value);
					_names.remove(name);
					_names.put(name, array);
				} else {
					var array = new Array();
					array.push(value);
					_names.put(name, array);
				}
				itemString = "";
			}
		}
		return _names;
	}
}

function PTADate(date){
	if ($.browser.msie || !!navigator.userAgent.match(/Trident/)) {
		return new Date(date);
	} else {
		return new Function('return '+date+';')();
	}
}
// ======================================= Properties
// ========================================
Hashtable.prototype.hash = null;
Hashtable.prototype.keys = null;
Hashtable.prototype.location = null;

/**
 * Hashtable - Constructor Create a new Hashtable object.
 */
function Hashtable() {
	this.hash = new Array();
	this.keys = new Array();

	this.location = 0;
}

Hashtable.prototype.containsKey = function(key) {
	if (this.hash[key] == null)
		return false;
	else
		return true;
}

/**
 * put Add new key param: key - String, key name param: value - Object, the
 * object to insert
 */
Hashtable.prototype.put = function(key, value) {
	if (value == null)
		return;

	if (this.hash[key] == null)
		this.keys[this.keys.length] = key;

	this.hash[key] = value;
}

/**
 * get Return an element param: key - String, key name Return: object - The
 * requested object
 */
Hashtable.prototype.get = function(key) {
	return this.hash[key];
}

/**
 * remove Remove an element param: key - String, key name
 */
Hashtable.prototype.remove = function(key) {
	for (var i = 0; i < this.keys.length; i++) {
		// did we found our key?
		if (key == this.keys[i]) {
			// remove it from the hash
			this.hash[this.keys[i]] = null;
			// and throw away the key...
			this.keys.splice(i, 1);
			return;
		}
	}
}

/**
 * size Return: Number of elements in the hashtable
 */
Hashtable.prototype.size = function() {
	return this.keys.length;
}

/**
 * populateItems Deprecated
 */
Hashtable.prototype.populateItems = function() {
}

/**
 * next Return: true if theres more items
 */
Hashtable.prototype.next = function() {
	if (++this.location < this.keys.length)
		return true;
	else
		return false;
}

/**
 * moveFirst Move to the first item.
 */
Hashtable.prototype.moveFirst = function() {
	try {
		this.location = -1;
	} catch (e) {/* //do nothing here :-) */
	}
}

/**
 * moveLast Move to the last item.
 */
Hashtable.prototype.moveLast = function() {
	try {
		this.location = this.keys.length - 1;
	} catch (e) {/* //do nothing here :-) */
	}
}

/**
 * getKey Return: The value of item in the hash
 */
Hashtable.prototype.getKey = function() {
	try {
		return this.keys[this.location];
	} catch (e) {
		return null;
	}
}

/**
 * getValue Return: The value of item in the hash
 */
Hashtable.prototype.getValue = function() {
	try {
		return this.hash[this.keys[this.location]];
	} catch (e) {
		return null;
	}
}

/**
 * getKey Return: The first key contains the given value, or null if not found
 */
Hashtable.prototype.getKeyOfValue = function(value) {
	for (var i = 0; i < this.keys.length; i++)
		if (this.hash[this.keys[i]] == value)
			return this.keys[i]
	return null;
}

/**
 * toString Returns a string representation of this Hashtable object in the form
 * of a set of entries, enclosed in braces and separated by the ASCII characters ", "
 * (comma and space). Each entry is rendered as the key, an equals sign =, and
 * the associated element, where the toString method is used to convert the key
 * and element to strings. Return: a string representation of this hashtable.
 */
Hashtable.prototype.toString = function() {

	try {
		var s = new Array(this.keys.length);
		s[s.length] = "{";

		for (var i = 0; i < this.keys.length; i++) {
			s[s.length] = this.keys[i];
			s[s.length] = "=";
			var v = this.hash[this.keys[i]];
			if (v)
				s[s.length] = v.toString();
			else
				s[s.length] = "null";

			if (i != this.keys.length - 1)
				s[s.length] = ", ";
		}
	} catch (e) {
		// do nothing here :-)
	} finally {
		s[s.length] = "}";
	}

	return s.join("");
}

/**
 * add Concatanates hashtable to another hashtable.
 */
Hashtable.prototype.add = function(ht) {
	try {
		ht.moveFirst();
		while (ht.next()) {
			var key = ht.getKey();
			// put the new value in both cases (exists or not).
			this.hash[key] = ht.getValue();
			// but if it is a new key also increase the key set
			if (this.get(key) != null) {
				this.keys[this.keys.length] = key;
			}
		}
	} catch (e) {
		// do nothing here :-)
	} finally {
		return this;
	}
};
