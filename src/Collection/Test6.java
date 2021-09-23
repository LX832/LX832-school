package Collection;


import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {

		System.out.println("참가는 했지만 완주는 못한사람은?");


		String[] participant = {"sangeun","sangwon","wonchul","sangeun","joyoung"};
    	String[] completion = {"wonchul","sangwon","joyoung"};    	
    	
		System.out.println(getArrayMin(participant, completion));		
		System.out.println("============================");
		
		System.out.println("동명이인" + getArrayMin2(participant, completion) + "n명은 완주못했어요");
		System.out.println(getArrayMin2(participant, completion));
	}
		
				
		
	public static String getArrayMin(String participant[], String completion[]) {
		
		String answer = "";
		int count = 0;
		try {
			if(participant.length > 0 && completion.length > 0) { 
				for(int i=0; i<participant.length; i++) {
					
					for(int j=0; j<completion.length; j++) {						
						if(participant[i].equals(completion[j]) == true) { 
							count ++; 																
						}												
					}
					
					if(count <= 0) { 
						if(answer.contains(participant[i]) == false) { 
							answer += String.valueOf(participant[i] + " ");							
						}	
					}
					
					count = 0; 
				}
			}else {
				System.out.println("비었는데요?");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return answer;
	}
	
	
	public static String getArrayMin2(String participant[], String completion[]) {
		
		String answer = "";
		int count = 0;
		try {
			if(participant.length > 0 && getArrayMin(participant, completion).length() > 0) { 
				for(int i=0; i<getArrayMin(participant, completion).length(); i++) {
					
					for(int j=0; j<completion.length; j++) {						
						if(participant[i].equals(completion[j]) == true) { 
							count ++; 																
						}												
					}
					
					if(count <= 0) { 
						if(answer.contains(participant[i]) == false) { 
							answer += String.valueOf(participant[i] + " ");							
						}	
					}
					
					count = 0; 
				}
			}else {
				System.out.println("비었는데요?");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return answer;
	}
	
}