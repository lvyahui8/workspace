<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>hellostruts.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  	<!-- 
  		在struts中，所有的处理类都是Action类，每一个Action类都要绑定一个ActionForm
  	 -->
  	 <html:errors/>
  	 <logic:present name="msg" scope="request">
  	 	<h3>${msg}</h3>
  	 </logic:present>
  	 
    <html:form action="hello.do" method="post">
    	请输入信息：<html:text property="info"></html:text>
    	<html:submit value="显示"></html:submit>
    </html:form>
  </body>
</html:html>
