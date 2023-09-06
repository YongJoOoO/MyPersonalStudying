package to_0906_7;

import java.util.*;

/*11265번. 끝나지 않는 파티 - 플로이드 */
public class Main {
	static int N, M;
	static int[][] distance;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		distance = new int[N+1][N+1];//기본 거리 
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				distance[i][j] = kb.nextInt();
			}
		}
		
		//우선 업데이트 시키자. 
		//플로이드 
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					//기존 경로보다 k를 거쳐서 더 최단 거리로 갈 방법 존재하면 갱신시킨다.
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
		
		//이제 완전 최단 경로로 세팅한 상태에서 요청 M개의 서비스를 확인
		ArrayList<String > answer = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			int a= kb.nextInt();
			int b = kb.nextInt();
			int T = kb.nextInt();//이 기준 시간 내에 갈 수 있냐 ? 
			
			if(distance[a][b] <= T) answer.add("Enjoy other party");
			else if(distance[a][b] > T) answer.add("Stay here");
		}
		
		//완성된 상태 출력 
		for(String x : answer) {
			System.out.println(x);
		}
	}
}