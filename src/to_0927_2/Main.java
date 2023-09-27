package to_0927_2;

import java.util.*;

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
		map = new int[N][N];
		for(int i=0; i<=N; i++) parent[i]= i;
		
		//가중치 오름차 작은 순 정렬
		PriorityQueue<int[] > pQ = new PriorityQueue<>((a, b) -> a[2]-b[2]);
				
		int lengh = 0;
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			for(int j=0; j<N; j++) {
				if(Character.isUpperCase(tmp.charAt(j))) {
					//대문자라면 
					int cost = (int) tmp.charAt(j) - 28;
					lengh += cost;
					map[i][j] = cost;
					pQ.offer(new int[] {i, j, cost});
				}else if(Character.isLowerCase(tmp.charAt(j))) {
					//소문자라면 
					int cost = (int) tmp.charAt(j) - 96;
					lengh += cost;
					map[i][j] = cost;
					pQ.offer(new int[] {i, j, cost});
				}else {
					//그 외라면 0인 경우밖에 없으므로 
					map[i][j] = 0;
					pQ.offer(new int[] {i, j, 0});
				}
			}
		}
			
		int useEdge = 0;
		int useCost = 0;
		
		while(!pQ.isEmpty()) {
			int[] cur = pQ.poll();
			if(find(cur[0]) != find(cur[1])) {
				union(cur[0], cur[1]);
				useCost += cur[2];
				useEdge++;
			}
		}
		
		if(useEdge == N-1) System.out.println(lengh - useCost);
		else System.out.println("-1");
	}

}
