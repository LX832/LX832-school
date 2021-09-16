package MethodSample;

import java.util.Scanner;

public class TotalSample_mut {
	
	public double mut() {
		Scanner sc = new Scanner(System.in);
		System.out.println("---- 곱셈 구하기 -----");
		System.out.println("첫번째 숫자 입력: ");
		double x = sc.nextDouble();// 12.345
		System.out.println("두번째 숫자 입력: ");
		double y = sc.nextDouble();// 34.123
		
		double sum = x * y;
		
		return sum;		

	
	}
}
