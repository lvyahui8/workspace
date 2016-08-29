package com.yahui.servlet.mvc.dbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/mvcweb";
	private static final String DBNAME = "root";
	private static final String DBPASSWORD = "";
	
	private Connection con = null;
	
	public DatabaseConnection(){
		try {
			Class.forName(DBDRIVER);
			this.con = DriverManager.getConnection(DBURL, DBNAME, DBPASSWORD);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return this.con;
	}
	
	public void close() throws Exception{
		if (this.con!=null) {
			try {
				this.con.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}
	
}
