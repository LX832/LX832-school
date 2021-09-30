package JDBC_Dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Oracle_Dept_Select {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		//1.driver definition & url, id, pw definition
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pw = "hr";
		
		Connection conn;
		PreparedStatement pstmt = null; //명령 실행
		ResultSet rs = null;
		
		//2.driver loading & user certification
		Class.forName(driver);
		
		conn= DriverManager.getConnection(url, id, pw);
		
		
		//3.statement execution
		
		
		try {
		String sql = "select * from Departments";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		System.out.println("---------------------- 부서정보 시스템 조회----------------------");
		System.out.println("부서ID" + "\t\t" + "부서이름" + "\t" + "매니저ID" + "\t" + "지역ID");			
		System.out.println("------------------------------------------------------------");
		
		
		while(rs.next()) {
			int D_id = rs.getInt("Department_ID");
			String D_name = rs.getString("Department_NAME");
			int M_id = rs.getInt("Manager_ID");
			int L_id = rs.getInt("Location_ID");
			
			System.out.println(D_id + "\t" + D_name + "\t" + M_id + "\t" + L_id);
			
		}
		System.out.println("------------------------------------------------------------");
		}catch(Exception e) {
			System.out.println("돌발상황이 발생하였습니다. 확인하시고 조치바랍니다.");		 		
		}finally {
			if (rs != null) {	rs.close();	}
			if (pstmt != null) { pstmt.close();	}
			if (conn != null) {	conn.close();	}				
		}
	}
}
