import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcEx2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb"; // Replace 'testdb' with your DB name
        String username = "root"; // Replace with your DB username
        String password = "password"; // Replace with your DB password

        try {
            // Load JDBC driver (optional in newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Insert a record
            String insertSQL = "INSERT INTO students (id, name) VALUES (?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
            insertStmt.setInt(1, 1);
            insertStmt.setString(2, "John");
            insertStmt.executeUpdate();
            System.out.println("Record inserted.");

            // Select records
            String selectSQL = "SELECT * FROM students";
            PreparedStatement selectStmt = conn.prepareStatement(selectSQL);
            ResultSet rs = selectStmt.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
