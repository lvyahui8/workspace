package org.lyh.happyhome.user.action;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.lyh.happyhome.user.service.UserService;
import org.lyh.happyhome.user.vo.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户模块Action
 * @author admin
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private User user = new User();
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	private UserService userService;
	public void setUserService(UserService userSerivce){
		this.userService = userSerivce;
	}
	
	/**
	 * 实行页面
	 */
	public String registerPage(){
		return "registerPage";
	}

	public String regist(){
		String sessionCapthca = (String) ServletActionContext.getRequest().getSession().getAttribute("capthca");
		if(!sessionCapthca.equals(this.captcha)){
			this.addActionError("验证码错误");
			return "capthcaError";
		}
		this.userService.save(user);
		super.addActionMessage("zhu ce cheng gong,qu youx xiang ji huo");
		return "msg";
	}

	public String captcha = null;

	/*
	 * Struct 属性驱动
	 */
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String active(){
		User existUser = userService.finByCode(user.getCode());
		if (existUser == null) {
			super.addActionError("code error!!");
		}
		else{
			existUser.setState(1);
			existUser.setCode(null);//one active
			userService.update(existUser);
			super.addActionMessage("active ok");
		}
		return "msg";
	}

	public String loginPage(){
		return "loginPage";
	}

	public String login(){
		User existUser = userService.login(user);
		if (existUser == null) {
			this.addActionError("login error!");
			return "loginPage";
		}
		else{
			//save session
			ServletActionContext.getRequest().getSession().setAttribute("existUesr",existUser);
			return "loginSucess";
		}
	}

	public String logout(){
		//销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
	}
	public String ajaxCheckUserName() throws IOException{
		//调用Service进行查询
		User existUser = this.userService.findByUserName(user.getUsername());
		
		HttpServletResponse respone = ServletActionContext.getResponse();
		respone.setContentType("text/html;charset=utf-8");
		if(existUser != null){
			respone.getWriter().println("false");
		}else{
			respone.getWriter().println("true");
		}
		return super.NONE;
	}
	
	
}
