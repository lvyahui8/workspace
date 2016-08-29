package com.wyyfl.calendarnotepad.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnection {
//	public static final String DBDRIVER = "org.gjt.mm.mysql.driver";
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/notes";
	public static final String DBUSER = "root";
	public static final String DBPASSWORD = "";
	
	
	private Connection conn = null;
	
	public DataBaseConnection(){
		try {
			Class.forName(DBDRIVER);		//加载数据库驱动
System.out.println("加载驱动成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public Connection getConnection(){
		try {
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD); //获取链接
System.out.println("连接成功");
		} catch (SQLException e) {
			//
			e.printStackTrace();
		}
		return this.conn;
	}
	
	public void close(){
		if(this.conn != null){
			try {
				this.conn.close();		//关闭链接
System.out.println("已关闭连接");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}