package com.lala.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lala.Dao.UserDao;
import com.lala.vo.User;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		int age=Integer.parseInt(request.getParameter("age"));
		String sex=request.getParameter("sex");
		User user=new User(username, password, age, sex);
		UserDao uDao=new UserDao();
		uDao.search();
		int flag=0;
		for(Entry<String, User> entry:UserDao.userMap.entrySet()){
			if(username.equals(entry.getKey())){
				flag=1;
			}
		}	
		if(!password.equals(password2)){
			flag=2;
		}

		if(flag==2){
			response.setHeader("Content-Type", "text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('两次密码输入不一致...'); window.location='register.jsp' </script>");
		}
		else if(flag==0){
			response.sendRedirect("login.jsp");
			uDao.register(user);
		}else{
			response.setHeader("Content-Type", "text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('用户名已存在...'); window.location='register.jsp' </script>");
			//response.sendRedirect("register.jsp");
		}
	}

}
