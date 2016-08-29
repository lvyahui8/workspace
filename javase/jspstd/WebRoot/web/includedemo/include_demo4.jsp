<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%><!--配置指令-->
<html>
	<head>
	<title>The include Action Example</title>
	</head>
	<body>
		<center>
			<h2>The include action Example</h2>
			<%
				int x = 5;
			%>
			<h1>include_demo4.jsp --> <%=x%></h1>
			<!--<%@include file="inlcude.jsp"%>这样包含会显示变量重复定义。因为它只是代码的简单替换-->
			<jsp:include page="include.jsp"/>
			
		</center>
	</body>
</html>
