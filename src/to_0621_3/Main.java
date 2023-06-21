package to_0621_3;

import java.util.ArrayList;
import java.util.Scanner;

/*1717번. 집합 표현하기 */
public class Main {
	static int[] parent;
	//union
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[b]= a;
		}
	}
	//find
	static int find(int a) {
		if(a == parent[a]) {
			return a;
		}else {
			return parent[a]=find(parent[a]);
		}
	}
	
	//samechk
	static boolean chkSame(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) {
			return true;
		}else {
			return false;
		}
	}
	
	//실행 메인 	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N= kb.nextInt();
		int M= kb.nextInt();
		
		parent = new int[N+1];
		ArrayList<String > answer= new ArrayList<>();
		for(int i=0; i<=N; i++) parent[i] = i;
		
		for(int i=0; i<M; i++) {
			int question = kb.nextInt();
			int a= kb.nextInt();
			int b= kb.nextInt();
			
			if(question == 0) {
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
		for(String x : answer) {
			System.out.println(x);
		}
		
	}

}
