package org.lyh.goods.user.web.servlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lyh.goods.user.domain.User;
import org.lyh.goods.user.service.UserService;
import org.lyh.goods.user.service.exception.UserException;
import org.lyh.goods.utils.TextUtils;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;


public class UserServlet extends BaseServlet {
	private UserService userService = new UserService();
	
	/**
	 * 异步校验用户名是否使用
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String ajaxValidateLoginname(HttpServletRequest req,HttpServletResponse resp)
		throws ServletException,IOException{
		
//		System.out.println(req.getParameter("loginname"));;
		
		resp.getWriter().print(userService.ajaxValidateLoginname(req.getParameter("loginname")));
		
		return null;
	}
	/**
	 * 异步校验邮箱是否已经注册
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String ajaxValidateEmail(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
		
		resp.getWriter().print(userService.ajaxValidateEmail(req.getParameter("email")));

		
		return null;
	}
	
	/**
	 * 校验验证码
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String ajaxValidateVerifyCode(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
		
		String verifyCode = req.getParameter("verifyCode").trim();
		String vcode = (String) req.getSession().getAttribute("vCode");
		System.out.println(verifyCode+":"+vcode);
		
		boolean b = false;
		if(!(verifyCode == null || null == vcode)){
			b = verifyCode.equalsIgnoreCase(vcode);
		}
		
		resp.getWriter().print(b);
		return null;
	}
	public String register(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
		/*
		 *	获取表当信息
		 */
System.out.println("注册开始");
		User formUser = CommonUtils.toBean(req.getParameterMap(), User.class);
		/*
		 * 校验
		 */
		String vCode = (String) req.getSession().getAttribute("vCode");
		Map<String, String> errors = this.validateFormUser(formUser, vCode);
		if(errors != null && errors.size()>0){
			req.setAttribute("formUser", formUser);
			req.setAttribute("errors", errors);
			System.out.println(errors.toString());
			return "f:/jsps/user/regist.jsp";
		}
		/*
		 * 注册
		 */
		userService.regist(formUser);
		/*
		 * 保存信息
		 */
		req.setAttribute("code", "success");
		req.setAttribute("msg", "注册成功，请到邮箱激活");
System.out.println("注册结束");
		return "f:/jsps/msg.jsp";
	}
	
	public Map<String,String> validateFormUser(User formUser,String vCode){
		Map<String,String> errors = new HashMap<String, String>();
		
		String userName = formUser.getLoginname();
		if(TextUtils.isEmpty(userName)){
			errors.put("loginname", "用户名不能为空");
		}else if(!userName.matches("\\w{6,12}")){
			errors.put("loginname", "用户名长度应在6-24位，并且是字母数字下划线的组合");
		}
		else if(!userService.ajaxValidateLoginname(userName)){
			errors.put("loginname","用户名已被注册！");
		}
		
		String loginpass = formUser.getLoginpass();
		if(TextUtils.isEmpty(loginpass)){
			errors.put("loginpass", "密码不能为空");
		}else if(!loginpass.matches("\\S{6,24}")){
			errors.put("loginpass", "密码长度6-24位，不能有中文及\\f\\n\\r\\t\\v");
		}
		
		String reloginpass = formUser.getReloginpass();
		if(TextUtils.isEmpty(reloginpass)){
			errors.put("reloginpass", "不能为空");
		}else if(!reloginpass.trim().equals(loginpass.trim())){
			errors.put("reloginpass", "两次输入密码不一致");
		}
		
		String email = formUser.getEmail();
		
		if(TextUtils.isEmpty(email)){
			errors.put("email", "邮箱地址不能为空");
		}
		else if(!email.matches("\\w+@\\w+\\.\\w+\\.*\\w*")){
			errors.put("email", "邮箱地址不合法");
		}else if(!userService.ajaxValidateEmail(email)){
			errors.put("email", "邮箱地址已经注册");
		}
		
		//验证码校验
		String verifyCode = formUser.getVerifyCode();
		
		if(TextUtils.isEmpty(verifyCode)){
			errors.put("verifyCode", "验证码不能为空");
		}
		else if(!verifyCode.matches("[0-9a-zA-Z]{4}") || !verifyCode.equalsIgnoreCase(vCode)){
			errors.put("verifyCode", "验证码错误");
		}
		
		return errors;
	}
	
	public String activation(HttpServletRequest req,HttpServletResponse resp)
		throws ServletException,IOException
	{
		String code = req.getParameter("activationCode");
		try {
			userService.activation(code);
			req.setAttribute("code", "sucess");
			req.setAttribute("msg", "恭喜注册成功，请马上登陆");
		} catch (UserException e) {
			// TODO Auto-generated catch block
			req.setAttribute("msg", e.getMessage());
			req.setAttribute("code","error");//通知msg.jsp显示X
		}
		return "f:/jsps/msg.jsp";
	}
	
}
