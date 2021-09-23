package trySample;

import java.util.InputMismatchException;
import java.util.Scanner;

/*problem> 7개의 데이터를 입력받아서 
 * 그 숫자중에서 음수와 양수를 구분하여 
 * 만약에 음수이면 다음 데이터를 읽으러 이동(next = skip = continue) 시키세요.
 * - 음수인지, 양수인지 판별하여 출력하세요.
 *  
 * 
 *  
 */

public class trySample6 {

	public static void main(String[] args) {
		int sum = 0, count = 0;
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("처리할 데이터의 갯수를 입력해 주세요.");
			int x = sc.nextInt();

			int data[] = new int[x];

			try {
				// 1. input
				System.out.println(x + "개의 데이터를 입력하세요.");
				for (int i = 0; i < data.length; i++) {
					data[i] = sc.nextInt();
				}

				// 2.음수와 양수 구분하기
				for (int i = 0; i < data.length; i++) {

					if (data[i] < 0) {
						continue;
					} else {
						System.out.println(data[i] + "양수 입니다.");
						sum += data[i];
						count++;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("문자열 데이터를 입력할 수 없습니다.");
			}
			
		} catch (InputMismatchException e) {
			System.out.println("문자열 데이터를 입력할 수 없습니다.");
		}
		System.out.println("합계: " + sum);
		System.out.println("양의 데이터의 갯수 : " + count);
	}

}
