<%@page import="com.yahui.jsp.util.IPTimeStamp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ page import="com.jspsmart.upload.*"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'smartuploaddemo01.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%
		request.setCharacterEncoding("UTF-8");
	 %>
  </head>
  
  <body>
<%=path %>
<%=basePath %>
  <%
  		SmartUpload smart = new SmartUpload();
  		smart.initialize(pageContext);		//初始化上传操作
  		smart.upload();
  		IPTimeStamp its = new IPTimeStamp(request.getRemoteAddr());
  		File file = smart.getFiles().getFile(0);
  		//获取后缀名
  		String ext = file.getFileExt();
  		
  		String fileName = its.getIPTimeRand()+"."+ext;
  		
  		file.saveAs(this.getServletContext().getRealPath("/")+java.io.File.separator+"upload"+java.io.File.separator+fileName);
  		String name = smart.getRequest().getParameter("name");
   %>
   <h2>姓名：<%= name%></h2>
   <span>你的文件已经上传，文件名保存为：<%=fileName %></span>
  </body>
</html>
