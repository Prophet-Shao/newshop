//----------------------------------------------------------------
// Core API is common api such module control and msg control for coolerp
// copyright micsun.com (company site : http://www.micsun.com  production site : http://www.coolerp.com)
// 深圳市微阳信息技术有限公司版权所有

var __webAppRoot="";

/**
 * 这个是全局需要访问，做初始化用。
 * @param webRoot
 * @param appName
 * @return
 */
function __initApp(webRoot,appName){
	__webAppRoot=webRoot;
	Micsun.currentApplication = appName;
}


/**
 * 登陆认证服务类
 */
Micsun.AuthService = Micsun.Class({
	_dataLayer:null,
	_onLoginSuccess:null,
	initialize:function(dataLayer){
    	//alert("dataLayer");
		this._dataLayer =dataLayer;
	},
	
	/**
	 * 验证是否已经登陆，如果没有登陆自动跳入到登陆页面
	 */
	loginCheck:function(onLoginSuccess){
    	var param = {};
    	this._onLoginSuccess=onLoginSuccess;
    	var _callback=(function(as){return function(resp){as.onLoginCheck(resp);}})(this);
    	this._dataLayer.requestData("SSO", "need_login_url", param, _callback);
	},
	
	/**
	 * 登陆回调
	 */
	onLoginCheck:function(resp){
		if(resp.success){	
    		var loginUrl = resp.object.loginUrl;
    		var returnUrl= window.location.href;
			window.location.href=loginUrl+"/wx_login.jsp?visitUrl="+encodeURIComponent(returnUrl);
		}else{
			if(this._onLoginSuccess!=null){
				this._onLoginSuccess();
			}
		}
	}
});


/**
 * 支付服务类
 */
Micsun.PayUtil = {
	//打赏
	donate:function(){
		window.location.href = Micsun.Conf.defaultUrl+'/mainsite/phone/donate.jsp';
	},
	//打赏
	pay:function(body,subject,serviceOrderId,outTradeNo,productCode,moneyTotal,backUrl,securityDog){
		var linkUrl =Micsun.Conf.baseUrl+'/wx_pay.jsp?';
		linkUrl+="securityDog="+securityDog;
		linkUrl+="&body="+encodeURIComponent(body);
		linkUrl+="&subject="+encodeURIComponent(subject);
		linkUrl+="&orderId="+serviceOrderId;
		linkUrl+="&outTradeNo="+encodeURIComponent(outTradeNo);
		linkUrl+="&productCode="+encodeURIComponent(productCode);
		linkUrl+="&moneyTotal="+encodeURIComponent(moneyTotal);	
		linkUrl+="&returnUrl="+encodeURIComponent(backUrl);
		linkUrl+="&failUrl="+encodeURIComponent(window.location.href);
		
		window.location.href = linkUrl;
	}
};

/**
 * 分享服务类
 */
Micsun.ShareUtil = {
	/**
	 * @shareType 分享类别
	 * @title 分享标题
	 * @content 分享内容
	 * @fullImgUrl 分享显示图片
	 * @fullVisitUrl 用户点击分享后到地址跳转到地址
	 * @backUrl 分享完毕后到哪里
	 *
	 */
	share:function(shareType, title,content,fullImgUrl,fullVisitUrl,backUrl){
   		var linkUrl =Micsun.Conf.baseUrl+'/wx_share.jsp?';
   		linkUrl+="content="+encodeURIComponent(content);
   		linkUrl+="&title="+encodeURIComponent(title);
   		linkUrl+="&shareType="+encodeURIComponent(shareType);
   		linkUrl+="&imgUrl="+encodeURIComponent(fullImgUrl);
   		linkUrl+="&visitUrl="+encodeURIComponent(fullVisitUrl);
   		linkUrl+="&backUrl="+encodeURIComponent(backUrl);
   		window.location.href = linkUrl;
   	}
};

	
	
