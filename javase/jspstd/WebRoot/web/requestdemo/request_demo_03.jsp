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
				request.setCharacterEncoding("UTF-8");//�ܽ��99%���������⣬���������Ȼ���ܽ�������⣬����Խ��ַ���ת�����루����new��
				String name = request.getParameter("name");
				String passwad = request.getParameter("passwad");
			%>
			<h2><%=name%></h2>
			<h2><%=passwad%></h2>
		</center>
	</body>
</html>