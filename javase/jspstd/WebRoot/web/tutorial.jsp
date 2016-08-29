<%@ page language='java' contentType='text/html' pageEncoding='UTF-8'%>
<%! int fontSize; %> 
<html> 
<head><title>FOR LOOP Example</title></head> 
<body>
	<%for ( fontSize = 1; fontSize <= 3; fontSize++){ %>
	   <font color="green" size="<%= fontSize %>">
	    JSP Tutorial
	   </font><br />
	<%}%>
</body> 
</html> 