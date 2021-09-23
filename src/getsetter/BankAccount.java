package getsetter;

import java.util.Scanner;

/*한국 소프트웨어 산업은행이 있습니다.
 * 이 은행에 계좌를 개설하고, 예금 입금, 출금, 종료하는 프로그램을 작성
 * 1. 계좌생성 : 계좌번호, 예금주, 초기입금액
 * 2. 계좌목록(리스트) : 계좌번호, 예금주, 잔액
 * 3. 입금 : 계좌번호, 입금액
 * 4. 출금 : 계좌번호, 출금액
 * 5. 종료 : 프로그램 종료
 * 
 * 
 * 
 */
public class BankAccount {
	
	private static Scanner sc = new Scanner(System.in);
	private static Account[] aArray = new Account[1000];

	public static void main(String[] args) {
		boolean running = true;
		while(running) {
			
		
		
		
		System.out.println("--------------------------");
		System.out.println("-1.계좌생성------------------------");
		System.out.println("-2.계좌목록------------------------");
		System.out.println("-3.입금------------------------");
		System.out.println("-4.출금------------------------");
		System.out.println("-5.프로그램 종료------------------------");
		System.out.println("-------------------------");
		
		int selectNO = sc.nextInt();
		
		switch (selectNO) {
		case 1: CreateAccpimt(); break;
		case 2: AccountList(); break;
		case 3: Deposit(); break;
		case 4: withDraw(); break;
		case 5: System.out.println("프로그램 종료 집에가자!!!!!!");
		running = false;
		}
		}
	}
	private static void withDraw() {
		// TODO Auto-generated method stub
		
	}
	private static void Deposit() {
		// TODO Auto-generated method stub
		
	}
	private static void AccountList() {
		System.out.println("----------------------");
		System.out.println("----Account List----");
		System.out.println("----------------------");
		
		for (int i=0; i < aArray.length; i++) {
			Account account = new aArray[i];
			
			if(account != null) {
				System.out.println(account.getAccountnumber());
				System.out.println(account.getAccountname());
				System.out.println(account.getInitValue());
			}
		}
		
	}
	// account create
	private static void CreateAccpimt() {
		
		System.out.println("----------------------");
		System.out.println("----Account Create----");
		System.out.println("----------------------");
		
		System.out.println("계좌번호 : ");
		String accountnumber = sc.next();
		
		System.out.println("예금주 : ");
		String accountname = sc.next();
		
		System.out.println("초기입금액 : ");
		int initValue = sc.nextInt();
		
		Account newAcconut = new Account(accountnumber, accountname, initValue );
		
	}

}
