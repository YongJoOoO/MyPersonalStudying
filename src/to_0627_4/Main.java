package to_0627_4;

import java.util.Scanner;

/*1976번. 여행 가자 
 *  도시의 연결 유무를 유니온 파인드 연산으로 해결할 수 있다는 아이디어
 * */
public class Main {
	static int[][] city;//도시 연결 정보 
	static int [] parent;//연결 부모 
	static int[] route;//도시 루트 
	//find
	static int find(int a) {
		if(a == parent[a]) return a;
		else {
			return parent[a] =find(parent[a]);
		}
	}
	
	//union
	static void union(int a, int b) {
		a= find(a);
		b=find(b);
		if(a!=b) {
			a = Math.max(a, b);
			b = Math.min(b, a);
			parent[b] = a;
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		
		city = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				city[i][j] = kb.nextInt();
			}
		}
		
		//루트 연결 정보 
		int[] route = new int[m+1];
		for(int i=1; i<=m; i++) {
			route[i] = kb.nextInt();
		}
		//부모값 초기화 
		parent = new int[n+1];
		for(int i=1; i<=n; i++) {
			parent[i]= i;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j =1; j<=n; j++) {
				if(city[i][j]==1) {//두 도시가 연결되어 있다면
					union(i, j);
				}
			}
		}
		
		//연결 여부 ㅇㅇx
		int index = find(route[1]);
		for(int i = 2; i<route.length; i++) {
			if(index != find(route[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}