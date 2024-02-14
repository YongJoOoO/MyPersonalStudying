package to_24_0214_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 11438번. LCA2 - 최소 공통 조상 문풀 
 * @author MYLG
 *
 */
public class Main {
	static ArrayList<ArrayList<Integer>> tree;
	static int[] depth;
	static int kmax; //kmax
	static int[][] parent;
	static boolean[] visited;
	//BFS
	private static void BFS(int root) {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(root);
		visited[root] = true;
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(int nx : tree.get(cur)) {
				if(!visited[nx]) {
					visited[nx] = true;
					Q.offer(nx);
					//세팅
					parent[0][nx] = cur;
					depth[nx] = depth[cur]+ 1;
				}
			}
		}
	}
	
	//getLCA
	private static int getLCA(int a, int b) {
		//더 큰 쪽을 b로 swap 처리 
		if(depth[a] > depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		//두 노드의 깊이를 2^k 씩 거슬러 올려줌 
		for(int k=kmax; k>=0; k--) {
			//두 노드의 깊이 차이에 맞는 최대 k에 대해서 (점프용)
			if(Math.pow(2, k) <= depth[b]-depth[a]) {
				if(depth[a] <= depth[parent[k][b]]) {
					//b 깊이가 더 크기 때문에 a에 맞춰주기 위해 
					b = parent[k][b];//계속 부모로 거슬러 올라감 
				}
			}
		}
		//같은 깊이에서 LCA 찾기 
		for(int k=kmax; k>=0; k--) { //역순 순회하면서 
			//a의 2^k 부모와 b의 2^k 부모 다르다면 계속 거슬러 올려줌 
			if(parent[k][a] != parent[k][b]) {
				a = parent[k][a];
				b = parent[k][b];
			}
		}
		
		int LCA = a;
		if(a != b) {
			LCA = parent[0][LCA];//바로 위에 꺼가 LCA임
		}
		return LCA;
	}
	
	
	//실행 메인 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		tree = new ArrayList<>();
		for(int i=0; i<= N; i++) tree.add(new ArrayList<>());
		
		//1) 데이터 초기화 하기 
		//kmax 구해줘야 됨 = treeHeight
		int len = N;
		kmax = 0;
		
		while(len != 0) {
			len/=2;
			kmax++;
		}
		
		depth = new int[N+1];
		parent = new int[kmax+1][N+1];//N+1개의 노드들 각각에 대한 2^k번쨰 위의 부모 저장
		visited = new boolean[N+1];
	
		//데이터 저장
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//양방향 간선임
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		
		BFS(1);//각 노드의 한칸 위 부모노드, 깊이 세팅 세팅 
		
		for(int k=1; k<=kmax; k++) { //kmax까지 하나씩 늘려보면서 더블점프 부모 세팅  
			for(int n = 1; n<=N; n++) { //모든 노드들에 대해서
				parent[k][n] = parent[k-1][parent[k-1][n]];
			}
		}
		
		//2) getLCA로 두 노드의 LCA 구하기 
		//질의 처리 개수
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(getLCA(a, b));
		}	
	}
}