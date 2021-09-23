package Collection;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/* Array => AarayList = > CollectionFramework : list + set + map 구조
 * List 구조 형태
 *  - 데이터의 중복 값을 허용x, 데이터의 저장순서를 유지x
 *  
 */

public class setSample1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		int x2 = sc.nextInt();
		
		
		Set<Integer> set = new HashSet<Integer>();
		set.add(100);
		set.add(200);
		set.add(300);
		set.add(x1);
		set.add(x2);
		
		System.out.println(set);
		System.out.println(set.toString());

		for(int data : set) {
			System.out.println("FOR문 : " + data);
		}
		//반복자
		Iterator<Integer> el = set.iterator();
		
		while(el.hasNext()) {
			System.out.println(el.next());
		}
		//data size
		System.out.println(set.size());
		
		//정렬 기능을 포함한 set 구조 형태
		TreeSet<Integer> tset = new TreeSet<Integer>();
		
		tset.add(11100);
		tset.add(1200);
		tset.add(3300);
		tset.add(6234);
		tset.add(6234);
		
		System.out.println(tset.size());
		System.out.println(tset);
	}

}
