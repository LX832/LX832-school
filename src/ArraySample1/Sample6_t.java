package ArraySample1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/* 조건 연산자 (삼항 연산자)
 * x = (   ) ? 참: 거짓;
 * 
 * 문제> 3개의 데이터를 입력받아서 가장 작은 값을 구하여 출력하세요
 */

public class Sample6_t {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int mini;
	    int Min[] = new int[5];
		
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		
		System.out.println("첫번째 값");
		Min[0] =Integer.parseInt(br.readLine());
		
		System.out.println("두번째 값");
		String x = br.readLine();
		Min[1] =Integer.parseInt(x);
		
		System.out.println("세번째 값");
		Min[2] =Integer.parseInt(br.readLine());
		
		System.out.println("네번째 값");
		Min[3] =Integer.parseInt(br.readLine());
		
		System.out.println("다섯번째 값");
		Min[4] =Integer.parseInt(br.readLine());
		
		mini = Min[0];
		
		for(int i=1; i<=4; i++) {
			mini = mini < Min[i] ? mini:Min[i];
		}
		System.out.println("최소값" + mini);
	}
}

