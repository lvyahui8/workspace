<%@ page language="java" contentType="text/html;charset=GBK"%><!--����ָ��-->

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
		<h3>��ӭ<%= userid %>���ٱ�վ</h3>
<%
	}
	else{
%>
		<h3>�����<a href="login.jsp">��½</a></h3>
<%
	}
%>
			<br/>
			<a href="logout.jsp">ע��</a>
		</center>
	</body>
</html>