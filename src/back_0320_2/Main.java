package back_0320_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* 백준 2587번. 대푯값 2
*/
public class Main {
	//솔루션 함수
	public ArrayList<Integer> solution(int[] arr){
		ArrayList<Integer> answer = new ArrayList<>();
		int tmp = 0;
		//평균값
		for(int i=0; i<5; i++) {
			tmp += arr[i];
		}
		answer.add(tmp /= 5);
		
		//중앙값
		Arrays.sort(arr);
		
		answer.add(arr[2]);		
		
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		
		Scanner kb = new Scanner(System.in);
		int[] arr = new int[5];
		
		for(int i=0; i<5; i++) {
			arr[i] = kb.nextInt();
		}	
		for(int x: T.solution(arr)) System.out.println(x);
	}
}