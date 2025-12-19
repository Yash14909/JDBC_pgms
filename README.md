# 🗄️ JDBC MySQL Connection Examples

A comprehensive collection of Java programs demonstrating various JDBC operations with MySQL database. Perfect for learning database connectivity and operations in Java!

## 📋 Overview

This repository contains 12 Java examples that progressively demonstrate different aspects of JDBC (Java Database Connectivity) with MySQL, from basic connections to advanced features like batch processing and metadata retrieval.

## 🎯 What You'll Learn

- Establishing database connections
- Creating tables dynamically
- Inserting, updating, and deleting records
- Executing queries and processing results
- Using PreparedStatements for parameterized queries
- Calling stored procedures
- Batch processing for multiple operations
- Retrieving database and result set metadata

## 📁 File Descriptions

### **Basic JDBC Operations**

**`JDBCExample.java`** - Your First JDBC Program
- Demonstrates the fundamental JDBC workflow
- Connects to `testdb` database
- Executes a simple SELECT query on the `users` table
- Shows the classic 6-step JDBC process

**`JdbcEx2.java`** - Insert and Select Operations
- Works with `studentdb` database
- Inserts a student record using PreparedStatement
- Retrieves and displays all students
- Great example of basic CRUD operations

### **Table Creation & Basic Inserts**

**`mysql1.java`** - Creating Tables
- Creates an `employee` table with `emp_id` (Primary Key) and `emp_name`
- Demonstrates DDL (Data Definition Language) operations
- Database: `manager`

**`mysql2.java`** - Simple Insert
- Inserts a hardcoded employee record (101, 'mahesh')
- Shows basic INSERT statement execution

### **PreparedStatement Examples**

**`mysql3.java`** - Introduction to PreparedStatements
- Uses parameterized queries with `?` placeholders
- Inserts employee (102, 'Ramesh') using setInt() and setString()
- Safer than regular statements (prevents SQL injection)

**`mysql33.java`** - Another PreparedStatement Example
- Similar to mysql3.java but inserts different data (103, 'Ramesh2')
- Reinforces PreparedStatement concepts

**`mysql333.java`** - Interactive Input with PreparedStatement
- Takes employee name as user input via Scanner
- Assumes auto-generated `emp_id` (auto-increment column)
- Most practical example for real-world applications

### **Data Retrieval**

**`mysql5.java`** - SELECT Query Execution
- Retrieves all employee records
- Demonstrates ResultSet navigation with `rs.next()`
- Displays data using `getInt()` and `getString()`

### **Stored Procedures**

**`mysql4.java`** - Calling Stored Procedures
- Uses `CallableStatement` to execute stored procedure `p1()`
- Shows how to work with database procedures from Java
- Processes and displays results from the procedure

### **Metadata Operations**

**`mysql6.java`** - ResultSet Metadata
- Uses `ResultSetMetaData` to get information about query results
- Displays total column count, column names, and data types
- Useful for dynamic query handling

**`mysql7.java`** - Database Metadata
- Uses `DatabaseMetaData` to retrieve database and driver information
- Shows database product name, version, driver details, and connection URL
- Great for debugging and logging connection details

### **Batch Processing**

**`mysql8.java`** - Batch Operations
- Executes multiple DELETE statements in a single batch
- Deletes employees with IDs 101 and 102
- More efficient than executing statements individually

## 🔧 Prerequisites

1. **Java Development Kit (JDK)** - Version 8 or higher
2. **MySQL Server** - Installed and running
3. **MySQL JDBC Driver** (Connector/J) - Add to your classpath
   - Download from: [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)
   - Or use Maven/Gradle dependency

## 🚀 Setup Instructions

### 1. Database Setup

```sql
-- Create the database
CREATE DATABASE manager;
USE manager;

-- Create employee table
CREATE TABLE employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(20)
);

-- For mysql333.java (auto-increment example)
CREATE TABLE employee (
    emp_id INT AUTO_INCREMENT PRIMARY KEY,
    emp_name VARCHAR(20)
);

-- Create stored procedure for mysql4.java
DELIMITER //
CREATE PROCEDURE p1()
BEGIN
    SELECT * FROM employee;
END //
DELIMITER ;
```

### 2. Update Connection Details

In each Java file, update these lines with your MySQL credentials:

```java
String url = "jdbc:mysql://localhost:3306/manager";
String username = "root";
String password = "your_password_here";  // ⚠️ Change this!
```

### 3. Compile and Run

```bash
# Compile (make sure MySQL JDBC driver is in classpath)
javac -cp .:mysql-connector-java-8.x.x.jar mysql1.java

# Run
java -cp .:mysql-connector-java-8.x.x.jar mysql1
```

## 📚 Learning Path

Follow this recommended sequence:

1. **Start Simple**: `JDBCExample.java` → `JdbcEx2.java`
2. **Table Operations**: `mysql1.java` → `mysql2.java`
3. **PreparedStatements**: `mysql3.java` → `mysql33.java` → `mysql333.java`
4. **Query Results**: `mysql5.java`
5. **Advanced Features**: `mysql4.java` (stored procedures)
6. **Metadata**: `mysql6.java` → `mysql7.java`
7. **Optimization**: `mysql8.java` (batch processing)

## ⚠️ Important Notes

- Always close database resources (`ResultSet`, `Statement`, `Connection`) to prevent memory leaks
- Use PreparedStatements for queries with user input to prevent SQL injection
- Never hardcode passwords in production code - use environment variables or configuration files
- Handle exceptions properly - these examples use basic try-catch for simplicity

## 🔐 Security Best Practices

```java
// ❌ Don't do this in production
String password = "password";

// ✅ Better approach
String password = System.getenv("DB_PASSWORD");
// Or use properties files, configuration managers, etc.
```

## 🤝 Common Issues & Solutions

**Problem**: `ClassNotFoundException: com.mysql.cj.jdbc.Driver`
- **Solution**: Add MySQL JDBC driver to your classpath

**Problem**: `Access denied for user 'root'@'localhost'`
- **Solution**: Check your MySQL username and password

**Problem**: `Unknown database 'manager'`
- **Solution**: Create the database first using the SQL setup commands

**Problem**: `Table 'employee' doesn't exist`
- **Solution**: Run the CREATE TABLE command from the setup section

## 📖 Additional Resources

- [JDBC Tutorial - Oracle](https://docs.oracle.com/javase/tutorial/jdbc/)
- [MySQL Connector/J Documentation](https://dev.mysql.com/doc/connector-j/en/)
- [PreparedStatement Best Practices](https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)

## 💡 Next Steps

Once comfortable with these examples, explore:
- Connection pooling (HikariCP, Apache DBCP)
- ORM frameworks (Hibernate, JPA)
- Transaction management
- Database connection security
- DAO (Data Access Object) pattern

---

**Happy Coding! 🚀**
