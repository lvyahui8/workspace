package ref.dao;

import info.MySqlInfo;

import java.sql.DriverManager;

import java.sql.Connection;

public class DBConnectionManager {
	private static Connection conn ;
	static {
		try {
			Class.forName(MySqlInfo.DBDRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws Exception{
		// TODO Auto-generated method stub
		conn = DriverManager.getConnection(MySqlInfo.DBURL,MySqlInfo.DBUSER,MySqlInfo.DBPASS);
		return conn;
	}

	public static void closeConnection() throws Exception {
		// TODO Auto-generated method stub
		conn.close();
	}

}
