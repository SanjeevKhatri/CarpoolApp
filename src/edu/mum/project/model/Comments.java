package edu.mum.project.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Comments {
	private int commentid;
	private String comment;
	private Users users;
	private Posts posts;
	private LocalDateTime datecreated;
	private LocalDateTime dateupdated;

	public Comments(int int1, String string, String string2, String string3, String string4, String string5,
			String string6, LocalDate localDate, String string7, String string8, LocalDate localDate2,
			LocalDate localDate3) {
		// TODO Auto-generated constructor stub
	}

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Posts getPosts() {
		return posts;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
	}

	public LocalDateTime getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(LocalDateTime datecreated) {
		this.datecreated = datecreated;
	}

	public LocalDateTime getDateupdated() {
		return dateupdated;
	}

	public void setDateupdated(LocalDateTime dateupdated) {
		this.dateupdated = dateupdated;
	}
}
