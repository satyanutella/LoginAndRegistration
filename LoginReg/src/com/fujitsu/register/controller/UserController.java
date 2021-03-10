package com.fujitsu.register.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fujitsu.register.DAO.UserDao;
import com.fujitsu.register.model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		UserDao dao = new UserDao();
		
		ResultSet rs = dao.userDetailscheck();
		
		
		
		ArrayList<User> userlist = new ArrayList<User>();
		try {
			while(rs.next())
			{
				userlist.add(new User(rs.getInt(1),(rs.getString(2)), (rs.getString(3)),(rs.getInt(4)),(rs.getString(5))));		
				
			}
			
			  
			  request.setAttribute("mylist",userlist);
			  //response.sendRedirect("userDetails.jsp"); //send redirect is not working in this case
			  request.getRequestDispatcher("userDetails.jsp").forward(request, response);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
