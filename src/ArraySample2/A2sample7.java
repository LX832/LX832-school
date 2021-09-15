package ArraySample2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*100000
 *2차원 배열 사용(for 2개 사용)
 *int [][] gugudan = new int[8][8]
 * 
 */

public class A2sample7 {

public static void main(String[] args) {
		

		
		Scanner sc = new Scanner(System.in);
		System.out.println("10개 입력해봐?");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		int n4 = sc.nextInt();
		int n5 = sc.nextInt();
		int n6 = sc.nextInt();
		int n7 = sc.nextInt();
		int n8 = sc.nextInt();
		int n9= sc.nextInt();
		int n10 = sc.nextInt();
		int brank[] = {n1,n2,n3,n4,n5,n6,n7,n8,n9,n10};
		
		int mmo=0;
		int count=0;
		for(int i=1; i<brank.length; i++) {
			if((brank[i])%5 ==0) {
				count++;
				mmo+=brank[i];
				System.out.println(brank[i]);
			}
			
		}
				System.out.println("5의배수의 총합"+mmo);
				System.out.println("5의배수 갯수"+ count);
				//System.out.print();
			
		
				
		}
}



	

