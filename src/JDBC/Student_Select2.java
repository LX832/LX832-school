package JDBC;

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
public class Student_Select2 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// 1.JDBC Loading
		String driver = "oracle.jdbc.OracleDriver"; // String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";// Express Edition Version
		// String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";// oracle 11g standard
		// Version
		// String url = "jdbc:oracle:thin:@210.112.234.67:1521:xe";//공인 IP

		String id = "LX832";
		String password = "dlwhdud1";

		Connection conn = null;
		PreparedStatement pstmt = null;// 보안상 이유로 권장, Query => select
		ResultSet rs = null;

		// 2.DBConnection
		try {
			Class.forName(driver);
			System.out.println("드라이버 연결에 성공하였습니다.!!!");
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("드라이버 연결에 실패하였습니다.!!!");
		}

		// 3. 사용자 인증
		try {
			conn = DriverManager.getConnection(url, id, password);
			System.out.println("사용자 인증을 성공적으로 연결하였습니다.");
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("사용자 인증을 실패 하였습니다.");
		}

		// 4.PreparedStatement : 명령 발행과 실행(Query)
		String sql = "select * from student";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("데이터를 성공적으로 조회 하였습니다.");
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("데이터를 성공적으로 조회 하였습니다.");
		}

		// 5.data output
		System.out.println("------------------------------- 학생정보 시스템 --------------------------------");
		System.out.println(
				"학번" + "\t" + "이름" + "\t" + "학과" + "\t" + "학년" + "\t" + "반" + "\t" + "성별" + "\t" + "키" + "\t" + "몸무게");
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

				System.out.println(stu_No + "\t" + stu_Name + "\t" + stu_Dept + "\t" + stu_Grade + "\t"
						+ stu_Class + "\t" + stu_Gender + "\t" + stu_Height + "\t" + stu_Weight);

			}
			System.out.println("---------------------------------------------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이터를 출력하지 못했습니다.");
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
				System.out.println("데이터베이스를 닫는데 성공하였습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("데이터베이스를 닫는데 실패하였습니다.");
			}

		}

	}

}
