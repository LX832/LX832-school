package JDBC_Dept;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 1.수정, 삭제 프로그램 작성
 * 2.method모듈로 작성 실행
 * 
 */
public class Oracle_Dept_Update {

	private static String ino;
	private static int Department_ID;
	private static String Department_NAME;
	private static int Manager_ID;
	private static int Location_ID;

	public static void main(String[] args) 	{
			
			String driver = "oracle.jdbc.OracleDriver"; 
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "hr";
			String pw = "hr";

			Connection connect = null;// 
			PreparedStatement pstmt = null;// 
			ResultSet rs = null;// 

			
			try {
				Class.forName(driver);
				System.out.println("드라이버 연결에 성공하였습니다.!!!");
			} catch (ClassNotFoundException e) {
				// e.printStackTrace();
				System.out.println("드라이버 연결에 실패하였습니다.!!!");
			}

			// 3. 사용자 인증
			try {
				connect = DriverManager.getConnection(url, id, pw);
				System.out.println("사용자 인증을 성공적으로 연결하였습니다.");
			} catch (SQLException e) {
				// e.printStackTrace();
				System.out.println("사용자 인증을 실패 하였습니다.");
			}

			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("********** 부서 정보 수정 **********");
			
			System.out.println("수정할 부서번호를 입력하세요.");		
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
			
			System.out.println("수정 할 관리자ID를 입력하세요.");		
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
			}catch(Exception e)	{
				System.out.println("돌발상황이 발생하였습니더. 확인하시고 조치바랍니다.");	 		
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
}