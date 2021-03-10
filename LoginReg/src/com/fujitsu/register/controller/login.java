package com.fujitsu.register.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fujitsu.register.DAO.LoginDao;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginDao dao = new LoginDao();
		
		if(dao.verifyUserCredentials(username, password))
		{
			HttpSession session = request.getSession();
			session.setAttribute("myuser", username);
			response.sendRedirect("welcome.jsp");
			
			
		}
		else
		{
			response.sendRedirect("login.jsp");

		}

		/*
		 * if(username.equals("s@gmail.com") && password.equals("abc")) { HttpSession
		 * session = request.getSession(); session.setAttribute("myuser", username);
		 * response.sendRedirect("welcome.jsp"); } else {
		 * 
		 * response.sendRedirect("login.jsp"); }
		 */
		
	}

}
