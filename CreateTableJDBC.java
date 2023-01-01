// Create Table using Statement interface

import java.sql.*;

public class CreateTableJDBC {
    public static void main(String[] args) {
        try {
            //Load JDBC Driver class
            Class.forName("com.mysql.jdbc.Driver");
            // Connect to database
            String connectionURL = "jdbc:mysql://localhost:3306/youtube";
            String username = "root";
            String password ="Root@123";
            Connection con = DriverManager.getConnection(connectionURL,username,password);
            
            // Create Query
            String q = "create table table1(tID int(20) primary key auto_increment,tname varchar(200) not null, tcity varchar(200))";
        
            // Create a statement
            Statement stmt = con.createStatement();

            // Execute Query
            stmt.executeUpdate(q);

            System.out.println("Table created successfully");

            // Close statement and connection
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }    
}
