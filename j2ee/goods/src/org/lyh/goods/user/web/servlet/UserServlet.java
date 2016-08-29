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
	 * �첽У���û����Ƿ�ʹ��
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
	 * �첽У�������Ƿ��Ѿ�ע��
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
	 * У����֤��
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
		 *	��ȡ����Ϣ
		 */
System.out.println("ע�Ὺʼ");
		User formUser = CommonUtils.toBean(req.getParameterMap(), User.class);
		/*
		 * У��
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
		 * ע��
		 */
		userService.regist(formUser);
		/*
		 * ������Ϣ
		 */
		req.setAttribute("code", "success");
		req.setAttribute("msg", "ע��ɹ����뵽���伤��");
System.out.println("ע�����");
		return "f:/jsps/msg.jsp";
	}
	
	public Map<String,String> validateFormUser(User formUser,String vCode){
		Map<String,String> errors = new HashMap<String, String>();
		
		String userName = formUser.getLoginname();
		if(TextUtils.isEmpty(userName)){
			errors.put("loginname", "�û�������Ϊ��");
		}else if(!userName.matches("\\w{6,12}")){
			errors.put("loginname", "�û�������Ӧ��6-24λ����������ĸ�����»��ߵ����");
		}
		else if(!userService.ajaxValidateLoginname(userName)){
			errors.put("loginname","�û����ѱ�ע�ᣡ");
		}
		
		String loginpass = formUser.getLoginpass();
		if(TextUtils.isEmpty(loginpass)){
			errors.put("loginpass", "���벻��Ϊ��");
		}else if(!loginpass.matches("\\S{6,24}")){
			errors.put("loginpass", "���볤��6-24λ�����������ļ�\\f\\n\\r\\t\\v");
		}
		
		String reloginpass = formUser.getReloginpass();
		if(TextUtils.isEmpty(reloginpass)){
			errors.put("reloginpass", "����Ϊ��");
		}else if(!reloginpass.trim().equals(loginpass.trim())){
			errors.put("reloginpass", "�����������벻һ��");
		}
		
		String email = formUser.getEmail();
		
		if(TextUtils.isEmpty(email)){
			errors.put("email", "�����ַ����Ϊ��");
		}
		else if(!email.matches("\\w+@\\w+\\.\\w+\\.*\\w*")){
			errors.put("email", "�����ַ���Ϸ�");
		}else if(!userService.ajaxValidateEmail(email)){
			errors.put("email", "�����ַ�Ѿ�ע��");
		}
		
		//��֤��У��
		String verifyCode = formUser.getVerifyCode();
		
		if(TextUtils.isEmpty(verifyCode)){
			errors.put("verifyCode", "��֤�벻��Ϊ��");
		}
		else if(!verifyCode.matches("[0-9a-zA-Z]{4}") || !verifyCode.equalsIgnoreCase(vCode)){
			errors.put("verifyCode", "��֤�����");
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
			req.setAttribute("msg", "��ϲע��ɹ��������ϵ�½");
		} catch (UserException e) {
			// TODO Auto-generated catch block
			req.setAttribute("msg", e.getMessage());
			req.setAttribute("code","error");//֪ͨmsg.jsp��ʾX
		}
		return "f:/jsps/msg.jsp";
	}
	
}
