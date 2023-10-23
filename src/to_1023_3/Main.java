package to_1023_3;

import java.util.Arrays;
import java.util.Scanner;

/*1940번. 주몽 - 투포인터 */
public class Main {
	static int N, M;
	static int[] arr;
	
	//실행메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb=new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		arr = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i]= kb.nextInt();
		}
		//정렬시켜두고
		Arrays.sort(arr);
		
		int st = 1; int ed = N;
		int cnt =0;
		while(st < ed) {
			int sum = arr[st] + arr[ed];
			if(sum == M) {
				st++;
				ed--;
				cnt++;
			}else if(sum <M ) {
				st++;
			}else if(sum > M) {
				ed--;
			}
		}
		System.out.println(cnt);
	}

}