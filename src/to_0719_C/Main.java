package to_0719_C;

import java.util.Arrays;
import java.util.Scanner;

/*11657번. 벨만포드 */
class Edge { 
	int st, ed, time;
	Edge(int st, int ed, int time){
		this.st= st;
		this.ed = ed;
		this.time = time;
	}
}
public class Main {
	static int N, M;
	static long distance[];
	static Edge edges[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		distance= new long[N+1];
		edges = new Edge[N+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		for(int i=0; i<M; i++) {
			int st = kb.nextInt();
			int ed = kb.nextInt();
			int time = kb.nextInt();
			edges[i] = new Edge(st, ed, time);
		}
		
		//벨만포드 알고리즘 수행 
		distance[1] = 0;//1부터 시작 
		
		for(int i=1; i<N; i++) { //각각의 노드들이 
			for(int j=0; j<M; j++) {
				Edge edge = edges[j];//각 엣지에 대하여 
				if(distance[edge.st] != Integer.MAX_VALUE && distance[edge.ed] > distance[edge.st]+edge.time) {
					distance[edge.ed] = distance[edge.st] + edge.time;
				}
			}
		}
	}

}
