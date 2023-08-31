package to_0831_3;

import java.util.*;
import java.util.Scanner;

/*10282번. 해킹 - 다익스트라 */
class Edge implements Comparable<Edge>{
	int e, val;
	Edge(int e, int val){
		this.e = e;
		this.val =val;
	}
	public int compareTo(Edge o) {
		return this.val - o.val;
	};
}
public class Main {
	static int TC;//테스트케이스 
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		TC = kb.nextInt();
		
		ArrayList<int[]> answer = new ArrayList<>();
		
		for(int t=0; t<TC; t++) { //테스트케이스 만큼만 반복할거고 
			int n = kb.nextInt();//정점
			int d = kb.nextInt();//간선 
			int c = kb.nextInt();//시작점
			
			ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
			for(int i=0; i<=n; i++) {
				graph.add(new ArrayList<>());
			}
			
			//데이터 입력받기
			for(int i=0; i<d; i++) {
				int e= kb.nextInt();
				int s = kb.nextInt();
				int v = kb.nextInt();
				//s -> e 방향으로 존재하는 방향 그랲다. 
				graph.get(s).add(new Edge(e, v));
			}
			
			//다익스트라 시작 
			int[] distance = new int[n+1];//1번부터 시작이니까
			Arrays.fill(distance, Integer.MAX_VALUE);
			
			PriorityQueue<Edge> pQ = new PriorityQueue<>();
			//시작점 초기화
			distance[c] = 0;//자기 자신은 0
			pQ.offer(new Edge(c, 0)); //자기 자신 c로 향한 가중치는 0으로 초기화 
			
			while(!pQ.isEmpty()) {
				Edge cur = pQ.poll();
				
				for(Edge nx : graph.get(cur.e)) {//인접 정점 담고 
					if(distance[nx.e] > distance[cur.e] + nx.val) {
						distance[nx.e] = distance[cur.e] + nx.val;
						pQ.offer(new Edge(nx.e, distance[nx.e]));
					}
				}
			}
			
			int cnt = 0;
			int max = 0;
			for(int i=1; i<=n; i++) {
				if(distance[i] != Integer.MAX_VALUE) {
					cnt++;
					max = Math.max(max, distance[i]);
				}
			}
			
			answer.add(new int[] {cnt, max});
		}
		
		//정답 출력 
		for(int[] x : answer) {
			System.out.println(x[0] +" "+x[1]);
		}
	}
}