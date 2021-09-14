package ArraySample1;

import java.util.Random;
import java.util.Scanner;

public class Sample3 {
	
	public static void main(String[] args) {
		/*원하는 데이터 찾기
		 * 임의의 수를 N개 입력받아서, 찾고자 하는 데이터의 위치가
		 * 어디인지를 찾아서 그 index값을 출력하세요.
		 * 1차원 배열 사용.
		 * int a[] = new int[5]
		 * String str[] = new String[5];
		 * 
		 * -----------------------------------------
		 * a		b		c		d		e
		 * -----------------------------------------
		 * 10		20		30		40		50
		 * -----------------------------------------
		 * 100번지   104번지  108번지  112번지  116번지
		 * [0]		[1]		[2]		[3]		[4]
		 
		
		Random RR = new Random();
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("배열수 정하기");
		int scan1 = scan.nextInt();
		int M[] = new int[scan1];
		//int M[] = {RR.nextInt()};
		
		
		
		for(int i=0; i<=scan1; i++ ) {
				
		System.out.println(M[i]);
		*/
		Scanner sc = new Scanner(System.in);
		System.out.println("카운트 입력");
		int count = sc.nextInt();
		
		int Data[] = new int[count];
		
		for(int i=0; i< Data.length; i++) {
			Data[i] = sc.nextInt();
		}
		System.out.println("데이터를 입력하셈");
		int SearchData = sc.nextInt();
		
		for(int i=0; i < Data.length; i++) {
			if(SearchData == Data[i]) {
				System.out.println(Data[i] +"는" + i +"번째");
			}else {
				System.out.println("데이터없음");
			}
		}	
	}
		
	
}


