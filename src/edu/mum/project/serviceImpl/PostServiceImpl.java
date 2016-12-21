package edu.mum.project.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import edu.mum.project.dbConnection.DBConnection;
import edu.mum.project.dbConnection.DateToLocalDateUtil;
import edu.mum.project.model.PostByUser;
import edu.mum.project.model.Posts;
import edu.mum.project.service.PostService;

public class PostServiceImpl {

	public boolean insertPost(String userEmail, Posts post) throws Exception {
		boolean flag = false;
		int userId = 0;
		int postType = 0;
		Connection con = (Connection) DBConnection.getConnection();
		PreparedStatement ps = (PreparedStatement) con
				.prepareStatement("SELECT userid FROM users where email='" + userEmail + "'");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			userId = Integer.parseInt(rs.getString("userid"));
		}
		if (post.getPosttype().equals("offerride")) {
			postType = 1;
		}
		// String insert = "INSERT into posts(userid,post,posttype) VALUES (" +
		// userId + ",'" + post.getPosts() + "'," + postType + ")";
		String insert = "INSERT INTO posts(userid,description,posttype,date,fromlocation,tolocation) " + "values ('"
				+ userId + "'," + post.getDescription() + ",'" + postType + "','" + post.getDate() + "','"
				+ post.getFromlocation() + "'," + post.getTolocation() + ")";
		PreparedStatement psu = (PreparedStatement) con.prepareStatement(insert);
		psu.executeUpdate();
		flag = true;
		return flag;
	}

//	public ArrayList<Posts> getAllPosts() {
//		List<Posts> AllPosts = new ArrayList<Posts>();
//		Connection con = (Connection) DBConnection.getConnection();
//		PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM posts");
//		ResultSet rs = ps.executeQuery();
//		while (rs.next()) {
//			Posts posts = new Posts();
//			String postDate = rs.getString(6);
//			String postFromLocation = rs.getString(7);
//			String postToLocation = rs.getString(8);
//			String postDescription = rs.getString(9);
//			posts.setDate(postDate);
//			posts.setFromlocation(postFromLocation);
//			posts.setTolocation(postToLocation);
//			posts.setDescription(postDescription);
//			AllPosts.add(posts);
//		}
//	}

	public ArrayList<String> getOfferedPost() {
		ArrayList allPost = new ArrayList();
		try {
			PreparedStatement ps = (PreparedStatement) DBConnection.getConnection().prepareStatement(
					"SELECT * FROM users u INNER JOIN posts p on u.userid=p.userid WHERE p.posttype=1 ORDER BY  p.dateupdated DESC LIMIT 3;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PostByUser userPost = new PostByUser();
				
				userPost.setPostid(Integer.parseInt(rs.getString("postid")));
				userPost.setUserid(Integer.parseInt(rs.getString("userid")));
				userPost.setPosttype(Integer.parseInt(rs.getString("posttype")));
				userPost.setPost(rs.getString("post"));
				userPost.setDatecreated(rs.getString("datecreated"));
				userPost.setDatecreated(rs.getString("dateupdated"));
				userPost.setName(rs.getString("fullname"));
				
				allPost.add(userPost);
			}
			return allPost;
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		return null;

	}
}
