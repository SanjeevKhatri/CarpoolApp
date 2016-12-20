package edu.mum.project.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.mum.project.dbConnection.DBConnection;
import edu.mum.project.dbConnection.DateToLocalDateUtil;
import edu.mum.project.model.Posts;
import edu.mum.project.service.PostService;

public class PostServiceImpl implements PostService {

	PreparedStatement ps;

	@Override
	public Posts addNewPosts(Posts posts) throws SQLException {
		return null;

	}

	@Override
	public void deletePosts(int id) throws SQLException {
		
	}

	@Override
	public Posts updatePosts(Posts posts) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Posts findPosts(int id) throws SQLException {
		return null;
		
	}

}
