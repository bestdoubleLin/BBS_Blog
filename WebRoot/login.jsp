<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <script>
  		function check(){
  			var text_1=document.getElementById("use").value;
  			var text_2=document.getElementById("pass").value;
  			if(text_1==""||text_1==null){
  				alert("用户名不能为空");
  				return false;
  			}
		    else if(text_2==""||text_2==null){
		    //alert(test_2+"*********************");  	
  				alert("密码不能为空");
  				return false;
  			}else
  			return true;
  		}
  	</script>
  	<h1 align="center">登录</h1>
  	  <form action="Login" method="post" onsubmit="return check();">
  	  	<table align="center">
  	  		<tr>
  	  			<td>用户名</td>
  	  			<td><input name="username" value="" id="use"></td>  	  			
  	  		</tr>
  	  		<tr>
  	  			<td>密码</td>
  	  			<td><input type="password" name="password" value="" id="pass"></td>
  	  		</tr>
  	  		<tr>
  	  			<td colspan="2" align="center"><input type="submit" value="登录"/></td>
   	  		</tr>
  	  	</table>
  	  	<p align="center"><a href="register.jsp">还没注册？点击注册</a></p>
  	  </form>
  </body>
</html>
