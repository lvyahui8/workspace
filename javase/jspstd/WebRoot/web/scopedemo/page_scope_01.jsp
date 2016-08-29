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
				pageContext.setAttribute("name","吕亚辉");
				pageContext.setAttribute("birthday",new Date());
			%>
			<%
				String username = (String) pageContext.getAttribute("name");
				Date userbirthday = (Date) pageContext.getAttribute("birthday");
			%>
			<h2><%=username%></h2>
			<h2><%=userbirthday%></h2>
		</center>
	</body>
</html>