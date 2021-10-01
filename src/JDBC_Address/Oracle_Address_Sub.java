package JDBC_Address;
/*
 * 주소록 관리 프로그램 개발
 *  - 조회,입력,수정,삭제 기능을 구현하여 출력하세요.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Oracle_Address_Sub {

	//클래스 변수	
	private String ino;
	private int seq;	
	private int userid;
	private String telphone;
	private String address;
	private String username;
	
	static Connection connect;//연결 역할을 하는 클래스
	static PreparedStatement pstmt = null;//명령 실행
	static ResultSet rs = null;

	public Connection DBconnect() throws ClassNotFoundException, SQLException {
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); 		
		connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LX832", "dlwhdud1"); 
		
		return connect;
	}

	public void insert(Connection conn) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("********** 유저 정보 입력 **********");
		
		System.out.println("유저ID를 입력하세요.");		
		try {
			ino = br.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("유저ID를 입력하는데 문제가 발생하였습니다.");
		}		
		userid = Integer.parseInt(ino); 
		
		
		System.out.println("유저명을 입력하세요.");		
		try {
			username = br.readLine(); // 이름 입력
		} catch (IOException e1) {
			System.out.println("유저명을 입력하는데 문제가 발생하였습니다.");
		}
		
		System.out.println("주소를 입력하세요.");		
		try {
			address = br.readLine(); // 반  입력
		} catch (IOException e1) {
			System.out.println("주소를 입력하는데 문제가 발생하였습니다.");
		}
		
		
		System.out.println("핸드폰 번호를 입력하세요.");		
		try {
			telphone = br.readLine(); // 반  입력
		} catch (IOException e1) {
			System.out.println("핸드폰 번호를 입력하는데 문제가 발생하였습니다.");
		}		
		
		String sql = "insert into address(userid, username, address, telphone)"
					+ "values(?, ?, ?, ?)";
		
		try {
			pstmt = connect.prepareStatement(sql);
			
			pstmt.setInt(1, userid);
			pstmt.setString(2, username);			
			pstmt.setString(3, address);			
			pstmt.setString(4, telphone);
						
			pstmt.executeUpdate();// insert, delete, update 공용으로 사용합니다.
			System.out.println("데이터를 성공적으로 입력 하였습니다.");
		} catch (SQLException e) {
			 e.printStackTrace();
			System.out.println("데이터를 입력하는데 실패 하였습니다.");
		}
		
	}

	public void select(Connection conn) {
		try {
			String sql = "select * from address order by userid";
				
			pstmt = connect.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
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
			System.out.println("--------------------------------------------------------");
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
			
			System.out.println("********** 유저 정보 수정 **********");
			
			System.out.println("수정할 유저ID를 입력하세요.");		
			try {
				ino = br.readLine();
			} catch (IOException e1) {
				//e1.printStackTrace();
				System.out.println("유저번호를 입력하는데 문제가 발생하였습니다.");
			}		
			userid = Integer.parseInt(ino); // 학번을 기준으로 수정 
			
			
			System.out.println("수정할 유저명를 입력하세요.");			
			try {
				username = br.readLine(); // 학과 수정 입력
			} catch (IOException e1) {
				System.out.println("부서명을 입력하는데 문제가 발생하였습니다.");
			}		
			
			System.out.println("수정할 주소를 입력하세요.");		
			try {
				address = br.readLine(); // 학년 수정 입력
			} catch (IOException e1) {
				System.out.println("주소를 입력하는데 문제가 발생하였습니다.");
			}
			
			
			
			System.out.println("수정할 핸드폰 번호를 입력하세요.");			
			try {
				telphone = br.readLine(); // 반 수정 입력
			} catch (IOException e1) {
				System.out.println("핸드폰 번호를 입력하는데 문제가 발생하였습니다.");
			}			
			
			String sql = "update address set username = ?,  address = ?, telphone = ? where userid = ?";

			try {
				pstmt = connect.prepareStatement(sql);
				
				pstmt.setString(1, username);
				pstmt.setString(2, address);
				pstmt.setString(3, telphone);
				pstmt.setInt(4, userid);		
				
				pstmt.executeUpdate();
				System.out.println("데이터를 성공적으로 수정 하였습니다.");
			} catch (SQLException e) {
				// e.printStackTrace();
				System.out.println("데이터를 수정하는데 실패 하였습니다.");
			}

			try {
				String sql2 = "select * from address";
					
				pstmt = connect.prepareStatement(sql2);
				rs = pstmt.executeQuery();
				System.out.println("데이터를 성공적으로 조회 하였습니다.");
			} catch (SQLException e1) {
				//e1.printStackTrace();
				System.out.println("데이터를 조회하는데 실패 하였습니다.");
			}
			
			
			//====================================표만들기=======================================
			
			
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

		System.out.println("삭제 대상이 되는 유저번호를 입력하세요.");
		try {
			ino = br.readLine();
		} catch (IOException e1) {
			// e1.printStackTrace();
			System.out.println("유저를 삭제하는데 문제가 발생하였습니다.");
		}
		userid = Integer.parseInt(ino);

		String sql = "delete from address where userid = ?";

		try {
			pstmt = connect.prepareStatement(sql);
			pstmt.setInt(1, userid);

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
	
}