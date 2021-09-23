package Collection;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 문제> 다음과 같은 성적이 존재합니다.
 * ---------------------------
 * key	value
 * ---------------------------
 * 최원철	 100
 * 고주란   99
 * 하승수   56
 * 권혁진   
 * 
 * ---------------------------
 * 
 * 1. 이 점수의 평균을 구하여 출력하세요.
 * 2. 최고점수는 얼마인가요?
 * 3. 최고점수를 받은 key는 누구인가요?
 */


/* Array => AarayList = > CollectionFramework : list + set + map 구조
 * Map 구조 형태
 *  - 쌍으로 구성(key, value)
 *  - key는 중복을 허용하지 않으나 데이터의 중복 값을 허용, 데이터의 저장순서를 유지
 *  - 복수개의 데이터를 저장합니다
 *  - 크기는 가변적입니다.
 *  - 키값으로 주로 검색하는데 
 *  
 */

public class MapSample3 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		String x2 = sc.next();
		
		
		Map<Integer, String> map = new HashMap<>();
		map.put(100, "현대빈");
		map.put(200, "최원철");
		map.put(300, "정상은");
		map.put(x1, x2);		
		
		System.out.println(map);
		System.out.println(map.toString());
		System.out.println(map.get(300));

		
		
		//data size
		System.out.println(map.size());
		
	}
}
