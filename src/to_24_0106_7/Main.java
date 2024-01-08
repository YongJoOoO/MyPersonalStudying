package to_24_0106_7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2110번. 공유기 설치 - 이분탐색 문풀 
 * @author MYLG
 *
 */
public class Main {
	static int N, C;
	static int[] arr;
	static int answer;
	//
	static void binarySearch(int st, int ed) {
		if(st > ed) return;
		
		int mid = (st + ed) / 2;
		
		if(getMaxC(mid) >= C) {
			//우리가 설치하려는 공유기 개수보다 크거나 같은경우 
			answer = mid;
			binarySearch(mid+1, ed);
		}else {
			binarySearch(st, mid-1);
		}
	}
	
	//distance 거리로 만들 수 있는 최대 공유기 개수반환 
	static int getMaxC(int distance) {
		int count = 1;
		int prev = arr[0];
		
		for(int i=1; i<N; i++) {
			if(arr[i] - prev >= distance) {
				//차이가 크거나 같은 공유기를 카운팅 
				count++;
				prev = arr[i];
			}
		}
		
		return count;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		C = kb.nextInt();
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = kb.nextInt();
		}
		
		Arrays.sort(arr); //정렬 필수 
		
		
		
		binarySearch(1, arr[N-1] - arr[0]);
		
		System.out.println(answer);
		
	}

}
