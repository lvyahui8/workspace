<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileUpload"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fileuploaddemo01.jsp' starting page</title>
    
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
    	DiskFileItemFactory factory = new DiskFileItemFactory();
    	ServletFileUpload upload = new ServletFileUpload(factory);
    	upload.setFileSizeMax(3*1024*1024);
    	List<FileItem> items = upload.parseRequest(request);//接受全部内容
    	Iterator<FileItem> iter = items.iterator();
    	while(iter.hasNext()){
    		FileItem item = iter.next();
    		String filedName = item.getFieldName();
    %>
    		<h4><%=filedName %>--><%=item.isFormField() %></h4><br/>
    <%
    		if(!item.isFormField()){		//不是普通文本
    			String fileName = item.getName();//获取文件名称
    			String contentType = item.getContentType();//获取文件类型
    			long sizeInBytes = item.getSize();//获取文件大小
    %>
    			上传文件名称：<%=fileName %><br/>
    			上传文件类型：<%=contentType %><br/>
    			上传文件大小：<%=sizeInBytes %><br/>
    <%
    			
    		}else{
    			String value = item.getString();
     %>
     			普通参数<%=value %>
     <%
    		}
    	}
     %>
     
  </body>
</html>
