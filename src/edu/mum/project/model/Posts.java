package edu.mum.project.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Posts {
	private int postid;
	private Users users;
	private String description;
	private String posttype;
	private String date;
	private String fromlocation;
	private String tolocation;
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFromlocation() {
		return fromlocation;
	}

	public void setFromlocation(String fromlocation) {
		this.fromlocation = fromlocation;
	}

	public String getTolocation() {
		return tolocation;
	}

	public void setTolocation(String tolocation) {
		this.tolocation = tolocation;
	}

	private LocalDateTime datecreated;
	private String dateupdated;

	public Posts() {

	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPosttype() {
		return posttype;
	}

	public void setPosttype(String i) {
		this.posttype = i;
	}

	public LocalDateTime getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(LocalDateTime datecreated) {
		this.datecreated = datecreated;
	}

	public String getDateupdated() {
		return dateupdated;
	}

	public void setDateupdated(String string) {
		this.dateupdated = string;
	}
}
