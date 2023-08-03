package to_0803_C;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//벨만 포드 11657번. 타임머신 문풀 복습 
class Edge{
	int s, e, val;
	Edge(int s, int e, int val){
		this.s =s;
		this.e= e;
		this.val = val;
	}
}

public class Main {
	static long[] distance;//거리
	static final int INF = Integer.MAX_VALUE;
	
	//실행메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();//노드
		int M = kb.nextInt(); //간선 
		
		Edge[] edges = new Edge[M+1];//간선 개수 
		distance=  new long[N+1];
		
		Arrays.fill(distance, INF);
		
		//데이터 입력받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			int v = kb.nextInt();
			edges[i] = new Edge(a, b, v);
		}
		
		//벨만-포드 시작
		//1) 시작 저점 처리 
		distance[1] = 0;
		
		//2) N-1번 순회하면서 정답 배열 갱신 
		for(int i=1; i<N; i++) {//N-1번 반복 
			for(int j=0; j<M; j++) {//각각 M번 순회하면서 간선 
				Edge cur = edges[j];
				if(distance[cur.s] != INF && distance[cur.e] > distance[cur.s]+ cur.val) {
					distance[cur.e] = distance[cur.s] + cur.val;//갱신 처리 
				}
			}
		}
		
		//3) 음수 사이클 존재여부 확인 
		boolean cycle = false;
		
		for(int i=0; i<M; i++) {
			Edge cur = edges[i];
			if(distance[cur.s] != INF && distance[cur.e] > distance[cur.s] + cur.val) {
				cycle = true;
			}
		}
		//4) 정답 출력 
		if(!cycle) {
			for(int i=2; i<=N; i++) { //1번에서 다른 노드로 가는 최단 경로 
				if(distance[i] == INF) {
					System.out.println("-1");
				}else {
					System.out.println(distance[i])	;
				}
			}
		}else {
			System.out.println("-1");
		}
	}
}