import java.io.*;
import java.sql.*;     // RESULT METADATA

public class mysql6 {
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

            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("Total Columns: " + rsmd.getColumnCount());
            System.out.println("Column name of 1st Column: " + rsmd.getColumnName(1));
            System.out.println("Column Type Name of 1st Column: " + rsmd.getColumnTypeName(1));

            rs.close();
            st.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
