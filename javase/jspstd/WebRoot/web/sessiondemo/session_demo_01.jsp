<%@ page language="java" contentType="text/html;charset=GBK"%><!--配置指令-->

<html>
	<head>
		<title>
			lvyahui
		</title>
	</head>
	<body>
		<center>
<%
	String id = session.getId();
%>

			<h3>Session Id :<%=id%></h3>
			<h3>Session Id Length:<%=id.length()%></h3>
		</center>
	</body>
</html>