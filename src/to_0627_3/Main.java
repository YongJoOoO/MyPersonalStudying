package to_0627_3;

import java.util.ArrayList;
import java.util.Scanner;

/*1707 집합의 표현 */
public class Main {
	static int [] parent;//부모 저장용
	//find
	static int find(int a) {
		if(a == parent[a]) return a;
		else {
			return parent[a] = find(parent[a]);
		}
	}
	
	//union
	static void union(int a, int b) {
		a = find(a); //부모 찾고 
		b = find(b); //부모 찾고 
		if(a!=b) {
			parent[b] = a;//a를 부모로 갱신 처리 
		}
	}
	//chkSame
	static boolean chkSame(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return true;
		else return false;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		ArrayList<String > answer = new ArrayList<>();
		
		int N = kb.nextInt();
		int M = kb.nextInt();
		
		parent = new int[N+1];
		
		//초기화
		for(int i=0; i<N+1; i++) {
			parent[i] = i;//자기 자신으로 초괴화
		}
		
		for(int i=0; i<M; i++) {
			int Q=kb.nextInt();
			int a=kb.nextInt();
			int b=kb.nextInt();
			
			if(Q==0) {
				union(a, b);
			}else {
				if(chkSame(a,b)) {
					answer.add("YES");
				}else {
					answer.add("NO");
				}
			}
		}
		
		for(String x : answer) System.out.println(x);
	}
}