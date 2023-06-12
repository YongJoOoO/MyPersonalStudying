package to_0612_C;

import java.util.*;

/* 1926번. 그림 - BFS */
public class Main {
	
	static int dx[] = {0, 0, -1, 1};
	static int dy[]	= {1, -1, 0, 0};
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	
	static int Pnum = 0;//그림 묶음 번호 
	static int P[] = new int[10*10]; //각 그림묶음별 개별 수량
	
	//BFS
	static void BFS(int x, int y) {
		Queue<int[]> Q = new LinkedList<>();
		
		P[Pnum]++; //각 번호별 개수 ++ 
		visited[x][y] = true;
		Q.add(new int[] {x, y});
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
				if(map[nx][ny] == 0 || visited[nx][ny]== true) continue;
				
				Q.add(new int[] {nx, ny});
				visited[nx][ny] = true;
				P[Pnum]++;
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = kb.nextInt();
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					Pnum++;
					BFS(i,j);
				}
			}
		}
		
		//정답존
		System.out.println(Pnum);//총 그림수
		int max = Integer.MIN_VALUE;
		for(int x : P) {
			if(max < x) max = x;
		}
		
		System.out.println(max);
	}
}