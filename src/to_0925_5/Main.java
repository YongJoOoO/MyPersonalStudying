package to_0925_5;

import java.util.PriorityQueue;
import java.util.Scanner;

/*16169번. 수행 시간 - 위상정렬 문풀 */
class Edge implements Comparable<Edge>{
	int num;
	int stage;//계급
	int ingT;//동작 속도 
	Edge(int num, int stage, int ingT){
		this.num = num;
		this.stage = stage;
		this.ingT = ingT;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		if(this.stage == o.stage) { //계급 같다면 
			return this.ingT - o.ingT;//시간 작은 순 
		}
		return this.stage - o.stage;//기본 계급 작은 순 
	}
}
public class Main {
	static int n;
	static int[] indegree;
	static int[] self;//자기 동작 시간 
	static int[] dy;//누적 결과 
	static PriorityQueue<Edge> pQ ;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		n = kb.nextInt();
		indegree = new int[n+1];
		self = new int[n+1];
		pQ = new PriorityQueue<>();
		
		for(int i=1; i<=n; i++) {
			int st = kb.nextInt();//계급
			int ti = kb.nextInt();//시간 
			self[i] = ti;//시간 담고 
			pQ.offer(new Edge(i, st, ti));
		}
		//0번째만 하나 처리 
		Edge tmp = pQ.poll();
		
		dy[tmp.num] = self[tmp.num];
		
	
	}

}
