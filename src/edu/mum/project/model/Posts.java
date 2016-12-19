package edu.mum.project.model;

import java.time.LocalDateTime;

public class Posts {
	private int postid;
	private Users users;
	private Posts posts;
	private String posttype;
	private LocalDateTime datecreated;
	private LocalDateTime dateupdated;

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
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

	public String getPosttype() {
		return posttype;
	}

	public void setPosttype(String posttype) {
		this.posttype = posttype;
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
