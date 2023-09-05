package to_0905_E;
import java.util.Scanner;

/*1743번. 음식물 피하기 - DFS &BFS*/
public class Main {	
	static int N, M, K;
	static int[][] map;
	static boolean[][] visited;
	static int count;
	
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//DFS
	static void DFS(int x, int y) {
		count++;//재귀 호출될 때마다  +1 처리
		visited[x][y] = true;
		
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx <0 || ny <0 || nx >= N || ny>= M) continue;
			if(!visited[nx][ny] && map[nx][ny] == 1) {
				DFS(nx, ny);//더 깊이 탐색하면서 나아감 
			}
		}
		
	}

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		K = kb.nextInt();
		
		map = new int[N][M];
		visited= new boolean[N][M];
		
		for(int i=0; i<K; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			map[a-1][b-1] =1;
		}
	
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) {
					count = 0;//여기서 0으로 초기화 해두고 
					DFS(i, j); //시작하지
					max = Math.max(max, count);
				}
			}
		}
		System.out.println(max);
	}
}