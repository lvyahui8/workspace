package cn.itcast.jdbc.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import cn.itcast.jdbc.JdbcUtils;

/**
 * JdbcUtils 用来获取Connection
 * 		底层用了c3p0连接池
 * 		还需要mysql驱动
 * @author admin
 *
 */
public class JdbcUtilsTest {
	
	
	/**
	 * 底层使用c3p0连接池，所以还学要提供c3p0配置文件
	 * @throws SQLException 
	 */
	@Test
	public void testGetConnection() throws SQLException
	{
		Connection conn = JdbcUtils.getConnection();
		System.out.println(conn);
		JdbcUtils.releaseConnection(conn);
		System.out.println(conn.isClosed());
	}
	
	/**
	 * JdbcUtils还提供了事务相关的功能
	 */
	@Test
	public void testTransaction(){
		try{
			JdbcUtils.beginTransaction();
			
			
			JdbcUtils.commitTransaction();
		}catch(Exception e){
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("回滚失败");
			}
		}
	}
}

