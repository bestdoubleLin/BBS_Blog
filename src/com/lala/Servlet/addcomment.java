package com.lala.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lala.Dao.UserDao;
import com.lala.vo.Comm;

/**
 * Servlet implementation class addcomment
 */
public class addcomment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addcomment() {
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
		response.setContentType("text/html;charset=utf-8");
		String comment=request.getParameter("comme");
		HttpSession session=request.getSession();
		String commentor=session.getAttribute("name").toString();
		String articleauthor=session.getAttribute("articleauthor").toString();
		String articlename=session.getAttribute("articlename").toString();
		//System.out.println("评论"+comment+"  评论人"+commentor+"  作者"+articleauthor+"    文章名"+articlename);
		
		//if(comment!=null&&!comment.equals("")){
			System.out.println("999999999999999999999999999");
			UserDao uDao=new UserDao();
			uDao.addcomms(new Comm(articleauthor, articlename, comment, commentor));
			response.sendRedirect("Main.jsp");
		//}else{
			//response.sendRedirect("read.jsp");
		//}
	}

}
