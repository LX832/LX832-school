package Collection;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*문제> 다음과 같은 성적이 존재합니다.
 * ---------------------------
 * key	value
 * ---------------------------
 * 최원철	 100
 * 고주란   99
 * 하승수   56
 * 권혁진   78
 * 
 * ---------------------------
 * 
 * 1. 이 점수의 평균을 구하여 출력하세요.
 * 2. 최고점수는 얼마인가요?
 * 3. 최고점수를 받은 key는 누구인가요?
 */

public class MapSample2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String x1 = sc.next();
		int x11 = sc.nextInt();
		
		String x2 = sc.next();
		int x22 = sc.nextInt();
		
		String x3 = sc.next();
		int x33 = sc.nextInt();
		
		String x4 = sc.next();
		int x44 = sc.nextInt();
		
		
		
		Map<String, Integer> map = new HashMap<>();
		map.put(x1, x11);
		map.put(x2, x22);
		map.put(x3, x33);
		map.put(x4, x44);
		
		int maxValue=0, totalValue = 0;
		String valueID = null;
		
		Set<Map.Entry<String, Integer>> eSet = map.entrySet();
		
		for(Map.Entry<String, Integer> entry : eSet) {
			
			if(entry.getValue() > maxValue) {
				maxValue = entry.getValue(); 
				valueID = entry.getKey();
			}
			totalValue += entry.getValue();
		}
		double average = totalValue / map.size();
		
		System.out.println("최고의 점수는 : " + maxValue);
		
		System.out.println("최고점수의 key value :" + valueID);


	
		}
}


