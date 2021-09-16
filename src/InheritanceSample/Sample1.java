package InheritanceSample;

import java.util.Scanner;

/*상속(Inheritance)
 * 기존에 존재하는 부모 클래스의 속성이나 메소드를 하위(자식, 파생 클래스)에게 물려주는 것
 * 주의할 점> 생성자는 상속이 안됩니다.
 * 
 * 
 * 생성자 메소드란?
 * 	 - 클래스를 초기화 하는 데 사용합니다. 전역변수 역할처럼 프로그램 전체 영향을 줍니다.
 * 		int xxx;
 * 		
 * 		this.xxx = xxx;
 * 
 * 	 - 클래스에서만 값을 전달해 줄 수 있습니다.
 * 	만약에, 생성자를 초기화 하지 않으면 일반적으로 JDK(JVM)이 알아서 초기화 해좁니다.
 * 	 - 생성자명은 반드시 클래스명과 같아야 합니다.
 *	 - 생성자는 상속이 안됩니다.
 *	 - 반환값이 존재하지 않습니다.
 *
 *
 * 생성자 오버로딩이란?
 * 	이름은 같지만, 역할이 다른 메소드를 구현 하는 것.
 * 	 - 구분 : 이름은 같으나 전달인자(매개변수)의 갯수나 데이터형이 다르면 구분이 됩니다.
 * 
 * 메소드 오버로딩이란?
 *  이름은 같지만, 역할이 다른 메소드를 구현 하는 것.
 *   -구분 : 이름이 같으나 전달인자(매개변수)의 갯수나 데이터형이 다르면 구분 됩니다.
 */


public class Sample1 {
	
	public Sample1(int x3, double y3) {

		double sum = x3 * y3;
		
		System.out.println("mul: " + sum);
	}
	public Sample1(double x4, int y4) {

		double sum = x4 / y4;
		
		System.out.println("div: " + sum);
	}
	public Sample1(int x2, int y2) {

		int sum = x2 - y2;
		
		System.out.println("sub: " + sum);
	}
	public Sample1(double x, double y) {

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
		Sample1 s1 = new Sample1(x,y);
		//생성자 오버로딩
		
		Scanner sc3 = new Scanner(System.in);
		System.out.println("----곱셈 구하기----");
		System.out.println("첫번째 숫자 입력: ");
		int x3 = sc3.nextInt();
		System.out.println("두번째 숫자 입력: ");
		double y3 = sc3.nextInt();
		
		Sample1 s2 = new Sample1(x3,y3);
		
		Scanner sc4 = new Scanner(System.in);
		System.out.println("----나눗셈 구하기----");
		System.out.println("첫번째 숫자 입력: ");
		double x4 = sc4.nextInt();
		System.out.println("두번째 숫자 입력: ");
		int y4 = sc4.nextInt();
		
		Sample1 s4 = new Sample1(x4,y4);
		
		//메소드 오버로딩 구현 시 사용
		//samle1 s4 = new Sample1();
		//s4.div(x4, y4);
	}

}
