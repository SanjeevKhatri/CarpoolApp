package edu.mum.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import edu.mum.project.model.Comments;
import edu.mum.project.model.Posts;
import edu.mum.project.serviceImpl.CommentServiceImpl;
import edu.mum.project.serviceImpl.PostServiceImpl;

@WebServlet("/CommentController")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CommentServiceImpl csi = new CommentServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommentServiceImpl csi = new CommentServiceImpl();
		ArrayList allComments = new ArrayList();

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");

		try {
			int pid = Integer.parseInt(request.getParameter("hid"));
			System.out.println(pid+".................................");
			allComments = csi.getAllPostComment(pid);
			System.out.println(allComments+"...........222222222222222222222......................");
		} catch (Exception e) {
			e.printStackTrace();
		}

		Gson gson = new Gson();
		String jsonData = gson.toJson(allComments);
		out.println("{\"JSONDATAAC\":" + jsonData + "}");
		System.out.println("{\"JSONDATAAC\":" + jsonData + "}");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String semail = (String) session.getAttribute("sessionEmail");
		Comments comments = new Comments();

		int pid = Integer.parseInt(request.getParameter("hid"));
		String postComment = request.getParameter("myComment");
		System.out.println(semail + "postComment=++++++++++++++==================+++++++++=======" + postComment);

		comments.setComment(postComment);

		try {
			csi.insertComment(semail, pid, comments);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher view = request.getRequestDispatcher("feed.jsp");
		view.forward(request, response);
	}

}
