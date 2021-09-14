import java.util.Arrays;
import java.util.Scanner;

public class SungjukSample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("인원수");
		int number = sc.nextInt();
		
		String[][] stud = new String [number][2];
		int[][] arr = new int[number][4];
		double[][] aver = new double[number][1];
		int[] rank = new int[number];
		int[][] ranking = new int[number][1];
		
		for(int i=0; i < arr.length; i++) {
			System.out.println("---번호와 각과목 점수를 입력하세요---");
			System.out.println("번호:");
			stud[i][0]=sc.next();
			System.out.println("이름:");
			stud[i][1]=sc.next();
			
			System.out.println("국어:");
			arr[i][0]=sc.nextInt();
			System.out.println("영어:");
			arr[i][1]=sc.nextInt();
			System.out.println("수학:");
			arr[i][2]=sc.nextInt();
		}
		
		for(int i = 0; i < arr.length; i++) {
			arr[i][3] = arr[i][0] + arr[i][1] + arr[i][2];
			aver[i][0] = arr[i][3] / 3.0;
		}
		
		for(int i=0; i <number; i++) {
			rank[i]=arr[i][3];
	
		}
		Arrays.sort(rank);
		
		for(int i=0; i < arr.length; i++) {
			//
			for(int j=arr.length-1; j>=0; j-- ) {
				
				if(arr[i][3] == rank[j]) {
					ranking[i][0] =arr.length-j;
					break;
				}else {
					continue;
				}
				
			}
		}
		
		
		
		System.out.println("=================================================");
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차");
		System.out.println("=================================================");
		
		for(int i=0; i < arr.length; i++) {
			System.out.print(stud[i][0] + "\t" + stud[i][1] + "\t"); //번호, 이름출력
			for(int j=0; j<4; j++) {
				System.out.print(arr[i][j] + "\t"); //국어,영어,수학,총점
				
			}
			System.out.printf("%5,3f \t", aver[i][0], ranking[i][0]);
			System.out.println();
			
		}
		System.out.println("=================================================");

	}

}
