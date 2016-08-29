<%@ page language="java" contentType="text/html;charset=UTF-8"%><!--配置指令-->
<%@ page import="java.util.*"%>
<html>
	<head>
		<title>
			lvyahui
		</title>
	</head>
	<body>
		<center>
			<%
				String username = (String) application.getAttribute("name");
				Date userbirthday = (Date) application.getAttribute("birthday");
			%>
			<h2><%=username%></h2>
			<h2><%=userbirthday%></h2>
		</center>
	</body>
</html>