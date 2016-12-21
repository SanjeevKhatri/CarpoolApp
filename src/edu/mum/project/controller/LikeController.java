package edu.mum.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import edu.mum.project.model.Likes;
import edu.mum.project.serviceImpl.CommentServiceImpl;
import edu.mum.project.serviceImpl.LikeServiceImpl;

@WebServlet("/LikeController")
public class LikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LikeServiceImpl lsi = new LikeServiceImpl();
		HttpSession session = request.getSession();
		String semail = (String) session.getAttribute("sessionEmail");

		try {
			lsi.insertLike(semail, 27);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher view = request.getRequestDispatcher("feed.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LikeServiceImpl lsi = new LikeServiceImpl();
		ArrayList allLikes = new ArrayList();

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");

		try {
			allLikes = lsi.getAllPostLikes(27);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Gson gson = new Gson();
		String jsonData = gson.toJson(allLikes);
		out.println("{\"JSONDATAAL\":" + jsonData + "}");
		System.out.println("{\"JSONDATAAL\":" + jsonData + "}");
	}

}
