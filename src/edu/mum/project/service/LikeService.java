package edu.mum.project.service;

import java.sql.SQLException;

import edu.mum.project.model.Likes;

public interface LikeService {
	public Likes addNewLikes(Likes likes) throws SQLException;

	public void deleteLikes(int id) throws SQLException;

	public Likes updateLikes(Likes likes) throws SQLException;

	public Likes findLikes(int id) throws SQLException;
}
