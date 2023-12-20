package to_1220_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 7562번. 나이트의 이동 - BFS 문풀 
 * @author MYLG
 *
 */
public class Main {
	//8방향으로 뻗어감 
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
	
	static int TC;
	static int I;
	static int[][] map;
	
	//BFS
	static int BFS(int[] st, int[] ed) {
		int[][] result = new int[I][I];
		
		for(int i=0; i<I; i++) {
			Arrays.fill(result[i], Integer.MAX_VALUE);
		}
		
		Queue<int[]> Q = new LinkedList<>();
		boolean[][] visited = new boolean[I][I];
		Q.offer(new int[] {st[0], st[1]});
		visited[st[0]][st[1]] = true;
		result[st[0]][st[1]] = 0;
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			//목표지점
			if(cur[0] == ed[0] && cur[1] == ed[1]) { //발견하면
				return result[ed[0]][ed[1]];
			}
			
			for(int k = 0; k<8; k++) { //1번에 뻗어갈 수 있는 방향들임 
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				//범위 벗어나거나 이미 방문한 좌표인 경우 넘어가고 
				if(nx <0 || nx >=I || ny <0 || ny >= I) continue;
				
				if(!visited[nx][ny]) {
					if(result[nx][ny] > result[cur[0]][cur[1]] + 1) {
						result[nx][ny] = result[cur[0]][cur[1]] + 1;
						visited[nx][ny] = true;
						Q.offer(new int[] {nx, ny});
					}
				}
			}
	
		}
		
		
		return 0;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		TC = kb.nextInt();
		
		List<Integer> answer = new ArrayList<>();
		
		for(int t=0; t<TC; t++) {			
			I = kb.nextInt();
			map = new int[I][I];
			
			int[] st = new int[2];
			int[] ed = new int[2];
			
			st[0] = kb.nextInt();
			st[1] = kb.nextInt();
			
			ed[0] = kb.nextInt();
			ed[1] = kb.nextInt();
			
			answer.add(BFS(st, ed));
		}
		
		for(int x : answer) System.out.println(x);
	}
}