import java.sql.*;
import java.io.*;

public class ImageSave{
	public static void main(String arg[]){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String conURL = "jdbc:mysql://localhost:3306/youtube";
			String username ="root";
			String pass = "Root@123";
			Connection con = DriverManager.getConnection(conURL,username,pass);
			
			String query = "insert into images(pic) values(?)";
			PreparedStatement pstm = con.prepareStatement(query);
			//To get image from user we use FileInputStream; image should be less than 65kb
			FileInputStream fis = new FileInputStream("pic1.jpg");
			pstm.setBinaryStream(1,fis,fis.available());
			pstm.executeUpdate();
			System.out.println("Done...");
			
			con.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}