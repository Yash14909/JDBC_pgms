import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password"; // Replace with your actual password

        try {
            // 1. Load the JDBC Driver (optional in newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");

            // 3. Create a statement
            Statement stmt = conn.createStatement();

            // 4. Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            // 5. Process the result
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }

            // 6. Close connections
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
