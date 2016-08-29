<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.yahui.com/jstl/c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'if.jsp' starting page</title>
  </head>
  
  <body>
  	<c:if test="${param.ref=='yahui'}" var="res1" scope="page">
  		<h3>欢迎${param.ref}光临</h3>
  	</c:if>
  	<c:if test="${19<32}" var="res2">
  		<h3>19比32小</h3>
  	</c:if>
  </body>
</html>
