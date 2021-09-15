package ArraySample2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*100000
 *2차원 배열 사용(for 2개 사용)
 *int [][] gugudan = new int[8][8]
 * 
 */

public class A2sample6 {

public static void main(String[] args) {
		

		
		Scanner sc = new Scanner(System.in);
		System.out.println("행열 입력?");
		int n = sc.nextInt();
		int m = sc.nextInt();
		//int count = 1;
		int  bbbbb[][] = new int[n][m];
		
		int k=1;
		for(int i=1; i<bbbbb.length; i++) {
			for(int j=i; j<bbbbb.length; j++) {
				bbbbb[j][i] = k;
				k++;
				//System.out.print();
			
		
				
			}
		}	
		for(int i=1; i<bbbbb.length; i++) {
			for(int j=1; j<bbbbb.length; j++) {
				System.out.print(bbbbb[i][j]+"\t");
				
			}
			System.out.println();
			}
		}
	}

	

