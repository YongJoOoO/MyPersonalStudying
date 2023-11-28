package to_1128_A;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 송아지 찾기 BFS 
 * @author MYLG
 *
 */
public class Main {
	static int S, E;
	static boolean[] visited;
	static int[] dx = {-1, +1, 5};
	//BFS
	static int BFS(int S) {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(S);
		visited[S]=  true;
		
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			
			for(int i=0; i<len; i++) {
				int cur = Q.poll();
				
				for(int k = 0; k<3; k++) {
					int nx = cur + dx[k];
					if(nx == E) {
						return L+1;
					}
					if(nx >= 1 && nx <= 10000 && !visited[nx]) {
						visited[nx]= true;
						Q.offer(nx);
					}
				}
			}
			L++;
		}
		return 0;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		S = kb.nextInt();
		E = kb.nextInt();
		
		visited= new boolean[20];
		
		System.out.println(BFS(S));
	}	
}