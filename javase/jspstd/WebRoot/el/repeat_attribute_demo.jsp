<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'repeat_attribute_demo.jsp' starting page</title>
    
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
    /*
    	如果不同的属性范围中保存了同名的属性，则el依次在page，request,session,application 中查找，这个时候就存在属性覆盖的问题，这个时候可以依靠内置对象帮忙
    	pageScope			-->		${pageScope.attrbiteName}		-->		在page范围查找属性
    	requestScope		-->		${requestScope.attrbiteName}	-->		在request范围查找属性
    	sessionScope		-->		${sessionScope.attrbiteName}	-->		在session范围查找属性
    	applicationScope	-->		${applicationScope.attributeName}-->	在application范围查找属性
    	
    */
        pageContext.setAttribute("info", "pageContext属性范围");
    	request.setAttribute("info","request属性范围");
    	session.setAttribute("info", "session属性范围");
    	application.setAttribute("info", "application属性范围");
     %>
     
     <h3>page属性内容：${pageScope.info}</h3>
     <h3>request属性内容：${requestScope.info}</h3>
     <h3>session属性内容：${sessionScope.info}</h3>
     <h3>application属性内容：${applicationScope.info}</h3>
  </body>
</html>
