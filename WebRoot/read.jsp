<%@ page language="java" import="java.util.*,com.lala.vo.Comm" contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'read.jsp' starting page</title>
    
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
    	ArrayList<Comm> commlist=(ArrayList<Comm>)request.getAttribute("comment");
     %>
    <form action="addcomment" method="post">
    	<table align="center">
    		<tr>
    			<td><h1 align="center"><%=request.getAttribute("title")%></h1></td>
    		</tr>
    		<tr>
    			<td align="center">文章区</td>
    		</tr>
    		<tr>
    			<td> <textarea rows="40" cols="100" readonly="readonly"><%=request.getAttribute("context")%></textarea></td>
    		</tr>
    		<tr>
    			<td>
    			评论：<br>
    			<%for(Comm comm:commlist) {%>
    				<p>评论内容：<%=comm.getComment() %></p>
    				<p align="right">评论人：<%=comm.getCommentor() %></p>
    				<hr>
    			<%} %>
    			</td>
    		</tr>
    		<tr>
    			<td align="center">评论区</td>
    		</tr>
    		<tr>
    			<td> <textarea rows="5" cols="100" name="comme">11111</textarea></td>
    		</tr>
    		<tr>
  	  			<td colspan="2" align="center"><input type="submit" value="提交"/></td>
   	  		</tr>
    	</table>
    </form>
  </body>
</html>
