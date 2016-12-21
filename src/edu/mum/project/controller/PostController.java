package edu.mum.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.mum.project.model.Posts;
import edu.mum.project.serviceImpl.PostServiceImpl;

@WebServlet("/PostController")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String semail = (String) session.getAttribute("sessionEmail");
		Posts posts = new Posts();
		PostServiceImpl psi = new PostServiceImpl();

		String posttype = request.getParameter("posttype");
		String date = request.getParameter("date");
		String fromlocation = request.getParameter("from");
		String tolocation = request.getParameter("to");
		String description = request.getParameter("description");

		posts.setPosttype(posttype);
		posts.setDescription(description);
		posts.setDate(date);
		posts.setFromlocation(fromlocation);
		posts.setTolocation(tolocation);

		try {
			psi.insertPost(semail, posts);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher view = request.getRequestDispatcher("feed.jsp");
		view.forward(request, response);
	}

}
