<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'print_map.jsp' starting page</title>
    
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
		Map map = new HashMap();
		
		map.put("lvyahui", "吕亚辉");
		map.put("yahui", "亚辉");
		map.put("qq", "3432432");
		request.setAttribute("info",map);
     %>
     <h3>key:lvyahui values:${info["lvyahui"]}</h3>
     <h3>key:yahui values:${info["yahui"]}</h3>
     <h3>key:qq values:${info["qq"]}</h3>
  </body>
</html>
