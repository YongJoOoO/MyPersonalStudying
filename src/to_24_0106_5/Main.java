package to_24_0106_5;

import java.util.Scanner;

/**
 * 2805번. 나무 자르기 - 이분 탐색 문풀
 * @author MYLG
 *
 */
public class Main {
	static int N, M;
	static int[] arr;
	static int answer;
	
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		arr = new int[N];
		int ed = 0;
		for(int i=0; i<N; i++) {
			arr[i] = kb.nextInt();
			ed = Math.max(ed, arr[i]);
		}
		
		//절단기의 범위를 좁히자 
		int st = 0;
		
		while(st <= ed) {
			int mid = (st + ed) / 2;
		
			long tmp = 0;//높이가 10억까지 올 수 있으므로
			for(int i=0; i<N; i++) {
				if(arr[i] - mid > 0) {
					tmp += (arr[i] - mid);
				}
			}
			
			if(tmp >= M) {
				answer = mid;
				st = mid + 1;//더 높은 절단면에서 ~ ed 사이에서 정답을 구해보자 
			}else {
				ed = mid - 1;//더 작은 절단면까지 
			}
		}
	
		System.out.println(answer);
	}

}
