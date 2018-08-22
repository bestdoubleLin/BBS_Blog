<%@page import="com.lala.Dao.UserDao,com.lala.vo.*,java.net.URLEncoder" %>
<%@ page language="java" import="java.util.*,java.util.Map,java.util.Map.Entry"  contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	h1{
		color:red;
	}
	ul{
		list-style-type:none;
	}
	ul li{
		font-size:40px;
	}
	a{
		text-decoration:none;
		out-line: none;
		color: #000;
	}
	</style>
  </head>
  
  <body>
    <h1 align="center" >啦啦博客</h1>
    <h3 align="right"><a href="publish.jsp?">发表博客</a> <a href="user.jsp">个人中心</a></h3>
    <hr>
    <ul>
    <% 
       UserDao uDao=new UserDao();
       uDao.showBlog();
       for(Blog blog:uDao.blogList){
       String str_1=blog.getArticleName();
       String str1= URLEncoder.encode(str_1, "utf-8");
       String str_2=blog.getUsername();
       String str2= URLEncoder.encode(str_2, "utf-8");%>
			<li><a href="Comment?articlename=<%=str1 %>&username=<%=str2 %>">
			<%=blog.getArticleName() %> -------------------------------------------------------
			    <%=blog.getUsername() %>
			   	<%=blog.getDate() %></a></li>
		<%}%>
  </body>
</html>
