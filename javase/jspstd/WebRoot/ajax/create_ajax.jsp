<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'create_ajax.jsp' starting page</title>
    <script language="JavaScript">
		var xmlHttp;				//AJAX核心对象名称
		function createXMLHttp(){
			if(window.XMLHttpRequest){	//firefox内核
				xmlHttp = new XMLHttpRequest();
			}
			else{				//IE内核浏览器
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		function showMsg(){
			createXMLHttp();
			xmlHttp.open("POST","content.html");
			xmlHttp.onreadystatechange = showMsgCallBack;
			xmlHttp.send(null);
		}
		function showMsgCallBack(){
			if(xmlHttp.readyState==4){
				if(200 == xmlHttp.status){
					//alert("****");
					var text = xmlHttp.responseText;
					document.getElementById("msg").innerHTML = text;
				}
			}
		}
	</script>
  </head>
  
  <body>
  	<input type="button" onClick="showMsg()" value="调用ajax显示内容">
  	<span id="msg"></span>
  </body>
</html>
 