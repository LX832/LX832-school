package JDBC_Dept;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Oracle_Dept_Delete {

	private static String ino;
	private static int Department_ID;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Connection connect = null;//
		PreparedStatement pstmt = null;//
		ResultSet rs = null;//

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 연결에 성공하였습니다.!!!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결에 실패하였습니다.!!!");
		}

		try {
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			System.out.println("사용자 인증을 성공적으로 연결하였습니다.");
		} catch (SQLException e) {
			System.out.println("사용자 인증을 실패 하였습니다.");
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("********** 부서 정보 삭제 **********");

		System.out.println("삭제 대상이 되는 부서번호를 입력하세요.");
		try {
			ino = br.readLine();
		} catch (IOException e1) {
			// e1.printStackTrace();
			System.out.println("부서번호를 삭제하는데 문제가 발생하였습니다.");
		}
		Department_ID = Integer.parseInt(ino);

		String sql = "delete from Departments where Department_ID = ?";

		try {
			pstmt = connect.prepareStatement(sql);
			pstmt.setInt(1, Department_ID);

			pstmt.executeUpdate();
			System.out.println("삭제가 성공했습니다.~~~");
		} catch (SQLException e1) {
			// e1.printStackTrace();
			System.out.println("삭제가 실패했습니다.~~~");
		}

		try {
			String sql2 = "select * from Departments";

			pstmt = connect.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			System.out.println("데이터를 성공적으로 조회 하였습니다.");
		} catch (SQLException e1) {
			// e1.printStackTrace();
			System.out.println("데이터를 조회하는데 실패 하였습니다.");
		}

		try {
			System.out.println("-------------부서정보 시스템 조회-----------------------");
			System.out.println("부서ID" + "\t" + "부서명" + "\t\t\t" + "관리자ID" + "\t" + "지역ID");
			System.out.println("---------------------------------------------------");

			while (rs.next()) {
				int D_id = rs.getInt("Department_ID");
				String D_name = rs.getString("Department_NAME");
				int M_id = rs.getInt("Manager_ID");
				int L_id = rs.getInt("Location_ID");

				System.out.println(D_id + "\t" + D_name + "\t\t" + M_id + "\t" + L_id);

			}
			System.out.println("---------------------------------------------------------------------------");
		} catch (Exception e) {
			System.out.println("돌발상황이 발생하였습니더. 확인하시고 조치바랍니다.");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connect != null) {
				try {
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}


		
			
		

	
	
	



		
	


		
	

		
	


