import java.sql.*;
public class mysql5
{
  public static void main(String args[]) throws Exception
  {
     Connection conn;
     Statement st;
    try
   {
     // Load and register the driver    
      Class.forName("com.mysql.cj.jdbc.Driver");
    
    //Establish the connection to the database server
    //  conn=DriverManager.getConnection("jdbc:mysql:dsn1");
    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/manager","root","password");
    
    // create a statement
     st=conn.createStatement();

    //Execute the statement
    // String q1="create table stud(name char(10), rno integer)";
    //String q1="create table employee(emp_id int PRIMARY KEY, emp_name varchar(20))";
     
    String q1 = "Select * from employee";

    // ResultSet rs= st.executeUpdate(q1);  // note the difference

    ResultSet rs= st.executeQuery(q1);  
  //Retrieve the results
   while(rs.next())
   {
     System.out.print(rs.getInt(1)+"\t");
     System.out.println(rs.getString(2));  
    }    
    //close the statement and connection
     conn.close();
    st.close();
 }//try
 catch (Exception e)
 {
    System.out.println(e.toString());
  }
 }//psvm
}//class
