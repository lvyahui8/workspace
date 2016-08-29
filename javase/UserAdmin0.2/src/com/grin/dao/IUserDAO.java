package com.grin.dao;

import java.util.List;

import com.grin.vo.User;

public interface IUserDAO {
	//表示数据库的增加操作
	public boolean doCreate(final User user) throws Exception;
	//表示数据库的更新操作
	public boolean doUpdate(final User user) throws Exception;
	//表示数据库的删除操作
	public boolean doDelete(final int id) throws Exception;
	//表示数据库的查询操作
	public User findById(final int id) throws Exception;
	//表示数据库的增加操作，查询所有的
	public List<User> findAll(final String keyWord) throws Exception;
}
