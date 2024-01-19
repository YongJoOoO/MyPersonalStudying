package to_24_0119_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1956번. 운동 - 플로이드 문풀 
 * @author MYLG
 *
 */
public class Main {
	static final int INF = 10000001;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int V = kb.nextInt();
		int E = kb.nextInt();
		
		int[][] distance = new int[V+1][V+1];
		
		for(int i=1; i<=V; i++) {
			Arrays.fill(distance[i], INF); //그냥 모든 distance에 대한 INF 초기화 처리함
		}
		
		//세팅
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			if(distance[a][b] > val) {
				distance[a][b] = val;
			}
		}
		
		//플로이드 시작
		for(int k = 1; k<=V; k++) {
			for(int i=1; i<=V; i++) {
				for(int j=1; j<=V; j++) {
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				if(distance[i][j] == INF) System.out.print("INF ");
				else System.out.print(distance[i][j]  + " ");
			}
			System.out.println();
		}
		
		/**
		 * 
		 * disatnce[i][i] : i -> i : i로 출발해서 i로 도착 (즉, 자기 자신에 대한 경로이므로 0 처리를 해둠)
		 * 그러나, 채윤님의 경우, i=j 부분을 따로 0처리를 하는 대신 INF로 초기화를 해두었기 때문에, 
		 * 플로이드 적용 후 distance[i][i] 에 대한 최단거리가 다음과 같이 갱신될 것이다. 
		 * distance[i][i] = i -> k -> i : 즉, 특정 경유지 k를 거쳐서 들어온 최단 거리를 저장하도록 함 (결과적으로는 사이클이 담김)
		 *  
		 */
		int answer = INF;
		for(int i=1; i<=V; i++) { 
			//answer = Math.min(answer, distance[i][j] + distance[j][i] ) 가 아니라 
			answer = Math.min(answer, distance[i][i]); //이렇게 i,i (즉, i -> 특정 경유지 k -> i 자기 자신으로 되돌아온 (사이클) 최단 경로가 담기게 되는 것이다. )
		}
		//System.out.println(answer);
	}

}
