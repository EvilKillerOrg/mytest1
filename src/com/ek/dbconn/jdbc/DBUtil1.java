package com.ek.dbconn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.junit.Test;

public class DBUtil1 {

  private static Logger logger = Logger.getLogger(DBUtil1.class);

  private static String url = "jdbc:mysql://localhost:3306/guide_db";
  private static String driverClassName = "com.mysql.jdbc.Driver";
  private static String username = "root";
  private static String password = "admin";

  public static Connection getConnection() {
    try {
      Class.forName(driverClassName);
      return DriverManager.getConnection(url, username, password);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;

  }
  
   @Test
   public void testName() throws Exception {
   logger.debug(DBUtil1.getConnection());
   }

}
