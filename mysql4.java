import java.sql.*;

public class mysql4
{
    public static void main(String args[]) throws Exception
    {
        Connection conn;
        Statement st;

        try {

        Class.forName("com.mysql.cj.jdbc.Driver");

            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/manager","root","password");
            st=conn.createStatement();
            CallableStatement cs = conn.prepareCall("{call p1()}");
            //Execute the stored procedure
            ResultSet rs = cs.executeQuery();
            //Display the result
            while(rs.next()) {
                int emp_id = rs.getInt(1);
                String emp_name = rs.getString(2);
                System.out.println("Empid:" + emp_id + ", name:" + emp_name);               
            }
            //close all connections
                cs.close();
                st.close();
                conn.close();
                cs.close();

        } catch (Exception e) {
            System.out.println("Error:"+ e.toString());
        } 

    }
}