package to_0316;

import java.util.Scanner;

/* 6-4.Least Recently Used
[입력]
첫 번째 줄에 캐시의 크기인 S(3<=S<=10)와 작업의 개수 N(5<=N<=1,000)이 입력된다.
두 번째 줄에 N개의 작업번호가 처리순으로 주어진다. 작업번호는 1 ~100 이다
[출력]
마지막 작업 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례로 출력합니다.
*/

public class Main2 {
	//솔루션 함수
	public int[] solution(int size, int n, int[] arr) {
		int[] cache = new int[size];
		//작업 하나씩 가져옴
		for(int x: arr) {
			//인덱스 찍을 변수 
			int pos = -1;
			//캐시 내부를 차례로 돌되
			for(int i = 0; i<size; i++) {
				//[Hit] arr에서 꺼낸 값이 캐쉬의 값에 존재할 경우 
				if(x==cache[i]) pos=i; //Hit 지점 인덱스를 pos에 저장시킴
			}
			//캐시 미스 (즉. 히트난 지점 없을 경우) 맨 뒤부터 거꾸로 돌면서 밀기
			if(pos == -1) {
				for(int i = size-1; i>=1; i--) {
					//거꾸로 작업 밀어버림
					cache[i] = cache[i-1];
				}
			}
			else { //캐시 히트 처리 (히트 지점부터 거꾸로 돌면서 밀기)
				for(int i = pos; i>=1; i--) {
					//거꾸로 작업 밀어버림
					cache[i] = cache[i-1];
				}
			}
			//무조건 맨 앞에는 현재 작업x 담음
			cache[0] = x;
		}
		return cache;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		Scanner kb = new Scanner(System.in);
		
		int s = kb.nextInt();
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n;i++) arr[i] = kb.nextInt();
		
		for(int x: T.solution(s, n, arr)) System.out.print(x+" ");
	}
}