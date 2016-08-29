<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.yahui.com/jstl/c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'out.jsp' starting page</title>

  </head>
  
  <body>
  	<%
  		pageContext.setAttribute("info", "<www.yahui.com>");
  	 %>
  	 <h3>属性存在：<c:out value="${info }" /></h3>
  	 <h3>属性不存在：<c:out value="${ref }" default="属性不存在"/></h3>
  	 <h3>属性不存在：<c:out value="${ref }" >属性不存在</c:out></h3>
  	 
  	 
  </body>
</html>
