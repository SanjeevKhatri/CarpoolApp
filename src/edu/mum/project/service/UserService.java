package edu.mum.project.service;

import java.sql.SQLException;

import edu.mum.project.model.Users;

public interface UserService {

	public Users addNewUser(Users user) throws SQLException;

	public void deleteUser(int id) throws SQLException;

	public Users updateUser(Users user) throws SQLException;

	public Users findUser(int id) throws SQLException;
}