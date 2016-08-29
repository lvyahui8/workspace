<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.yahui.com/jstl/c"%>
<%@ page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'foreach.jsp' starting page</title>
  </head>
  <body>
    <%
    	String info[] = {
    		"lvyahui","dengjie","2012","0627"
    	};
    	pageContext.setAttribute("ref", info);
    	List all = new ArrayList();
    	all.add("lvyahui");
    	all.add("dengjie");
    	all.add("2012");
    	all.add("0627");
    	pageContext.setAttribute("list", all);
    	Map map = new HashMap();
    	map.put("name", "lvyahui");
    	map.put("na", "dengjie");
    	pageContext.setAttribute("map", map);
     %>
     
     <c:forEach items="${ref}" var="mem">
     	${mem}
     </c:forEach>
     <c:forEach items="${ref}" var="mem" step="2">
     	${mem}
     </c:forEach>
      <c:forEach items="${list}" var="mem">
     	${mem}
     </c:forEach>
      <c:forEach items="${map}" var="mem">
     	${mem.key} --> ${mem.value}
     </c:forEach>
  </body>
</html>
