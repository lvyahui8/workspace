package cn.itcast.jdbc.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.JdbcUtils;
import cn.itcast.jdbc.TxQueryRunner;

/**
 * TxQueryRunner 是 QueryRunner的子类
 * 		接口与QueryRunner类似
 * 		区别：底层使用JdbcUtils，支持事务
 * QueryRunner的三个方法
 * update():insert,update,delete
 * query():select
 * batch():批处理
 * @author admin
 *	
 */
public class TxQueryRunnerTest {
	@Test
	public void testUpdate() throws SQLException{
		String sql = "insert into t_user(uid,loginname,loginpass,email,status,activationCode) "
				+ "values(?,?,?,?,?,?)";
		
		Object [] params = {CommonUtils.uuid(),"lvyahui","qwe321","lvyahui8@126.com",1,CommonUtils.uuid()};
		
		QueryRunner qr = new TxQueryRunner();
		qr.update(sql, params);
	}
	@Test
	public void testUpdateTx() throws Exception{
		
		try {
			JdbcUtils.beginTransaction();		//开始事务
			
			QueryRunner qr = new TxQueryRunner();
			String sql = "insert into t_user(uid,loginname,loginpass,email,status,activationCode) "
					+ "values(?,?,?,?,?,?)";
			
			Object [] params = {"1300","lvyaling","qwe321","lvyaling@126.com",1,CommonUtils.uuid()};
			qr.update(sql, params);
			
			if(true){
				throw new Exception();
			}
			params = new Object[] {"1300","lvyahui","qwe321","lvyahui8@126.com",1,CommonUtils.uuid()};
			qr.update(sql, params);
			
			JdbcUtils.commitTransaction();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JdbcUtils.rollbackTransaction();
			throw e;
		}
		
		
		
		
	}
	
	/**
	 * 单行结果集映射到javabean中
	 * 
	 */
	@Test
	public void testQuery1() throws SQLException{
		String sql = "select * from t_user where uid=?";
		
		QueryRunner qr = new TxQueryRunner();
		
		User user = qr.query(sql, new BeanHandler<User>(User.class),"B50ADE921BF14F6EB5331777B1874763");
		
		System.out.println(user);
	}
	
	/**
	 * 多行结果集映射到javabean中
	 * 
	 */
	@Test
	public void testQuery2() throws SQLException{
		String sql = "select * from t_user";
		
		QueryRunner qr = new TxQueryRunner();
		
		List<User> users = qr.query(sql, new BeanListHandler<User>(User.class));
		
		for(User user : users){
			System.out.println(user);
		}
	}
	
	/**
	 * 单行结果集映射到map集合中
	 */
	@Test
	public void testQuery3() throws SQLException{
		String sql = "select * from t_user where uid=?";
		
		QueryRunner qr = new TxQueryRunner();
		
		Map<String,Object> map = qr.query(sql, new MapHandler(),"B50ADE921BF14F6EB5331777B1874763");
		
		System.out.println(map);
	}
	
	/**
	 * 多行结果集映射到map集合中
	 */
	@Test
	public void testQuery4() throws SQLException{
		String sql = "select * from t_user";
		
		QueryRunner qr = new TxQueryRunner();
		
		List<Map<String,Object>> maps = qr.query(sql, new MapListHandler());
		for(Map<String,Object> map : maps){
			System.out.println(map);
		}
	}
	
	
	/**
	 * 单行单列的结果集封装到Object中
	 */
	@Test
	public void testQuery5() throws SQLException{
		String sql = "select count(*) from t_user";
		QueryRunner qr = new TxQueryRunner();
		
		/**
		 * 对于整数类型，不同的数据库驱动，对整数的转换不同
		 * > Integer
		 * > Long
		 * > BigInteger
		 * 无论哪种类型都是Number类型
		 */
		Number n = (Number) qr.query(sql, new ScalarHandler());
		
		System.out.println(n);
		
	}
}
