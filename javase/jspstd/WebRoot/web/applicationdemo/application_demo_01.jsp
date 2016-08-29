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
	String path = this.getServletContext().getRealPath("/");//this表示当前web容器
%>

			<h3>真实路径<%=path%></h3>
		</center>
	</body>
</html>