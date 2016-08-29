<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.yahui.com/jstl/c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'remove.jsp' starting page</title>
    
  </head>
  
  <body>
  	<c:set var="info" value="lvyahui" scope="request" ></c:set>
  	<c:remove var="info"/>
  	<h5>${info}</h5>
  </body>
</html>
