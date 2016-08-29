<%@ page language="java" contentType="text/html;charset=GB2312"%><!--閰嶇疆鎸囦护-->

<html>
	<head>
		<title>
			lvyahui
		</title>
	</head>
	<body>
		<center>
<%
	response.setHeader("refresh","2;URL=login.jsp");
	session.invalidate();	//注销，表示当前的session失效
%>
	<h2>注销成功</h2>
	<h3>2秒后跳转到login页面，如果没有跳转，请点击<a href="login.jsp">这里</a></h3>

		</center>
	</body>
</html>