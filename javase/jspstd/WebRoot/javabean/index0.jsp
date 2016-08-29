<%@page import="com.yahui.jsp.bean.SimpleBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="simple" scope="page" class="com.yahui.jsp.bean.SimpleBean"></jsp:useBean>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <%
    	SimpleBean simpleBean = new SimpleBean();
    	simpleBean.setName("hello");
    	simpleBean.setAge(19);
    	simple.setName("smiple");
    	simple.setAge(19);
    %>
    		<!-- 表达式标签使用< % = %>标签，语句后面不用加;号-->
    <h1>姓名：<%=simpleBean.getName()%></h1>
    <h1>年龄：<%=simpleBean.getAge() %></h1>
    <h1>姓名: <%=simple.getName() %></h1>
    <h1>年龄：<%=simple.getAge() %></h1>
  </body>
</html>
