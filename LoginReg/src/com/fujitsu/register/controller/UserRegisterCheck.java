package com.fujitsu.register.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fujitsu.register.DAO.UserRegDao;
import com.fujitsu.register.model.User;

/**
 * Servlet implementation class UserRegisterCheck
 */
@WebServlet("/UserRegisterCheck")
public class UserRegisterCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		UserRegDao dao;
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int phone = Integer.parseInt(request.getParameter("number"));
		String address = request.getParameter("address");


		//generating random num
		Random random = new Random();
		int userId = random.nextInt(99);
		
		User newUser = new User(userId,username,password,phone,address);
		out.print("new user :"+newUser);
		
		//saving in database
		dao = new UserRegDao();
		boolean result = dao.registerUser(newUser);
		
		if(result)
		{
		
		
			out.print("Resgistered successfully ");
			response.sendRedirect("welcome.jsp");
		}
			
		else
			System.err.println("Internal server error");
	}

}
