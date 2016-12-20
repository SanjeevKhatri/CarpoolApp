package edu.mum.project.model;

import java.time.LocalDate;

public class Users {
	private int userid;
	private String fullname;
	private String gender;
	private String state;
	private String city;
	private String street;
	private int zipcode;
	private int birthyear;

	public Users() {
		// TODO Auto-generated constructor stub
	}

//	public Users(int int1, String string, String string2, String string3, String string4, String string5,
//			String string6, LocalDate localDate, String string7, String string8, LocalDate localDate2,
//			LocalDate localDate3) {
//		// TODO Auto-generated constructor stub
//	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender2) {
		this.gender = gender2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zip) {
		this.zipcode = zip;
	}

	public int getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(LocalDate datecreated) {
		this.datecreated = datecreated;
	}

	public LocalDate getDateupdated() {
		return dateupdated;
	}

	public void setDateupdated(LocalDate dateupdated) {
		this.dateupdated = dateupdated;
	}

	private String email;
	private String password;
	private LocalDate datecreated;
	private LocalDate dateupdated;
}
