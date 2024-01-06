package to_24_0106_A;

import java.util.Scanner;

/**
 * 1654번. 랜선 자르기 - 이분 탐색 문풀 
 * @author MYLG
 *
 */
public class Main {
	static long K, N;
	static long[] arr;
	static long answer;
	
	static void binarySearch(long st, long ed) {
		if(st > ed) return;
		
		long mid = (st+ed)/2; //최대 랜선 크기 
		
		if(getMaxLan(mid) >= N) {
			//이 mid로 잘ㄹ라서 만들 수 있는 랜선 N개 이상이라면 ?
			answer = mid;
			binarySearch(mid+1, ed);
		}else {
			binarySearch(st, mid-1);
		}
	}
	
	static long getMaxLan(long mid) {
		long count = 0;
		
		for(int i=0; i<K; i++) {
			count += (arr[i] / mid);
		}
		return count;
	}
	
	//main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb= new Scanner(System.in);
		K = kb.nextLong();
		N = kb.nextLong();//만들고싶은 랜선 개수
		
		long max = 0;
		
		arr = new long[(int)K];
		
		for(int i=0; i<K; i++) {
			arr[i]=  kb.nextLong();
			max =  Math.max(max, arr[i]);
		}
		
		binarySearch(1, max);
		
		System.out.println(answer);
	}

}
