package org.lyh.happyhome.user.service;


import org.lyh.happyhome.user.dao.UserDao;
import org.lyh.happyhome.user.vo.User;
import org.lyh.happyhome.utils.MailUtils;
import org.lyh.happyhome.utils.UUIDUtils;

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

	public void save(User user){
		user.setState(0);
		String code = UUIDUtils.getUUID();
		user.setCode(code);
		this.userDao.save(user);
		//MailUtils.sendMail(user.getEmail(),code);
	}

	public User finByCode(String code) {
		return userDao.finByCode(code);
	}

	public void update(User existUser) {
		userDao.update(existUser);
	}

	public User login(User user) {
		return this.userDao.login(user);
	}
}
