package to_0801_3;

import java.util.Arrays;
import java.util.Scanner;

//11722번. 가장 긴 감소하는 부분 수열 
public class Main {	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) arr[i] = kb.nextInt();
		
		int[] dy = new int[n];
		Arrays.fill(dy, 1);//일단 1로 세팅해두고
		int answer = dy[0];
		for(int i=1; i<n; i++) {
			int max = 0;
			for(int j= i; j>=0; j--) {
				if(arr[i] < arr[j] && max < dy[j]) {
					//현재 i보다 더 큰 값을 가지면서, 그들 중에서 dy[] 값은 max인 애 찾기 
					max = dy[j];
				}
			}
			dy[i] = Math.max(dy[i], max+ 1);//길이 +1 처리 
			answer = Math.max(answer, dy[i]);//최대 값을 answer로
		}
		System.out.println(answer);
	}
}