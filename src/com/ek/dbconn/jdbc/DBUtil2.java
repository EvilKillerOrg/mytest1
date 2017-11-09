package com.ek.dbconn.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Test;

public class DBUtil2 {
  private static Logger logger = Logger.getLogger(DBUtil2.class);
  
  private static String driverClassName;
  private static String url;
  private static String username;
  private static String password;
  
  static{
    InputStream inStream = null;
    Properties propertie = new Properties();
    try {
      inStream = DBUtil2.class.getClassLoader().getResourceAsStream("jdbc.properties");
      propertie.load(inStream);
      driverClassName = propertie.getProperty("driverClassName");
      url = propertie.getProperty("url");
      username = propertie.getProperty("username");
      password = propertie.getProperty("password");
    } catch (IOException e) {
      e.printStackTrace();
    }finally{
      if(inStream!=null){
        try {
          inStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
  
  
  public static Connection getConnection(){
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
  public void TestConn(){
    logger.debug(DBUtil2.getConnection());
  }

}
