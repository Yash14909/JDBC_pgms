import java.sql.*;
import java.util.*;

public class mysql333 {
    public static void main(String args[]) {
        Connection conn = null;
        PreparedStatement ps = null;
        Scanner sc = new Scanner(System.in);

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "password");

            // Read emp_name input
            System.out.print("Enter Employee Name: ");
            String emp_name = sc.nextLine();

            // Insert only the emp_name, emp_id is auto-generated
            String insertQuery = "INSERT INTO employee(emp_name) VALUES (?)";
            ps = conn.prepareStatement(insertQuery);
            ps.setString(1, emp_name);

            int i = ps.executeUpdate();
            System.out.println("✅ " + i + " row(s) inserted.");

            // Close resources
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.toString());
        } finally {
            sc.close();
        }
    }
}
