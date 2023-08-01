package to_0801_1;

import java.util.Scanner;

//1912번. 연속합 
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr =new int[n];
		
		for(int i=0; i<n; i++) arr[i] = kb.nextInt();
		
		int[] dy = new int[n];//i를 마지막 선택 항으로 하는 최대합
		
		dy[0] = arr[0];//초기화
		int answer = dy[0];//얘로 초기화 해두고 
		for(int i=1; i<n; i++) {
			//직전까지의 합에 연달아 합치기 vs 지금부터 시작하기 중에 더 큰 값으로 세팅 
			dy[i] = Math.max(arr[i], dy[i-1] + arr[i]);
			answer = Math.max(answer, dy[i]);
		}
		System.out.println(answer);
		
	}

}
