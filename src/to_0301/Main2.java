package to_0301;

import java.util.Scanner;

/* 2-10. 봉우리
 *  [입력]
	첫 줄에 자연수 N이 주어진다.(2<=N<=50)
	두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 
	각 자연수는 100을 넘지 않는다.
    [출력] 봉우리 개수 출력 
 * */
public class Main2 {
	//상하좌우 인덱스 지칭 목적의 변수 두개 생성
	int [] dx = {-1, 0, 1, 0};
	int [] dy = {0, 1, 0, -1};
			 //  상, 우, 하, 좌 
	//솔루션 함수 
	public int solution(int n, int[][]arr) {
		int answer = 0;	
		
		//각각의 arr[i][j] vs 상. 하,좌,우 비교해서 봉우리 카운팅
		for(int i = 0; i< n; i++) {
			for(int j = 0; j<n; j++) {
				//봉우리 판별
				boolean flag = true;
				
				//상하좌우 탐색용 dx, dy
				for(int k = 0; k<4; k++) {
					int nx = i+dx[k]; //행 좌표
					int ny = j+dy[k]; //열 좌표
					//[경계 걸러내면서] 봉우리 아닌 경우 
					if( nx>=0 && nx<n && ny  >=0 && ny <n && arr[nx][ny] >= arr[i][j]) {
						flag = false;// f 주고
						break;
					}
				}
				//통과한 상태는 봉우리 맞으니까 카운팅 
				if(flag) answer++; //여기서 카운팅
			}
		}
		return answer;
	}
	
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		Scanner kb = new Scanner(System.in);
		//입력
		int n = kb.nextInt();
		int[][] arr = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		//출력
		System.out.println(T.solution(n, arr));
	}
}