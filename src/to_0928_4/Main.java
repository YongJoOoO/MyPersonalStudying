package to_0928_4;

import java.util.Scanner;

/* */
public class Main {
	static int [] parent;
	//find
	static int find(int a) {
		if(a == parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	//union
	static void union(int a, int b) {
		a =  find(a);
		b = find(b);
		if(a!=b) {
			parent[b] = a;
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		int N =kb.nextInt();
		int M = kb.nextInt();
		
		parent = new int[N];//0~N-1까지 
		for(int i=0; i<N; i++) parent[i] = i;
		
	
		//M개의 경우를 담는데 
		for(int i=0; i<M; i++) {
			int a= kb.nextInt();
			int b= kb.nextInt();
			
			if(find(a) != find(b)) {
				union(a, b);
			}else if(find(a) == find(b)) {
				//만약 이미 같은 애들이라면 이때의 카운팅을 담기 
				System.out.println(i+1);
				return;
			}
		}	
		System.out.println(0);
	}
}