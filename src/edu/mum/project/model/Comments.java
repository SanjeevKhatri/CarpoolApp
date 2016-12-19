package edu.mum.project.model;

import java.time.LocalDateTime;

public class Comments {
	private int commentid;
	private String comment;
	private Users users;
	private Posts posts;
	private LocalDateTime datecreated;
	private LocalDateTime dateupdated;

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
