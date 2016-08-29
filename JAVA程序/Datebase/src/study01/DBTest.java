package study01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/test";
		Connection con = null;
		String sql;
		Statement stmt = null;
		String num, name, sex;
		int age, math, eng, spec;
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException");
			System.err.println(e.getMessage());
		}

		try {
			con = DriverManager.getConnection(url, "root", "java");
			stmt = con.createStatement();

			// 向student表中插入一条记录
			sql = "INSERT INTO STUDENT"
					+ "VALUES('200108','赵小龙','男',20,71,62,76)";
			stmt.executeUpdate(sql);

			// 检索student表中的所有记录并获取数据输出
			sql = "SELECT * FROM STUDENT";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("学号\t姓名\t性别\t年龄\t" + "高等数学\t英语\t专业课");
			while (rs.next()) {
				num = rs.getString(1);
				name = rs.getString(2);
				sex = rs.getString(3);
				age = rs.getInt(4);
				math = rs.getInt(5);
				eng = rs.getInt("英语");
				spec = rs.getInt("专业课");
				System.out.println(num + "\t" + name + "\t" + sex + "\t" + age
						+ "\t" + math + "\t" + eng + "\t" + spec);
			}

			// 检索高等数学成绩80分以上的学生信息
			rs = stmt.executeQuery("SELECT 学号,姓名,高等数学,英语,专业课 " + "FROM STUDENT"
					+ "WHERE 高等数学>=80");

			System.out.println();
			System.out
					.println("The students whose math mark is beyond 80 are:");
			while (rs.next()) {
				num = rs.getString(1);
				name = rs.getString(2);
				math = rs.getInt(3);

				eng = rs.getInt("英语");
				spec = rs.getInt("专业课");
				System.out.println("学号=" + num + "\t" + "姓名=" + name + "\t"
						+ "高等数学=" + math + "\t" + "英语=" + eng + "\t" + "专业课="
						+ spec);

			}
		} catch (SQLException e) {
			//
			e.printStackTrace();
		}
		finally{
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				//
				e.printStackTrace();
			}
		}
	}

}
