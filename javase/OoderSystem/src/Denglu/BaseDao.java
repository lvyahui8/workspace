package Denglu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDao {
	
	static
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getCon()
	{
		Connection con=null;
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=catering","sa","123qwe");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void doClose(Connection con,Statement stat)
	{
		try {
			stat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void doClose(Connection con,Statement stat,ResultSet rs)
	{
		try {
			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
