package ArraySample2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*구구단을 만들어서 출력하세요
 *2차원 배열 사용(for 2개 사용)
 *int [][] gugudan = new int[8][8]
 * 
 */

public class A2sample2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("몇단할래?");
		int n = sc.nextInt();
		int m = sc.nextInt();
		//int count = 1;
		int  gugudan[][] = new int[n][m];
		
		
		for(int i=0; i<gugudan.length; i++) {
			for(int j=0; j<gugudan.length; j++) {
			gugudan[i][j] = (i+1)*(j+1);
			
			
				
			}
		}	
		for(int i=0; i<gugudan.length; i++) {
			for(int j=0; j<gugudan.length; j++) {
				System.out.println((i+1)+"*"+ (j+1) + "=" + gugudan[i][j]);
			}
			System.out.println("===========================");
			}
		}

}
	

