package to_0803_5;

import java.util.Arrays;
import java.util.Scanner;

//벨만-포드 문제풀이
class Edge {
	int s, e, val;
	Edge(int s, int e, int val){
		this.s=s;
		this.e= e;
		this.val =val;
	}
}
public class Main {
	static final int INF = Integer.MAX_VALUE;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		int N = kb.nextInt();
		int M = kb.nextInt();
		
		long[] distance = new long[N+1]; 
		Edge[] edges = new Edge[M]; //간선 정보 담기 
		
		Arrays.fill(distance, INF);//초기화 
		
		//데이터 입력받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int v = kb.nextInt();
			edges[i]= new Edge(a, b, v);
		}
		
		//벨만포드 
		//1) 시작정점 처리 
		distance[1]= 0;
		
		//2) N-1번 반복하며 정답배열 세팅 
		for(int i=1; i<N; i++) { //N-1번 반복 
			for(int j=0; j<M; j++) {//1번 반복할 때, 모든 간선 순회하면서 
				Edge cur = edges[j];//현재 엣지에 대하여
				if(distance[cur.s] != INF && distance[cur.e] > distance[cur.s]+cur.val) {
					distance[cur.e] = distance[cur.s] + cur.val;
				}
			}
		}
		
		//3) 음수 사이클 존재 확인 
		boolean cycle = false;
		
		for(int i=0; i<M; i++) {
			Edge cur = edges[i];
			if(distance[cur.s] != INF && distance[cur.e] > distance[cur.s] + cur.val) {
				cycle = true;
			}
		}
		
		if(!cycle) {
			for(int i=2; i<=N; i++) {
				if(distance[i] == INF) {
					System.out.println("-1");
				}else {
					System.out.println(distance[i]);
				}
			}
		}else { //사이클 존재할 경우 
			//즉, 만약 무한히 시간을 오려잰으로 돌릴 수 있다면에 해당 
			System.out.println("-1");
		}	
	}
}