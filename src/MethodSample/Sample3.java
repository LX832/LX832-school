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
 * static
 * 
 * 문제> 실수형 데이터 2개의 값을 입력받아서, 합계를 구하여 출력하세요	
 * 
 * 
 * class는 접근제어자를 public로 시작합니다.
 * 
 * 
 */

public class Sample3 {
//field area : 클래스 변수와 클래스 메소드
	
	private double add(double x, double y) { // x parameter, y parameter
		
		//int sum  = (int)(x + y);
		double sum = x + y;
		
		return sum;
	}	
	
	public static void main(String[] args) {
		//main 영역 : 지역변수, 지역함수
		
		Sample3 s3 = new Sample3();
		
		
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		
		//1. 방식
		double result = s3.add(x,y); //arguments(x,y)
		
		double add = x + y;
		System.out.println("덧셈의 결과는 : " + result);
		
		
		
	} //main end

	
	
	
}
	
	
//field area
	
	

//class end