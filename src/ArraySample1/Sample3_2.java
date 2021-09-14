package ArraySample1;

import java.util.Scanner;

public class Sample3_2 {
	


		public static void main(String[] args) {
			
			int count;
			
			
	
			Scanner sc = new Scanner(System.in);
			System.out.println("카운트 입력");
			count = sc.nextInt();
		
			int Data[] = new int[count];
		
			for(int i=0; i< Data.length; i++) {
				Data[i] = sc.nextInt();
			}
			
			boolean run = true;
			
			while(run) {
				
			System.out.println("데이터를 입력하셈");
			int SearchData = sc.nextInt();
		
		
			for(int i=0; i < Data.length; i++) {
				if(SearchData == Data[i]) {
					System.out.println(Data[i] +"는" + i +"번째");
		
				}				
			}
			if(run) {
				System.out.println("데이터 검색을 계속하시겠습니까?(Y/N)");
				String str = sc.next(); //문자열을 입력
				
				if(str.equals("y")) {
					continue;
				}else {
					break;
				}
			}
		}
	}
}
		


