package to_24_0106_1;

import java.util.Scanner;

/**
 * 2805번. 나무 자르기 - 이분탐색 문풀
 * @author MYLG
 *
 */
public class Main {
	static int N, M;
	static int[] arr;
	static long answer = 0;//정답용 
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		arr = new int[N];
		
		int ed = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			arr[i]=  kb.nextInt();
			ed = Math.max(ed, arr[i]);
		}
		int st = 0;
		
		while(st <= ed) {
			//절단기로 설정
			int mid = (st+ed) /2;
			
			long tmp = 0;
			for(int i=0; i<N; i++) {
				if(arr[i] - mid > 0) {
					tmp+= arr[i] - mid;
				}
			}
			
			if(tmp >= M) {
				answer = mid;
				st = mid + 1 ; //윗구간 
			}else {
				ed = mid - 1;
			}			
		}
		
		System.out.println(answer);	
	}
}