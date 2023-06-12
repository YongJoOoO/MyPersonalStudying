package to_0612_1;

import java.util.*;

/*2667번. 단지번호 붙이기 - DFS 로 풀어보기 */
public class Main {
	//정적 변수 
	static int N; //정사각형 크기
	static int[][] apart;//담을 용도
	//방향 변수 
	static int dx[] = {0, 0, 1, -1};
	static int dy[]	= {1, -1, 0, 0};
	
	//총 개수 
	static int apartNum = 0;
	//방문 여부
	static boolean[][] visited;
	//오름차순 정렬해야 하는 1차원 아파트 개수
	static ArrayList<Integer> aparts = new ArrayList<>();
	//DFS
	static void DFS(int x, int y ) {
		
		//방문 처리
		visited[x][y] = true;
		//현 단지 내의 아파트 개수 처리
		aparts.get(apartNum++);
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			//범위 벗어나면 패스 
			if(nx <0 || ny <0 || nx >=N|| ny >=N) {
				continue;
			}
			//길이 아니거나 이미 방문한 경우에도 패스 
			if(apart[nx][ny] == 0 || visited[nx][ny] == true) {
				continue;
			}
			
			//그 외에는 
			visited[nx][ny] = true;
			DFS(nx, ny);//더 깊이 방문 
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		N = kb.nextInt();
		apart = new int[N][N];
		visited = new boolean[N][N];
		//입력받기 
		for(int i=0; i<N; i++) {
			String s = kb.next();
			for(int j =0; j<N; j++) {
				apart[i][j] = s.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j =0; j<N; j++) {
				if(apart[i][j] == 1 && !visited[i][j]) {
					//DFS호출 횟수(반환 포함) == 총 단지 묶음 개수 
					apartNum++;
					aparts.add(apartNum);
					DFS(i, j);
				}
			}
		}
		
		//정답 오름차순 정려  
		Collections.sort(aparts);
		
		System.out.println(apartNum);//총 단지 수 
		for(int x : aparts) {
			System.out.println(x);
		}
	}
}