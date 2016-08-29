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
			<jsp:forward page="page_scope_03.jsp"/>
		</center>
	</body>
</html>