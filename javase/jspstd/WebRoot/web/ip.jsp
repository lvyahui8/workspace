<%@ page language='java' contentType='text/html' pageEncoding='UTF-8'%>
<head><title>Hello World</title></head>
<body>
Hello World!<br/>
<%-- 这是jsp注释，客户端看不到--%>
<%
out.println("Your IP address is " + request.getRemoteAddr());
%>
</body>
</html>