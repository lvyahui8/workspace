<%@ page language="java" contentType="text/html" pageEncoding='UTF-8'%>

<html>
	<head>
		<title>
			lvyahui
		</title>
	</head>
	<body>
		<center>
			<%
				request.setCharacterEncoding("UTF-8");//能解决99%的乱码问题，如果这样依然不能解决大问题，则可以将字符串转换编码（重新new）
				String content = request.getParameter("info");
			%>
			<h2><%=content%></h2>
		</center>
	</body>
</html>