package day01;

import info.MySqlInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
//		String sql = "SELECT * FROM user";
		String sql = "SELECT id,name,sex,birthday FROM user WHERE name LIKE ? OR sex LIKE ?  OR birthday LIKE ?";
		//SELECT id,name,sex,birthday FROM user WHERE name LIKE 'lvyah' OR sex LIKE ''  OR birthday LIKE '';
		try {
			Class.forName(MySqlInfo.DBDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(MySqlInfo.DBURL,MySqlInfo.DBUSER,MySqlInfo.DBPASS);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+"lvyahui"+"%");
			pstmt.setString(2,"%"+"lvyahui"+"%");
			pstmt.setString(3,"%"+"lvyahui"+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
//				System.out.println(rs);
				System.out.println(
						rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDate(4)
						);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally{
			try {
				if(pstmt != null){
					pstmt.close();
					System.out.println("关闭命令通道");
				}
				if(conn != null){
					conn.close();
					System.out.println("关闭链接");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
