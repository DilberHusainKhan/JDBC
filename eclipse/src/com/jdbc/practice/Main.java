package com.jdbc.practice;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		try {
				Connection con = ConnectionProvider.getConnection();
				
				String query = "insert into images(pic) values(?)";
				PreparedStatement pstm = con.prepareStatement(query);
				
				JFileChooser jfc = new JFileChooser();
				jfc.showOpenDialog(null);
				File fobj = jfc.getSelectedFile();
				FileInputStream fis = new FileInputStream(fobj);
				pstm.setBinaryStream(1,fis,fis.available());
				pstm.executeUpdate();
				System.out.println("Update done...");
				JOptionPane.showMessageDialog(null, "Succesfully Inserted!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
