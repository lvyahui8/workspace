<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import=" java.util.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'list.jsp' starting page</title>
  </head>
  <body>
   <%
   	Set all = (Set) this.getServletContext().getAttribute("online");
   	Iterator it = all.iterator();
   	while(it.hasNext()){
   	%>
   		<h5><%=it.next() %></h5>
   	<%
   	}
    %>
  </body>
</html>
