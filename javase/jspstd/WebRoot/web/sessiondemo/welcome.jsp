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
	String userid = (String)session.getAttribute("userid");
	if (userid != null) {
%>
		<h3>欢迎<%= userid %>光临本站</h3>
<%
	}
	else{
%>
		<h3>请进行<a href="login.jsp">登陆</a></h3>
<%
	}
%>
			<br/>
			<a href="logout.jsp">注销</a>
		</center>
	</body>
</html>