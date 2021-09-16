package MethodSample;

import java.util.Scanner; //class 형태

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
 * static
 * 
 * 문제> 실수형 데이터 2개의 값을 입력받아서, 합계를 구하여 출력하세요	
 * 
 * 
 */

public class Sample3_1{
//field area : 클래스 변수(전역변수)와 클래스 메소드
	


	
	public static void main(String[] args) {
		//main 영역 : 지역변수, 지역함수
		
		Sample3_1 s3 = new Sample3_1();
		
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		
		//1. 방식
		
		double min = x - y;
		System.out.println(x-y);
		
		
		
	} //main end

	
	
	
}
	
	
//field area
	
	

//class end