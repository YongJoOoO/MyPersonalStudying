package to_0612_7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*BFS로 풀기 */
public class Main {
	static int n, m, st, ed;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean visited[];
	static int[] dist;//정답 존 
	//BFS
	static void BFS(int n) {
		Queue<Integer >Q = new LinkedList<>();
		
		visited[n] = true;
		Q.add(n);
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			
			if(cur == ed) break;
			
			for(int nx : graph.get(cur)) {
				//이미 확인한 정점일 경우 0 이상이므로 조건에 달아준다.
				if(!visited[nx] && dist[nx] == 0) { //여기서 nx 거리 0인 경우에 한해서 추가하니 됨 
					dist[nx] = dist[cur]+1; //직전 정점 거리 +1
					Q.add(nx);
				}
			}
		}
	}	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		st = kb.nextInt();
		ed = kb.nextInt();
		m = kb.nextInt();
		graph = new ArrayList<>();
		
		visited = new boolean[n+1];
		dist = new int[n+1];
		
		//공간 생성
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		//입력 받기
		for(int i=0; i<m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		BFS(st);
		
		if(dist[ed] == 0) {
			System.out.println(-1);
		}else {
			System.out.println(dist[ed]);
		}
	}
}