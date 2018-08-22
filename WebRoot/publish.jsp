<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'publish.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		.put{
			width:800px;
		}
	</style>
  </head>
  
  <body>
    <h1 align="center">我要发表博客</h1>
    <hr>
    <form action="Publish" method="post">
    	<table align="center">
    		<tr><td><h2>标题</h2></td></tr>
    		<tr><td><input type="text" name="title" class="put" style="height:50px"></td></tr>
    		<tr><td><h2>文章内容</h2></td></tr>
    		<tr><td><textarea name="context" class="put" style="height:800px"></textarea></td></tr>
    		<tr>
  	  			<td colspan="2" align="center"><input type="submit" value="提交"/></td>
   	  		</tr>
    	</table>
    </form>
  </body>
</html>
