package com.yahui.servlet.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yahui.servlet.mvc.dao.IUserDAO;
import com.yahui.servlet.mvc.vo.User;

public class UserDAOImpl implements IUserDAO
{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public UserDAOImpl(Connection conn){
		this.conn = conn;
	}
	
	public boolean findLogin(User user) throws Exception {
		
		boolean flag = false;
		String sql = "select name from user where userid=? and password=?";

		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, user.getUserId());
		this.pstmt.setString(2, user.getPassword());
		
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			user.setName(rs.getString(1));//取出一个用户的真实姓名
			flag=true;
		}
		this.pstmt.close();
		return flag	;
	}
	

}
