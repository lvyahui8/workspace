<%@ page language="java" contentType="text/html;charset=UTF-8"%><!--配置指令-->

<html>
	<head>
		<title>
			lvyahui
		</title>
	</head>
	<body>
		<center>
<%!//加！号，全局
	int count = 0;
%>

<%
	response.setHeader("refresh","2;");	//页面2秒刷新一次
%>
			<h3>这是第<%=count++%>次刷新</h3>
		</center>
	</body>
</html>