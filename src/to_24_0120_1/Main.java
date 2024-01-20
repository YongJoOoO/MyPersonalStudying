package to_24_0120_1;

import java.util.Scanner;

/**
 * 1717번. 집합의 표현 - 유니온 파인드 문풀 
 * @author MYLG
 *
 */
public class Main {
	static int[] parent;//대표 노드 저장용 배열 
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
		int N = kb.nextInt();//정점 개수
		int M = kb.nextInt(); //질의 
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) parent[i]= i;//초기화 
		
		for(int i=0; i<M; i++) {
			int query = kb.nextInt();
			int a = kb.nextInt();
			int b = kb.nextInt();
			if(query == 0) { //합집합 연산 수행 
				union(a, b);
			}else if(query == 1) { //ㄹㅇ 질의
				if(find(a) == find(b)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}	
	}
}