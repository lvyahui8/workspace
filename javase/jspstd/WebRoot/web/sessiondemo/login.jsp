<%@ page language="java" contentType="text/html;charset=GBK"%><!--閰嶇疆鎸囦护-->

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
			<h2>登陆成功</h2>
			<h3>2秒后跳转到welcome页面，如果没有跳转，请点击<a href="welcome.jsp">这里</a></h3>
<%
		}
		else{
%>
			<h2>登陆失败</h2>
<%
		}
	}
%>
	</body>
</html>