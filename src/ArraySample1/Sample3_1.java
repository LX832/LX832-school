package ArraySample1;

import java.util.Scanner;

public class Sample3_1 {
	


		public static void main(String[] args) {
			int cnt = 0;
			int count;
			
			
	
			Scanner sc = new Scanner(System.in);
			System.out.println("카운트 입력");
			count = sc.nextInt();
		
			int Data[] = new int[count];
		
			for(int i=0; i< Data.length; i++) {
				Data[i] = sc.nextInt();
			}
			do {
				cnt++;
			System.out.println("데이터를 입력하셈");
			int SearchData = sc.nextInt();
		
		
			for(int i=0; i < Data.length; i++) {
				if(SearchData == Data[i]) {
				System.out.println(Data[i] +"는" + i +"번째");
				}
				
		
			}
			
			}while(cnt < count);
}
			
}

