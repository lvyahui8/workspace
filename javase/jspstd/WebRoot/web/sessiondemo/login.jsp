<%@ page language="java" contentType="text/html;charset=GBK"%><!--配置指令-->

<html>
	<head>
		<title>
			lvyahui
		</title>
	</head>
	<body>
		<form action="login.jsp" method="post">
			usrname:<input type="text" name="usrname"><br/>
			passwad:<input type="password" name="passwad"><br/>
			<input type="submit" value="login">
			<input type="reset" value="clean">
		</form>
<%
	String usrname = request.getParameter("usrname");
	String passwad = request.getParameter("passwad");
	if(!(null==usrname || null==passwad || "".equals(usrname) || "".equals(passwad))){
		if("lvyahui".equals(usrname) && "mima".equals(passwad)){
			session.setAttribute("userid",usrname);
			response.setHeader("refresh","2;URL=welcome.jsp");
%>
			<h2>��½�ɹ�</h2>
			<h3>2�����ת��welcomeҳ�棬���û����ת������<a href="welcome.jsp">����</a></h3>
<%
		}
		else{
%>
			<h2>��½ʧ��</h2>
<%
		}
	}
%>
	</body>
</html>