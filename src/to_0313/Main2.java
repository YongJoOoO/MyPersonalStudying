package to_0313;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 5-6. 공주 구하기
[입력]
첫 줄에 자연수 N(5<=N<=1,000)과 K(2<=K<=9)가 주어진다.
[출력]
첫 줄에 마지막 남은 왕자의 번호를 출력합니다.
*/
public class Main2 {
	//솔루션 함수 
	public int solution(int n, int k) {
		int answer = 0;
		Queue<Integer> Q = new LinkedList<>();
		//초기 큐 세팅
		for(int i = 1; i<= n; i++) {
			Q.offer(i);
		}
		//내부 돌면서
		while(!Q.isEmpty()) {
			//k번째 직전까지 돌면서 앞데이터는 뒤에 다시 붙임
			for(int i = 1; i<k; i++) {
				Q.offer(Q.poll());
			}
			//k번째는 그냥 뺌
			Q.poll();
			//마지막 1개가 공주구하러 갈 왕자임 
			if(Q.size() == 1) answer = Q.poll();
		}	
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
	
		System.out.println(T.solution(n, k));
	}
}