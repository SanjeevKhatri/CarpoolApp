package edu.mum.project.service;

import java.sql.SQLException;

import edu.mum.project.model.Comments;


public interface CommentService {
	public Comments addNewComments(Comments comments) throws SQLException;

	public void deleteComments(int id) throws SQLException;

	public Comments updateComments(Comments comments) throws SQLException;

	public Comments findComments(int id) throws SQLException;

}
