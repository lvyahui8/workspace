package day01;

import info.MySqlInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test01 {

/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		Connection conn = null;
		String sql;
		Statement stmt = null;
		
		try {
			Class.forName(MySqlInfo.DBDRIVER); // �������ݿ�����
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(MySqlInfo.DBURL, MySqlInfo.DBUSER, MySqlInfo.DBPASS); // ��ȡ����
			System.out.println("���ӳɹ�");
			stmt = conn.createStatement();
			
			sql = "SELECT * FROM user";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDate(4));
			}
			
		} catch (Exception e) {
			//
//			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}
		finally{
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {

					conn.close();

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
