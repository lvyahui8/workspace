<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.yahui.com/jstl/c"%>
<%@ page import="com.yahui.jsp.bean.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'set.jsp' starting page</title>
  </head>
  
  <body> 
   	<c:set var="name" value="lvyahui" scope="request"></c:set>
  	 <h6>${name}</h6>
  	 
  	 <%
  	 	SimpleInfo sim = new SimpleInfo();
  	 	request.setAttribute("simple",sim);
  	  %>
  	 <c:set value="lvyahui" target="${simple }" property="content"></c:set>
  		<h5>${simple.content}</h5>
  </body>
</html>
