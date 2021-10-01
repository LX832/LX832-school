package JDBC_Dept;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Oracle_Dept_Sub2 {

	//클래스 변수	
	private String ino;
	private int Department_ID;
	private String Department_NAME;
	private int Manager_ID;
	private int Location_ID;
	
	static Connection connect;//연결 역할을 하는 클래스
	static PreparedStatement pstmt = null;//명령 실행
	static ResultSet rs = null;

	public Connection DBconnect() throws ClassNotFoundException, SQLException {
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); 		
		connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); 
		
		return connect;
	}

	public void insert(Connection conn) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("********** 부서 정보 입력 **********");
		
		System.out.println("부서ID를 입력하세요.");		
		try {
			ino = br.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("부서ID를 입력하는데 문제가 발생하였습니다.");
		}		
		Department_ID = Integer.parseInt(ino); // 학번 입력
		
		
		System.out.println("부서명을 입력하세요.");		
		try {
			Department_NAME = br.readLine(); // 이름 입력
		} catch (IOException e1) {
			System.out.println("부서명을 입력하는데 문제가 발생하였습니다.");
		}
		
		System.out.println("매니저ID를 입력하세요.");		
		try {
			ino = br.readLine(); // 반  입력
		} catch (IOException e1) {
			System.out.println("매니저ID를 입력하는데 문제가 발생하였습니다.");
		}
		Manager_ID = Integer.parseInt(ino);
		
		System.out.println("회사위치를 입력하세요.");		
		try {
			ino = br.readLine(); // 반  입력
		} catch (IOException e1) {
			System.out.println("회사위치를 입력하는데 문제가 발생하였습니다.");
		}
		Location_ID = Integer.parseInt(ino); 
		
		String sql = "insert into Departments(Department_ID, Department_NAME, Manager_ID, LOCATION_ID)"
					+ "values(?, ?, ?, ?)";
		
		try {
			pstmt = connect.prepareStatement(sql);
			
			pstmt.setInt(1, Department_ID);
			pstmt.setString(2, Department_NAME);			
			pstmt.setInt(3, Manager_ID);			
			pstmt.setInt(4, Location_ID);
						
			pstmt.executeUpdate();// insert, delete, update 공용으로 사용합니다.
			System.out.println("데이터를 성공적으로 입력 하였습니다.");
		} catch (SQLException e) {
			 e.printStackTrace();
			System.out.println("데이터를 입력하는데 실패 하였습니다.");
		}
		
	}

	public void select(Connection conn) {
		try {
			String sql = "select * from Departments order by Department_ID";
				
			pstmt = connect.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
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
			}catch(Exception e) {
				System.out.println("돌발상황이 발생하였습니더. 확인하시고 조치바랍니다.");	 		
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
			

	public void update(Connection conn) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("********** 부서 정보 수정 **********");
			
			System.out.println("수정할 부서ID를 입력하세요.");		
			try {
				ino = br.readLine();
			} catch (IOException e1) {
				//e1.printStackTrace();
				System.out.println("부서번호를 입력하는데 문제가 발생하였습니다.");
			}		
			Department_ID = Integer.parseInt(ino); // 학번을 기준으로 수정 
			
			
			System.out.println("수정할 부서명를 입력하세요.");			
			try {
				Department_NAME = br.readLine(); // 학과 수정 입력
			} catch (IOException e1) {
				System.out.println("부서명을 입력하는데 문제가 발생하였습니다.");
			}		
			
			System.out.println("수정 할 관리자 ID를 입력하세요.");		
			try {
				ino = br.readLine(); // 학년 수정 입력
			} catch (IOException e1) {
				System.out.println("관리자 ID를 입력하는데 문제가 발생하였습니다.");
			}
			Manager_ID = Integer.parseInt(ino);
			
			
			System.out.println("수정할 회사위치를 입력하세요.");			
			try {
				ino = br.readLine(); // 반 수정 입력
			} catch (IOException e1) {
				System.out.println("회사위치를 입력하는데 문제가 발생하였습니다.");
			}
			Location_ID = Integer.parseInt(ino);
			
			String sql = "update Departments set Department_NAME = ?,  Manager_ID = ?, Location_ID = ? where Department_ID = ?";

			try {
				pstmt = connect.prepareStatement(sql);
				
				pstmt.setString(1, Department_NAME);
				pstmt.setInt(2, Manager_ID);
				pstmt.setInt(3, Location_ID);
				pstmt.setInt(4, Department_ID);		
				
				pstmt.executeUpdate();
				System.out.println("데이터를 성공적으로 수정 하였습니다.");
			} catch (SQLException e) {
				// e.printStackTrace();
				System.out.println("데이터를 수정하는데 실패 하였습니다.");
			}

			try {
				String sql2 = "select * from Departments";
					
				pstmt = connect.prepareStatement(sql2);
				rs = pstmt.executeQuery();
				System.out.println("데이터를 성공적으로 조회 하였습니다.");
			} catch (SQLException e1) {
				//e1.printStackTrace();
				System.out.println("데이터를 조회하는데 실패 하였습니다.");
			}
			
			
			//====================================표만들기=======================================
			
			
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
			
			
			//====================================표만들기=======================================
			
			
			}catch(Exception e)	{
				System.out.println("돌발상황이 발생하였습니다. 확인하시고 조치 바랍니다.");	 		
			}finally{
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
	public void delete(Connection conn) {
		
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
			System.out.println("삭제가 성공했습니다.");
		} catch (SQLException e1) {
			// e1.printStackTrace();
			System.out.println("삭제가 실패했습니다.");
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