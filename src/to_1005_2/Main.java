package to_1005_2;

import java.util.*;
import java.util.Queue;
import java.util.Scanner;

class Fish{
	int fx, fy; //현재 좌표 
	int size;//상어 크기 
	int time;//시간 
	Fish(int fx, int fy, int size, int time){
		this.fx = fx;
		this.fy = fy;
		this.size = size;
		this.time = time;
	}
}
public class Main {
	
	static int N;
	static int[][] board;
	static Fish fs;
	
	//4방향             상,  좌, 하 , 우 
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0,  1};
	
	//BFS
	static int BFS() {
		//먹었는지 체크용
		boolean[][] visited = new boolean[N][N];
		Queue<Fish> Q = new LinkedList<>();
		//초기값 세팅 
		Q.offer(new Fish(fs.fx, fs.fy, fs.size, fs.time));
		//시작점의 baord값도 0으로 초기화
		board[fs.fx][fs.fy] = 0;
		visited[fs.fx][fs.fy] = true;
		
		while(!Q.isEmpty()) {
			Fish cur = Q.poll();
			
			for(int k=0; k<4; k++) {
				int nx = cur.fx + dx[k];
				int ny = cur.fy + dy[k];
				
				//좌표 범위 벗어나거나 빈 공간이거나 상어보다 큰 물고기일 경우 그냥 지나
				if(nx <0 || ny <0 || nx>=N || ny>= N || board[nx][ny] == 0 || cur.size < board[nx][ny] || visited[nx][ny] == true) continue;
				fs.time += 1;//시간++처리
				//사이즈가 같은 경우 = 지나는 가지만 못 먹고 
				if(board[nx][ny] == cur.size) {
					fs.fx = nx;
					fs.fx = ny;
				}
				if(board[nx][ny] < cur.size) {//더 작은 물고기는 먹을 수 있다.
					fs.fx = nx;
					fs.fy = ny;
					fs.size += board[nx][ny];
					
					board[nx][ny] = 0;//먹었으니까 빈공간으로 처리 
					visited[nx][ny] = true;
				}
				//현재의 갱신된 물고기 값을 갱신시킴
				Q.offer(new Fish(fs.fx, fs.fy, fs.size, fs.time));
			}
		}
		return fs.time;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		board = new int[N][N];
		//데이터 입력받기 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				board[i][j] = kb.nextInt();
				//아기 상어 발견 시 위치 초기화 시킴
				if(board[i][j] == 9) {
					fs = new Fish(i, j, 2, 0);
				}
			}
		}
		
		System.out.println(BFS());
		
		
	}	

}
