package com.grin.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grin.dao.IUserDAO;
import com.grin.vo.User;

public class MyIUserDAOImpl implements IUserDAO{

	private Connection conn = null;				//创建数据库连接字段
	
	public MyIUserDAOImpl(Connection conn){		//构造函数
		this.conn = conn;
	}
	
	abstract class AbstractUpdater{//类似于适配器类
		PreparedStatement pstmt = null;
		
		public PreparedStatement getPstmt() {
			return pstmt;
		}
		protected AbstractUpdater(String sql) throws SQLException {
			
			this.pstmt = conn.prepareStatement(sql);;
		}
		void update(final User user) throws SQLException{
		}
		void update(final int id) throws SQLException{
		}
		void update(final String keyWord) throws SQLException{
		}
		abstract void update() throws SQLException ;
		
		protected void closePstmt() throws SQLException   {
			if (this.pstmt != null) {
				this.pstmt.close();
			}
		}
	}
	
	@Override
	public boolean doCreate(final User user)  throws Exception{
		String sql = "INSERT INTO user(name,sex,birthday) VALUES(?,?,?)";
		AbstractUpdater updater = new AbstractUpdater(sql) {
			@Override
			void update(final User user) throws SQLException {
				pstmt.setString(1, user.getName()); //从user类的对象中读取信息
				pstmt.setString(2, user.getSex());
				pstmt.setDate(3, new Date(user.getBirthday().getTime()));
			}

			@Override
			void update() throws SQLException {
				this.update(user);
			}
			
		};
		boolean res = admin(updater);
		updater.closePstmt();
		return res;
	}

	
	@Override
	public boolean doUpdate(final User user) throws Exception {
		String sql = "UPDATE user SET name=?,sex=?,birthday=? WHERE id=?";
		AbstractUpdater updater = new AbstractUpdater(sql) {
			
			@Override
			void update(User user) throws SQLException {
				this.pstmt.setString(1, user.getName());
				this.pstmt.setString(2, user.getSex());
				this.pstmt.setDate(3, new Date(user.getBirthday().getTime()));
				this.pstmt.setInt(4, user.getId());
			}

			@Override
			void update() throws SQLException {
				this.update(user);
			}
		};
		boolean res = admin(updater);
		updater.closePstmt();
		return res;
	}

	@Override
	public boolean doDelete(final int id) throws Exception {
		
		String sql =  "DELETE FROM user WHERE id=?";
		AbstractUpdater updater = new AbstractUpdater(sql) {
			
			@Override
			void update(int id) throws SQLException {
				this.pstmt.setInt(1, id);
			}

			@Override
			void update() throws SQLException {
				this.update(id);
			}
		};
		boolean res = admin(updater);
		updater.closePstmt();
		return res;
	}

	@Override
	public User findById(final int id) throws Exception {
		User user = null;
		String sql = "SELECT id,name,sex,birthday FROM user WHERE id=?";
		AbstractUpdater updater = new AbstractUpdater(sql) {
			
			@Override
			void update(int id) throws SQLException {
				this.pstmt.setInt(1, id);
			}

			@Override
			void update() throws SQLException {
				this.update(id);
			}
		};
		admin(updater);
		ResultSet rs = updater.getPstmt().executeQuery();
		if(rs.next()){
			user = MyIUserDAOImpl.this.getUserByRs(rs);
		}
		updater.closePstmt();
		return user;
	}

	@Override
	public List<User> findAll(final String keyWord) throws Exception {
		List<User> all = new ArrayList<User>();
		String sql = "SELECT id,name,sex,birthday FROM user WHERE name LIKE ? OK sex LIKE ? OR birthday LIKE";
		AbstractUpdater updater = new AbstractUpdater(sql) {
			
			@Override
			void update(String keyWord) throws SQLException {
				pstmt.setString(1, "%"+keyWord+"%");
				pstmt.setString(2, "%"+keyWord+"%");
				pstmt.setString(3, "%"+keyWord+"%");
			}
			@Override
			void update() throws SQLException {
				this.update(keyWord);
			}
		};
		admin(updater);
		ResultSet rs = updater.getPstmt().executeQuery();
		while (rs.next()) {
			User user = getUserByRs(rs);
			all.add(user);
		}
		rs.close();
		updater.closePstmt();
		return all;
	}


	public User getUserByRs(ResultSet rs) throws SQLException {
		return new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4));
	}
	
	public boolean admin(AbstractUpdater updater)
			throws SQLException {
		boolean flag = false;
		updater.update();
		if(updater.getPstmt().executeUpdate() > 0){		//至少更新了一行
			flag = true;
		}
		return flag;
	}

}
