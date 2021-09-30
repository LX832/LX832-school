package JDBC_Dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class fffffff {

   @SuppressWarnings("null")
   public static void main(String[] args) throws ClassNotFoundException, SQLException {
      
      Login lg = new Login();
      lg.mmm(null);
      //1. driver definition & url, id, pw definition
      PreparedStatement pstmt;
      Connection conn = null; // 연결역할을 하는 클래스
      ResultSet rs;
      
      
      
      //3. statement execution
      String sql = "select * from Departments";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      
      System.out.println("--------------------- 부서정보 시스템 조회 -------------------");
      System.out.println(
            "부서ID" + "\t" + "부서명" + "\t" + "관리자ID" + "\t" + "지역ID" );
      System.out.println("------------------------------------------------------");

      
      while(rs.next()) {
         int D_id = rs.getInt("Department_ID");
         String D_name = rs.getNString("Department_NAME");
         int M_id = rs.getInt("Manager_ID");
         int L_id = rs.getInt("Location_ID");
         

         System.out.println(D_id + "\t" + D_name + "\t" + M_id + "\t" + L_id );
         
      }
      
      System.out.println("---------------------------------------------------------------------------");
      
      if(rs != null) { rs.close(); }
      if(pstmt != null) { pstmt.close(); }
      if(conn != null) { conn.close(); }
      //4. result output

   }

}