package JDBC_Dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

	public static void mmm(String[] args) {
		
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pw = "hr";
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			System.out.println("드라이버 연결에 성공하였습니다.!!!");
		} catch (ClassNotFoundException e) {
			
			System.out.println("드라이버 연결에 실패하였습니다.!!!");
		}

		try {
			conn = DriverManager.getConnection(url, id, pw);
			
			System.out.println("사용자 인증을 성공적으로 연결하였습니다.");
		} catch (SQLException e) {
			
			System.out.println("사용자 인증을 실패 하였습니다.");
		}
	}

}
