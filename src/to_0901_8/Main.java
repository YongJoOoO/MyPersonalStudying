package to_0901_8;

import java.util.*;
import java.util.PriorityQueue;
import java.util.Scanner;

/*14497번. 주난의 난 - 다익스트라 */
public class Main {

	static int N, M;
	static int x1, y1, x2, y2;
	static int[][] map;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//다익스트라 
	static int[][] dijkstra(int x, int y){
		int[][] dist = new int[N][M];
		for(int i=0; i<N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
		
		PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[2]-b[2]);
		dist[x][y] = 0;
		pQ.offer(new int[] {x, y, 0});
		
		while(!pQ.isEmpty()) {
			int[] cur = pQ.poll();
			if(cur[2] > dist[cur[0]][cur[1]]) continue;
			
			if(cur[0]==x2-1 && cur[1] == y2-1) {
				return dist;//여기서 그냥 넘겨줘도 됨 
			}
			
			for(int k = 0; k<4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if(nx <0 || ny <0 || nx >= N || ny >= M) continue;
				
				if(dist[nx][ny] > dist[cur[0]][cur[1]] + map[nx][ny]) {
					dist[nx][ny] = dist[cur[0]][cur[1]] + map[nx][ny];
					pQ.offer(new int[] {nx, ny, dist[nx][ny]});
				}
			}
		}
		return dist;
	}
	
	//main 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		x1 = kb.nextInt();
		y1 = kb.nextInt();
		x2 = kb.nextInt();
		y2 = kb.nextInt();
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			
			for(int j=0; j<M; j++) {
				if(tmp.charAt(j) == '#') {
					map[i][j] = 0;
				}else if(tmp.charAt(j) == '*') {
					map[i][j] = 0;
				}else {
					map[i][j] = Character.getNumericValue(tmp.charAt(j));
				}
			}
		}
		
		int[][] dist1 = dijkstra(x1-1, y1-1);
		
		System.out.println(dist1[x2-1][y2-1] + 1);
		
	}

}