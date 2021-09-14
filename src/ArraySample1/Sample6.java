package ArraySample1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/* 조건 연산자 (삼항 연산자)
 * x = (   ) ? 참: 거짓;
 * 
 * 문제> 3개의 데이터를 입력받아서 가장 작은 값을 구하여 출력하세요
 */

public class Sample6 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("카운트 입력");
		int count = sc.nextInt();

		int Data[] = new int[count];

		for(int i=0; i <= Data.length; i++) {
			for(int j=0; j <= Data.length; j++) {
				Data[i] = sc.nextInt();
				Data[j] = sc.nextInt();
				System.out.println(Math.min(Data[i],Data[j]));
		}


		}
	}
}

