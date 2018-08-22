package com.lala.Servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lala.Dao.UserDao;
import com.lala.vo.Comm;

/**
 * Servlet implementation class Comment
 */
public class Comment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Comment() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		response.setCharacterEncoding("utf-8");
		String article=URLDecoder.decode(request.getParameter("articlename"), "UTF-8");
		String username=URLDecoder.decode(request.getParameter("username"),"UTF-8");
		System.out.println(article);
		HttpSession session=request.getSession();
		session.setAttribute("articleauthor", username);
		session.setAttribute("articlename", article);
		//System.out.println(article+"***********"+username);
		ArrayList<Comm>comms=new ArrayList<Comm>();
		UserDao uDao=new UserDao();
		comms=uDao.getComms(username, article);
		String context=uDao.context(username, article);
		//System.out.println("ÎÄÕÂÄÚÈÝ"+context);
		request.setAttribute("title", article);
		request.setAttribute("context", context);
		request.setAttribute("comment", comms);
		request.getRequestDispatcher("read.jsp").forward(request, response);
	}

}
