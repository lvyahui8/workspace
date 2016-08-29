package com.grin.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
//	private static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/Users";
	private static final String DBUSER = "root";
	private static final String DBPASS = "root";
	
	private Connection conn = null;

	public DataBaseConnection() {
		try {
			Class.forName(DBDRIVER);		//�������ݿ�����
System.out.println("���������ɹ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS); //��ȡ����
System.out.println("���ӳɹ�");
		} catch (SQLException e) {
			//
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection(){
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
