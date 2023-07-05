package to_0705_3;

import java.util.Arrays;
import java.util.Scanner;

/*벨만 포드 | 타임머신 */
class Edge{
	int st, ed, val;
	Edge(int st, int ed, int val){
		this.st= st;
		this.ed = ed;
		this.val = val;
	}
}
public class Main {
	static int N, M;
	static long distance[];
	static Edge edges[];
	static final long INF = Integer.MAX_VALUE;
	//벨만 포드
	static boolean bellmanFord(int start) {
		distance[start] = 0;//시작점 세팅 
		
		for(int i=0; i<N-1; i++) {
			for(int j=1; j<=N; j++) { //얘가 문제였던 거 같다 .
				Edge cur = edges[j];//각 j번째 엣지 
				if(distance[cur.st] != INF && distance[cur.ed] > distance[cur.st]+cur.val) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N= kb.nextInt();
		M=kb.nextInt();
		edges = new Edge[M+1];
		distance = new long[N+1];
		
		Arrays.fill(distance, INF);
		
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			edges[i] = new Edge(a, b, c);
		}
		
		boolean flag = bellmanFord(1);
		
		if(!flag) { ///사이클이 없을 경우 
			for(int i=2; i<=N; i++) {
				if(distance[i] == INF) {//방문 안한 경로없는 애면 
					System.out.println("-1");//-1 출력
				}else {//경로 있따면 
					System.out.println(distance[i]);
				}
			}
		}else if(flag == true) {//사이클이 존재할 경우 
			System.out.println("-1");
		}
	}
}