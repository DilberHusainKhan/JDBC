package com.jdbc.practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayData {
	public static void main(String[] args) {
		try {
		Connection con = ConnectionProvider.getConnection();
		String q = "select * from table1";
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(q);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getString(3));
		}
		System.out.println("Query run....");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
