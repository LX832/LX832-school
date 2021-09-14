import java.util.Scanner;


public class HotelSampleTT {
	//filed area
	//global varivable(C) = class varivable(Jave)
	//int totalsum= 0; 라고 안해도됨 (자동초기화 기능이 있다)
	static int totalsum;
			
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("행을 입력하세요. (층)");
			int su1 = sc.nextInt();
			System.out.println("열을 입력하세요. (호)");
			int su2 = sc.nextInt();
			
			int kosmos[][]=new int [su1][su2];
			
			System.out.println("각층 각호의 인원수를 입력하세요.");
			for(int i = 0; i < kosmos.length; i++) {
				
			
			for(int j = 0; j < kosmos[i].length; j++) {
				kosmos[i][j] = sc.nextInt();
			}
			}
			int sum=0;
			double aver = 0.0;
			
			for(int i=0; i<kosmos.length; i++) {
				sum = 0;
				for(int j=0; j < kosmos[i].length; j++) {
					sum+=kosmos[i][j];
					
					
				}
				aver = sum / (double)kosmos[i].length;
				System.out.println("전체인원수:" + sum + "각 층의 평균 인원수" + aver);
			}
			
			
			System.out.println();
						
			
			System.out.println("각층 각호의 인원수를 출력하세요");
			for(int i=0; i<kosmos.length; i++)
				for(int j=0; j<kosmos[i].length; j++) {
					System.out.println(kosmos[i][j]+ "");
					
				}
			System.out.println();
			
		}
	
	}

