package to_0911_3;

import java.util.Scanner;

/*3184번. 양 - DFS & BFS 문풀 */
public class Main {
	static int R, C;
	static int[][] map;
	static boolean[][]visited;
	static int[] ans;
	//4방향 탐색 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//DFS
	static int[] DFS(int x, int y) {
		visited[x][y] = true;
		if(map[x][y] == 2) {//늑대
			ans[1]++;
		}else if(map[x][y] == 3) {//양 
			ans[0]++;
		}
		
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx <0 || ny<0 || nx >= R || ny>=C ) continue;
			 
			if(visited[nx][ny] == true || map[nx][ny] == 1) continue;
			DFS(nx, ny);//개수 처리만 하고 갈 수 있는 데까진 쭉 감
			
		}
		
		return ans;
	}
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		R = kb.nextInt();
		C = kb.nextInt();
		map = new int[R][C];
		visited = new boolean[R][C];
		ans = new int[2]; //ans[0] 양,  ans[1] 늑대
		
		//데이터 입력ㅂ다기 
		for(int i=0; i<R; i++) {
			String tmp = kb.next();
			for(int j=0; j<C; j++) {
				if(tmp.charAt(j) == '.') { //빈 공간 0
					map[i][j] = 0;
				}else if(tmp.charAt(j) == '#') { //울타리 1
					map[i][j] = 1;
				}else if(tmp.charAt(j) == 'v') { //늑대 2
					map[i][j] = 2;
				}else if(tmp.charAt(j) == 'o') { //양 3
					map[i][j] = 3;
				}
			}
		}
	
		int w =0;//늑대 
		int s =0;//양
		//호출 
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(!visited[i][j] && map[i][j] !=1) {
					ans[0] = ans[1] = 0;//초기화 해놓고 
					int[] x = DFS(i, j);
					if(x[1] >= x[0]) {//늑대가 더 많으면 
						w += x[1];
					}else if(x[1]< x[0]) { //양이 더 많ㅇ므녀 
						s += x[0];
					}
				}
			}
		}
		System.out.println(s + " " + w);//늑대, 양 
		
	}
}