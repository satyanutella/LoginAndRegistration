package com.fujitsu.register.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fujitsu.register.model.User;

public class UserDao {
	
	public ResultSet userDetailscheck()
	{
		String url = "jdbc:mysql://localhost:3306/register";
		String db_username = "root";
		String db_password = "root";
		
		Connection con;
		PreparedStatement pstmt;
		String sql = "select * from users";

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,db_username,db_password);
			pstmt = con.prepareStatement(sql);
			 
			ResultSet rs = pstmt.executeQuery();
			
		   return rs;
			  
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

}
