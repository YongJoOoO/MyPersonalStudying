package to_24_0117_1;

import java.util.Scanner;

/**
 * 1956번. 운동 - 플로이드 문풀 
 * @author MYLG
 *
 */
public class Main {
	static final int INF = 10000001;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int V = kb.nextInt();
		int E = kb.nextInt();
		
		int[][] distance = new int[V+1][V+1];
		
		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				if(i==j) distance[i][j] = 0;
				else {
					distance[i][j] = INF;
				}
			}
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
		
		int answer = INF;
		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				if(i != j && distance[i][j] != INF && distance[j][i] != INF) {
					answer = Math.min(answer, distance[i][j] + distance[j][i]);
				}
			}
		}
		
		if(answer == INF) System.out.println(-1);
		else System.out.println(answer);
	}
}