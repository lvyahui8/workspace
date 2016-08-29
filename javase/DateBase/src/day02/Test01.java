package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import info.MySqlInfo;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		Statement stmt = null;
		PreparedStatement updateSales;
		PreparedStatement updateTotal;
		
		String updateString = "UPDATE user"+
						"SET sex = ? WHERE id = ?";
		String updateStatement = "UPDATE user"+
						"SET name = ? WHERE id = ?";
		
		String query = "SELECT id,name,sex FROM user";

		try {
			Class.forName(MySqlInfo.DBDRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(MySqlInfo.DBURL,MySqlInfo.DBUSER,MySqlInfo.DBPASS);
System.out.println("连接成功");
			updateSales = con.prepareStatement(updateString);
			updateTotal = con.prepareStatement(updateStatement);
			String [] salesForWeek = {"nan","nv","M","W"};
			String [] names = {"lisi","zhansan","wangwu","xiaoqiang"};
			int [] ids = {1,3,4,5};
			
			//关闭事物自动更新模式
			con.setAutoCommit(false);
			
			//循环的每次执行都作为一个单独的事物
			for (int i = 0; i < ids.length; i++) {
				updateSales.setString(1,salesForWeek[i]);
				updateSales.setInt(2, ids[i]);
				updateSales.executeUpdate();
				
				updateTotal.setString(1, names[i]);
				updateTotal.setInt(2, ids[i]);
				updateTotal.executeUpdate();
				
				con.commit();
			}
			
			//恢复自动更新模式
			con.setAutoCommit(true);
			
			updateSales.close();
			updateTotal.close();
			
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				System.out.println(rs.getInt("id")+"  "+rs.getString("sex")+"  "+rs.getString("name"));
			}
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
