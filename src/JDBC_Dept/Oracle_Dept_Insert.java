package JDBC_Dept;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Oracle_Dept_Insert{
	
	private static  String ino;
	private static  int Department_id;
	private static  String Department_name;
	private static  int Manager_id;
	private static  int Location_id;

	public static void main(String[] args) {
		
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
	
	

		//DBConnection();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("********** 직원 정보 시스템 테이블 입력 **********");

		
		System.out.println("부서ID를 입력하세요.");
		try {
			ino = br.readLine();			
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("부서ID을 입력하는데 문제가 발생하였습니다.");
		}		
		Department_id = Integer.parseInt(ino);
			
			
		System.out.println("부서이름을 입력하세요.");
		try {
			Department_name = br.readLine(); // 이름 입력
		} catch (IOException e1) {
			System.out.println("부서이름을 입력하는데 문제가 발생하였습니다.");
		}

		
		
		System.out.println("매니저ID를 입력하세요.");
		try {
			ino = br.readLine(); // 학년 입력
		} catch (IOException e1) {
			System.out.println("매니저ID를 입력하는데 문제가 발생하였습니다.");
		}
		Manager_id = Integer.parseInt(ino);
		
		
		
		System.out.println("지역ID를 입력하세요.");
		try {
			ino = br.readLine(); // 반 입력
		} catch (IOException e1) {
			System.out.println("지역ID를 입력하는데 문제가 발생하였습니다.");
		}
		Location_id = Integer.parseInt(ino);
		

		String sql = "insert into departments (Department_ID, Department_NAME, Manager_ID, LOCATION_ID)"
				+ "values(?, ?, ?, ?)";

		System.out.println("---------------------------------------------------------------------------");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Department_id);
			pstmt.setString(2, Department_name);			
			pstmt.setInt(3, Manager_id);			
			pstmt.setInt(4, Location_id);
			
			pstmt.executeUpdate();// insert, delete, update 공용으로 사용합니다.
			// 5.data output
			
			System.out.println("데이터를 성공적으로 입력 하였습니다.");
		} catch (SQLException e) {
			 e.printStackTrace();
			System.out.println("데이터를 입력하는데 실패 하였습니다.");
			
			String sql2 = "select * from Departments";
			
			try {
				pstmt = conn.prepareStatement(sql2);
				rs = pstmt.executeQuery();

				
			System.out.println("---------------------- 부서정보 시스템 조회----------------------");
			System.out.println("부서ID" + "\t\t" + "부서이름" + "\t" + "매니저ID" + "\t" + "지역ID");			
			System.out.println("------------------------------------------------------------");
			
			
			while(rs.next()) {
				int D_id = rs.getInt("Department_id");
				String D_name = rs.getString("Department_NAME");
				int M_id = rs.getInt("Manager_ID");
				int L_id = rs.getInt("Location_ID");
				
				System.out.println(D_id + "\t" + D_name + "\t" + M_id + "\t" + L_id);
			}
			
			System.out.println("데이터를 성공적으로 입력 하였습니다.");
		} catch (SQLException e1) {
			 e1.printStackTrace();
			System.out.println("데이터를 입력하는데 실패 하였습니다.");
		}

		} finally {
			try {
				if (rs != null) {	rs.close();	}
				if (pstmt != null) { pstmt.close();	}
				if (conn != null) {	conn.close();	}
				System.out.println("데이터베이스를 닫는데 성공하였습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("데이터베이스를 닫는데 실패하였습니다.");
			}
		}
	}
}


		
	


		
	

		
	


