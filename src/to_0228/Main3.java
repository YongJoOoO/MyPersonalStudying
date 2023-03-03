package to_0228;

import java.util.Scanner;

/* 2-7. 점수 계산 
 * 설명
[입력]
첫째 줄에 문제의 개수 N (1 ≤ N ≤ 100)이 주어진다. 
둘째 줄에는 N개 문제의 채점 결과를 나타내는 0 혹은 1이 빈 칸을 사이에 두고 주어진다.
 (0은 문제의 답이 틀린 경우이고, 1은 문제의 답이 맞는 경우이다.)
[출력]
첫째 줄에 입력에서 주어진 채점 결과에 대하여 가산점을 고려한 [총 점수를 출력]한다.
 * */
public class Main3 {
	
	//솔루션 함수 
	public int solution(int n, int[] arr) {
		int answer = 0; //총점
		int cnt=0; 
		//각각의 arr[i]에 대해서
			//1) 1이면 cnt++ , answer에 누적 
			//2) 0이면 cnt = 0;  
		for(int i =0; i<n; i++) {
			if(arr[i] == 1) { //1나오면 계속 ++ 하다가 
				cnt++;
				answer += cnt; //총점 누적 
			}
			else cnt = 0; //0 나오면 0 리셋
		}
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		//입력
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i =0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		//출력
		System.out.println(T.solution(n, arr));
	}
}