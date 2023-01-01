import java.sql.*;
import java.io.*;

public class InsertDataInTableWithDynamicInput {
    public static void main(String[] args) {
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String conURL = "jdbc:mysql://localhost:3306/youtube";
            String username = "root";
            String pass = "Root@123";
            Connection con = DriverManager.getConnection(conURL,username,pass);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter 1 to Insert Or 2 to display");
            int no  = Integer.parseInt(br.readLine());
            if(no==1){
                String q = "insert into table1(tname,tcity) values(?,?)";
                insertData(con, q);
            }else{
                String newQ = "select * from table1";
                displayData(con,newQ);
            }
            con.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void insertData(Connection con, String q) throws SQLException, IOException{
        PreparedStatement pstm = con.prepareStatement(q);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Your name");
            String name = br.readLine();
            System.out.println("Enter Your city");
            String city = br.readLine();
            pstm.setString(1, name);
            pstm.setString(2, city);
            System.out.println("Inserted successfully");
            pstm.executeUpdate();
            pstm.close();
            br.close();
    }

    public static void  displayData(Connection con, String q) throws SQLException{
            Statement stm = con.createStatement();
            ResultSet set = stm.executeQuery(q);
            while(set.next()){
                System.out.print(set.getString(1)+"  |  "+set.getString(2)+"  |  "+set.getString(3));
                System.out.println();
            }

        }
}