package to_24_0106_8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2110번. 공유기 설치 - 이분 탐색 문풀 
 * @author MYLG
 *
 */
public class Main {
	static int N, C;
	static int[] arr; 
	
	//getMaxC
	static int getMaxC(int distance) {
		int count = 1;
		int prev = arr[0];
		
		for(int i=1; i<N; i++) {
			if(arr[i] - prev >= distance) {
				count++;
				prev = arr[i];
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb=  new Scanner(System.in);
		N = kb.nextInt();
		C = kb.nextInt();
		
		arr= new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = kb.nextInt();
		}
		//정렬 
		Arrays.sort(arr);
		
		int answer = 0;
		
		int st = 1, ed= 1000000000;
		while(st <= ed) {
			int mid = (st+ ed)/2;
			
			if(getMaxC(mid) >= C) {
				answer = mid;
				st = mid+1;	
			}else {
				ed = mid-1;
			}
		}
		System.out.println(answer);
	}
}