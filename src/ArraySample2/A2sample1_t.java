package ArraySample2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*1 2 3
 *6 5 4
 *7 8 9
 * 
 */

public class A2sample1_t {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("열 입력");
		int hot = sc.nextInt();
		System.out.println("행 입력");
		int hhh = sc.nextInt();
		int hrr[][] = new int [hot][hhh];
		for(int i=0; i < hhh; i++) {
			System.out.println((i+1)+"번째 데이터 입력");
			hrr[i][0] = sc.nextInt();
			
			
			Arrays.sort(hrr,Collections.reverseOrder());
		
			for(int k[] : hrr) {
				System.out.println("Descending sort :" + k + "");
		
			}
		}
	}
}

