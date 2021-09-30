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


public class Oracle_Dept_TotalMethod {
	// field area : class variable, 자동 초기화,
	private static  String ino;
	private static  int Department_id;
	private static  String Department_name;
	private static  int Manager_id;
	private static  int Location_id;

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// 정보의 은닉성, 공통모듈
	private void DBConnection() {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pw = "hr";

		try {
			Class.forName(driver);
			System.out.println("드라이버 연결에 성공하였습니다.!!!");
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("드라이버 연결에 실패하였습니다.!!!");
		}

		try {
			conn = DriverManager.getConnection(url, id, pw);
			// System.out.println(conn);
			System.out.println("사용자 인증을 성공적으로 연결하였습니다.");
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("사용자 인증을 실패 하였습니다.");
		}
	}// end.

	private void Title() {
		System.out.println("-------------------------");
		System.out.println("-----부서 정보 시스템 메뉴-----");
		System.out.println("-------------------------");
		System.out.println("1.부서정보 입력                         ");
		System.out.println("2.부서정보 수정                         ");
		System.out.println("3.부서정보 삭제                         ");
		System.out.println("4.부서정보 조회                         ");
		System.out.println("5.부서정보 프로그램 종료              ");
		System.out.println("-------------------------");
	}

	// Student_Insert()
	private void Student_Insert() throws SQLException, IOException {

		DBConnection();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("********** 부서정보 시스템 테이블 입력 **********");

		System.out.println("부서번호를 입력하세요.");
		try {
			ino = br.readLine();
			Department_id = Integer.parseInt(ino); // 학번 입력

			String sql = "select * from ";

			pstmt = conn.prepareStatement(sql);
			System.out.println(pstmt);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int xx = rs.getInt("stu_no");

				if (xx == Department_id) {
					System.out.println("중복된 학번 입니다. 다시 확인하고 입력해 주세요.");
					Student_Insert();
				}
			}
		} catch (SQLException e) {
			System.out.println("데이터를 조회를 실패 하였습니다.");
		}
		
		System.out.println("이름을 입력하세요.");
		try {
			Department_name = br.readLine(); // 이름 입력
		} catch (IOException e1) {
			System.out.println("이름을 입력하는데 문제가 발생하였습니다.");
		}

		System.out.println("학년을 입력하세요.");
		try {
			ino = br.readLine(); // 학년 입력
		} catch (IOException e1) {
			System.out.println("학년을 입력하는데 문제가 발생하였습니다.");
		}
		Manager_id = Integer.parseInt(ino);

		System.out.println("반을 입력하세요.");

		try {
			ino = br.readLine(); // 반 입력
		} catch (IOException e1) {
			System.out.println("키를 입력하는데 문제가 발생하였습니다.");
		}
		Location_id = Integer.parseInt(ino);

		System.out.println("몸무게를 입력하세요.");

		String sql = "update Departments set Department_NAME = ?,  Manager_ID = ?, Location_ID = ? where Department_ID = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Department_id);
			pstmt.setString(2, Department_name);			
			pstmt.setInt(3, Manager_id);			
			pstmt.setInt(4, Location_id);
			
