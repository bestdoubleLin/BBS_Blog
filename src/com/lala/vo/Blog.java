package com.lala.vo;

import java.util.Date;

public class Blog {
	
	private String articleName;
	private String username;
	private String context;
	private Date date;
	

	public Blog(String articleName, String username, String context) {
		this.articleName = articleName;
		this.username = username;
		this.context = context;
	}	
	public Blog(String articleName, String username) {
		this.articleName = articleName;
		this.username = username;
	}
	
	public Blog(String articleName, String username, Date date) {
		this.articleName = articleName;
		this.username = username;
		this.date = date;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return articleName + " " + username + " " + date  ;
	}
}
