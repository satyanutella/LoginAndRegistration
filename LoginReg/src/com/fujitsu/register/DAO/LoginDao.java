package com.fujitsu.register.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

public class LoginDao {
	
	public boolean verifyUserCredentials(String username, String password)
	{
		
		String url = "jdbc:mysql://localhost:3306/register";
		String db_username = "root";
		String db_password = "root";
		
		Connection conn;
		PreparedStatement pstmt;
		String sql = "select * from users where username=? and password=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,db_username,db_password);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			
				return true;
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	}



