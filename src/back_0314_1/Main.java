package back_0314_1;

import java.util.Arrays;
import java.util.Scanner;

/* 백준. 2693번. N번째 큰 수 
 * */
public class Main {
	//솔루션 함수 
	public int[] solution(int t, int[][]arr) {
		int[] answer = new int[t];
		
		for(int i = 0; i<t; i++) {
			Arrays.sort(arr[i]);
		}
		
		for(int i =0; i<t; i++) {
			answer[i] = arr[i][7];
		}
		
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		Main T = new Main();
		
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		int[][] arr = new int[t][10];
		
		for(int i = 0; i<t; i++	) {
			for(int j = 0; j<10; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		for(int x: T.solution(t, arr)) System.out.println(x);
	}
	
}