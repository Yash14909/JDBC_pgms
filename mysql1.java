import java.io.*;
import java.sql.*;
public class mysql1
{
  public static void main(String args[]) throws Exception
  {
     Connection conn;
     Statement st;
    try
   {
     // Load and register the driver
     //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     
     Class.forName("com.mysql.cj.jdbc.Driver");
   
    //Establish the connection to the database server
    // conn =DriverManager.getConnection("jdbc:odbc:rgsdsn");
    //  conn=DriverManager.getConnection("jdbc:mysql:dsn1");
    
    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/manager","root","password");
  
    
    // create a statement
     st=conn.createStatement();

    //Execute the statement
    // String q1="create table stud(name char(10), rno integer)";
    //String q1="create table stud1(rno integer,name char(10))";
 
    String q1="create table employee(emp_id int PRIMARY KEY, emp_name varchar(20))";
     st.executeUpdate(q1);

    //close the statement and connection
  System.out.println("Done....");
     conn.close();
    st.close();
 }//try
 catch (Exception e)
 {
    System.out.println(e.toString());
  }
 }//psvm
}//class
