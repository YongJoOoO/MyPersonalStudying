package to_0719_8;

import java.util.ArrayList;
import java.util.Scanner;

/*1717번. 집합의 표현*/
public class Main {
	static int parent[];
	//find
	static int find(int a) { //부모 찾기 
		if(a == parent[a]) return a;
		else {
			return parent[a] = find(parent[a]);
		}
	}
	//union
	static void union(int a, int b) { //결합 시키기 
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[b] = a;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		
		parent = new int[N+1];
		for(int i=0; i<=N; i++) {
			parent[i] = i;//자기 자신으로 초기화 
		}
		ArrayList<String> answer= new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			int question = kb.nextInt();
			int a = kb.nextInt();
			int b= kb.nextInt();
			if(question==0) {
				union(a,b);//결합
			}else if(question==1) {
				a = find(a);
				b = find(b);
				if(a==b) {
					answer.add("YES");
				}else if(a!=b) {
					answer.add("NO");
				}
			}
		}
		//출력 
		for(String x : answer)System.out.println(x);
	}
}