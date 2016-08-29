<%@ page language="java" contentType="text/html;charset=UTF-8"%><!--配置指令-->
<html>
	<head>
	<title>The include Action Example</title>
	</head>
	<body>
		<center>
			<h2>The include action Example</h2>
			<jsp:include page="info.jsp"/>
			<jsp:include page="info.html">
			<jsp:include page="info.inc"/>
		</center>
	</body>
</html>