package back_0406;

import java.util.Scanner;

/* 11053번. 가장 긴 증가하는 부분 수열  */
public class Main {
	static int[] dy;

	//솔루션 함수 
	public int solution(int[] arr) {
		int answer =0;
		dy = new int[arr.length];
		
		dy[0] =1;
		answer = dy[0];
		
		for(int i=1; i<arr.length; i++) {
			 int max = 0;
			 for(int j=i-1; j>=0; j--) {
				 if(arr[i]> arr[j] && dy[j] > max) max = dy[j];
			 }
			 dy[i] = max+1;
			 answer = Math.max(answer, dy[i]);
		}
		return answer ;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n= kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		System.out.println(T.solution(arr));
		
	}
}