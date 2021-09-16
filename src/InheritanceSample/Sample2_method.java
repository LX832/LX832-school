package InheritanceSample;

import java.util.Scanner;



public class Sample2_method {
	
	public Sample2_method(int x3, double y3) {

		double sum = x3 * y3;
		
		System.out.println("mul: " + sum);
	}
	public Sample2_method(double x4, int y4) {

		double sum = x4 / y4;
		
		System.out.println("div: " + sum);
	}
	public Sample2_method(int x2, int y2) {

		int sum = x2 - y2;
		
		System.out.println("sub: " + sum);
	}
	public Sample2_method(double x, double y) {

		int sum = (int)(x + y);
		
		System.out.println("add: " + sum);
	}

	public static void main(String[] args) {
		// Constructor Example
		
		Scanner sc = new Scanner(System.in);
		System.out.println("----덧셈 구하기----");
		System.out.println("첫번째 숫자 입력: ");
		double x = sc.nextDouble();
		System.out.println("두번째 숫자 입력: ");
		double y = sc.nextDouble();		
		
		//실수형 데이터			
		Sample2_method s1 = new Sample2_method(x,y);
		//생성자 오버로딩
		
		Scanner sc3 = new Scanner(System.in);
		System.out.println("----곱셈 구하기----");
		System.out.println("첫번째 숫자 입력: ");
		int x3 = sc3.nextInt();
		System.out.println("두번째 숫자 입력: ");
		double y3 = sc3.nextInt();
		
		Sample2_method s2 = new Sample2_method(x3,y3);
		
		Scanner sc4 = new Scanner(System.in);
		System.out.println("----나눗셈 구하기----");
		System.out.println("첫번째 숫자 입력: ");
		double x4 = sc4.nextInt();
		System.out.println("두번째 숫자 입력: ");
		int y4 = sc4.nextInt();
		
		Sample2_method s4 = new Sample2_method(x4,y4);
		
		//메소드 오버로딩 구현 시 사용
		//samle1 s4 = new Sample1();
		//s4.div(x4, y4);
	}

}
