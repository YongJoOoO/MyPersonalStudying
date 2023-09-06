package to_0906_1;

import java.util.*;
import java.util.Scanner;

/*1717번. 집합의 표현 - 유니온 파인드 문풀 */
public class Main {
	static int n, m;
	static int[] parent;
	//find
	static int find(int a) {
		if(a == parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	//union
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[b] = a;
		}
	}

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		//1) 자기 자신을 처음에 세팅 
		parent = new int[n+1];
		for(int i=1; i<=n; i++) parent[i]=i;
		
		ArrayList<String> answer = new ArrayList<>();
		
		//2) 데이터 입력받기 
		for(int i=0; i<m; i++) {
			int q = kb.nextInt();
			int a = kb.nextInt();
			int b = kb.nextInt();
			
			if(q == 0) { //union
				union(a, b);
			}else if(q == 1) {//find
				if(find(a) == find(b)) { //부모 같은지 
					answer.add("YES");
				}else {//다른지 
					answer.add("NO");
				}
			}
		}
		//3) 데이터 출력 
		for(String x : answer) {
			System.out.println(x);
		}	
	}
}