<%@page import="java.io.FileOutputStream"%>
<%@page import="javax.tools.FileObject"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.File"%>
<%@page import="com.yahui.jsp.util.IPTimeStamp"%>
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
    	IPTimeStamp its = new IPTimeStamp(request.getRemoteAddr());
    	DiskFileItemFactory factory = new DiskFileItemFactory();
    	//设置一个临时文件存放目录
    	//这里报错，说找不到路径，原来不支持空格E:\Workspaces\MyEclipse 10\jspstd\WebRoot\\uploadtemp\
    	factory.setRepository(new File(this.getServletContext().getRealPath("/")+File.separator+"uploadtemp"));
    	ServletFileUpload upload = new ServletFileUpload(factory);
    	upload.setFileSizeMax(3*1024*1024);
    	List<FileItem> items = upload.parseRequest(request);//接受全部内容
    	Iterator<FileItem> iter = items.iterator();
    	while(iter.hasNext()){
    		FileItem item = iter.next();
    		String filedName = item.getFieldName();
 
    		if(!item.isFormField()){		//不是普通文本
    			String fileName = item.getName();//获取文件名称
    			String contentType = item.getContentType();//获取文件类型
    			long sizeInBytes = item.getSize();//获取文件大小
    %>
    			上传文件名称：<%=fileName %><br/>
    			上传文件类型：<%=contentType %><br/>
    			上传文件大小：<%=sizeInBytes %><br/>
    <%
    			File saveFile = null;
    			InputStream input = null;
    			OutputStream output = null;
    			input = item.getInputStream();
    			output = new FileOutputStream(new File(this.getServletContext().getRealPath("/")+"upload")+File.separator+its.getIPTimeRand()+"."+item.getName().split("\\.")[1]);
    			int temp = 0;
    			byte data[] = new byte[512];
    			while((temp=input.read(data,0,512))!=-1){
    				output.write(data);
    			}
    			input.close();
    			output.close();
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
