package MethodSample;

import java.util.Scanner; //class 형태

/* 	method 종류(분류)
 * ------------------------------------------------------------------
 *   return value 	arguments(main area) = parameter(field area)
 * ------------------------------------------------------------------
 * 1.		O			O   
 * 2. 		O			X
 * 3.		X			O   
 * 4.		X			X  [O]
 * ------------------------------------------------------------------
 * 
 */
public class Sample5 { //4500
	
	private void add() { 		//4800
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();// 12.345
		double y = sc.nextDouble();// 34.123
		
		double sum = x + y;
		
		System.out.println("덧셈의 결과는 : " + sum);// ?		
	} 
	
	
	public static void main(String[] args) { 
				
		Sample5 s3 = new Sample5();// 4500 = s3
						
		//4.방식 = 프로그래밍 언어론 
		s3.add(); // call by reference(주소 참조), 객체명.메소드명()

	} // main end

	
		
}//class end