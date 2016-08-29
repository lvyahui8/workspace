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
				session.setAttribute("name","吕亚辉");
				session.setAttribute("birthday",new Date());
			%>
			<a href="session_scope_02.jsp">通过超链接获取</a>
			<!--客户端跳转依然可以取得，但是如果再打开一个新的浏览器，就无法获取了。
			因为session属性保存在一个浏览器进程中-->
		</center>
	</body>
</html>