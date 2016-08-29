<%@ page language="java" contentType="text/html" pageEncoding='UTF-8'%><!--配置指令-->
<%@ page errorPage="/error.jsp"%><!--不改变浏览器地址栏的跳转-服务器端跳转-->
<html>
	<head>
		<title>
			lvyahui
		</title>
	</head>
	<body>
		<center>
			<table border='1'>
				<tr>
					<td><h2>我是hello</h2></td>
				</tr>
				<tr>
					<td><h2>你是world</h2></td>
				</tr>
			</table>
		</center>

		<%
			int result = 10/0;
		%>
	</body>
</html>