package com.grin.test;

import com.grin.dao.factory.DAOFactory;
import com.grin.vo.User;

public class TestID {
	//
	public static void main(String [] args) throws Exception{
		User user = DAOFactory.getIUserDAOInstance().findById(3);
		System.out.println(user);
	}
}
