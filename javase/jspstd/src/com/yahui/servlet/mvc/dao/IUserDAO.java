package com.yahui.servlet.mvc.dao;

import com.yahui.servlet.mvc.vo.User;

public interface IUserDAO {
	public boolean findLogin(User user) throws Exception;
}
