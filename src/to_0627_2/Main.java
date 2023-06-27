package to_0627_2;

import java.util.ArrayList;
import java.util.Scanner;

/*1717번. 집합의 표현 */
public class Main {
	static int[] parent;//부모 노드 저장용
	//유니온
	static void union(int a, int b) {
		//일단 대표 노드 찾아서 
		a = find(a);
		b = find(b);
		if(a != b) { //둘이 다르면 
			parent[a] = a;//a로 대표노드 설정 
		}
	}
	//find
	static int find(int a) {
		if(a == parent[a]) {
			return a;//얘가 뿌리면 얘를 리턴
		}
		else {
			return parent[a] = find(parent[a]);//그 부모를 find해서 뿌리 찾기 
		}
	}
	//same여부
	static boolean chkSame(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b) return true;
		else return false;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		
		ArrayList<String> answer = new ArrayList<>();
		
		parent = new int[N+1];
		for(int i=0; i<=N; i++) {
			parent[i] = i;//초기화 = 최초는 자기 자신 가리킴 
		}
		
		for(int i=0; i<M; i++) {
			int Q = kb.nextInt();
			
			int a = kb.nextInt();
			int b = kb.nextInt();
			
			if(Q == 0) {
				union(a,b);
			}else {
				if(chkSame(a, b)) {
					answer.add("YES");
				}else {
					answer.add("NO");
				}
			}
		}
		
		
		//정답 출력 
		for(String x : answer) System.out.println(x);
	}

}
