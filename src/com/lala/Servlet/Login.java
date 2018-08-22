package com.lala.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.lala.Dao.UserDao;
import com.lala.vo.User;

/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {


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
		User user=new User(username, password);
		UserDao uDao=new UserDao();
		uDao.search();
		int n=uDao.login(user);
		HttpSession session=request.getSession();
		session.setAttribute("backvalue", n);
		if(n==1){
			session.setAttribute("name", username);
			response.sendRedirect("Main.jsp");			
		}else{
			response.sendRedirect("fail.jsp");
		}
	}

}
