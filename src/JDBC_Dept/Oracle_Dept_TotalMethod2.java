package JDBC_Dept;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Oracle_Dept_TotalMethod2 {

	public static void main(String[] args) {
		
		Oracle_Dept_Sub ods = new Oracle_Dept_Sub();
				
		while(true) {
			System.out.println("---------------------");
			System.out.println("  부서 정보 시스템 메뉴        ");
			System.out.println("---------------------");
			System.out.println("1.부서별 정보 입력              ");
			System.out.println("2.부서별 정보 조회              ");
			System.out.println("3.부서별 정보 수정              ");
			System.out.println("4.부서별 정보 삭제              ");
			System.out.println("5.부서별 정보 프로그 종료     ");
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
			//ods.update(conn);
			break;
		case 4 :
			//ods.delete(conn);
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
