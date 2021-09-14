package ArraySample1;

import java.util.Scanner;

public class gggggggg {
	
	public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in);

	System.out.println("임의의 수");
	int n = scan.nextInt();
	String str[] = new String[n];

	for (int i = 0; i < n; i++) {
		System.out.println((i+1)+"번째 데이터입력");
		str[i] = scan.next();
	}

	System.out.println("검색할 데이터를 입력하세요");
	String x = scan.next();
		
	for (int i = 0; i < n; i++) {
		if (str[i] == x) {
			System.out.println("str[" + i + "]번에" + x + "자료가 있습니다.");			
		} else {
			System.out.println("str["+ i +"]에는 찾는데이터가 없습니다.");
		}
	}
}
}


