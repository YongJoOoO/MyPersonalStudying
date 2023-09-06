package to_0906_8;

import java.util.ArrayList;
import java.util.Scanner;

/*21940번. 가운데에서 만나기 - 플로이드 문풀*/
public class Main {
	static int N, M;
	static int[][] distance;
	static int K;//친구들 
	static int[] dosi;//친구들이 사는 위치 
	static final int INF = 1000001;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		//배열 초기화 해놓고 
		distance = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) distance[i][j] = 0;
				else distance[i][j] = INF; 
			}
		}
		
		//데이터 입력받기 - 기본적으로 각 도로로 가는 시간 담ㅁ아두고 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			int T= kb.nextInt();
			distance[a][b] = T;//일방 통행임
		}
		
		//친구 위치 받기 
		K = kb.nextInt();
		dosi = new int[K+1];
		for(int i=1; i<=K; i++) dosi[i] = kb.nextInt();//각 위치임 
		
		//플로이드 처리 
		//일단 최단거리로 세팅해놓고 
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(i==j) continue;
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
		
		int answer[] = new int[N+1];
		//우선 왕복거리 각 친구들위치에서 각 정점까지의 왕복거리를 answer에 담을 거임 
		for(int i=1; i<=N; i++) {
			for(int k=1; k<=K; k++) {
				int idx = dosi[k];//각 친구 위치 좌표
				//왕복 거리  최댓값을 담을 거임 
				answer[i] = Math.max(answer[i], distance[i][idx]+ distance[idx][i]);
			}
		}
		
		//이 상태에서 min값을 갖는 
		int min = INF;
		ArrayList<Integer> candi = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			if(min > answer[i]) {//더 작은 값 발견시 
				min = answer[i];
				candi.clear();//기존값 다 지우고 
				candi.add(i);//현재 정점 담기 
			}else if(min == answer[i]) { //이어 같은 값 여러 개일 경우 
				candi.add(i);//이어 붙이기 
			}
		}
		
		//답 출력 시, 여러 개면 오름차순 
		for(int x : candi) {
			System.out.print(x + " ");
		}
	}
}