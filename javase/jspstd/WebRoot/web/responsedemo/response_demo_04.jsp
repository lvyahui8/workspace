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

	<jsp:forward page="hello.html"/>

<%
	System.out.println("forward跳转之后");
%>
		</center>
	</body>
</html>