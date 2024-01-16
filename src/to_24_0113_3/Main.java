package to_24_0113_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 11657번. 타임머신 - 벨만 포드 문풀
 * @author MYLG
 *
 */
class Edge{
	int st, ed, val;
	Edge(int st, int ed, int val){
		this.st = st;
		this.ed= ed;
		this.val =val;
	}
}
public class Main {
	static final int INF = 10000001;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		
		
		ArrayList<Edge> graph = new ArrayList<>();
		
		//세팅 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			int val = kb.nextInt();
			graph.add(new Edge(a, b, val));
		}
		
		int[] distance = new int[N+1];
		Arrays.fill(distance, INF);
		//시작점 초기화
		distance[1] = 0;
		
		//처음엔 N-1번 순회함
		for(int i=0; i<N-1; i++) { //반복 횟수 지칭 
			
			for(int j=0; j<M; j++) { //매 반복마다 모든 간선에 대해 순회함
				Edge cur = graph.get(j);
				//다음 정점이 현재 정점값에 val 값 합쳐서 경유하여 가는 게 더 작을 때 갱신 
				if(distance[cur.st] != INF && distance[cur.ed] > distance[cur.st] + cur.val) {
					distance[cur.ed] = distance[cur.st] +cur.val;
				}
			}
		}
		
		boolean cycle = false;
		//이미 N-1번 돌았을 때 최단 경로가 되는 상태인데 만약 한 번 더 돌았을 떄 갱신되는 값이 존재할 경우 음수 사이클이 존재하는 거임
		for(int i=0; i<M; i++) {
			Edge cur = graph.get(i);
			if(distance[cur.st] != INF && distance[cur.ed] > distance[cur.st] + cur.val) {
				cycle = true;
			}
		}
		
		//음수 사이클이 존재한다는 건 경로가 없다는 거니까 -1 출력 
		if(cycle) {
			System.out.println(-1);
		}else {
			for(int i=2; i<=N; i++) {
				if(distance[i] == INF) {
					System.out.println("-1");
					continue;
				}
				System.out.println(distance[i]);
			}
		}
	}
}