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
	Cookie c1 = new Cookie("name","lvyahui");
	Cookie c2 = new Cookie("id","343");
	c1.setMaxAge(100);
	c2.setMaxAge(100);	//设置cookie的保存时间，单位为秒
	response.addCookie(c1);
	response.addCookie(c2);
%>

		</center>
	</body>
</html>