package edu.mum.project.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import edu.mum.project.dbConnection.DBConnection;
import edu.mum.project.model.Comments;
import edu.mum.project.model.Likes;
import edu.mum.project.model.LikesOnPost;
import edu.mum.project.model.PostOnComment;
import edu.mum.project.service.LikeService;

public class LikeServiceImpl {

	public boolean insertLike(String userEmail, int postId) throws Exception {
		boolean flag = false;
		int userId = 0;

		Connection con = (Connection) DBConnection.getConnection();
		PreparedStatement ps1 = (PreparedStatement) con
				.prepareStatement("SELECT userid FROM users where email='" + userEmail + "'");

		ResultSet rs1 = ps1.executeQuery();
		while (rs1.next()) {
			userId = Integer.parseInt(rs1.getString("userid"));
		}

		String insert = "INSERT INTO likes(userid,postid) " + "values ('" + userId + "'," + "'" + postId + "')";

		PreparedStatement psu = (PreparedStatement) con.prepareStatement(insert);
		psu.executeUpdate();
		flag = true;
		return flag;
	}

	public ArrayList<String> getAllPostLikes(int postId) throws SQLException, Exception {
		ArrayList allLikes = new ArrayList();
		PreparedStatement ps = (PreparedStatement) DBConnection.getConnection().prepareStatement(
				"SELECT * FROM users u INNER JOIN likes c INNER JOIN posts p on p.postid=c.postid and u.userid=c.userid WHERE p.postid="
						+ postId + ";");

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			LikesOnPost likesOnPost = new LikesOnPost();

			likesOnPost.setFullname(rs.getString("fullname"));
			likesOnPost.setLikeid(Integer.parseInt(rs.getString("likeid")));
			likesOnPost.setUserid(Integer.parseInt(rs.getString("userid")));
			likesOnPost.setPostid(Integer.parseInt(rs.getString("postid")));
			likesOnPost.setDatecreated(rs.getString("datecreated"));
			likesOnPost.setDateupdated(rs.getString("dateupdated"));

			allLikes.add(likesOnPost);
		}

		System.out.println(allLikes.toString());
		return allLikes;
	}
	
	
	
	public int getNumberofLikesById(int postId) throws SQLException, Exception {
		int lik=0;
		PreparedStatement ps = (PreparedStatement) DBConnection.getConnection().prepareStatement(
				"SELECT * FROM likes l INNER JOIN posts p on l.postid=p.postid WHERE p.postid=" + postId + ";");

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			lik++;
		}

		System.out.println(lik);
		return lik;
	}
	
	
	public int isLikedByUser(int postId, int userId) throws SQLException, Exception {
		int isliked=0;
		PreparedStatement ps = (PreparedStatement) DBConnection.getConnection().prepareStatement(
				"SELECT * FROM likes l INNER JOIN posts p on l.postid=p.postid INNER JOIN users u on l.userid=u.userid WHERE p.postid=" + postId +"AND u.userid="+ userId+ ";");
	
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			isliked=1;
		}
		

		System.out.println(isliked);
		return isliked;
	}
	
	
	
}
