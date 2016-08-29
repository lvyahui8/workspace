package com.grin.dao.factory;

import com.grin.dao.IUserDAO;
import com.grin.dao.proxy.IUserDAOProxy;

public class DAOFactory {
	public static IUserDAO getIUserDAOInstance(){
		return new IUserDAOProxy();
	}
}
