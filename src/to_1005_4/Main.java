package to_1005_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


//아기상어 BFS
class Fish {
	int x, y, move;
	Fish(int x, int y, int move){
		this.x = x;
		this.y = y;
		this.move = move;
	}
}
public class Main {
	static int N, px, py, time=0, size = 2;
	static int[][] map;
	static boolean[][] chk;
	//4방향 
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	//물고기 먹이 정렬 
	//먹이 정렬 - 가장 가까운 물고기 찾기 -ArrayList에 담아두고 찾기 
		static void preySort(List<Fish> list) {
			Collections.sort(list, new Comparator<Fish>() {
				@Override
				public int compare(Fish o1, Fish o2) {
					// 1. 가장 가까운(move) 2. 가장 위 (x) , 3.가장 왼쪽(y)
					if(o1.move == o2.move) {
						if(o1.x == o2.x) {
							// 가장 왼쪽
							return o1.y-o2.y;
						}else {
							// 가장 위  
							return o1.x-o2.x;
						}
					}else {
						// 가장 가까운 곳 
						return o1.move- o2.move;
					}
				}
			});
		}
	//BFS
	static void BFS(int x, int y) {
		int eating = 0;
		px = x; py = y;
		while(true) {
			Queue<Fish> Q = new LinkedList<>();
			List<Fish> preyList = new ArrayList<>();
			chk = new boolean[N][N];
			
			chk[px][py] = true;
			Q.offer(new Fish(px, py, 0));
			
			while(!Q.isEmpty()) {
				Fish cur = Q.poll();
				int cur_move = cur.move;
				
				for(int k=0; k<4; k++) {
					int nx = cur.x + dx[k];
					int ny = cur.y + dy[k];
					if(nx< 0 || ny <0 || nx>=N || ny >= N  || map[nx][ny] == 0) continue;
					if(chk[nx][ny] ) continue;
					chk[nx][ny] = true;
					//상어 사이즈 보다 작거나 같은 물고기들 중에서 
					if(map[nx][ny] <= size) {
						//같은 애는 못 먹으니까
						//size보다 작은 애들 물고기들은 
						if(map[nx][ny] < size) {
							//리스트에 담아두고, 그만큼 가는 위치도 담기 
							preyList.add(new Fish(nx, ny, cur_move+1));
						}
						//기본적으로 같던 작던 Q에는 담아두기 
						Q.offer(new Fish(nx, ny, cur_move+1));
					}
				}
			}
			
			//이제 먹이 list에 대하여 
			if(preyList.size() == 0) {
				//아예 먹을 거 없으면 break; 걸기
			}else {
				if(preyList.size() > 1) {
					preySort(preyList);//정렬시켜서 
				}
				
				//첫 물고기에 대하여 
				Fish eat = preyList.get(0);
				time += eat.move;//움직인 거리를 세팅 
				eating++;//먹은 물고기 수 ++ 
				
				//아기 상어는 '먹은 물고기의 위치'로 재세팅 
				map[px][py] = 0; //기존의 상어 위치는 0으로 처리하고 
				px = eat.x;
				py = eat.y;
				map[px][py] = 9;//상어 위치 
				
				//아기 상어크기== eating수 -> 사이즈 크기 +1
				if(size == eating) {
					size++;
					eating = 0;
				}
				
			}
			
			
		}
	}
	
	//실행메인
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st = null;
		
		int st_x = 0, st_y = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num == 9) {
					st_x = i;
					st_y = j;
				}
			}
		}
		BFS(st_x, st_y);
		System.out.println(time);
	}

}