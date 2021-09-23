package trySample;

import java.util.InputMismatchException;
import java.util.Scanner;

/* problem> 임의의 숫자 데이터를 입력받아서 
 * 그 숫자가 기준이 되어서, 다른 숫자들과 비교하여 
 * 큰수 인지, 같은 수인지, 작은 수인지를 판별 출력하세요.
 * <key Point> 555
 *  1000 => "555가 1000보다  작습니다."
 *  
 * try ~ catch
 */

public class trySample7 {

	public static void main(String[] args) {
		int keyPoint = 555;
		
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

					if (data[i] < keyPoint) {
						System.out.println(data[i] + "이 keyPoint 값보다 작습니다."); 
					} else if(data[i] == keyPoint){
						System.out.println(data[i] + "이 keyPoint 값하고 같습니다."); 
					} else {
						System.out.println(data[i] + "이 keyPoint 값보다 큽니다."); 
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("문자열 데이터를 입력할 수 없습니다.");
				System.out.println("문자 데이터를 입력할 수 없습니다.");
				System.out.println("특수문자열 데이터를 입력할 수 없습니다.");
			}
			
		} catch (InputMismatchException e) {
			System.out.println("문자열 데이터를 입력할 수 없습니다.");
			System.out.println("문자 데이터를 입력할 수 없습니다.");
			System.out.println("특수문자열 데이터를 입력할 수 없습니다.");
		}
		
	}

}
