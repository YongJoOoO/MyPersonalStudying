package to_0707_2;

import java.util.PriorityQueue;
import java.util.Scanner;

/*불우이웃 돕기 다시 풀기 RE */
class Edge implements Comparable<Edge>{
	int s;
	int e;
	int val;
	Edge(int s, int e, int val){
		this.s= s;
		this.e= e;
		this.val = val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}
public class Main {
	static int N, sum;
	static int[] parent;
	static PriorityQueue<Edge> pQ = new PriorityQueue<>();
	
	//find
	static int find(int a ) {
		if(a == parent[a]) return a;
		else {
			return parent[a] = find(parent[a]);
		}
 	}
	//union
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[b] = a;
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		parent = new int[N];
		for(int i=0; i<N; i++) parent[i]=i;
		
		//데이터 입력받아서 숫자형태로 저장하기
		for(int i=0; i<N; i++) {
			String st = kb.next();
			char[] c = st.toCharArray();
			int tmp =0;
			//j로 각 c의 문자 찍으면서 처리 
			for(int j=0; j<N; j++) {
				if(c[j] >= 'a' && c[j] <= 'z') { //소문자일 경우 
					tmp = c[j] - 'a' + 1;
				}else if(c[j] >='A' && c[j] <= 'Z') { //대문자일 경우 
					tmp = c[j] - 'A' + 27;
				}
				//랜선 총합 누적 
				sum += tmp;
				if(i != j && tmp != 0) {
					pQ.add(new Edge(i, j, tmp));//엣지 담기 
				}
			}
		}
		//여기서부터 최소비용 신장트리 
		
		int useEdge = 0;
		int minVal = 0;
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(find(cur.s) != find(cur.e)) {
				union(cur.s, cur.e);
				minVal = cur.val;//최소비용 누적합
				useEdge++;//사용 간선 ++ 처리 
			}
		}
		
		//빠져나온 상태가 N-1개의 간선 사용한 거면 출력하고 그 외는 -1 출력 
		if(useEdge == N-1) {
			System.out.println(sum - minVal);//최댓값 = 전체 -최소비용 
		}else {
			System.out.println(-1);
		}
	}

}
