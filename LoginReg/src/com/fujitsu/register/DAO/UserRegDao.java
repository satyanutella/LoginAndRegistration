package com.fujitsu.register.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.fujitsu.register.model.User;
import com.mysql.cj.xdevapi.PreparableStatement;


public class UserRegDao {
	
	public boolean registerUser(User user)
	{
		
		String url = "jdbc:mysql://localhost:3306/register";
		String db_username = "root";
		String db_password = "root";
		
		Connection con;
		PreparedStatement pstmt;
		String sql = "insert into users values(?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(url,db_username,db_password);
			
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getPassword());
			pstmt.setInt(4, user.getPhone());

			pstmt.setString(5, user.getAddress());

			int result = pstmt.executeUpdate();
			if(result>0)
				return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Start of UserRegDao :: registerUser");
		return false;

	}

}
