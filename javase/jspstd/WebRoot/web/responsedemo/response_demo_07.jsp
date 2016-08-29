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
	Cookie c[] = request.getCookies();
	if(c!=null){
		for (int i = 0;i < c.length ; i++) {
%>
		<h3><%=c[i].toString()+"--"+c[i].getName()+".."+c[i].getValue()%></h3>
<%
		}
	}
%>

		</center>
	</body>
</html>