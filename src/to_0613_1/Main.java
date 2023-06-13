package to_0613_1;

import java.util.Scanner;

/*1926번. 그림 - DFS 로 풀이 */
public class Main {
	static int N, M;
	static int[][] picture;
	static boolean[][] visited;
	
	//방향 -상하좌우
	static int[]dx = {0, 0, 1, -1};
	static int[]dy = {1, -1, 0, 0};
	
	//정답용
	static int num;//그림 넘버이자, 총개수가 누적될 변수 
	static int count;
	static int max = 0;
	
	//DFS
	static void DFS(int x, int y) {
		visited[x][y] = true;//방문 처리 
		//각 개수 너비 탐색 
		count++;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || ny <0 || nx >=N || ny >= M) continue;
			if(picture[nx][ny] == 0 || visited[nx][ny] == true) continue;
			
			//그 외에 대해서는 깊이 DFS 탐색 
			DFS(nx, ny);
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner kb =new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		
		picture = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				picture[i][j] = kb.nextInt();
			}
		}
		//호출
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				//색칠된 그림이면서 방문 전인 좌표에 대하여 차례로 전진 
				if(picture[i][j]==1 && !visited[i][j]) {
					num++;//번호 ++처리 == DFS 호출 횟수가 총 그림개수가 됨
					DFS(i, j);
					//여기서 복귀된 count를 Arraylist에 담아?
					max = Math.max(max, count);
					
					count= 0; //여기서 다 시 0 세팅
				}
				
			}
		}
		System.out.println(num);
		System.out.println(max);
	}
}