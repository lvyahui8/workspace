package com.grin.dao.proxy;

import java.util.List;

import com.grin.dao.IUserDAO;
import com.grin.dao.impl.IUserDAOImpl;
import com.grin.dbc.DataBaseConnection;
import com.grin.vo.User;

public class IUserDAOProxy implements IUserDAO {

	private DataBaseConnection dbc = null;
	private IUserDAO dao = null;
	
	public IUserDAOProxy(){
		this.dbc = new DataBaseConnection();
		this.dao = new IUserDAOImpl(this.dbc.getConnection());
	}
	
	@Override
	public boolean doCreate(User user) throws Exception {
		boolean flag = true;
		try {
			flag = this.dao.doCreate(user);
		} 
		finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdate(User user) throws Exception {
		boolean flag = true;
		try {
			flag = this.dao.doUpdate(user);
		} 
		finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doDelete(int id) throws Exception {
		boolean flag = true;
		try {
			flag = this.dao.doDelete(id);
		} 
		finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public User findById(int id) throws Exception {
		User user = null;
		try {
			user = this.dao.findById(id);
		} 
		finally{
			this.dbc.close();
		}
		return user;
	}

	@Override
	public List<User> findAll(String keyWord) throws Exception {
		List<User> all = null;
		try {
			all = this.dao.findAll(keyWord);
		} 
		finally{
			this.dbc.close();
		}
		return all;
	}

}
