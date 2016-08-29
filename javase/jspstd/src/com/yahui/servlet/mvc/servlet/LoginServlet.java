package com.yahui.servlet.mvc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yahui.servlet.mvc.factory.DAOFactory;
import com.yahui.servlet.mvc.vo.User;

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)
		throws ServletException , IOException
	{
		String path = "login.jsp";
		String userid = req.getParameter("userid");
		String userpass = req.getParameter("userpass");
		List<String> info = new ArrayList<String>();
		if (null==userid || "".equals(userid)) {
			info.add("用户id不能为空");
		}
		if(null == userpass || "".equals(userpass)){
			info.add("密码不能为空");
		} 
		if (info.size()==0) {
			User user = new User();
			user.setUserId(userid);
			user.setPassword(userpass);
			try{
				if(DAOFactory.getIUserDAOInstance().findLogin(user)){
					info.add("用户登录成功，欢迎"+user.getName());
				}else{
					info.add("用户登录失败，错误的用户名和密码");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		req.setAttribute("info", info);
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse resp)
		throws ServletException,IOException
	{
		this.doGet(req, resp);
	}
}
