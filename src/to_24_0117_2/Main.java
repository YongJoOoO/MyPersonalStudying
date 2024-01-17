package to_24_0117_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 1865번. 웜홀 - 벨만 포드 문풀 
 * @author MYLG
 *
 */
class Edge{
	int s, e, val;
	Edge(int s, int e, int val){
		this.s= s;
		this.e= e;
		this.val = val;
	}
}
public class Main {
	static int TC;
	static int N, M, W;
	static int[] distance;
	static final int INF = 10000001;
	static ArrayList<Edge> graph;
	//벨만 포드
	static boolean bellmanFord() {
		boolean flag = false;
		Arrays.fill(distance, INF);
		
		distance[1]= 0;
		//N-1번 반복
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<graph.size(); j++) {
				Edge cur = graph.get(j);
				if(distance[cur.e] > distance[cur.s] + cur.val) {
					distance[cur.e] = distance[cur.s] + cur.val;
				}
			}
		}
		
		//한번 더 반복 시, 값 갱신 일어나는가 ?
		for(int i=0; i<graph.size(); i++) {
			Edge cur = graph.get(i);
			if(distance[cur.e] > distance[cur.s] + cur.val) {
				flag = true;
			}
		}
		
		return flag;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		ArrayList<String> answer = new ArrayList<>();
		
		TC = kb.nextInt();
		for(int t = 0; t<TC; t++) {
			N = kb.nextInt();
			M = kb.nextInt();
			W = kb.nextInt();
			
			distance = new int[N+1];
			graph = new ArrayList<>();
			
			//입력 - 도로 방향 X
			for(int i=0; i<M; i++) {
				int a = kb.nextInt();
				int b = kb.nextInt();
				int time= kb.nextInt();
				graph.add(new Edge(a, b, time));
				graph.add(new Edge(b, a, time));
			}
			
			//웜홀
			for(int i=0; i<W; i++) {
				int a = kb.nextInt();
				int b = kb.nextInt();
				int time = kb.nextInt(); //거꾸로
				graph.add(new Edge(a, b, -time));
			}
			
			if(bellmanFord()) {
				answer.add("YES");
			}else {
				answer.add("NO");
			}
		}
		for(String x : answer) System.out.println(x);
	}
}