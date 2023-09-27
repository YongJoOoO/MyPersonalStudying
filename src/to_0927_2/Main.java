package to_0927_2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] parent;
	static int[][] map;
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
			parent[b] = a;
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		//'A'는 65 'a'는 97
		N = kb.nextInt();
		parent = new int[N+1];

		for(int i=0; i<=N; i++) parent[i]= i;
		
		//가중치 오름차 작은 순 정렬
		PriorityQueue<int[] > pQ = new PriorityQueue<>((a, b) -> a[2]-b[2]); //오름차순 정렬 
				
		int total = 0;
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			for(int j=0; j<N; j++) {
				if(tmp.charAt(j) == '0') { continue;
				}else {
					char c = tmp.charAt(j);
					int t = 0;
					if(Character.isUpperCase(c)) {
						//대문자일 경우 
						t = c - 'A' + 27;
					}else if(Character.isLowerCase(c)) {
						///소문자일 경우 
						t = c - 'a' + 1;
					}
					
					total += t;
					
					if(i!=j && t!=0) {
						pQ.offer(new int[] {i, j, t});
					}
				}
			}
		}
			
		int useEdge = 0;
		int useCost = 0;
		
		while(!pQ.isEmpty()) {
			int[] cur = pQ.poll();
			//System.out.println(cur[2]);
			if(find(cur[0]) != find(cur[1])) {
				//사이클 형성 하지 않을 경우 
				union(cur[0], cur[1]);
				useEdge++;
				useCost += cur[2];
			}
		}
		
		if(useEdge == N-1) System.out.println(total - useCost);
		else System.out.println("-1");
		
	}
}