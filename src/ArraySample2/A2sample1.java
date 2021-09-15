package ArraySample2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*1 2 3
 *6 5 4
 *7 8 9
 * 
 */

public class A2sample1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 배열의 크기를 입력해주세요");
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int Data[][] = new int[n][m];
		
		System.out.println("******데이터 입력부분*******");
		int start=0, end, count = 1;
		end = m - 1; 
		for(int i=0; i < Data.length; i++) {
			
			if(i%2 ==0) {
				for(int j = start; j <= end; j++) {
					Data[i][j] = count++;
				}
			}else {
				for(int j =end; j>=start; j-- ) {
					Data[i][j] = count++;
				}
			}			
		}
		for(int i=0; i < Data.length; i++) {
			for(int j=0; j < Data[i].length; j++) {
				System.out.print(Data[i][j]+" ");
				
				
			}
			System.out.println();
		}
	}
}
	

