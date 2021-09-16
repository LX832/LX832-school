package MethodSample;

import java.util.Scanner;
/*
 * 접근제한자
 * -------------------------------------
 * 	-private : 자신이 속한 클래스에서만 접근 가능
 *  -protected : 패키지, 클래스, 상속
 *  -public : 파일 정보 숨김이 안됨. hidden 속성
 * 	-생략을 했을 경우 : 디폴트 => 같은 패키지, 같은 
 * 
 */
public class TotalCalculator {

	public static void main(String[] args) {
		
		TotalCalculator tc = new TotalCalculator();
		TotalSample_add tadd = new TotalSample_add();
		tadd.add();
		
		TotalSample_sub tsub = new TotalSample_sub();
		Scanner sc = new Scanner(System.in);
		System.out.println("----덧셈 구하기----");
		System.out.println("첫번째 숫자 입력: ");
		double x = sc.nextDouble();
		System.out.println("두번째 숫자 입력: ");
		double y = sc.nextDouble();
		tsub.sub(x,y);
		
		TotalSample_mut tmut = new TotalSample_mut();
		double result = tmut.mut();
		System.out.println("곱셈의 결과: " + result);
		
		double result2 = TotalSample_div.div();
		System.out.println("나눗셈의 결과 : " + result2);
		
	}
}
