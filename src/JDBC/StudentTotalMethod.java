package JDBC;

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

/* JDBC 적용 
 * 1.오라클 드라이버 로딩
 * 2.사용자 인증 : 11g, 18c
 * 3.SQL 발행 : select, delete, update, insert
 * 4.결과 출력
 * - 입력, 수정, 삭제, 조회 프로그램 작성
 * <가정 : 만일 ~ 라면> 
 *  - 메소드 호출 하려면 클래스의 객체를 생성합니다.
 * StudentTotalMethod stm = new StudentTotalMethod();
 * 
 * 1.stm.Student_Insert();
 * 2.stm.Student_Update();
 * 3.stm.Student_Delete();
 * 4.stm.Student_Select();
 * 
 * - menu create
 * -------------------------
 * 1.학생정보 입력/조회
 * 2.학생정보 수정/조회
 * 3.학생정보 삭제/조회
 * 4.학생정보 조회 프로그램
 * 5.학생정보 프로그램 종료
 * -------------------------
 * 
 * - 처리 방법 고민(생각)
 * 1. 그냥 메소드 적용?
 * 2. 상속 이용하여 적용?
 * 3. 인터페이스 사용할 것인가? 추상 메소드 오버라이딩 적용 추가?
 * 4. 각각을 나누어서 상속이나 인터페이스를 적용?
 * 5. 공통 부분은 무엇이며, 어떻게 처리할 것인가?
 * 6. 입력에 사용할 클래스는?
 * 7. 처리에 사용할 클래스는?
 * 8. 결과를 출력할 때 어떤 클래스를 적용 할 것인가?
 * 9. 예외처리할 것은 어느 부분인가 파악?
 * 10. 데이터베이스의 데이터를 분석해 봅니다.
 * 11. 기타 사항을 생각해 봅니다.
 *  
 * 
 */
public class StudentTotalMethod {
	// field area : class variable, 자동 초기화,
	private String ino;
	private int stu_no;
	private String stu_name;
	private String stu_dept;
	private int stu_grade;
	private String stu_class;
	private String stu_gender;
	private double stu_height;
	private double stu_weight;

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// 정보의 은닉성, 공통모듈
	private void DBConnection() {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.28:1521:xe";
		String id = "hyun";
		String pw = "1234";

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
		System.out.println("1.학생정보 입력/조회                  ");
		System.out.println("2.학생정보 수정/조회                  ");
		System.out.println("3.학생정보 삭제/조회                  ");
		System.out.println("4.학생정보 조회 프로그램              ");
		System.out.println("5.학생정보 프로그램 종료              ");
		System.out.println("-------------------------");
	}

	// Student_Insert()
	private void Student_Insert() throws SQLException, IOException {

		DBConnection();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("********** 학생 정보 시스템 테이블 입력 **********");

		System.out.println("학생번호를 입력하세요.");
		try {
			ino = br.readLine();
			stu_no = Integer.parseInt(ino); // 학번 입력

			String sql = "select * from student";

			pstmt = conn.prepareStatement(sql);
			System.out.println(pstmt);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int xx = rs.getInt("stu_no");

				if (xx == stu_no) {
					System.out.println("중복된 학번 입니다. 다시 확인하고 입력해 주세요.");
					Student_Insert();
				}
			}
		} catch (SQLException e) {
			System.out.println("데이터를 조회를 실패 하였습니다.");
		} /*
			 * finally { if(rs != null) { rs.close(); } }
			 */

		System.out.println("이름을 입력하세요.");
		try {
			stu_name = br.readLine(); // 이름 입력
		} catch (IOException e1) {
			System.out.println("이름을 입력하는데 문제가 발생하였습니다.");
		}

		System.out.println("학과를 입력하세요.");
		try {
			stu_dept = br.readLine(); // 학과 입력
		} catch (IOException e1) {
			System.out.println("학과를 입력하는데 문제가 발생하였습니다.");
		}

		System.out.println("학년을 입력하세요.");
		try {
			ino = br.readLine(); // 학년 입력
		} catch (IOException e1) {
			System.out.println("학년을 입력하는데 문제가 발생하였습니다.");
		}
		stu_grade = Integer.parseInt(ino);

		System.out.println("반을 입력하세요.");
		try {
			stu_class = br.readLine(); // 반 입력
		} catch (IOException e1) {
			System.out.println("반을 입력하는데 문제가 발생하였습니다.");
		}

		System.out.println("성별을 입력하세요.");
		try {
			stu_gender = br.readLine(); // 반 입력
		} catch (IOException e1) {
			System.out.println("성별을 입력하는데 문제가 발생하였습니다.");
		}

		System.out.println("키를 입력하세요.");
		try {
			ino = br.readLine(); // 반 입력
		} catch (IOException e1) {
			System.out.println("키를 입력하는데 문제가 발생하였습니다.");
		}
		stu_height = Double.parseDouble(ino);

		System.out.println("몸무게를 입력하세요.");
		try {
			ino = br.readLine(); // 반 입력
		} catch (IOException e1) {
			System.out.println("몸무게를 입력하는데 문제가 발생하였습니다.");
		}
		stu_weight = Double.parseDouble(ino);

		String sql = "insert into student(stu_no, stu_name, stu_dept, stu_grade, stu_class, stu_gender, stu_height, stu_weight)"
				+ "values(?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, stu_no);
			pstmt.setString(2, stu_name);
			pstmt.setString(3, stu_dept);
			pstmt.setInt(4, stu_grade);
			pstmt.setString(5, stu_class);
			pstmt.setString(6, stu_gender);
			pstmt.setDouble(7, stu_height);
			pstmt.setDouble(8, stu_weight);

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
		stu_no = Integer.parseInt(ino); // 학번을 기준으로 수정

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
			System.out.println("삭제가 성공했습니다.");
		} catch (SQLException e1) {
			// e1.printStackTrace();
			System.out.println("삭제가 실패했습니다.");
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
