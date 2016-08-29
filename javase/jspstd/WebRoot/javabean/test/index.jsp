<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String currentPath = request.getRequestURI();
%>
<%
	request.setCharacterEncoding("UTF-8");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<%=path %><br/>
	<%=basePath %><br/>
	<%=currentPath %><br/>
  	<jsp:useBean id="reg" scope="request" class="com.yahui.jsp.bean.Register"></jsp:useBean>
	<form action="<%=currentPath %>check.jsp" method="post">
		用户名：<input type="text" name="name" value='<jsp:getProperty property="name" name="reg"/>'/><%= reg.getErrorMsg("errname") %><br/>
		年&nbsp;&nbsp;龄：<input type="text" name="age" value='<jsp:getProperty property="age" name="reg"/>'><%= reg.getErrorMsg("errage") %><br/>
		邮&nbsp;&nbsp;箱：<input type="text" name="email" value='<jsp:getProperty property="email" name="reg"/>'><%= reg.getErrorMsg("erremail") %><br/>
		<input type="submit" value="注册"/><input type="reset" value="重置">
	</form>
  </body>
</html>
