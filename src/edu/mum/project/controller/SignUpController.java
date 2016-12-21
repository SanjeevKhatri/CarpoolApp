package edu.mum.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.mum.project.model.Users;
import edu.mum.project.service.UserService;
import edu.mum.project.serviceImpl.UserServiceImpl;

@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		Users users= new Users();
		UserServiceImpl usi= new UserServiceImpl();
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		session.setAttribute("sessionEmail", email);
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		int zip = Integer.parseInt(request.getParameter("zip"));
		int birthyear = Integer.parseInt(request.getParameter("birthyear"));
		users.setFullname(fullname);
		users.setBirthyear(birthyear);
		users.setCity(city);
		users.setEmail(email);
		users.setPassword(password);
		users.setGender(gender);
		users.setState(state);
		users.setZipcode(zip);
		users.setGender(gender);
		try {
			usi.insertUser(users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher("feed.jsp");
		view.forward(request, response);
	}

}
