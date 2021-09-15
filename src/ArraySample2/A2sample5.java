package ArraySample2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*구구단을 만들어서 출력하세요
 *2차원 배열 사용(for 2개 사용)
 *int [][] gugudan = new int[8][8]
 * 
 */

public class A2sample5 {

public static void main(String[] args) {
		

		
		Scanner sc = new Scanner(System.in);
		System.out.println("행열 입력?");
		int n = sc.nextInt();
		int m = sc.nextInt();
		//int count = 1;
		int  bbbbb[][] = new int[n][m];
		
		int k=1;
		for(int i=0; i<bbbbb.length; i++) {
			for(int j=0; j<=i; j++) {
				bbbbb[i][j] = k;
				k++;
				//System.out.print();
			
		
				
			}
		}	
		for(int i=0; i<bbbbb.length; i++) {
			for(int j=0; j<bbbbb.length; j++) {
				System.out.print(bbbbb[i][j]+"\t");
				
			}
			System.out.println();
			}
		}
	}

	

