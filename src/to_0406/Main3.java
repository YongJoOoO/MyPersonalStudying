package to_0406;

import java.util.Arrays;
import java.util.Scanner;

/* 10-5. 동전 교환 (냅색 알고리즘) */
public class Main3 {
	static int n, m;
	static int[] dy;
	//솔루션
	public int solution(int[] coin) {
		//우선 dy 내부는 최대값으로 담기 
		Arrays.fill(dy, Integer.MAX_VALUE);
		dy[0] = 0;
		for(int i=0; i<n; i++) {
			for(int j=coin[i]; j<=m; j++) {
				dy[j] = Math.min(dy[j], dy[j-coin[i]]+1);
			}
		}
		return dy[m];
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		//동전개수 
		n = kb.nextInt();
		int[] arr= new int[n];
		for(int i=0; i<n; i++) {
			//동전 종류
			arr[i] = kb.nextInt();
		}
		//금액
		m = kb.nextInt();
		dy = new int[m+1];
		
		System.out.println(T.solution(arr));
	}
}