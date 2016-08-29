package com.yahui.servlet.mvc.factory;

import com.yahui.servlet.mvc.dao.IUserDAO;
import com.yahui.servlet.mvc.dao.UserDAOProxy;

public class DAOFactory {
	public static IUserDAO getIUserDAOInstance(){
		return new UserDAOProxy();
	}
}
