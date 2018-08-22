package com.lala.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lala.Dao.UserDao;
import com.lala.vo.Blog;

/**
 * Servlet implementation class Publish
 */
public class Publish extends HttpServlet {
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
		String title=request.getParameter("title");
		String context=request.getParameter("context");
		HttpSession session=request.getSession();
		String username=session.getAttribute("name").toString();
		UserDao uDao=new UserDao();
		//System.out.println(username);
		uDao.insert(new Blog(title,username,context));
		response.sendRedirect("Main.jsp");
	}

}
