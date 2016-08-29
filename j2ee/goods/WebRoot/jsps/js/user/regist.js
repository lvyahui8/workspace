/**
 * 
 */
var _NULL			=		"内容不能为空";
var _OK				=		"ok";
var UNAME_STAND		=		"用户名长度应在6-24位，并且是字母数字下划线的组合";
var UNAME_USE		=		"用户名已经被使用";
var PASS_STAND		=		"长度6-24位，不能有中文及\\f\\n\\r\\t\\v";
var PASS_AS			=		"两次密码不一致";
var EMAIL_STAND		=		"邮箱地址不合法";
var EMAIL_USE		=		"邮箱已经被注册"
var VCODE_ERROR		=		"验证码错误";

$(function(){
	
	/*
	 * 
	 */
	$(".labelError").each(function(){
		showError($(this));
	});
	var sb = $("#submit");
	sb.hover(function(){
		sb.attr("src","/goods/images/regist2.jpg");
	},function(){
		sb.attr("src","/goods/images/regist1.jpg");
	})
	$(".input").each(function(){
				var error = $("#"+$(this).attr("id")+"Error");
				//error.css("display","none");
				$(this).focus(function (){
					error.css("display","none");
				});
				$(this).blur(function(){
//					alert(text);
					check($(this));
				});
			}
	);
	
	$("#registForm").submit(function (){
		var form_ok = true;
		$(".input").each(function(){
			if(_OK !=check($(this))){
				form_ok = false;
			}
		});
		return form_ok;
	});
});

function showError(ele){
	var text = ele.text();
	if(!text){
		ele.css("display","none");
	}
	else{
		ele.css("display","");
	}
}
function check(ele){
	var id = ele.attr("id");
	var checkFun = "check" + id.substring(0,1).toUpperCase() + id.substring(1) + "(\""+ele.val()+"\")";//获取校验方法
	//alert(checkFun)
	var res = eval(checkFun);
	var error = $("#"+ele.attr("id")+"Error");
	if(res){
		if(res == _OK){
			error.css("background", "url(/goods/images/good.png) no-repeat");
		}
		else{
			error.css("background", "url(/goods/images/error.png) no-repeat");
		}
		error.text(res);
		error.css("display","");
	}
	return res;
}
function checkLoginname(val){
	var res = _OK;
	//alert(val)
	//非空校验
	if(empty(val)){
		res = _NULL; 
	}
	//长度与非法字符校验
	else if(!/\w{6,24}$/.test(val)){
		res = UNAME_STAND;
	}
	//往服务器发送校验请求
	else{
		console.log("往服务器发送ajax请求");
		$.ajax({
			url:"/goods/UserServlet",
			data:{method:"ajaxValidateLoginname",loginname:val},
			type:"POST",
			dataType:"json",
			async:false,			//这里必须为false，否则会单独起一个线程，checkLoginname不会等服务器响应，直接return
			cache:false,
			success:function(result){
				console.log(result)
				if(!result){
					res = UNAME_USE;
				}
			}
		});
	}
	return res;
}

function checkLoginpass(val){
	var res = _OK;
	if(empty(val)){res=_NULL;}
	else if(!/\S{6,24}/.test(val)){//\S 等效于 [^ \f\n\r\t\v]
		res = PASS_STAND;
	}
	return res;
}

function checkReloginpass(val){
	if(val != $("#loginpass").val()){
		return PASS_AS;
	}else{
		return _OK;
	}
}

function checkEmail(val){
	var res = _OK
	if(empty(val)){res = _NULL;}
	else if(!/\w+@\w+.\w+.\w*/.test(val)){
		res =  EMAIL_STAND;
	}
	//往服务器发送校验请求
	else{
		console.log("往服务器发送ajax请求,检验Email");
		$.ajax({
			url:"/goods/UserServlet",
			data:{method:"ajaxValidateEmail",email:val},
			type:"POST",
			dataType:"json",
			async:false,			//这里必须为false，否则会单独起一个线程，checkLoginname不会等服务器响应，直接return
			cache:false,
			success:function(result){
				console.log(result)
				if(!result){
					res =  EMAIL_USE;
				}
			}
		});
	}
	return res;
}

function checkVerifyCode(val){
	var res = _OK;
	if(empty(val)){res =  _NULL;}
	else if(!/[a-zA-Z0-9]{4}/.test(val)){
		res = VCODE_ERROR;
	}
	else{
		console.log("往服务器发送ajax请求,检验验证码");
		$.ajax({
			url:"/goods/UserServlet",
			data:{method:"ajaxValidateVerifyCode",verifyCode:val},
			type:"POST",
			dataType:"json",
			async:false,			//这里必须为false，否则会单独起一个线程，checkLoginname不会等服务器响应，直接return
			cache:false,
			success:function(result){
				console.log(result)
				if(!result){
					res =  VCODE_ERROR;
				}
			}
		});
	}
	return res;
}
function empty(val){
	return (null == val || "" == val);
}