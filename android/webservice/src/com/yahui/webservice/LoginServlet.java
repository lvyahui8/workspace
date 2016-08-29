package com.yahui.webservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ServletRequest是欧洲人写的，使用的是ISO-8859-1编码，而实际浏览器发送给服务器默认是UTF-8编码，所以后面要纠正这个错误
		//纠正错误的方法是首先以ISO-8859-1转换成0，1序列，再按utf-8编码0-1序列，就得到了正确的内容
		String username = new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");		
		String password = new String(request.getParameter("password").getBytes("ISO-8859-1"),"utf-8");//
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		
		if("zs".equals(username)&&"123".equals(password)){
			response.getOutputStream().write("登录成功".getBytes());
		}
		else{
			response.getOutputStream().write("登录失败".getBytes());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
