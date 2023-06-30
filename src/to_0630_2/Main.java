package to_0630_2;

import java.util.Arrays;
import java.util.Scanner;

/*투 포인터 알고리즘 - 백준 1940. 주몽 */
public class Main {

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		int[] arr= new int[N];
		
		for(int i=0 ; i<N; i++) arr[i] = kb.nextInt();
		
		Arrays.sort(arr);
		
		int st = 0;
		int ed = N -1;
		
		int answer = 0;
		int sum = 0;
		while(st < ed) {
			sum = arr[st] + arr[ed];
			if(sum < M) {
				st++;
			}else if(sum > M ) {
				ed--;
			}else if(sum == M){
				answer++;
				st++;
				ed--;
			}
		}
		
		System.out.println(answer);
	}
}