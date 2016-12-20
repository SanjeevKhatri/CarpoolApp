package edu.mum.project.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import edu.mum.project.dbConnection.DBConnection;
import edu.mum.project.dbConnection.DateToLocalDateUtil;
import edu.mum.project.model.Users;
import edu.mum.project.service.UserService;

public class UserServiceImpl implements UserService{

	PreparedStatement ps;

	@Override
	public void deleteUser(int id) throws SQLException {
		ps = DBConnection.getConnection().conn.prepareStatement("delete from Users where userId = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	@Override
	public Users updateUser(Users user) throws SQLException {

		Users oldUser = findUser(user.getUserid());
		oldUser.setPassword(user.getPassword());
		oldUser.setCity(user.getCity());
		oldUser.setStreet(user.getStreet());
		oldUser.setZipcode(user.getZipcode());
		oldUser.setEmail(user.getEmail());
		oldUser.setState(user.getState());

		ps = DBConnection.getConnection().conn.prepareStatement(
				"update Users set password=?, state=?, city=?, street=?, zipcode=?,email=?,dateupdated=? where userId=?");
		ps.setString(1, user.getPassword());
		ps.setString(2, user.getState());
		ps.setString(3, user.getCity());
		ps.setString(4, user.getStreet());
		ps.setString(5, user.getZipcode());
		ps.setString(6, user.getEmail());
		ps.setDate(7, java.sql.Date.valueOf(LocalDate.now()));
		ps.setInt(8, user.getUserid());

		ps.executeUpdate();

		// return updated info

		return oldUser;

	}

	@Override
	public Users findUser(int id) throws SQLException {
		ps = DBConnection.getConnection().conn.prepareStatement("select * from Users where userId = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Users user = null;
		if (rs.next()) {
			System.out.println("User found");
			user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), DateToLocalDateUtil.getLocalDate(rs.getDate(8)), rs.getString(9),
					rs.getString(10), DateToLocalDateUtil.getLocalDate(rs.getDate(11)),
					DateToLocalDateUtil.getLocalDate(rs.getDate(12)));
		}
		return user;
	}

	@Override
	public Users addNewUser(Users user) {

		try {

			ps = DBConnection.getConnection().conn.prepareStatement(
					"insert into Users (userId, fullname, gender, state, city, street, zipcode, birthyear, email, password, datecreated,dateupdated) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, user.getUserid());
			ps.setString(2, user.getFullname());
			ps.setString(3, user.getGender());
			ps.setString(4, user.getState());
			ps.setString(5, user.getCity());
			ps.setString(6, user.getStreet());
			ps.setString(7, user.getZipcode());
			ps.setInt(8, user.getBirthyear());
			ps.setString(9, user.getEmail());
			ps.setString(10, user.getPassword());
			ps.setDate(11, java.sql.Date.valueOf(user.getDatecreated()));
			ps.setDate(12, java.sql.Date.valueOf(user.getDateupdated()));
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}