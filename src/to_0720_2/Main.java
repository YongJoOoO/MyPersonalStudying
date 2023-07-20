package to_0720_2;

import java.util.Arrays;
import java.util.Scanner;

//벨만 포드 알고리즘 
class Edge {
	int s;//시작점
	int e;//끝점
	int val;//가중치
	Edge(int s, int e, int val){
		this.s = s;
		this.e = e;
		this.val = val;
	}
}
public class Main {
	static int N, M;
	static long distance[];
	static Edge[] edges;
	static final int INF = Integer.MAX_VALUE;
	//벨만 포드
	static boolean bellmanFord(int start) {
		distance[start] =0;
		for(int i=0; i<N; i++) {//노드-1 번 반복 한 답 세팅 확인 
			for(int j =0; j<M; j++) {
				Edge ed = edges[j];
				//더 작은 거리 업데이트 
				if(distance[ed.s] != INF && distance[ed.e] > distance[ed.s]+ ed.val) {
					distance[ed.e] = distance[ed.s] + ed.val;
				}
			}
		}
		
		//한 번 더 확인용
		for(int i=0; i<M; i++) {
			Edge ed = edges[i];
			if(distance[ed.s] != INF && distance[ed.e] > distance[ed.s]+ed.val) {
				return true;//사이클 존재 
			}
		}
		return false; //발견 안됐으면 false 
		
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		distance= new long[N+1];
		edges = new Edge[M+1];
		
		Arrays.fill(distance, INF);
	
		//입력받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b=  kb.nextInt();
			int c = kb.nextInt();
			edges[i] = new Edge(a, b, c);
		}
		
		//벨만포드 호출
		boolean flag = bellmanFord(1);//음수 가중치 판별 
		
		if(!flag) {
			for(int i=2; i<=N; i++) {
				if(distance[i] == INF) {
					System.out.println("-1");
				}else {
					System.out.println(distance[i]);
				}
			}
		}else {
			System.out.println("-1");
		}
	}

}
