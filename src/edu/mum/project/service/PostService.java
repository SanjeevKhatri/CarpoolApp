package edu.mum.project.service;

import java.sql.SQLException;

import edu.mum.project.model.Posts;

public interface PostService {
	public Posts addNewPosts(Posts posts) throws SQLException;

	public void deletePosts(int id) throws SQLException;

	public Posts updatePosts(Posts posts) throws SQLException;

	public Posts findPosts(int id) throws SQLException;
}
