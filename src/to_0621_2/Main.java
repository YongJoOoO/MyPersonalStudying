package to_0621_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*백준 1325번. 효율적인 해킹 */
public class Main {
	static int N, M;
	
	static boolean visited[];
	static int answer[];
	static ArrayList<ArrayList<Integer>> graph;
	//BFS
	static void BFS(int n) {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(n);
		visited[n] = true;

		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(int nx : graph.get(cur)) {
				if(!visited[nx]) {
					visited[nx] = true;
					Q.add(nx);
					answer[nx]++;//방문할 때마다 ++ 처리
				}
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();

		answer = new int[N+1];
		graph = new ArrayList<>();
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		//입력받기
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			graph.get(a).add(b);
		}
		
		//각 모든 노드에 대하여 
		for(int i=1; i<=N; i++) {
			visited = new boolean[N+1];
			BFS(i);
		}
		
		//출력
		int max = Integer.MIN_VALUE;
		for(int x : answer) {
			if(x > max) {
				max = x;
			}
		}
		
		for(int i=0; i<N+1; i++) {
			if(answer[i] == max) {
				System.out.print(i+" ");
			}
		}
	}
}