package com.yahui.servlet.mvc.dao;

import com.yahui.servlet.mvc.dao.impl.UserDAOImpl;
import com.yahui.servlet.mvc.dbc.DatabaseConnection;
import com.yahui.servlet.mvc.vo.User;

public class UserDAOProxy implements IUserDAO {
	private DatabaseConnection dbc = null;
	public IUserDAO dao = null;
	public UserDAOProxy(){
		try{
			this.dbc = new DatabaseConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		this.dao = new UserDAOImpl(this.dbc.getConnection());
	}
	
	public boolean findLogin(User user) throws Exception{
		boolean flag = false;
		
		try{
			flag = this.dao.findLogin(user);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
}
