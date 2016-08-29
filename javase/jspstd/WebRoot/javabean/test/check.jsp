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
    
    <title>My JSP 'check.jsp' starting page</title>
    
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
	<jsp:useBean id="reg" scope="request" class="com.yahui.jsp.bean.Register"></jsp:useBean>
	<jsp:setProperty property="*" name="reg"/>
	<%
		if(reg.isValidata()){
	 %>
	 	<jsp:forward page="success.jsp"/>
	 <%
	 	}
	 	else{
	  %>
	  	<jsp:forward page="index.jsp"/>
	  <%
	  	}
	   %>
  </body>
</html>
