package edu.mum.project.serviceImpl;

import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.mysql.jdbc.Connection;

import edu.mum.project.dbConnection.DBConnection;
import edu.mum.project.dbConnection.DateToLocalDateUtil;
import edu.mum.project.model.Users;
import edu.mum.project.service.UserService;

public class UserServiceImpl{

	public boolean insertUser(Users user) throws Exception {
		String passwordmd = "";
		try {

			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(user.getPassword().getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
			passwordmd = sb.toString();
			int m = 0;
			if (user.getGender().equals("Male")) {
				m = 1;
			} else if (user.getGender() == ""){
				m = 1;
			} else {
				m = 0;
			}
			
			Connection con = (Connection) DBConnection.getConnection();
			System.out.println("after");
			String insert = "INSERT INTO users(fullname,gender,state,city,street,zipcode,birthyear,email,password) "
					+ "values ('" + user.getFullname() + "'," + m + ",'" + user.getState() + "','" + user.getCity() + "','" + user.getStreet() + "'," + user.getZipcode() + ","
					+ user.getBirthyear() + ",'" + user.getEmail() + "'," + "'" + passwordmd + "')";
			PreparedStatement stat = (PreparedStatement) con.prepareStatement(insert);
			stat.executeUpdate();
			//System.out.println(passwordmd);
			return true;
		} catch (Exception ex) {
			System.out.println(ex.toString());
			return false;
		}
	}
	
	public boolean checkUserLogin(String email, String password) throws Exception {
		String emailmd = "";
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		emailmd = sb.toString();
		Connection con = (Connection) DBConnection.getConnection();
		String query = "select email,password from users";
		PreparedStatement stat = (PreparedStatement) con.prepareStatement(query);
		ResultSet res = stat.executeQuery();
		while (res.next()) {
			String mail = res.getString("email").toString();
			String pass = res.getString("password").toString();
			if (email.equals(mail) && pass.equals(emailmd)) {
				return true;
			}
		}

		return false;
	}

}