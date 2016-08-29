<%@ page language="java" contentType="text/html" pageEncoding='UTF-8'%><!--配置指令-->
<%@ page errorPage="/error.jsp"%><!--不改变浏览器地址栏的跳转-服务器端跳转-->
<%@ page import="java.sql.*" %>
<html>
	<head>
		<title>
			lvyahui
		</title>
	</head>
	<body>
		<%!
			public static final String DBDRIVER = "com.mysql.jdbc.Driver";
			public static final String DBURL = "jdbc:mysql://localhost:3306/users";
			public static final String DBUSER = "root";
			public static final String DBPASS = "root";
		%>
		<%!
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		%>
		<%
			try{
				Class.forName(DBDRIVER);
				conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
				String sql = "SELECT name,sex,birthday from user";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
		%>
		<center>
			<table border='3' width='80%'>
				<tr>
					<td>name</td>
					<td>sex</td>
					<td>birthday</td>
				</tr>
			<%
				while(rs.next()){
					String name = rs.getString(1);
					String sex = rs.getString(2);
					String birthday = rs.getDate(3).toString();
			%>
				<tr>
					<td><%=name%></td>
					<td><%=sex%></td>
					<td><%=birthday%></td>
				</tr>
			<%
				}
			%>
			</table>
		</center>
		<%
			}catch(Exception e){
				System.out.println(e);
			}
			finally{
				rs.close();
				pstmt.close();
				conn.close();
			}
		%>
	</body>
</html>