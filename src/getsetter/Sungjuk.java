package getsetter;

import java.util.Scanner;

/*
 * 세 과목의 성적을 입력받아서, 총점과 평균을 구하여 출력하세요
 *  - getter & setter 메소드 이용
 *  문제 파악(요구사항 파악)>
 *  
 *  1. 학생 수?
 *  2. 과목 수?
 *  3. 데이터 제공 유무(가상 데이터 입력?, 파일 제공?, DB접근 제공,  (ID/PW)....)
 *  4. 총점?
 *  5. 평균?
 *  
 *  문제 분석>
 *  1. 속성 파악? 자릿수, 정수/실수/문자열, 특수문자...
 *  2. 어떤 데이터베이스를 사용해야 하는가?
 *  3. 어떤 네트워크를 지원원해야 하는가 (유선, 무선, 유무선 지원 여부)
 *  4. 어떤 서버를 주기동으로 사용해야 하는가? (유선, 무선, 유무선 지원 여부)
 *  5. 비용 처리는?
 *  6. 컨설팅 유무
 *  7. 소프트웨어 개발자?
 *  8. 하드웨어(펌웨어, 임베디드 시스템)?
 *  9. 등등....
 *  비용과 프로젝트 기간?
 *  
 *  문제 설계>
 *  1. 속성과 동작에 의하여 설계가 진행됩니다.
 *  2. 과목수? 3과목
 *  3. 3과목? 국어, 영어, 수학
 *  4. 국어는 변수? 영어 변수는? 수학 변수는? (자료형), 주관식/객관식
 *  5. 국어,영어,수학 자릿수?
 *  6. 총점 구하는 공식
 *  7. 평군 구하는 공식
 *  8. 타이틀은? cui, gui 방식 선택
 *  
 *  sample>
 *  국어 = kor, 영어 = eng, 수학 = mat, 총점 = total, 평균 = average
 *  kor, eng, mat, total, average = double
 */

public class Sungjuk {
	
	double kor; //클래스 변수 ,자동초기화 get/set
	double eng; //get/set
	double mat; //get/set
	double total; //getter
	double average; //getter
	
	//.....


	public double getKor() {
		return kor;
	}
	
	public void setKor(double kor) {
		this.kor = kor;
	}
	
	public double getEng() {
		return eng;
	}
	
	public void setEng(double eng) {
		this.eng = eng;
	}
	
	public double getMat() {
		return mat;
	}
	
	public void setMat(double mat) {
		this.mat = mat;
	}
	
	public double getTotal() {
		total = this.kor + eng + mat;
		
		return total;
	}
	
	public double getAverage() {
		average = total/3.0;
		
		return average;
	}



	
	
	public static void main(String[] args) {
			Sungjuk sj = new Sungjuk();
		
		Scanner sc = new Scanner(System.in);
			System.out.println("국어 점수를 입력해 주세요:");
			double kor = sc.nextDouble();
			System.out.println("영어 점수를 입력해 주세요:");
			double eng = sc.nextDouble();
			System.out.println("수학 점수를 입력해 주세요:");
			double mat = sc.nextDouble();
			
			sj.setKor(kor);
			sj.setEng(eng);
			sj.setMat(mat);
			
			double total = sj.getTotal();
			System.out.println("총점: " + total);
			double average = sj.getAverage();
			System.out.println("평균: " + average);

	}
}
	
