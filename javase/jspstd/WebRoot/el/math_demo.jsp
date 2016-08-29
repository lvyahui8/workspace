<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'math_demo.jsp' starting page</title>
  </head>
  <body>
	<%
		pageContext.setAttribute("num1",20);
		pageContext.setAttribute("num2",30);
	 %>
	 <h5>操作数:${num1} and ${num2 }</h5>
	 算术运算<br/>
	 <h5>+:${num1+num2}</h5>
	 <h5>-:${num1-num2}</h5>
	 <h5>*:${num1*num2 }</h5>
	 <h5>/:${num1/num2} and ${num1 div num2} </h5>
	 <h5>%:${num1%num2} and ${num1 mod num2} </h5>
	 逻辑运算<br/>
	 <h5>==:${num1 == num2} and ${num1 eq num2} </h5>
	 <h5>!=:${num1 != num2} and ${num1 ne num2} </h5>
	 <h5> < :${num1 < num2} and ${num1 lt num2} </h5>
	 <h5> > :${num1 > num2} and ${num1 gt num2} </h5>
	 <h5> <= :${num1 <= num2} and ${num1 le num2} </h5>
	 <h5> >= :${num1 >= num2} and ${num1 ge num2} </h5>
	 <%
	 	pageContext.setAttribute("flagA",true);
	 	pageContext.setAttribute("flagB",false);
	 	
	  %>
	  位操作<br/>
	  <h5>操作数:${flagA} and ${flagB }</h5>
	  <h5>&&:${flagA && flagB} and ${flagA and flagB }</h5>
	  <h5>||:${flagA||flagB} and ${flagA or flagB }</h5>
	  <h5>!:${!flagA} and ${not flagA }</h5>
	  
	  <%
	  	pageContext.setAttribute("n1",10);
	  	pageContext.setAttribute("n2",20);
	  	pageContext.setAttribute("n3",30);
	   %>
	   其他操作符<br/>
	   <h5>empty optr:${empty n1 }</h5>
	   <h5>3 optr:${n1>n2 ? "大于" : "小于" }</h5>
	   <h5>() optr:${(n1+n2)*n3}</h5>
  </body>
</html>
