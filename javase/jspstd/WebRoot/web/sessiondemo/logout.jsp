<%@ page language="java" contentType="text/html;charset=GB2312"%><!--配置指令-->

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
	session.invalidate();	//ע������ʾ��ǰ��sessionʧЧ
%>
	<h2>ע���ɹ�</h2>
	<h3>2�����ת��loginҳ�棬���û����ת������<a href="login.jsp">����</a></h3>

		</center>
	</body>
</html>