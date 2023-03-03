package to_0301;

import java.util.Scanner;

/* 2-11번. 임시반장 정하기 
[입력]
첫째 줄에는 반의 학생 수를 나타내는 정수가 주어진다. 
둘째 줄부터는 1번 학생부터 차례대로 각 줄마다 1학년부터 5학년까지 몇 반에 속했었는지 나온다
[출력]
첫 줄에 임시 반장으로 정해진 학생의 번호를 출력한다.
여러 명이면 작은 번호 출력한다.
 * */
public class Main3 {
	//솔루션 함수
	public int solution(int n, int[][] arr) {
		int answer = 0, max = Integer.MIN_VALUE;
		//[기준] i번 학생 기준
		for(int i = 1; i<= n; i++) {
			int cnt=0; //매번 i와 같은 반 학생 카운팅용
			//[비교] j번 학생들
			for(int j = 1; j<=n; j++) {
				// 1~5 학년까지 돌면서 같은 반 누적하기
				for(int k = 1; k <=5; k++) {
					// i 학생의 k 학년때 반이 == j 학생의 k학년때 반과 같다면 
					if(arr[i][k] == arr[j][k]) {
						cnt++; //누적
						break;
					}
				}
			}
			//가장 같은반 많이 했던 학생을 임시반장으로 선출 
			if(cnt > max) { //기존 max값보다 큰 경우 
				max=cnt;
				answer = i; //현재의 학생으로 임시반장 갱신 
			}
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Main3 T = new Main3();
		
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		//인덱스 1번부터 시작하게 배열 생성 
		int[][] arr = new int[n+1][6];
		
		for(int i =1; i<= n; i++) {	
			for(int j=1; j<=5; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		System.out.println(T.solution(n, arr));
	}
} 