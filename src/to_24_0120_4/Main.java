package to_24_0120_4;

import java.util.Scanner;
/**
 * 1976번. 여행 가자 - 유니온 파인드 문풀 
 * @author MYLG
 *
 */
public class Main {
	static int[] parent;
	static int[][] map;//정보 담길 용도 
	
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
		
		int N = kb.nextInt();//각 도시들
		int M = kb.nextInt();//여행 계획 
	
		parent = new int[N+1];//도시
		for(int i=1; i<=N; i++) parent[i] = i;
		
		map = new int[N+1][N+1];// i번 도시와 j번 도시의 연결 여부
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = kb.nextInt();
				if(map[i][j] == 1) {
					//연결되어 있다면 
					union(i, j); //연결 처리 하고 
				}
			}
		}
		
		int[] query = new int[M];
		for(int i=0; i<M; i++) {
			query[i] = kb.nextInt();
		}
		boolean flag = true;
		int tmp = query[0];
		for(int i=1; i<M; i++) {
			if(find(tmp) != find(query[i])) flag = false;
			
			tmp = query[i];
		}
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}
}