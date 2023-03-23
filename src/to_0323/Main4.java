package to_0323;

import java.util.Scanner;

/* 8-4. 중복순열 구하기*/
public class Main4 {
	static int[] pm; 
	static int n, m;
	//DFS  n개씩 뻗어나가면서 m번 뽑아나감  
	public void DFS(int L) {
		
		if(L == m) { //정해진만큼 뽑았으면 깊이 O
			for(int x : pm) System.out.print(x+ " ");
			System.out.println();
			
		}else {
			//각 단계에서 1~n가닥씩 뻗어나감 
			for(int i=1; i<=n; i++) {
				pm[L] = i;//중복순열 담고 
				DFS(L+1);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main4 T = new Main4();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		pm = new int[m]; //m번 뽑으니까

		T.DFS(0);
	}
}