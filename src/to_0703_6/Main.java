package to_0703_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/*백준 11779번. 최소비용 구하기 2 */
class Node implements Comparable<Node>{
	int v;
	int val;
	Node(int v, int val){
		this.v = v;
		this.val = val;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.val - o.val; //가중치값 기준 오름차순 
	}
}
public class Main {
	static int [] distance;
	static boolean [] visited;
	static ArrayList<ArrayList<Node>> graph;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		
		//초기화
		distance = new int[N+1];
		visited = new boolean[N+1];
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Node>());
		}
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			int w =kb.nextInt();
			graph.get(a).add(new Node(b, w));
		}
		
		int st = kb.nextInt();
		int e = kb.nextInt();
		
		PriorityQueue<Node> pQ = new PriorityQueue<>();
		
		//시작점 세팅
		distance[st] = 0;
		pQ.add(new Node(st, 0));
		
		//직전 경로 세팅용 
		int preCity[] = new int[N+1];
		
		while(!pQ.isEmpty()) {
			//현재 노드
			Node cur = pQ.poll();
			int c_v = cur.v;
			int c_val = cur.val;
			
			if(!visited[c_v]) {
				visited[c_v] = true;
				for(Node nx : graph.get(c_v)) {
					int nx_v = nx.v;
					int nx_val = nx.val;
					if(!visited[nx_v] && distance[nx_v] > distance[c_v]+ nx_val) {
						//여기서 경로 처리 
						distance[nx_v] = distance[c_v]+nx_val;
						pQ.add(new Node(nx_v, distance[nx_v]));
						
						//직전 경로 저장 
						preCity[nx_v] = c_v;
					}
				}
			}
		}
		
		//최소비용 출력
		System.out.println(distance[e]);
		
		//경로 역추적하기 
		int cnt = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(e);//끝지점 담고 
		while(preCity[e] != 0) { //거리값이 0되면 시작점인 거니까 
			cnt++;
			stack.push(preCity[e]);
			e = preCity[e];  // p[5] = 3 -> p[3] = 1 -> p[1] = 0
		}
		//경로개수 
		System.out.println(cnt+1);
		
		//경로 출력
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}