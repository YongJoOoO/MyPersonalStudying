package to_0612_9;

import java.util.ArrayList;
import java.util.Scanner;

/* 1012번. 유기농 배추 DFS 
 * */
public class Main {
	static int T;
	static int N, M, e;
	
	static int [][] map;
	static boolean[][] visited;
	static ArrayList<Integer> arr = new ArrayList<>();
	
	//방향
	static int dx[] = {0, 0 , 1, -1};
	static int dy[] = {1, -1, 0 ,0};
	
	//DFS
	static void DFS(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 || ny<0 || nx>= M || ny>=N) continue;
			if(map[nx][ny] ==0 || visited[nx][ny] == true) continue;
			
			//그 외의 경우 다음 경로로 더 깊이 탐색 
			DFS(nx,ny);
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		T = kb.nextInt();
		
		for(int t=1; t<=T; t++) { //각 케이스별 
			M = kb.nextInt(); 
			N = kb.nextInt(); 
			e = kb.nextInt(); 
			
			map = new int[M][N];
			visited = new boolean[M][N];
			
			for(int i=0; i<e; i++) {
				map[kb.nextInt()][kb.nextInt()] = 1;
			}
			
			int answer = 0;
			//DFS 움직이기 
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						//호출-복귀 덩어리가 총 개수 
						DFS(i, j);
						answer++;
					}
				}
			}
			
			arr.add(answer);//이번 케이스의 정답은 여기에 답고 
		}
		
		
		//정답 출력 
		for(int x : arr) {
			System.out.println(x);
		}
		
	}

}