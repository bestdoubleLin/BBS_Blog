<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fail.jsp' starting page</title>
    
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
    	
    	if(session.getAttribute("backvalue").toString().equals("2")){%>
    		<h1>密码错误！！！！！！！！</h1>
    	<%
    	response.setHeader("Refresh", "3;URL=login.jsp");
    	 }else{%>
    		<h1>用户不存在！！！！！！！！</h1>
    	<%
    	response.setHeader("Refresh", "3;URL=login.jsp");
    	}
    
     %>
  </body>
</html>
