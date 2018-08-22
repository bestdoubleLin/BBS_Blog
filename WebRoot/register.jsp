<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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

  	 <h1 align="center">请注册</h1>
  	  <form action="Register" method="post">
  	  	<table align="center">
  	  		<tr>
  	  			<td>用户名</td>
  	  			<td><input type="text" name="username" value=""></td>  	  			
  	  		</tr>
  	  		<tr>
  	  			<td>密码</td>
  	  			<td><input type="password" name="password" value=""></td>
  	  		</tr>
  	  		<tr>
  	  			<td>再次输入密码</td>
  	  			<td><input type="password" name="password2" value=""></td>
  	  		</tr>
  	  		<tr>
  	  			<td>年龄</td>
  	  			<td><input type="text" name="age" value="" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"></td>
  	  		</tr>
  	  		<tr>
  	  			<td>性别</td>
  	  			<td><input id="man" type="radio" checked="checked" name="sex" value="男"/>男 <input id="woman" type="radio"  name="sex" value="女"/>女</td>
  	  		</tr>
  	  		<tr>
  	  			<td colspan="2" align="center"><input type="submit" value="注册"/></td>
   	  		</tr>
  	  	</table>
  	  </form>
  </body>
</html>
