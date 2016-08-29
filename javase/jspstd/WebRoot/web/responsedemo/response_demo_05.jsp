<%@ page language="java" contentType="text/html;charset=UTF-8"%><!--配置指令-->

<html>
	<head>
		<title>
			lvyahui
		</title>
	</head>
	<body>
		<center>

<%
	System.out.println("forward跳转之前");
%>

	<% response.sendRedirect("hello.html"); %>

<%
	System.out.println("forward跳转之后");
%>
		</center>
	</body>
</html>