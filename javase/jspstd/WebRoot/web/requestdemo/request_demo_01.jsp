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
				String content = request.getParameter("info");
			%>
			<h2><%=content%></h2>
		</center>
	</body>
</html>