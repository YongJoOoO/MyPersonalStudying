package to_0613_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*1167번. 트리의 지름 
 * */
class Edge{
	int e; 
	int v;
	Edge(int e, int v){
		this.e = e;
		this.v = v;
	}
}

public class Main{
	static boolean visited[];
	static int[] distance;
	static ArrayList<Edge>[] A;
	
	//BFS
	static void BFS(int i) {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(i);
		visited[i]= true;
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(Edge x : A[cur]) {
				int e = x.e;
				int v = x.v;
				if(!visited[e]) {
					visited[e] = true;
					Q.add(e);
					distance[e] = distance[cur]+v;
				}
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		A = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			A[i] = new ArrayList<Edge>();
		}
		
		for(int i=0; i<N; i++) {
			int S = kb.nextInt();
			while(true) {
				int E = kb.nextInt();
				if(E==-1) break;
				int V = kb.nextInt();
				A[S].add(new Edge(E,V));
			}
		}
		distance = new int[N+1];
		visited = new boolean[N+1];
		BFS(1);
		
		int Max=1;
		
		for(int i=2; i<=N; i++) {
			if(distance[Max] <distance[i]) Max =i;
		}
		
		distance = new int[N+1];
		visited=new boolean[N+1];
		
		BFS(Max);
		
		Arrays.sort(distance);
		System.out.println(distance[N]);
	}
}