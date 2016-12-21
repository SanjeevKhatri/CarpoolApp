package edu.mum.project.model;

public class PostByUser {
	private int postid;
	private int userid;
	private int posttype;
	private String post;
	private String fromlocation;
	private String tolocation;
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

	private String datecreated;
	private String dateupdated;
	private String name;

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getPosttype() {
		return posttype;
	}

	public void setPosttype(int i) {
		this.posttype = i;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(String datecreated) {
		this.datecreated = datecreated;
	}

	public String getDateupdated() {
		return dateupdated;
	}

	public void setDateupdated(String dateupdated) {
		this.dateupdated = dateupdated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
