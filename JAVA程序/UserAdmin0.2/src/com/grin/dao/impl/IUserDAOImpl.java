package com.grin.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.grin.dao.IUserDAO;
import com.grin.vo.User;

public class IUserDAOImpl implements IUserDAO {

	private Connection conn = null;				//创建数据库连接字段
	
	public IUserDAOImpl(Connection conn){		//构造函数
		this.conn = conn;
	}
		
	@Override
	public boolean doCreate(User user) throws Exception {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO user(name,sex,birthday) VALUES(?,?,?)";
		
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, user.getName()); //从user类的对象中读取信息
			pstmt.setString(2, user.getSex());
			pstmt.setDate(3, new Date(user.getBirthday().getTime()));
			if(pstmt.executeUpdate() > 0){
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		}
		finally{
			if(pstmt != null){
				pstmt.close();
			}
		}
		return flag;
	}

	@Override
	public boolean doUpdate(User user) throws Exception {
		//
		return false;
	}

	@Override
	public boolean doDelete(int id) throws Exception {
		//
		return false;
	}

	@Override
	public User findById(int id) throws Exception {
		User user = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT id,name,sex,birthday FROM user WHERE id=?";
		
		
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4));
			}
		} catch (Exception e) {
			throw e;
		}
		finally{
			if(pstmt != null){
				pstmt.close();
			}
		}
		return user;
	}

	@Override
	public List<User> findAll(String keyWord) throws Exception {
		//
		return null;
	}

}
