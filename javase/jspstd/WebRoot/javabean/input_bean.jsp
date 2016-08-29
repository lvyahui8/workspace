<%@page import="com.yahui.jsp.bean.SimpleBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'input_bean.jsp' starting page</title>
    
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
    	request.setCharacterEncoding("UTF-8"); 
    	//SimpleBean simple = new SimpleBean(); 
    	//simple.setName(request.getParameter(&quot;name&quot;)); 
    	//simple.setAge(Integer.parseInt(request.getParameter(&quot;age&quot;)));  
     %>
    <jsp:useBean id="simple" scope="page" class="com.yahui.jsp.bean.SimpleBean"></jsp:useBean>
    
   	<!-- 为该javabean自动设置属性，如果可以设置，必须保证参数名称与属性一致，其实因为它的实现原理是反射-->
   	<jsp:setProperty property="*" name="simple"/>
   	
   	
   		<!-- 将属性值调换位置进行设置 -->
   <!-- 	<js p: setProperty property="name" name="simple" param="age"/>
   	<j sp: setProperty property="age" name="simple" param="name"/> -->
   
   	<%-- <h1>name: <%= //simple.getName() %></h1>
   	<h1>age:<%= //simple.getAge() %></h1> --%>
   	<h1>name:<jsp:getProperty name="simple" property="name"></jsp:getProperty></h1>
   	<h1>age:<jsp:getProperty name="simple" property="age"></jsp:getProperty></h1>
  </body>
</html>
