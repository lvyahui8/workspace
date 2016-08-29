<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.yahui.com/jstl/c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'choose.jsp' starting page</title>
  </head>
  
  <body>
  	<%
  		pageContext.setAttribute("num",10);
  	 %>
  	 
  	 <c:choose>
  	 	<c:when test="${num==10}">
  	 		<h3>num=10</h3>
  	 	</c:when>
  	 	<c:when test="${num==20}">
  	 		<h3>num=10</h3>
  	 	</c:when>
  	 	<c:otherwise>
  	 		<h3>一个都不对</h3>
  	 	</c:otherwise>
  	 </c:choose>
  </body>
</html>
