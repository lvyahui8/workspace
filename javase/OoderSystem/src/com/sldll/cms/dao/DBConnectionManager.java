package com.sldll.cms.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionManager {
	private static Connection conn ;
	static {
		try {
			Class.forName(SqlServerInfo.DBDRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws Exception{
		// TODO Auto-generated method stub
		conn = DriverManager.getConnection(SqlServerInfo.DBURL,SqlServerInfo.DBUSER,SqlServerInfo.DBPASS);
System.out.println(conn);
		return conn;
	}

	public static void closeConnection() throws Exception {
		// TODO Auto-generated method stub
		if(null != conn){
			conn.close();
		}
	}

}
