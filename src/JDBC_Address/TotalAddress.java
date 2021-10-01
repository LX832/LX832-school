package JDBC_Address;
/*
 * 주소록 관리 프로그램 개발
 *  - 조회,입력,수정,삭제 기능을 구현하여 출력하세요.
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class TotalAddress {

	public static void main(String[] args) {
		
		Oracle_Address_Sub ods = new Oracle_Address_Sub();
		
		while(true) {
			System.out.println("---------------------");
			System.out.println("  유저 정보 시스템 메뉴        ");
			System.out.println("---------------------");
			System.out.println("1.유저 정보 입력              ");
			System.out.println("2.유저 정보 조회              ");
			System.out.println("3.유저 정보 수정              ");
			System.out.println("4.유저 정보 삭제              ");
			System.out.println("5.유저 정보 프로그램 종료     ");
			System.out.println("---------------------");	
					
		Scanner sc = new Scanner(System.in);
		int menu = sc.nextInt();
		
		Connection conn = null; 
		try {
			conn = ods.DBconnect();
		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
		} 
		
		switch(menu) {
		case 1:
			ods.insert(conn);
			break;			
		case 2:
			ods.select(conn);
			break;
		case 3:
			ods.update(conn);
			break;
		case 4 :
			ods.delete(conn);
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");			
			System.exit(0);
		default :
			System.out.println("메뉴를 다시 입력해 주세요."); 
		}	
		}
	}
}
