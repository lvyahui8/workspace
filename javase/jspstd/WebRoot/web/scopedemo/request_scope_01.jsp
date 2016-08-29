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
				request.setAttribute("name","吕亚辉");
				request.setAttribute("birthday",new Date());
			%>
			<jsp:forward page="request_scope_02.jsp"/>
		</center>
	</body>
</html>