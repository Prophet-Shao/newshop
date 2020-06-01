//----------------------------------------------------------------
// Core API is common api 
// copyright micsun.com (company site : http://www.micsun.com  production site : http://www.coolerp.com)
// 深圳市微阳信息技术有限公司版权所有
if (!Micsun) {
	alert("The following script will work with common.js!")
}

Micsun.Conf = {};

Micsun.Conf.version = "null";
Micsun.Conf.projectCode = "jzkd";
Micsun.Conf.projectName = "jzkd";

// 0, web  1, android  2,iphone, 3 window
Micsun.Conf.deviceType = 0;
//deviceType=0, the url will be used.
Micsun.Conf.defaultUrl = "http://localhost:8080/CoolC2M";


//-------------------------------------------------------
//对于Window的应用，需要加入这个，取与内置的浏览器通讯。
//对移动端不受影响。
if (Micsun.isWindows && Micsun.Conf.deviceType == 3) {
	window.appBridge = {};
	Micsun.extend(window.appBridge, {
		requestData: function (dataParam) {
			this.execMsg("requestData", dataParam);
		},
		command: function (dataParam) {
			this.execMsg("command", dataParam);
		},
		execMsg: function (funName, dataParam) {
			var event = new MessageEvent(funName, { "view": window, "bubbles": false, "cancelable": false, "data": dataParam });
			document.dispatchEvent(event);
		}
	});
}
