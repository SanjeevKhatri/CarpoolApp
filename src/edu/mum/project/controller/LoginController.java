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

import edu.mum.project.serviceImpl.UserServiceImpl;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		session.setAttribute("sessionEmail", email);

		String remembercbox = request.getParameter("remember");
		if (remembercbox != null) {
			Cookie cEmail = new Cookie("cookuser", email.trim());
			Cookie cPassword = new Cookie("cookpass", password.trim());
			Cookie cRemember = new Cookie("cookrem", remembercbox.trim());
			cEmail.setMaxAge(60 * 60 * 15);// 15 minutes
			cPassword.setMaxAge(60 * 60 * 15);
			cRemember.setMaxAge(60 * 60 * 15);
			response.addCookie(cEmail);
			response.addCookie(cPassword);
			response.addCookie(cRemember);
		}

		UserServiceImpl usi = new UserServiceImpl();
		try {
			if (usi.checkUserLogin(email, password)) {
				RequestDispatcher view = request.getRequestDispatcher("feed.jsp");
				view.forward(request, response);
			} else {
				request.setAttribute("logout", "Either Email or Password is incorrect");
				RequestDispatcher view = request.getRequestDispatcher("login.jsp");
				view.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
