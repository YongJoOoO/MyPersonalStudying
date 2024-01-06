package to_24_0106_2;

import java.util.Scanner;

/**
 * 2805번. 나무 자르기 - 이분탐색 (재귀)
 * @author MYLG
 *
 */
public class Main {
	static int N, M;
	static int[] arr;
	static int answer;
	//재귀
	static void binarySearch(int st, int ed) {
		if(st > ed) return;
		
		int mid = (st+ ed)/2;
		
		long tmp = 0;//잘려나간 거 담을거임
		for(int i=0; i<N; i++) {
			 if(arr[i] - mid > 0) {
				 tmp += (arr[i] - mid);
			 }
		}
		
		if(tmp >= M) {
			answer = mid;
			binarySearch(mid+1, ed);
		}else {
			binarySearch(st, mid-1);
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		arr = new int[N];
		
		int max = 0;
		for(int i=0; i<N; i++) {
			arr[i] = kb.nextInt();
			max = Math.max(max, arr[i]);
		}
		
		binarySearch(0, max);
		System.out.println(answer);
	}
}