package to_0801_2;

import java.util.Scanner;

//11055번. 가장 큰 증가하는 부분수열 
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] arr= new int[n];
		
		for(int i=0; i<n; i++) arr[i]= kb.nextInt();
		
		int[] dy = new int[n];
		dy[0] = arr[0];//초기화 
	
		for(int i=1; i<n; i++) { //i로 현재값 찍고 
			int max = 0;
			for(int j=i; j>=0; j--) {//j로 i앞을 순회할 거임 
				if(arr[i] > arr[j] && max < dy[j]) {
					max = dy[j];//갱신 계속 시켜줘서 최대 값으로 세팅하려고 
				}
			}
			//빠져나온 상태에서 dy[i] 세팅해주기 
			dy[i] = max+arr[i];//기존 max값에 현재 데이터i도 붙여서 dy[i] 담기 
			
		}
		int max = Integer.MIN_VALUE;
		for(int x : dy) {
			max = Math.max(max, x);
		}
		System.out.println(max);
	}
}