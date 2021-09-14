package ArraySample1;

import java.util.Scanner;

public class Sample4 {

	public static void main(String[] args) {
			
			
			Scanner scan = new Scanner(System.in);
			System.out.println("처리하고자 과목 수 입력");
			int stc = scan.nextInt();
			
			int sco[] = new int[stc];
			int mo = 0;
			int sum = 0;
			
			for(int i=0; i < sco.length; i++) {
				mo = scan.nextInt();
				sco[i] = mo;
				sum +=sco[i];
				
			int total = sum;
			double aver = total/ 3.0;

			
			
		   System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균\t랭킹");
		   
			}
			
			}
}