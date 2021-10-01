package JDBC_MenuSelector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuSeletorSampleTotal {

	public static void main(String[] args) {
		
		MenuSeletorSample ods = new MenuSeletorSample();
				
		while(true) {
			System.out.println("---------------------");
			System.out.println("  SQL 시스템 실행시켜보기   ");
			System.out.println("---------------------");
			System.out.println("1.select			 ");
			System.out.println("2.delete             ");
			System.out.println("3.update             ");
			System.out.println("4.insert             ");
			System.out.println("5.부서별 정보 프로그램 종료   ");
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
			ods.select(conn);			
			break;			
		case 2:
			ods.delete(conn);
			
			break;
		case 3:
			ods.update(conn);
			break;
		case 4 :
			ods.insert(conn);
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
