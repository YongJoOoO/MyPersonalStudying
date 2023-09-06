package to_0906_2;

import java.util.Scanner;

/*1976번. 여행 가자 - 유니온 파인드 */
public class Main {
	static int n, m; //m은 여행계획속도시수 
	static int[] parent;
	static int[][] map;
	static int[] route;//계획한 여행 도시 담기 - m개
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
		n = kb.nextInt();
		m = kb.nextInt();
		map = new int[n+1][n+1];
		parent = new int[n+1];
		//parent 초기ㅗ하
		for(int i=1; i<=n; i++) parent[i]= i;
	
	
		//입력받기 
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				map[i][j] = kb.nextInt();
			}
		}
		route = new int[m+1];//얘 도시 계획 담긴 배열 
		//동혁이의 여행 계획 담기 
		for(int i=1; i<=m; i++) route[i]= kb.nextInt();
		
		//이제 각 map 돌면서 1인 값에 대해서는 union 처리 
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(map[i][j] == 1) {
					union(i, j);//경로 합치기 
				}
			}
		}
		
		//이제 각 도시별 부모 도시 찾아서 하나라도 다른 도시 나오면 X 모두 같으면 O
		
		//첫번째 도시의 부모는 미리 찾아둠 
		int tmp = find(route[1]);
		
		for(int i=2; i<route.length; i++) { //그 뒷쪽 루트도시의 부모도시가 하나라도 1번이랑 다르다면 
			if(tmp != find(route[i])) { //뒷 부분 루트 순회하면서 
				//하나라도 1번의 부모와 다른 부모 나타나면 
				System.out.println("NO"); //안속해 있음
				return;//걍 여기서 끝 
			}
		}
		//아니라면 탈출해서 YES
		System.out.println("YES");
	}
}