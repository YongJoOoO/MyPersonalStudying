package to_0803_9;

import java.util.ArrayList;
import java.util.Scanner;

//복습 - 유니온 파인드 1717번. 
public class Main {
	static int[] parent;
	
	//find
	static int find(int a ) {
		if(a == parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	//union
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[b]= a;
		}
	}
	
	//실행메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		
		parent= new int[n+1];
		
		for(int i=1; i<=n; i++) parent[i] = i;
		
		ArrayList<String> answer = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			int q = kb.nextInt();
			int a = kb.nextInt();
			int b = kb.nextInt();
			
			if(q == 0) { //합치기 
				union(a, b);
			}else { //확인용 
				int x = find(a);
				int y = find(b);
				if(x==y) {
					answer.add("YES");
				}else {
					answer.add("NO");
				}
			}
		}
		
		for(String x : answer) {
			System.out.println(x);
		}
	}
}