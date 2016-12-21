package edu.mum.project.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import edu.mum.project.dbConnection.DBConnection;
import edu.mum.project.model.Comments;
import edu.mum.project.model.PostByUser;
import edu.mum.project.model.PostOnComment;
import edu.mum.project.model.Posts;
import edu.mum.project.service.CommentService;

public class CommentServiceImpl {

	public boolean insertComment(String userEmail, int postId, Comments comment) throws Exception {
		boolean flag = false;
		int userId = 0;
		
		Connection con = (Connection) DBConnection.getConnection();
		PreparedStatement ps1 = (PreparedStatement) con
				.prepareStatement("SELECT userid FROM users where email='" + userEmail + "'");
		
		ResultSet rs1 = ps1.executeQuery();
		while (rs1.next()) {
			userId = Integer.parseInt(rs1.getString("userid"));
		}

		System.out.println("!!!!!!!!!!********************"+postId);
	
		String insert = "INSERT INTO comments(userid,postid,comment) " + "values ('"+ userId + "'," + "'" + postId + "','" + comment.getComment() + "')";

		System.out.println(insert);
		PreparedStatement psu = (PreparedStatement) con.prepareStatement(insert);
		psu.executeUpdate();
		flag = true;
		return flag;
	}

	
	
	
	
	 public ArrayList<String> getAllPostComment(int postId) throws SQLException,
	 Exception {
	 ArrayList allComments = new ArrayList();
	 PreparedStatement ps = (PreparedStatement)
	 DBConnection.getConnection().prepareStatement("SELECT * FROM users u INNER JOIN comments c INNER JOIN posts p on p.postid=c.postid and u.userid=c.userid WHERE p.postid="+postId+";");
	
	 ResultSet rs = ps.executeQuery();
	 while (rs.next()) {
		 PostOnComment postOnComment = new PostOnComment();
	
		 postOnComment.setFullname(rs.getString("fullname"));
		 postOnComment.setCommentid(Integer.parseInt(rs.getString("commentid")));
		 postOnComment.setUserid(Integer.parseInt(rs.getString("userid")));
		 postOnComment.setPostid(Integer.parseInt(rs.getString("postid")));
		 postOnComment.setComment(rs.getString("comment"));
		 postOnComment.setDatecreated(rs.getString("datecreated"));
		 postOnComment.setDateupdated(rs.getString("dateupdated"));
	
		 allComments.add(postOnComment);
	 }
	
	 System.out.println(allComments.toString());
	 return allComments;
	 }
	
	
}