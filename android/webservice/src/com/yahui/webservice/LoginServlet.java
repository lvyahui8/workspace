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
		//ServletRequest��ŷ����д�ģ�ʹ�õ���ISO-8859-1���룬��ʵ����������͸�������Ĭ����UTF-8���룬���Ժ���Ҫ�����������
		//��������ķ�����������ISO-8859-1ת����0��1���У��ٰ�utf-8����0-1���У��͵õ�����ȷ������
		String username = new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");		
		String password = new String(request.getParameter("password").getBytes("ISO-8859-1"),"utf-8");//
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		
		if("zs".equals(username)&&"123".equals(password)){
			response.getOutputStream().write("��¼�ɹ�".getBytes());
		}
		else{
			response.getOutputStream().write("��¼ʧ��".getBytes());
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
