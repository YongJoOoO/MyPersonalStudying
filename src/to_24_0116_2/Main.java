package to_24_0116_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 4792번. 레드 블루 스패닝 트리 - 최소비용 신장 트리 문풀 
 * @author MYLG
 *
 */
class Edge{
	int s, e;
	char val;
	Edge(int s, int e, char B){
		this.s= s;
		this.e = e;
		this.val = val;
	}
}
public class Main {
	static int[] parent;
	
	//find
	static int find(int a) {
		if(a == parent[a]) return a; 
		else return parent[a]= find(parent[a]);
	}
	//union
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[b]= a;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);

		while(true) {
			int N = kb.nextInt();
			int M = kb.nextInt();
			int K = kb.nextInt();
			
			if(N == 0 && M ==0 && K == 0) break;
			
			parent = new int[N+1];
			for(int i=1; i<=N; i++) parent[i] = i;
			
			Queue<Edge> pQ = new LinkedList<>();
			
			for(int i=0; i<M; i++) {
				String[] tmp = kb.nextLine().split(" ");
				char val = tmp[0].charAt(0); //이 부분
				int a = Integer.parseInt(tmp[1]);
				int b = Integer.parseInt(tmp[2]);
				pQ.offer(new Edge(a, b, val));
			}
			
			boolean flag = true;
			int useEdge = 0;
			while(useEdge != K) {
				Edge cur = pQ.poll();
				if(cur == null) {
					flag = false;
					break;
				}
				if(find(cur.s) != find(cur.e)) {
					if(cur.val == 'B') {
						union(cur.s, cur.e);
						useEdge++;
					}
				}
			}
			
			if(flag) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
		
		
	}

}
