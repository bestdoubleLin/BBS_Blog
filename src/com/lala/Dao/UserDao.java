package com.lala.Dao;

import java.awt.RadialGradientPaint;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.mail.internet.NewsAddress;

import java.util.Set;

import com.lala.vo.*;

public class UserDao {

	public static Map<String, User> userMap=new HashMap<String, User>();
	public ArrayList<Blog> blogList=new ArrayList();
	PreparedStatement ps=null;
	ResultSet rs=null;
	Connection conn=null;
	/**
	 * 连接数据库
	 * @return
	 */
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs", "root", "123456");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 遍历用户信息
	 */
	public void search(){
		String sql="select * from bbs.user";
		try {
			ps=getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				userMap.put(rs.getString("username"),new User(rs.getString("username"),rs.getString("password"),rs.getInt("age"),rs.getString("sex")));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public int login(User user) {
		for(Entry<String, User> entry:userMap.entrySet()){
			if(user.getUsername().equals(entry.getKey())){
				if(user.getPassword().equals(entry.getValue().getPassword())){
					//对
					return 1;
				}else{
					//密码不对
					return 2;
				}
			}
		}	
		//没有用户
		return 3;
	}
	/**
	 * 用户注册
	 * @param user
	 */
	public void register(User user) {
		String sql="insert into bbs.user(password,username,age,sex) values(?,?,?,?)";
		try {
			ps=getConnection().prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getUsername());
			ps.setInt(3, user.getAge());
			ps.setString(4, user.getSex());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * 博客遍历
	 */
	public void showBlog(){
		String sql="select articleName,username,date from bbs.blog order by date desc";
		try {
			ps=getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				blogList.add(new Blog(rs.getString("articleName"), rs.getString("username"), rs.getDate("date")));
				//System.out.println(rs.getString("username")+"----------------"+rs.getDate("date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 博客添加
	 */
	public void insert(Blog blog){
		String sql="insert into bbs.blog(ArticleName,username,date,context) values(?,?,?,?)";
		try {
			ps=getConnection().prepareStatement(sql);
			ps.setString(1, blog.getArticleName());
			ps.setString(2, blog.getUsername());
			ps.setDate(3,new java.sql.Date(new java.util.Date().getTime()));
			ps.setString(4, blog.getContext());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 获取此用户信息
	 * @throws SQLException 
	 */
	public User userinfo(String username){
		String sql="select * from bbs.user where username=?";
		try {
			ps=getConnection().prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			while(rs.next()){
				return new User(rs.getString("username"), rs.getString("password"), rs.getInt("age"),  rs.getString("sex"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}
	/**
	 *文章内容
	 */
	public String context(String username,String articleName){
		String con=null;
		String sql="select context from bbs.blog where username=?and articleName=?";
		try {
			ps=getConnection().prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, articleName);
			rs=ps.executeQuery();
			while(rs.next()){
				con=rs.getString("context");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return con;
	}
	/**
	 * 获取评论
	 */
	public ArrayList<Comm> getComms(String username,String articleName){
		String sql="select * from bbs.comment where username=?and articleName=?";
		ArrayList<Comm> commlist=new ArrayList<Comm>();
		try {
			ps=getConnection().prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, articleName);
			rs=ps.executeQuery();
			while(rs.next()){
				Comm comm=new Comm(rs.getString("username"),rs.getString("articleName") , rs.getString("comment"), rs.getString("commentor"));
				commlist.add(comm);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return commlist;
	}
	/**
	 * 添加评论
	 */
	public void addcomms(Comm comm){
		String insesql="insert into bbs.comment(username,articleName,comment,commentor) values(?,?,?,?)";
		try {
			ps=getConnection().prepareStatement(insesql);
			ps.setString(1, comm.getUsername());
			ps.setString(2,comm.getArticlename());
			ps.setString(3,comm.getComment());
			ps.setString(4, comm.getCommentor());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//	public static void main(String[] args) throws ParseException {
//		UserDao uDao=new UserDao();
////		User user=uDao.userinfo("aaa");
////		System.out.println(user.toString());
//		uDao.addcomms(new Comm("aaa", "today", "good", "abc"));
//		ArrayList<Comm> commlist=uDao.getComms("aaa","today");
//		//System.out.println(commlist.size());
//		for(Comm comm:commlist){
//			System.out.println(comm.toString());
//		}
//		System.out.println(uDao.context("aaa", "today"));
//	}
}
