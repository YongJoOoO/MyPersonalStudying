package to_0801_4;

import java.util.Arrays;
import java.util.Scanner;

//12015번. 가장 긴 증가하는 부분 수열 2 
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr= new int[n];
		
		for(int i=0; i<n; i++) arr[i] = kb.nextInt();
		
		int[] dy = new int[n];
		Arrays.fill(dy, 1);//기본 1로 세팅 
		int answer= dy[0];
		for(int i=1; i<n; i++) {
			int max = 0;
			for(int j=i; j>=0; j--) {
				if(arr[i] > arr[j] && max < dy[j]) {
					max = dy[j];
				}
			}
			//dy세팅
			dy[i] = Math.max(dy[i], max+1);// 더 큰 값으로 세팅
			answer = Math.max(answer, dy[i]);//가장 큰 값 
		}
		System.out.println(answer);
	}
}