<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.yahui.com/jstl/c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'catch.jsp' starting page</title>
  </head>
  <body>
  	<c:catch var="errmsg">
  		<%
  			int result = 10/0;
  		 %>
  	</c:catch>
  	<h4>${errmsg}</h4>
  </body>
</html>
