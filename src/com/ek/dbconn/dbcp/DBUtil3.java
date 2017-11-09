package com.ek.dbconn.dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

public class DBUtil3 {

 
  private static DataSource dataSource;

  static {
    InputStream inStream = null;
    Properties pripertie = new Properties();
    try {
      inStream = DBUtil3.class.getClassLoader().getResourceAsStream("jdbc.properties");
      pripertie.load(inStream);
      dataSource = BasicDataSourceFactory.createDataSource(pripertie);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() {
    try {
      return dataSource.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  
  @Test
  public void testdb() {
    System.out.println(DBUtil3.getConnection());
  }

}
