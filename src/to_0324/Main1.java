package to_0324;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* 8-5. 동전교환 
다음과 같이 여러 단위의 동전들이 주어져 있을때 
거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
각 단위의 동전은 무한정 쓸 수 있다.
*/
public class Main1 {
	static int n, m, answer = Integer.MAX_VALUE;
	//DFS
	public void DFS(int L, int sum, Integer[]arr) {
		if(sum > m) return;
		if(sum == m) {
			answer = Math.min(answer, L);
		}else {
			for(int i=0; i<n; i++) {
				DFS(L+1, sum+arr[i], arr); //재귀 호출 
			}
		}
	}
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		//Arrays.sort 사용할 대상은 Integer 객체로 생성한다.
		Integer [] arr =new Integer[n];
		for(int i=0; i<n; i++) arr[i] = kb.nextInt();
		//내림차순 정렬 (큰 수부터 해야 더 효율적)
		Arrays.sort(arr, Collections.reverseOrder());
		
		m = kb.nextInt();
		
		T.DFS(0, 0, arr);
		
		System.out.println(answer);
	}
}