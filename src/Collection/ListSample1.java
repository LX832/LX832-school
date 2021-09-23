package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/* Array => AarayList = > CollectionFramework : list + set + map 구조
 * List 구조 형태
 *  - 데이터의 중복 값을 허용하고, 데이터의 저장순서를 유지합니다.
 *  
 */

public class ListSample1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		int x2 = sc.nextInt();
		
		
		List<Integer> li = new ArrayList<Integer>();
		li.add(100);
		li.add(200);
		li.add(300);
		li.add(x1);
		li.add(x2);
		
		System.out.println(li);
		System.out.println(li.get(1));

		for(int data : li) {
			System.out.println("FOR문 : " + data);
		}
		
		Iterator<Integer> el = li.iterator();
		
		while(el.hasNext()) {
			System.out.println(el.next());
		}
		
		System.out.println(li.size());
		
	}

}
