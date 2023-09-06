package to_0906_6;

import java.util.*;
import java.util.Scanner;

/*백준 11657번. 타임머신 - 벨만포드 */
class Edge {
	int s, e, val;
	Edge(int s, int e, int val){
		this.s = s;
		this.e = e;
		this.val = val;
	}
}
public class Main {
	static int N, M;
	static long[] distance;
	static ArrayList<Edge>graph;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		distance= new long[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		graph = new ArrayList<>();
		
		//데이터 입력 받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			int c = kb.nextInt();
			//방향 그래프 
			graph.add(new Edge(a, b, c));
		}
		
		//시작점 초기화
		distance[1] =  0;
		
		//1) N-1번 반복 하기 
		for(int i=0; i<N-1; i++) {//총 N-1번
			for(int j=0; j<M; j++) {//전체 엣지를 순회 
				Edge cur = graph.get(j);
				
				if(distance[cur.s] != Integer.MAX_VALUE && distance[cur.e] > distance[cur.s] + cur.val) {
					distance[cur.e] = distance[cur.s] + cur.val;
					
				}
			}
		}
		
		boolean flag = false; 
		
		//2) 1번 더 반복했을 때 변경점 있으면 -1 출력 아니면 그냥 값 출력 
		for(int i=0; i<M; i++) {
			Edge cur = graph.get(i);
			if(distance[cur.s] != Integer.MAX_VALUE && distance[cur.e] > distance[cur.s] + cur.val) {
				flag = true;
			}
		}
		
		//3) 답 출력 
		if(flag == true) System.out.println("-1");
		else {
			for(int i=2; i<=N; i++) {
				System.out.println(distance[i]);
			}
		}
	}
}