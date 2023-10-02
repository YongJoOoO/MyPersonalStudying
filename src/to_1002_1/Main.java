package to_1002_1;

import java.util.PriorityQueue;
import java.util.Scanner;

/*16202번. MST 게임 - 최소 신장 트리 */
class Edge implements Comparable<Edge>{
	int s, e, val;
	Edge(int s, int e, int val){
		this.s = s;
		this.e = e;
		this.val = val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}
public class Main {
	static int N, M, K;
	static int[] parent;//부모 
	static PriorityQueue<Edge> pQ = new PriorityQueue<>();
	static PriorityQueue<Edge> first;//초기화 용
	
	//find
	static int find(int a) {
		if(a == parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	
	//union
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			parent[b] =a;
		}
	}
	
	//MST
	static int[] MST() {
		
		//answer[0] : 비용 
		//answer[1] : 사용 간선 수
		int[] answer = new int[2];
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) parent[i] = i;
		
		int useEdge = 0;
		int useCost = 0;
		
		while(!pQ.isEmpty()) { //빌 때까지 돌려야 함 
			Edge cur = pQ.poll();
			
			if(find(cur.s)  != find(cur.e)) {
				union(cur.s, cur.e);
				useCost += cur.val;
				useEdge++;
				
			}
			first.offer(cur);//하나씩 넘겨주잖아.
		}
		//답 세팅 
		answer[0] = useCost;//비용 
		answer[1] = useEdge; //개수 
		
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		K = kb.nextInt();
		
		//데이터 입력받기 
		for(int i=0; i<M; i++) { //M개 입력받기 
			int a = kb.nextInt();
			int b = kb.nextInt();
			//가중치는 i+1이다. 
			//양방향 간선
			pQ.offer(new Edge(a, b, i+1));
		}

		///K번 돌면서 답을 받아야 함
		for(int i=0; i<K; i++) {
			//매번 사용할 pQ는 초기화 해줌
			first = new PriorityQueue<>();//새로 생성해서 
			//pQ = first;//뺀 애를 다시 주입시킴 
			int[] result = MST();//하나씩 받기 
			if(result[1] == N-1) { //사용 간선이 N-1개 일 때 
				System.out.print(result[0] +" ");//그때의 가중치 합을 출력하고 
			}else {//그 외에는 무조건 0임 불가능하니까 
				System.out.print("0 ");
			}
			//매번 MST가 끝난 뒤에는 가장 최소 간선은 poll 처리 
			first.poll();//하나씩 뽑고 
			pQ = first;//뽑은 거를 넘겨주기 
		}	
	}
}