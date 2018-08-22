<%@page import="java.sql.Connection"%>
<%@page import="com.lala.Dao.UserDao"%>
<%@page import="com.lala.vo.User"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		h1{
			color:red;
		}
	</style>
  </head>
  
  <body>
    <h1 align="center" >个人信息</h1>
    <hr>
    <% 
    	String username=session.getAttribute("name").toString();
    	UserDao uDao=new UserDao();
		User user=uDao.userinfo(username);
    %>
    <h2 align="center">用户名:<%=user.getUsername() %></h2>
    <h2 align="center">密码:<%=user.getPassword() %></h2>
    <h2 align="center">年龄:<%=user.getAge() %></h2>
    <h2 align="center">性别:<%=user.getSex() %></h2>
  </body>
</html>
