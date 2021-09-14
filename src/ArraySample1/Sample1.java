package ArraySample1;

import java.util.Random;

/*배열: 같은 성질의 숫자나 문자를나열 한 것.
 * 		-데이터의 갯수가 아주 많은 경우 사용
 * 		-c에서 구조체가 자바에서는 class 형태로 변환됩니다. => 필드영역
 * 1차원 배열: 점으로 구성, 메모리 사용, 포인터(c, 주소에 조작) => object(객체, 주소 조작 불가능)
 * 	int a = 5000;
 *  *pA;
 *  pA = &a;
 *  print(pA); => ?
 *  주소값이 존재합니다.
 *  
 *  intA[] = in[10]; [0]~[9], 행과 열이 같습니다.
 *  
 *  2차원 배열: 선으로 구성
 *   int B[][] = int[5][7];// 5행과 7열이 존재합니다.
 *   
 *   
 *  3차원 배열: 면으로 구성
 *  double C [][][] = new double[][][], 면, 행, 열
 *  
 *  자바는 행 중심언어, 파이썬은 열 중심언어
 *  
 *  문제> boolean형 난수를 100개 생성하여 출력하세요.
 *  
 *  
 */

public class Sample1 {
	
	public static void main(String[] args) {
		
		Random RR = new Random();
		
		for(int i=0; i < 100; i++) {
			 System.out.println(100 + Math.random());			
		}
		
	}
}