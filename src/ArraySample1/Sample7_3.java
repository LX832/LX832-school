package ArraySample1;

import java.util.Arrays;

import java.util.Collections;
import java.util.Scanner;


/*임의의 수를 N개 입력받아서, 배열에 저장하고 내림차순 정렬을 하여 출력하세요.
 * 데이터 100 300 400 200 55
 * 1회전 결과: 400 100 300 200 55 
 * 2회전 결과: 400 300 100 200 55
 * 3회전 결과: 400 300 200 100 55
 * 4회전 결과: 400 300 200 100 55
 */

public class Sample7_3 {
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 배열의 크기를 입력하세염");
		int n = sc.nextInt();
		Integer sortData[] = new Integer[n];
		
		System.out.println("^^^^데이터입력^^^^^");
		
		for(int i=0; i<sortData.length; i++) {
			System.out.println((i+1)+"번째 데이터 입력");
			sortData[i]=sc.nextInt();
		}
		int imsi;
		for(int i=0; i<sortData.length; i++) {
			
			for(int j=i+1; j <sortData.length; j++) {
				if(sortData[i] < sortData[j]) {
					imsi = sortData[i];
					sortData[i] = sortData[j];
					sortData[j]= imsi;
				}				
				
			}
			System.out.println("내림차순 결과출력");
			System.out.println((i+1) + "회전결과");
				for(int k : sortData) {
					System.out.print( k + " ");
					
				}
				System.out.println();
				System.out.println("========================");
			}

		}
			
			

}


	
	
		      


