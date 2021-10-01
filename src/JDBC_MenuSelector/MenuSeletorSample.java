package JDBC_MenuSelector;

/*
 * CRUD 표현 실행
 * 명령행 입력으로 명령을 입력하여 실행 결과를 출력하도록 프로그래밍 하세요.
 * select * from student;
 * delete * from Departments where Department_ID = 200;
 * update student set aaa, bbb, ccc where stu_id = 100;
 * insert into student values(         );
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuSeletorSample {

	//클래스 변수	

	private String cm;
	private String ino;
	private int userid;
	private String username;
	private String address;
	private String telphone;
	private int stu_no;
	private String stu_dept;
	private String stu_grade;
	private String stu_class;
	
	static Connection connect;//연결 역할을 하는 클래스
	static PreparedStatement pstmt = null;//명령 실행
	static ResultSet rs = null;

	public Connection DBconnect() throws ClassNotFoundException, SQLException {
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); 		
		connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LX832", "dlwhdud1"); 
		
		return connect;
	}
	public void select(Connection conn) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("********** 유저 정보 수정 **********");
		
		System.out.println("입력할 명령어를 입력하세요.");		
		try {
			cm = br.readLine();
		} catch (IOException e1) {
			//e1.printStackTrace();
			System.out.println("명령어를 입력하는데 문제가 발생하였습니다.");
		}				 
		
		try {
			String sql = cm;
			
			pstmt = connect.prepareStatement(sql);
			rs = pstmt.executeQuery();			
			System.out.println(cm);
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("데이터를 성공적으로 조회 하였습니다.");
		}
			System.out.println("------------------------------- 학생정보 시스템 --------------------------------");
			System.out.println("학번" + "\t" + "이름" + "\t" + "학과" + "\t" + "학년" + "\t" + "반" + "\t" + "성별" + "\t" + "키" + "\t" + "몸무게");
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
			
				System.out.println("--------------------------------------------------------");
			}catch(Exception e) {
				System.out.println("돌발상황이 발생하였습니다. 확인하시고 조치바랍니다.");	 		
			}finally {
				if (rs != null) {	
				try {
					rs.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}	}
				if (pstmt != null) { 
				try {
					pstmt.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}	}
				if (connect != null) {	
				try {
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	}
			}
		}
	
	public void delete(Connection conn) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			System.out.println("********** 부서 정보 삭제 **********");
	
			System.out.println("명령어를 입력하세요.(address)");
			try {
				cm = br.readLine();
			} catch (IOException e1) {
				// e1.printStackTrace();
				System.out.println("유저를 삭제하는데 문제가 발생하였습니다.");
			}
			
	
		
	
			try {
				String sql = cm;
				pstmt = connect.prepareStatement(sql);					
				pstmt.executeUpdate();
				System.out.println("삭제가 성공했습니다.");
			} catch (SQLException e1) {
				// e1.printStackTrace();
				System.out.println("삭제가 실패했습니다.");
			}
	
			try {
				String sql2 = "select * from address";
	
				pstmt = connect.prepareStatement(sql2);
				rs = pstmt.executeQuery();
				System.out.println("데이터를 성공적으로 조회 하였습니다.");
			} catch (SQLException e1) {
				// e1.printStackTrace();
				System.out.println("데이터를 조회하는데 실패 하였습니다.");
			}
	
			try {
				System.out.println("------------------유저정보 시스템 조회-----------------------");
				System.out.println("유저ID" + "\t" + "유저명" + "\t\t\t" + "주소" + "\t" + "핸드폰번호");
				System.out.println("-------------------------------------------------------");
				
				while(rs.next()) {
					int U_id = rs.getInt("userid");
					String U_name = rs.getString("username");
					String AD = rs.getString("address");
					String PN = rs.getString("telphone");
					
					System.out.println(U_id + "\t" + U_name + "\t\t" + AD + "\t" + PN);
	
				}
				System.out.println("-------------------------------------------------------");
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
	
				
	
		public void update(Connection conn) {
				
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("********** 유저 정보 수정 **********");
			
			System.out.println("입력할 명령어를 입력하세요.");		
			try {
				cm = br.readLine();
			} catch (IOException e1) {
				//e1.printStackTrace();
				System.out.println("명령어를 입력하는데 문제가 발생하였습니다.");
			}				 
			
			try {
				String sql = cm;
				pstmt = connect.prepareStatement(sql);					
				pstmt.executeUpdate();
				System.out.println("수정이 성공했습니다.");
			} catch (SQLException e1) {
				// e1.printStackTrace();
				System.out.println("수정이 실패했습니다.");
			}
				try {
					String sql2 = "select * from student";
		
					pstmt = connect.prepareStatement(sql2);
					rs = pstmt.executeQuery();
					System.out.println("데이터를 성공적으로 조회 하였습니다.");
				} catch (SQLException e1) {
					// e1.printStackTrace();
					System.out.println("데이터를 조회하는데 실패 하였습니다.");
				}
			
			
				System.out.println("------------------------------- 학생정보 시스템 --------------------");
				System.out.println("학번" + "\t\t" + "학과" + "\t" + "학년" + "\t" + "반");
				System.out.println("---------------------------------------------------------------");

				try {	
					while (rs.next()) { // next() ? 다음에 읽어올 데이터가 존재하는가?
						int stu_No = rs.getInt("stu_no");						
						String stu_Dept = rs.getString("stu_dept");
						int stu_Grade = rs.getInt("stu_grade");
						String stu_Class = rs.getString("stu_class");

						System.out.println(stu_No +"\t" + stu_Dept + "\t" + stu_Grade + "\t" + stu_Class);

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

		


	public void insert(Connection conn) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("********** 유저 정보 입력 **********");
		
		System.out.println("명령어를 입력하세요.");		
		try {
			cm = br.readLine(); // 반  입력
		} catch (IOException e1) {
			System.out.println("명령어를 입력하는데 문제가 발생하였습니다.");
		}		
		
		

		try {
			String sql = cm;
			pstmt = conn.prepareStatement(sql);			
			pstmt.executeUpdate();
			System.out.println("데이터를 성공적으로 수정 하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이터를 수정하는데 실패 하였습니다.");
		}

		// 5.data output
		String sql2 = "select * from student";
		
		try {
			pstmt = conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			System.out.println("데이터를 성공적으로 조회 하였습니다.");
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("데이터를 조회하는데 실패 하였습니다.");
		}
			
		System.out.println("------------------------------- 학생정보 시스템 --------------------");
		System.out.println("학번" + "\t\t" + "학과" + "\t" + "학년" + "\t" + "반");
		System.out.println("---------------------------------------------------------------");

		try {	
			while (rs.next()) { // next() ? 다음에 읽어올 데이터가 존재하는가?
				int stu_No = rs.getInt("stu_no");						
				String stu_Dept = rs.getString("stu_dept");
				int stu_Grade = rs.getInt("stu_grade");
				String stu_Class = rs.getString("stu_class");

				System.out.println(stu_No +"\t" + stu_Dept + "\t" + stu_Grade + "\t" + stu_Class);

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