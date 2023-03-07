package to_0307;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

/* 04-05. k번째 큰 수 
[입력]
첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.
[출력]
첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.
*/
public class Main3 {
	//솔루션 함수 
	public int solution(int n, int k, int[]arr) {
		int answer= -1;
		//TreeSet을 내림차순 정렬 
		TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
		
		//n개의 카드 중 3장을 뽑는 것
		for(int i = 0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				for(int l = j+1; l<n; l++) {
					//뽑은 3개 카드를 더해서 set에 추가
					Tset.add(arr[i]+arr[j]+arr[l]);
				}
			}
		}
		int cnt = 0; //몇번째인지 누적
		//TreeSet 내부에서 k번째 큰 수 탐색
		for(int x : Tset) {
			cnt++;
			if(cnt == k) return x;
		}
		
		return answer;
	}
	//메인 실행 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		
		System.out.println(T.solution(n, k, arr));
	}
}