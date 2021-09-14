import java.util.Scanner;

public class HotelSample {     // (5,7)
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("객실 수");
		int host = sc.nextInt();
		
		int[][] hstt = {{10, 5, 6, 7, 8, 9, 10},{1, 9, 7, 8, 5, 4, 3},{10, 20, 30, 40, 50, 60, 70},{3, 5, 8, 9, 12, 22, 55},{6, 3, 8, 2, 5, 4, 5}};
		//int[][] hstt = {{1,2,3,4,5},{2,3,4,5,6},{4,5,6,7,8}};
		double[][] aver = new double[host][1];
		 
	for(int i = 0; i < hstt.length; i++) {
		hstt[i][5] = hstt[i][0] + hstt[i][1] + hstt[i][2] + hstt[i][3] + hstt[i][4]+ hstt[i][5]+ hstt[i][6];
		aver[i][0] = hstt[i][5] / 7.0;
		
		System.out.println(aver[i][0]);
		}	
		
	}
}