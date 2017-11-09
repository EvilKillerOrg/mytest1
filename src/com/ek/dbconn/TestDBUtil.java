package com.ek.dbconn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ek.dbconn.dbcp.DBUtil3;
import com.ek.vo.UserInfoVO;

public class TestDBUtil {

  private Connection conn;
  private Statement st;
  private ResultSet rst;

  public List<UserInfoVO> findUser() {
    String sql = "select * from userinfo_dbconn";
    UserInfoVO vo = null;
    List<UserInfoVO> list = new ArrayList<UserInfoVO>();

    conn = DBUtil3.getConnection();
    try {
      st = conn.createStatement();
      rst = st.executeQuery(sql);

      while (rst.next()) {
        vo = new UserInfoVO();
        vo.setUuid(rst.getInt("uuid"));
        vo.setUsername(rst.getString("username"));
        vo.setPassword(rst.getString("password"));
        list.add(vo);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (rst != null) {
        try {
          rst.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (st != null) {
        try {
          st.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return list;
  }

  @Test
  public void testFindUser() {
    TestDBUtil test3 = new TestDBUtil();
    List<UserInfoVO> list = test3.findUser();
    for (UserInfoVO userInfoVO : list) {
      System.out.println(userInfoVO.getUsername());
    }
  }

  

}