			pstmt.executeUpdate();
			System.out.println("데이터를 성공적으로 수정 하였습니다.");
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("데이터를 수정하는데 실패 하였습니다.");
		}

		try {
			String sql2 = "select * from Departments";
				
			pstmt = conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			System.out.println("데이터를 성공적으로 조회 하였습니다.");
		} catch (SQLException e1) {
			//e1.printStackTrace();
			System.out.println("데이터를 조회하는데 실패 하였습니다.");
		}
			
		try {
		System.out.println("-------------부서정보 시스템 조회-----------------------");
		System.out.println("부서ID" + "\t" + "부서명" + "\t\t\t" + "관리자ID" + "\t" + "지역ID");
		System.out.println("---------------------------------------------------");

			pstmt.executeUpdate();// insert, delete, update 공용으로 사용합니다.
			System.out.println("데이터를 성공적으로 입력 하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이터를 입력하는데 실패 하였습니다.");
		}

		String sql2 = "select * from student";

		try {
			pstmt = conn.prepareStatement(sql2);
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
		

		while(rs.next()) {
			int D_id = rs.getInt("Department_ID");
			String D_name = rs.getString("Department_NAME");
			int M_id = rs.getInt("Manager_ID");
			int L_id = rs.getInt("Location_ID");
			
			System.out.println(D_id + "\t" + D_name + "\t\t" + M_id + "\t" + L_id);
			
		}
			System.out.println("---------------------------------------------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이터를 출력하지 못했습니다.");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
				System.out.println("데이터베이스를 닫는데 성공하였습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("데이터베이스를 닫는데 실패하였습니다.");
			}
		}
	}

	// update() 처리 부분
	private void Student_Update() {

		DBConnection();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("********** 학생 정보 시스템 테이블 수정 **********");

		System.out.println("수정할 학생번호(int)를 입력하세요.");
		try {
			ino = br.readLine();
		} catch (IOException e1) {
			// e1.printStackTrace();
			System.out.println("학번을 입력하는데 문제가 발생하였습니다.");
		}
		Department_ID = Integer.parseInt(ino); // 학번을 기준으로 수정

		System.out.println("수정할 이름(string)를 입력하세요.");
		try {
			stu_name = br.readLine(); // 학과 수정 입력
		} catch (IOException e1) {
			System.out.println("이름을 입력하는데 문제가 발생하였습니다.");
		}

		System.out.println("수정할 학과(string)를 입력하세요.");
		try {
			stu_dept = br.readLine(); // 학과 수정 입력
		} catch (IOException e1) {
			System.out.println("학과를 입력하는데 문제가 발생하였습니다.");
		}

		System.out.println("수정할 학년(int)을 입력하세요.");
		try {
			ino = br.readLine(); // 학년 수정 입력
			stu_grade = Integer.parseInt(ino);
		} catch (IOException e1) {
			System.out.println("학년을 입력하는데 문제가 발생하였습니다.");
		}

		System.out.println("수정할 반(String)을 입력하세요.");
		try {
			stu_class = br.readLine(); // 반 수정 입력
		} catch (IOException e1) {
			System.out.println("반을 입력하는데 문제가 발생하였습니다.");
		}

		String sql = "update student set stu_name = ?, stu_dept = ?,  stu_grade = ?, stu_class = ? where stu_no = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, stu_name);
			pstmt.setString(2, stu_dept);
			pstmt.setInt(3, stu_grade);
			pstmt.setString(4, stu_class);
			pstmt.setInt(5, stu_no);

			pstmt.executeUpdate();
			System.out.println("데이터를 성공적으로 수정 하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이터를 수정하는데 실패 하였습니다.");
		}

		String sql2 = "select * from student";

		try {
			pstmt = conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			System.out.println("데이터를 성공적으로 조회 하였습니다.");
		} catch (SQLException e1) {
			// e1.printStackTrace();
			System.out.println("데이터를 조회하는데 실패 하였습니다.");
		}

		System.out.println("------------------------------- 학생정보 시스템 --------------------------------");
		System.out.println("학번" + "\t\t" + "이름" + "\t" + "학과" + "\t" + "학년" + "\t" + "반" + "\t" + "성별" + "\t" + "키"
				+ "\t" + "몸무게");
		System.out.println("---------------------------------------------------------------------------");

		try {
			while (rs.next()) { // next() ? 다음에 읽어올 데이터가 존재하는가?
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
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
				System.out.println("데이터베이스를 닫는데 성공하였습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("데이터베이스를 닫는데 실패하였습니다.");
			}
		}
	}

	// delete 부분 실행
	private void Student_Delete() {

		DBConnection();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("********** 학생 정보 시스템 테이블 삭제 **********");

		System.out.println("삭제 대상이 되는 학생번호를 입력하세요.");
		try {
			ino = br.readLine();
			stu_no = Integer.parseInt(ino);
			System.out.println(stu_no);
			
		} catch (IOException e1) {
			// e1.printStackTrace();
			System.out.println("삭제 대상이 되는 학번을 입력하는데 문제가 발생하였습니다.");
		}
		
		String sql = "delete from student where stu_no = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stu_no);

			pstmt.executeUpdate();
			System.out.println("삭제가 성공했습니다.~~~");
		} catch (SQLException e1) {
			// e1.printStackTrace();
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
				double stu_Height = rs.getDouble("stu_height");
				double stu_Weight = rs.getDouble("stu_weight");

				System.out.println(stu_No + "\t" + stu_Name + "\t" + stu_Dept + "\t" + stu_Grade + "\t" + stu_Class
						+ "\t" + stu_Gender + "\t" + stu_Height + "\t" + stu_Weight);

			}
			System.out.println("---------------------------------------------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이터를 출력하지 못했습니다.");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
				System.out.println("데이터베이스를 닫는데 성공하였습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("데이터베이스를 닫는데 실패하였습니다.");
			}
		}
	}

	// 조회 프로그램 실행
	private void Student_Select() {

		DBConnection();

		String sql = "select * from student order by stu_no";

		try {
			pstmt = conn.prepareStatement(sql);
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
			while (rs.next()) { // next() ? 다음에 읽어올 데이터가 존재하는가?
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
				if (rs != null) {
					rs.close();
					System.out.println(rs);
					
					if (pstmt != null) {
						pstmt.close();
						if (conn != null) {							
							conn.close();
						}
					}
				}
				System.out.println("데이터베이스를 닫는데 성공하였습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("데이터베이스를 닫는데 실패하였습니다.");
			}
		}
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws SQLException, IOException {
		StudentTotalMethod stm = new StudentTotalMethod();

		Scanner sc = new Scanner(System.in);

		try {

			while (true) {

				stm.Title();

				System.out.println("메뉴번호를 선택해 주세요.");
				int x = sc.nextInt();

				switch (x) {
				case 1:
					stm.Student_Insert();
					break;
				case 2:
					stm.Student_Update();
					break;
				case 3:
					stm.Student_Delete();
					break;
				case 4:
					stm.Student_Select();
					break;

				case 5:
					System.out.println("프로그램 종료.");
					System.exit(0);
				}
			}
		} catch (InputMismatchException ime) {
			System.out.println("데이터 형식이 잘못되었습니다. 확인바랍니다.");

		}
		stm.main(args);
	}

}