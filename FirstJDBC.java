// First JDBC Program
import java.sql.*;
public class FirstJDBC {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver class
            Class.forName("com.mysql.jdbc.Driver");
            // Create a connection to the database
            String URL = "jdbc:mysql://localhost:3307/youtube";
            String username = "root";
            String password = "Root@123";

            Connection con = DriverManager.getConnection(URL,username,password);


            if(con.isClosed()){
                System.out.println("Connection is closed");
                        
            }else{
                System.out.println("Connection is Creaetd.....");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
