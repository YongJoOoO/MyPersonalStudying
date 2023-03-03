package to_0301;

import java.util.Scanner;

/* 2-12. 멘토링 
[입력]
첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.
두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 
학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.
만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면
3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.
[출력]
첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.
*/
public class Main4 {
	//솔루션 함수
	public int solution(int n, int m, int[][] arr) {
		int answer = 0;
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				int cnt = 0;
				for(int k = 0; k<m; k++) {
					int pi = 0, pj=0;
					for(int s =0; s<n; s++) {
						if(arr[k][s] == i) pi = s;
						if(arr[k][s] == j) pj = s; 
					}
					if(pi<pj) cnt++;
				}
				if(cnt==m) {
					answer++;
				}
			}
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main4 T = new Main4();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		int[][] arr = new int[m][n];
		for(int i =0; i<m; i++) {
			for(int j =0; j<n; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		
		System.out.println(T.solution(n, m, arr));
	}
}