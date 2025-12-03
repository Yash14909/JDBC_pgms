import java.io.*;
import java.sql.*;     // RESULT METADATA

public class mysql7 {
    public static void main(String args[]) throws Exception {
        Connection conn;
        Statement st;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "password");

            // Create statement
            st = conn.createStatement();
            String q1 = "SELECT * FROM employee";
            ResultSet rs = st.executeQuery(q1);

            DatabaseMetaData dbmd = conn.getMetaData();

            System.out.println("getDatabaseProductName: " + dbmd.getDatabaseProductName());
            System.out.println("getDatabaseProductVersion: " + dbmd.getDatabaseProductVersion());
            System.out.println("getDriverName: " + dbmd.getDriverName());
            System.out.println("getDriverVersion: " + dbmd.getDriverVersion());
            System.out.println("getDriverName: " + dbmd.getDriverName());
            System.out.println("getURL" + dbmd.getURL());
           
  
   
            System.out.println("getUserName:" + dbmd.getUserName());
            //close the statements and connection


            rs.close();
            st.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
