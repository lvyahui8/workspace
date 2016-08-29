<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%><!--配置指令-->
<html>
	<head>
	<title>The include Action Example</title>
	</head>
	<body>
		<center>
			<h2>The include action Example</h2>
			<jsp:include page="receive_param.jsp">
				<jsp:param name="name" value="Lvyahui"/>
				<jsp:param name="info" value="buzhichizhongwen"/>
			</jsp:include>
		</center>
	</body>
</html>
