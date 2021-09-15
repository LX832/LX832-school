package ArraySample1;

import java.util.Arrays;

import java.util.Collections;


/*임의의 수를 N개 입력받아서, 배열에 저장하고 내림차순 정렬을 하여 출력하세요.
 * 데이터 100 300 400 200 55
 * 1회전 결과: 400 100 300 200 55 
 * 2회전 결과: 400 300 100 200 55
 * 3회전 결과: 400 300 200 100 55
 * 4회전 결과: 400 300 200 100 55
 */

public class Sample7 {
		
	public static void main(String[] args) {
		
		//int moa[][] = new int[4][5];
		 Integer moa[][] = {{400,100,300,200,55},{400,300,100,200,55},{400,300,200,100,55},{400,300,200,100,55}};
		//for (int i = 0; i < moa.length; ++i) {
		  //    for(int j = 0; j < moa[i].length; ++j) {
		    //    System.out.println(moa[i][j]);
		 for (Integer i[] : moa) {
		        Arrays.sort(i, Collections.reverseOrder());
		        System.out.println(Arrays.toString(i));
		      }
		      
		}
	}
	
		      


