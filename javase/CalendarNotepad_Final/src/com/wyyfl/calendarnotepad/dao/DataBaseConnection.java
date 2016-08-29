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
			Class.forName(DBDRIVER);		//�������ݿ�����
System.out.println("���������ɹ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public Connection getConnection(){
		try {
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD); //��ȡ����
System.out.println("���ӳɹ�");
		} catch (SQLException e) {
			//
			e.printStackTrace();
		}
		return this.conn;
	}
	
	public void close(){
		if(this.conn != null){
			try {
				this.conn.close();		//�ر�����
System.out.println("�ѹر�����");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}