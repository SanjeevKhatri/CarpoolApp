package edu.mum.project.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.mum.project.dbConnection.DBConnection;
import edu.mum.project.dbConnection.DateToLocalDateUtil;
import edu.mum.project.model.Posts;
import edu.mum.project.model.Users;
import edu.mum.project.service.PostService;

public class PostServiceImpl implements PostService {

	PreparedStatement ps;

	@Override
	public Posts addNewPosts(Posts posts) throws SQLException {
		return null;

	}

	@Override
	public void deletePosts(int id) throws SQLException {
		ps = DBConnection.getConnection().conn.prepareStatement("delete from users where usreid = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	@Override
	public Posts updatePosts(Posts posts) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Posts findPosts(int id) throws SQLException {
		ps = DBConnection.getConnection().conn.prepareStatement("select * from posts where postid = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Posts post = null;
		if (rs.next()) {
			System.out.println("Post found");
			post = new Posts(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
					DateToLocalDateUtil.getLocalDate(rs.getDate(5)), DateToLocalDateUtil.getLocalDate(rs.getDate(6)));
		}
		return post;
	}

}
