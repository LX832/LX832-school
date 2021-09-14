package ArraySample1;

import java.util.Scanner;

/*로또 난수 발생 출력하기
 *  범위 : 1~45
 *  중복숫자는 제외
 */

public class Sample5 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("로또번호 끝자리");
		int nb = scan.nextInt();
	
		//int rot[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45}
		int rot[] = new int[nb];
		
		for(int i=0; i < rot.length; i++) {			

		System.out.println(rot[i]);
	}
	}
}
