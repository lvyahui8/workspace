package org.lyh.happyhome.user.service;

import org.lyh.happyhome.user.dao.UserDao;
import org.lyh.happyhome.user.vo.User;

public class UserService {
	/**
	 * 注入DAO
	 */
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	
	public User findByUserName(String username){
		return this.userDao.findByUserName(username);
	}
}
