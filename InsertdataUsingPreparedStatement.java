import java.sql.*;
public class InsertdataUsingPreparedStatement {
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
            String q = "insert into table1(tname,tcity) values(?,?)";
        
            // Get a Preparedstatement because we need dynamic query
            PreparedStatement pstm = con.prepareStatement(q);

            // Set the value to query
            pstm.setString(1, "Humayun");
            pstm.setString(2, "Kanpur");

            // Execute Query 
            pstm.executeUpdate();  //

            System.out.println("Query Inserted successfully!");

            // Close statement and connection
            pstm.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
