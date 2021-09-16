package InheritanceSample;

import java.util.Scanner;

public class Sample_sungjuk {
	
	private double kor; // 100
	private double eng; // 98
	private static double mat;
	
	//클래스 변수 초기화
	public Sample_sungjuk(double kor, double eng, double mat) {
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	
	public void printOutput() {
		
		double sum = this.kor + this.eng + this.mat;
		
		System.out.println(sum);// 198.0
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("----성적 구하기----");
		System.out.println("국어 점수 입력: ");
		double kor = sc.nextDouble();
		System.out.println("영어 점수 입력: ");
		double eng = sc.nextDouble();
		System.out.println("수학 점수 입력: ");
		double mat = sc.nextDouble();
		
		Sample_sungjuk ss = new Sample_sungjuk(kor, eng, mat);
		ss.printOutput();
		
		System.out.println(mat);
		System.out.println(Sample_sungjuk.mat);
	}
}
