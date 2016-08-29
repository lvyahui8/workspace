<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'depte_info.jsp' starting page</title>
    
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
     <h3>部门编号：${deptinfo.deptno }</h3>
	 <h3>部门名称：${deptinfo.dname }</h3>
	 <h3>部门位置：${deptinfo.loc }</h3>
	 <%
	 	List all = (List) request.getAttribute("alldeptinfo");
	 	if(all != null)   {
	  %>
	  		<table border="1" width="90%">
	  			<tr>
	  				<td>部门编号</td>
	  				<td>部门名称</td>
	  				<td>部门位置</td>
	  			</tr>
	  <%
	  		Iterator it = all.iterator();
	  		while(it.hasNext()){
	  			pageContext.setAttribute("dept",it.next());
	  %>
	  			<tr>
	  				<td>${dept.deptno }</td>
	  				<td>${dept.dname }</td>
	  				<td>${dept.loc }</td>
	  			</tr>
	  <%	
	  		}
	  %>
	  		</table>
	  <%
	  }
	   %>
  </body>
</html>
