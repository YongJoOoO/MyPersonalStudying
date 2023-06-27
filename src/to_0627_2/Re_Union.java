package to_0627_2;

import java.util.Scanner;

public class Re_Union {
	//부모 노드 저장용 
	static int[] parent;
	
	//union
	static void union(int a , int b) {
		a = find(a);
		b = find(b);
		if(a!= b) {
			parent[b] = a;
		}
	}
	//find
	static int find(int a) {
		if(a == parent[a]){
			//인덱스와 값이 동일한 경우 
			return a ;//얘가 대표 노드 
		}else {
			return parent[a] = find(parent[a]);
		}
	}
	
	//chkSame
	static boolean chkSame(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) {
			return true;
		}else {
			return false;
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		
		parent = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			int Q = kb.nextInt();
			int a = kb.nextInt();
			int b = kb.nextInt();
			
			if(Q == 0) {
				union(a, b);
			}else {
				if(chkSame(a, b)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
	}
}