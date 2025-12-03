import java.sql.*;
// Prepared Statement interface accepts parameters at runtime
//Uses prepareStatement() method of Connection interface
public class mysql33
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
     conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/manager","root","password");
    
    // create a statement
     st=conn.createStatement();

    //Execute the statement
      String q1="insert into employee values (? ,?)";


    // prepareStatement() is method of connection interface
    PreparedStatement ps = conn.prepareStatement(q1);

   //uname= sc.next();  uid=sc.nextInt();

    ps.setInt(1,103);
    ps.setString(2,"Ramesh2");  // position specified and data provided
   
  // int i = ps.executeUpdate(q1); // notice the difference
   int i = ps.executeUpdate();
   System.out.println("no of rows updated "+i);

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
 