import java.sql.*;

public class InsertJDBC{
	public static void main(String arg[]){
		try{
			//Load a driver
			Class.forName("com.mysql.jdbc.Driver");
			//Connect to database
			String URL = "jdbc:mysql://Localhost:3306/youtube";
			String username = "root";
			String pass = "Root@123";
			Connection con = DriverManager.getConnection(URL,username,pass);
			//Create a query
			String q = "create table employee(eID int(20) primary key auto_increment, name varchar(200) not null, salary int(10),company varchar(200) not null)";
			//Create a statement
			Statement st = con.createStatement();
			//Exceute query
			st.executeUpdate(q);
			System.out.println("Table Create Sucessfully...");
			//Close st & con
			st.close();
			con.close();
			
		}catch(Exception e){e.printStackTrace();}
	}
}