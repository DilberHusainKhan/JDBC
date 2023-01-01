package com.jdbc.practice;
import java.sql.*;

public class ConnectionProvider {
	private static Connection  con;
	
	public static  Connection getConnection() {
		try {
		if(con == null) {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","Root@123");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;	
	}
}
