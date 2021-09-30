package JDBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/* OOO 프로젝트
 * 소스 작성일자: 2021년 9월 28일 오전 9시37분
 * 컴파일 일자: 2021년 9월 28일
 * 소스 작성자: 현대빈
 * use DB: 오라클 11g Express Edition
 * 
 * Student 테이블의 데이터를 조회하는 프로그램을 작성
 * 
 */
public class Student_Delete2 {

	private static int stu_no;
	private static String ino;

	@SuppressWarnings("unused")
	public static void main(String[] args) {		
		String driver = "oracle.jdbc.OracleDriver"; 
		String url = "jdbc:oracle:thin:@192.168.0.28:1521:xe";

		String id = "LX832";
		String pw = "dlwhdud1";// 

		Connection conn = null;// 
		PreparedStatement pstmt = null;// 
		ResultSet rs = null;//
		
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
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("********** 학생 정보 시스템 테이블 삭제 **********");
		
		System.out.println("삭제 대상이 되는 학생번호를 입력하세요.");		
		try {
			ino = br.readLine();
		} catch (IOException e1) {
			//e1.printStackTrace();
			System.out.println("학번을 삭제하는데 문제가 발생하였습니다.");
		}		
		stu_no = Integer.parseInt(ino); // 학번 입력
		
		String sql = "delete from student where stu_no = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stu_no);
			
			pstmt.executeUpdate();
			System.out.println("삭제가 성공했습니다.~~~");
		} catch (SQLException e1) {
			//e1.printStackTrace();
			System.out.println("삭제가 실패했습니다.~~~");
		}
		
		
		String sql2 = "select * from student";

		try {
			pstmt = conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			System.out.println("데이터를 성공적으로 조회 하였습니다.");
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("데이터를 조회를 실패 하였습니다.");
		}
		
		System.out.println("------------------------------- 학생정보 시스템 --------------------------------");
		System.out.println("학번" + "\t\t" + "이름" + "\t" + "학과" + "\t" + "학년" + "\t" + "반" + "\t" + "성별" + "\t" + "키"
				+ "\t" + "몸무게");
		System.out.println("---------------------------------------------------------------------------");

		try {
			while (rs.next()) { 
				int stu_No = rs.getInt("stu_no");
				String stu_Name = rs.getString("stu_name");
				String stu_Dept = rs.getString("stu_dept");
				int stu_Grade = rs.getInt("stu_grade");
				String stu_Class = rs.getString("stu_class");
				String stu_Gender = rs.getString("stu_gender");
				int stu_Height = rs.getInt("stu_height");
				int stu_Weight = rs.getInt("stu_weight");

				System.out.println(stu_No + "\t" + stu_Name + "\t" + stu_Dept + "\t" + stu_Grade + "\t" + stu_Class
						+ "\t" + stu_Gender + "\t" + stu_Height + "\t" + stu_Weight);

			}
			System.out.println("---------------------------------------------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이터를 출력하지 못했습니다.");
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
