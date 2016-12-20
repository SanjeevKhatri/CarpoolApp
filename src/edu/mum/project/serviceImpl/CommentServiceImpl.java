package edu.mum.project.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.mum.project.dbConnection.DBConnection;
import edu.mum.project.model.Comments;
import edu.mum.project.service.CommentService;

public class CommentServiceImpl implements CommentService{

	PreparedStatement ps;

	@Override
	public Comments addNewComments(Comments comments) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComments(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Comments updateComments(Comments comments) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comments findComments(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}