<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>会员注册</title>
<%@include file="head.jsp" %>
<link href="${pageContext.request.contextPath}/css/register.css" rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/js/jquery.form.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container register">
		<div class="span24">
			<div class="wrap">
				<div class="main clearfix">
					<div class="title">
						<s:fielderror></s:fielderror>
						<s:actionerror/>
						<strong>会员注册</strong>USER REGISTER
					</div>
					<form id="registerForm"  method="post" action="${pageContext.request.contextPath}/user_regist.action" >
						<div class="row">
							<span class="requiredField">*</span>用户名:
							<input type="text" id="username" name="username" class="text" maxlength="20"/>
							<span><s:fielderror fieldName="username"/></span>
						</div>
						<div class="row">
							<span class="requiredField">*</span>密&nbsp;&nbsp;码:
							<input type="password" id="password" name="password" class="text" maxlength="20" autocomplete="off"/>
							<span><s:fielderror fieldName="password"/> </span>
						</div>
						<div class="row">
							<span class="requiredField">*</span>确认密码:
							<input type="password" name="rePassword" id="rePassword" class="text" maxlength="20" autocomplete="off"/>
							<span><s:fielderror fieldName="rePassword"/> </span>
						</div>		
						<div class="row">	
							<span class="requiredField">*</span>E-mail:
							<input type="text" id="email" name="email" class="text" maxlength="200"/>
							<span><s:fielderror fieldName="email"/> </span>
						</div>
						<div class="row">
							姓名:<input type="text" name="name" class="text" maxlength="200"/>
						</div>
						<div class="row">
							性别:<span class="fieldSet">
								<label>
									<input type="radio" name="sex" value="male"/>男
								</label>
								<label>
									<input type="radio" name="sex" value="female"/>女
								</label>
							</span>
						</div>
						<div class="row">
							地址:<input type="text" name="addr" class="text" maxlength="200"/>
						</div>
						<div class="row">
							<span class="requiredField">*</span>验证码:
							<span class="fieldSet">
								<input type="text" id="captcha" name="captcha" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/captcha.action"  title="点击更换验证码">
							</span>
							<span><s:fielderror fieldName="captcha"/> </span>
						</div>
						<div class="row">
							<input type="submit" class="submit" value="同意以下协议并注册">
							已经拥有账号了？立即登录即可体验在线购物！
							<a href="./会员登录.htm">立即登录</a>
						</div>
					</form>
					<script>
						$("#registerForm").validate({
							rules:{
								username:{
									required:true,
									minlength:6,
									remote:{
										url:"user_ajaxCheckUserName.action",
										type:'POST',
										data:{
											'username':function(){
												return $("#username").val()
											}
										}
									}
								},
								password:{
									required:true,
									minlength:8
								},
								rePassword:{
									required:true,
									equalTo:"#password"
								},
								email:{
									required:true,
									email:true
								}
							},
							messages:{
								username:{
									required:"用户名不能为空",
									minlength:$.validator.format("用户名的长度至少为{0}位"),
									remote:"用户名存在"
								},
								password:{
									required:"密码不能为空",
									minlength:$.validator.format("密码长度至少为{0}位")
								},
								rePassword:{
									required:true,
									equalTo:"两次密码不一致"
								},
								email:{
									required:"邮箱不能为空",
									email:"请输入合法的邮箱地址"
								}
							},
							submitHandler:function(form){
								//alert(form);
								//form.submit();
								$(form).ajaxSubmit();
							}
						});
						$("#captchaImage").click(function(){
							$(this).attr("src","${pageContext.request.contextPath}/captcha.action?time="+new Date().getTime());
						});
					</script>
				</div>
			</div>
		</div>
	</div>
<%@include file="footer.jsp" %>
</body>
</html>