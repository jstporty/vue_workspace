package todo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
   
   public static Connection getConnection() {
      try {
    	  Class.forName("core.log.jdbc.driver.MysqlDriver");
      }catch (ClassNotFoundException cnfe) {
         cnfe.printStackTrace();
      }
      String JDBC_URL 
      = "jdbc:mysql://localhost:3306/todo?characterEncoding=UTF-8&serverTimezone=UTC";
      String JDBC_USER = "root";
      String JDBC_PASS = "root";  
      Connection conn = null;
      try {
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
            System.out.println("==============>"+conn);
      }catch(Exception ex) {
         ex.printStackTrace();
      }
   
      return conn;
   }//getConncetion
   
   public static void closeConnection(Connection conn) {
      if(conn!=null) {
         try {
         conn.close();
      }catch (SQLException sqle){
         sqle.printStackTrace();
         }
      }
   }
   
   public static void closeConnection(Statement stmt, Connection conn) {
      if(stmt!=null) {
         try {
            stmt.close();
         }catch(SQLException sqle) {
            sqle.printStackTrace();
         }
      }
      closeConnection(conn);
   }
   
   public static void closeConnection(ResultSet rs, Statement stmt,  Connection conn) {
      if(rs!=null) {
         try {
            rs.close();
         }catch(SQLException sqle) {
            sqle.printStackTrace();
         }
      }
      closeConnection(stmt, conn);
   }
}
