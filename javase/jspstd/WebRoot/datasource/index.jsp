<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.sql.*"%>
<%@ page import="java.sql.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
  
  <% 
  	String DSNAME = "java:comp/env/jdbc/jspstd" ; //名称 
  	Context ctx = new InitialContext();
  	DataSource ds = (DataSource) ctx.lookup(DSNAME);
  	Connection conn = ds.getConnection();
   %>
   
   <%=conn %>
   <!--
   	提示异常javax.naming.NameNotFoundException: Name [jdbc/jspstd] is not bound in this Context. Unable to find [jdbc].
   将String DSNAME = "jdbc/jspstd" ; 修改为
   String DSNAME = "java:comp/env/jdbc/jspstd" ; 之后，拿到了数据可连接
   	31880756, URL=jdbc:mysql://localhost:3306/mvcweb, UserName=root@localhost, MySQL-AB JDBC Driver
   -->
   <%
   	conn.close();//放回连接池
    %>
  
  </body>
</html>
