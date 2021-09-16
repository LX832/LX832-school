package MethodSample;

import java.util.Scanner;

/* method 종류(분류)
 * ----------------------------------------------------------------
 * 	  return value     arguments(main area) = parameter(field area)
 * ----------------------------------------------------------------
 * 1.       O              O
 * 2.       O              X
 * 3.       X              O
 * 4.       X              X
 * ----------------------------------------------------------------
 * 
 * 문제> 실수형 데이터 2개의 값을 입력받아서, 합계를 구하여 출력하세요	
 * 
 * 
 */

public class Sample2 {
//field area : 클래스 변수와 클래스 메소드
	
	public static void main(String[] args) {
		//main 영역 : 지역변수, 지역함수
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		
		double add = x + y;
		System.out.println(add);
		
		
		
	} //main end
	
	
//field area
	
	
}//class end
