<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  prefix="mytag" uri="yahuitag"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'presenttag.jsp' starting page</title>
  </head>
  
  <body>
  <%
    String scope = "session";
    session.setAttribute("username","吕亚辉");
  %>
  
  <mytag:present name="username" scope="<%=scope %>">
  	<h2><%=scope %>范围存在属性:${sessionScope.username }</h2>
  </mytag:present>
  <mytag:present name="alluser" scope="request">
  	<h2>request范围存在属性:${sessionScope.alluser }</h2>
  </mytag:present>

  </body>
</html>
