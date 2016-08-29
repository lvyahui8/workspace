package com.grin.test;

import java.sql.Date;

import com.grin.dao.factory.DAOFactory;
import com.grin.menu.Menu;
import com.grin.vo.User;

public class TestID {
	//
	public static void main(String [] args) throws Exception{
//		User user = DAOFactory.getIUserDAOInstance().findById(2);
//		System.out.println(user);
		
//		List<User> allUser = DAOFactory.getIUserDAOInstance().findAll("");
//		for (Iterator<User>iterator = allUser.iterator(); iterator.hasNext();) {
//			User user =  iterator.next();
//			System.out.println(user);
//		}
		
//		DAOFactory.getIUserDAOInstance().doDelete(2);
		
//		User user = new User();
//		user.setName("qianqian");
//		user.setSex("wuman");
//		user.setBirthday(new Date(System.currentTimeMillis()));
//		DAOFactory.getIUserDAOInstance().doCreate(user);
		new Menu();
	}
}
