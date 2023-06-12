package to_0612_4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*BFS 로 풀기 - BFS 호출 횟수 = 총 단지 수 , 각 뿌리에서 출발해서 인접 정점으로 퍼져가는데 
 * 인접정점 담은 Queue 가 빈 상태 되면 종료된다. */
public class Main {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	
	static int apartNum;
	static int[] answer = new int[25*25];
	
	//방향 존 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//BFS
	static void BFS(int x, int y) {
		Queue<int[]> Q = new LinkedList<>();
		
		visited[x][y] = true;
		Q.add(new int[] {x,y});
		answer[apartNum]++;
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx<0 ||ny<0 || nx>=n ||ny>=n) continue;
				if(map[nx][ny] == 0 || visited[nx][ny] == true) continue;
				
				visited[nx][ny] = true;
				Q.add(new int[] {nx, ny});
				answer[apartNum]++; //여기서도 ++ 아파트 카운팅 
			}
		}
		
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		map = new int[n][n];
		visited =new boolean[n][n];
		
		for(int i =0; i<n; i++) {
			String s = kb.next();
			for(int j = 0; j<n; j++) {
				map[i][j] = Character.getNumericValue(s.charAt(j));
			}
		}
	
		for(int i=0; i<n; i++) {
			for(int j =0; j<n; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					apartNum++;//아파트 num
					BFS(i, j);
				}
			}
		}
		//정답 메이킹 
		Arrays.sort(answer);
		System.out.println(apartNum);
		
		for(int x : answer ) {
			if(x==0) continue;
			System.out.println(x);
		}
	}
}