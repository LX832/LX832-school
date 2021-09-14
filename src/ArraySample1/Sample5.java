package ArraySample1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*로또 난수 발생 출력하기
 *  범위 : 1~45
 *  중복숫자는 제외
 */

public class Sample5 {
	
	public static void main(String[] args) {
		
		
		int br[] = new int[6];
		Random r = new Random();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("로또번호 몇개줄까?");
		int nb = scan.nextInt();
	
		//int rot[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45}
				
		loop: for(int i = 1; i < nb; i++) {			
			for(int j=0; j < br.length; j++) {
				
				int lot = r.nextInt(45) + 1;
				for (int m=0; m<j; m++) {
					if(lot==br[i]) {
						j--;
						continue loop;
					}
				}
				br[j] = lot;
			}
			Arrays.sort(br);
			
			for(int k= 0; k < br.length; k++) {
				System.out.print(br[k]+" ");
			}
			System.out.println();
	}
	}
}
