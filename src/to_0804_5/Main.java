package to_0804_5;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		long[] arr= new long[N];
		for(int i=0; i<N; i++) arr[i] = kb.nextLong();
		// 이문제의 경우 자기 자신을 카운팅할 수 있으니까. 조심해야 함 
		Arrays.sort(arr);
		int cnt = 0;
		
	
		for(int k=0; k<N; k++) {
			long find = arr[k];
			int st = 0;
			int ed = N-1;
			while(st <ed) {
				if(arr[st] + arr[ed] == find) {
					if(st != k && ed != k) {
						cnt++;
						break;
					}else if(st==k) {
						st++;
					}else if(ed ==k) {
						ed--;
					}
				}else if(arr[st] + arr[ed] > find) {
					ed--;
				}else if(arr[st] + arr[ed] <find) {
					st++;
				}
			}
		}
		System.out.println(cnt);
		
	}
}