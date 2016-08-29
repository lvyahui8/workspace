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

			// ��student���в���һ����¼
			sql = "INSERT INTO STUDENT"
					+ "VALUES('200108','��С��','��',20,71,62,76)";
			stmt.executeUpdate(sql);

			// ����student���е����м�¼����ȡ�������
			sql = "SELECT * FROM STUDENT";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("ѧ��\t����\t�Ա�\t����\t" + "�ߵ���ѧ\tӢ��\tרҵ��");
			while (rs.next()) {
				num = rs.getString(1);
				name = rs.getString(2);
				sex = rs.getString(3);
				age = rs.getInt(4);
				math = rs.getInt(5);
				eng = rs.getInt("Ӣ��");
				spec = rs.getInt("רҵ��");
				System.out.println(num + "\t" + name + "\t" + sex + "\t" + age
						+ "\t" + math + "\t" + eng + "\t" + spec);
			}

			// �����ߵ���ѧ�ɼ�80�����ϵ�ѧ����Ϣ
			rs = stmt.executeQuery("SELECT ѧ��,����,�ߵ���ѧ,Ӣ��,רҵ�� " + "FROM STUDENT"
					+ "WHERE �ߵ���ѧ>=80");

			System.out.println();
			System.out
					.println("The students whose math mark is beyond 80 are:");
			while (rs.next()) {
				num = rs.getString(1);
				name = rs.getString(2);
				math = rs.getInt(3);

				eng = rs.getInt("Ӣ��");
				spec = rs.getInt("רҵ��");
				System.out.println("ѧ��=" + num + "\t" + "����=" + name + "\t"
						+ "�ߵ���ѧ=" + math + "\t" + "Ӣ��=" + eng + "\t" + "רҵ��="
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
