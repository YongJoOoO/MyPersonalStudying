package to_0407;

import java.util.Scanner;

/* 9-6. 친구인가 | 서로소 집합 Disjoint-Set: Union&Find 알고리즘 | */
public class Main2 {
	static int[] unf;
	//Find
	public static int Find(int v) {
		if(v==unf[v]) return v;
		else return unf[v] = Find(unf[v]);
	}
	//Union
	public static void Union(int a, int b) {
		int fa = Find(a);
		int fb = Find(b);
		
		if(fa!=fb) unf[fa] = fb;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		
		//unf 초기화
		unf = new int[n+1];
		for(int i=1; i<=n; i++) unf[i]= i;
		
		for(int i=1; i<=m; i++) {
			int a= kb.nextInt();
			int b= kb.nextInt();
			Union(a,b);
		}
		int a= kb.nextInt();
		int b= kb.nextInt();
		int fa = Find(a);
		int fb = Find(b);
		if(fa == fb) System.out.println("YES");
		else System.out.println("NO");	
	}
}