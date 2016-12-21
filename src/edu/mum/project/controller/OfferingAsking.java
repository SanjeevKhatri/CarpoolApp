package edu.mum.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.mum.project.serviceImpl.PostServiceImpl;

/**
 * Servlet implementation class OfferingAsking
 */
@WebServlet("/OfferingAsking")
public class OfferingAsking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostServiceImpl psi = new PostServiceImpl();
		ArrayList allPost = new ArrayList();

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");

		allPost = psi.getOfferedPost();

		Gson gson = new Gson();
		String jsonData = gson.toJson(allPost);
		out.println("{\"JSONDATA\":" + jsonData + "}");
		System.out.println("{\"JSONDATA\":" + jsonData + "}");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostServiceImpl psi = new PostServiceImpl();
		ArrayList allPost = new ArrayList();

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");

		allPost = psi.getAskingPost();

		Gson gson = new Gson();
		String jsonData = gson.toJson(allPost);
		out.println("{\"JSONDATA\":" + jsonData + "}");
		System.out.println("{\"JSONDATA\":" + jsonData + "}");
	}

}
