package to_24_0409_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 3190번. 뱀 - 구현 문풀 
 * @author MYLG
 *
 */
public class Main {
	static int N, K, L;
	static int[][] board;
	//사방향 
	static int[] dx = {0, 1, 0, -1}; //우, 하, 좌, 상 (시계방향)
	static int[] dy = {1, 0, -1, 0};
	//query pQ
	static Queue<int[]> pQ ;
	//solve
	static int BFS() {
		Queue<int[]> Q= new LinkedList<>();
		Q.offer(new int[] {1, 1});
		board[1][1] = 2;//자기 몸임 
		int time = 0;
		int k = 0;//오른쪽 향함
		int[] cur = new int[] {1, 1}; //시작
		
		while(true) {
			//한칸씩 나아가봄 
			int nx = cur[0] + dx[k];
			int ny = cur[1] + dy[k];
			time++;
			
			//1) 경계 벗어나면 out
			if(nx <1 || nx >N || ny <1 || ny >N) break;//찰풀
			
			//2) 자기 몸 만나도 아웃
			if(board[nx][ny] == 2) break;
			
			//3) 사과인지 여부에 따라 다름
			//사과 아닌 경우
			if(board[nx][ny] == 0) {
				int[] tmp = Q.poll();//직전 거리 
				board[tmp[0]][tmp[1]] = 0;
			}
			
			//4) 초당 방향 전환 필요 
			if(!pQ.isEmpty()) {
				if(time == pQ.peek()[0]) {
					int[] q = pQ.poll();
					k += q[1];
					if(k < 0) k = 3;
					if(k > 3) k = 0;
				}
			}
			
			board[nx][ny] = 2;
			Q.offer(new int[] {nx, ny});
			cur[0] = nx;
			cur[1] = ny;
		}
		return time;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		N = kb.nextInt();
		K = kb.nextInt();
		board = new int[N+1][N+1];
		
		for(int i=0; i<K; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			board[a][b] = 1;//사과 
		}
		
		L = kb.nextInt();
		pQ=  new LinkedList<>();
		for(int i=0; i<L; i++) {
			int t = kb.nextInt();
			String dir = kb.next();
			if(dir.equals("D")) {
				pQ.offer(new int[] {t, 1});
			}
			if(dir.equals("L")){
				pQ.offer(new int[] {t, -1});
			}
		}		
		System.out.println(BFS());	
	}
}