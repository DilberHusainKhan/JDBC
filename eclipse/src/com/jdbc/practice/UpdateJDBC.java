package com.jdbc.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateJDBC {
	public static void main(String arg[]){
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectionProvider.getConnection();
			String q = "update table1 set tname = ?, tcity = ? where tID = ? ";
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter new name:");
			String name = br.readLine();
			System.out.println("Enter city: ");
			String city = br.readLine();
			System.out.println("Enter old id: ");
			int id = Integer.parseInt(br.readLine());
			
			PreparedStatement pstm = con.prepareStatement(q);
			pstm.setString(1,name);
			pstm.setString(2,city);
			pstm.setInt(3, id);
			
			pstm.executeUpdate();
			System.out.println("Update done...");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
