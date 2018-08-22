package com.lala.vo;

public class Comm {

	private String username;
	private String articlename;
	private String comment;
	private String commentor;
	public Comm(String username, String articlename, String comment, String commentor) {
		super();
		this.username = username;
		this.articlename = articlename;
		this.comment = comment;
		this.commentor = commentor;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getArticlename() {
		return articlename;
	}
	public void setArticlename(String articlename) {
		this.articlename = articlename;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCommentor() {
		return commentor;
	}
	public void setCommentor(String commentor) {
		this.commentor = commentor;
	}
	@Override
	public String toString() {
		return "Comm [username=" + username + ", articlename=" + articlename + ", comment=" + comment + ", commentor="
				+ commentor + "]";
	}
	
}
