package to_0901_3;

import java.util.*;
import java.util.Scanner;

/*20007번. 떡 돌리기 -다익스트라 문풀 */ 
class Edge implements Comparable<Edge>{
	int e, val;
	Edge(int e, int val){
		this.e = e;
		this.val =val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}
public class Main {
	static int N, M, X, Y;
	static ArrayList<ArrayList<Edge>> graph;
	static int[] distance;//거리용 배열 
	static boolean[] visited;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();//정점 개수 
		M = kb.nextInt(); //도로 개수
		X = kb.nextInt();//기준 거리 
		Y = kb.nextInt(); //출발 점 
		
		//초기화 
		graph = new ArrayList<>();
		distance = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		visited =new boolean[N];
		
		for(int i=0; i<N; i++) {
			graph.add(new ArrayList<>());
		}
		//데이터 입력받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int t = kb.nextInt();
			//양방향
			graph.get(a).add(new Edge(b, t));
			graph.get(b).add(new Edge(a, t));
		}
		
		//다익스트라 
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		//시작점 초기화
		distance[Y] = 0;
		pQ.offer(new Edge(Y, 0));
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(visited[cur.e]) continue;
			visited[cur.e] = true;
			
			for(Edge nx : graph.get(cur.e)) {
				if(!visited[nx.e] && distance[nx.e] > distance[cur.e] + nx.val) {
					distance[nx.e] = distance[cur.e] + nx.val;
					pQ.offer(new Edge(nx.e, distance[nx.e]));
				}
			}
		}

		boolean flag = false;
		Arrays.sort(distance);//최단 거리 정렬 시키고 
		//가까운ㅇ 집부터 방문한다그랬으니까
		//쟤네 중 가장 긴 거리가 X보다 크면 어차피 방문 불가 
		
		if(distance[N-1] * 2 > X) System.out.println("-1");
		
		else {
			int idx = 0;
			int tmp =0;
			
			for(int i=0; i<N; i++) {//2배 해놓고 
				distance[i] *=2;
			} 
			int cnt = 0;
		
			while(true) {
				//누적을 할 건데 
				tmp += distance[idx++];
				if(tmp > X) { //X넘어가면 
					cnt++;//카운팅해놓고 
					//직전 idx로 되돌아가기 
					idx--;
					tmp = 0;
				}
				//그러다가 N-1 넘어가면 break
				if(idx > N -1) {
					break;
				}
			}
			
			if(tmp <= X) cnt++;
			
			System.out.println(cnt);
		}
	}
}