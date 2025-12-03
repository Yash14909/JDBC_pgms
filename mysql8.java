import java.sql.*;

public class mysql8 {
    public static void main(String args[]) throws Exception {
        Connection conn;
        Statement st;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "password");

            // Create statement
            st = conn.createStatement();
            st.addBatch("DELETE FROM employee WHERE emp_id=101");
            st.addBatch("DELETE FROM employee WHERE emp_id=102");
            st.executeBatch();
            System.out.println("Batch processing done successfully");
            
            conn.close();
            st.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
