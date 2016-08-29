<%@ page language="java" contentType="text/html;charset=GB2312"%><!--配置指令-->
<%@ page import="java.io.*"%>
<html>
	<head>
		<title>
			lvyahui
		</title>
	</head>
	<body>
		<center>
<%
	request.setCharacterEncoding("GB2312");
	String name = request.getParameter("filename");
	String content = request.getParameter("filecontent");
	String fileName = this.getServletContext().getRealPath("/") + File.separator + "note" + File.separator + name;
System.out.println(fileName);
	File file = new File(fileName);
	if (!file.getParentFile().exists()) {
		file.getParentFile().mkdir();
	}
	PrintStream ps = null;
	ps = new PrintStream(new FileOutputStream(file));
	ps.println(content);
	ps.close();
%>
		</center>
	</body>
</html>