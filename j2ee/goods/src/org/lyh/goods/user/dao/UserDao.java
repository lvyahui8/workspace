package org.lyh.goods.user.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lyh.goods.user.domain.User;

import cn.itcast.jdbc.TxQueryRunner;

public class UserDao {
	QueryRunner qr = new TxQueryRunner();
	
	/**
	 * �����û����Ƿ�ע��
	 * @param loginname
	 * @return
	 * @throws SQLException
	 */
	public boolean ajaxValidateLoginname(String loginname) throws SQLException{
		
		String sql = "select count(1) from t_user where loginname=?";
		Number number = (Number) qr.query(sql, new ScalarHandler(),loginname);		
		return number.intValue() == 0;
	}
	
	/**
	 * ����Email�Ƿ�ע��
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public boolean ajaxValidateEmail(String email) throws SQLException{
		String sql = "select count(*) from t_user where email=?";
		Number number = (Number) qr.query(sql, new ScalarHandler(),email);
		return number.intValue() == 0;
	}
	
	/**
	 * ����û�
	 * @param user
	 * @throws SQLException 
	 */
	public void add(User user) throws SQLException{
		String sql = "insert into t_user values(?,?,?,?,?,?)";
		
		Object [] params = {user.getUid(),user.getLoginname(),user.getLoginpass()
				,user.getEmail(),user.isStatus(),user.getActivationCode()};
		
		qr.update(sql, params);
	}
	
	/**
	 * ���ݼ������ѯ�û�
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	public User findByCode(String code) throws SQLException{
		
		
		String sql = "select * from t_user where activationCode=?";
		
		return  qr.query(sql, new BeanHandler<User>(User.class),code);
	}
	
	public void updateStatus(String uid,boolean status) throws SQLException{
		String sql = "update t_user set status=? where uid=?";
		
		qr.update(sql,status,uid);
	}
	
	
}
