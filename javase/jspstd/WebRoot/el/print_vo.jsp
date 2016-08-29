<%@page import="com.yahui.el.vo.Dept"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'print_vo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>&nbsp; 
 
	<% 
		Dept dept = new Dept();
		dept.setDeptno(10);
		dept.setDname("永州三中");
		dept.setLoc("吕亚辉");
		 request.setAttribute("deptinfo",dept);
	 %>
	 
	 <h3>部门编号：${deptinfo.deptno }</h3>
	 <h3>部门名称：${deptinfo.dname }</h3>
	 <h3>部门位置：${deptinfo.loc }</h3>
  </body>
</html>
