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

	public String ajaxCheckUserName() throws IOException{
		//调用Service进行查询
		User existUser = this.userService.findByUserName(user.getUsername());
		
		HttpServletResponse respone = ServletActionContext.getResponse();
		respone.setContentType("text/html;charset=utf-8");
		if(existUser != null){
			respone.getWriter().println("true");
		}else{
			respone.getWriter().println("false");
		}
		return super.NONE;
	}
	
	
}
