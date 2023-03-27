package to_0327;

import java.util.Scanner;

/*8-8. 수열 추측하기  | DFS *** 조금 어렵다.
*/
public class Main1 {
	static int[] b, p, ch;
	static int n, f;
	boolean flag = false;
	int[][] dy = new int[35][35];
	
	//combi 조합
	public int combi(int n, int r) {
		if(dy[n][r]>0) return dy[n][r];
		if(n==r || r==0) return 1;
		else return dy[n][r] = combi(n-1, r-1)+ combi(n-1, r);
	}
	
	//dfs 함수 
	public void DFS(int L, int sum) {
		if(flag) return; //그러면 리턴
		if(L==n) { //n개 중에서 n개 뽑은 순열 완성됨
			if(sum == f) {
				for(int x: p) System.out.print(x + " ");
				flag = true;
			}
		}else {
			for(int i=1; i<=n; i++) {
				if(ch[i] == 0) {
					ch[i] = 1;
					p[L] = i;
					DFS(L+1, sum+(p[L]*b[L]));
					//복귀하면서 탐색해야 함
					ch[i]=0;
				}
			}
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		f = kb.nextInt();
		
		//조합 확인용 배열 
		b = new int[n];
		//정답 확인용 배열 (순열) 
		p = new int[n];
		//방문 체크용 배열
		ch = new int[n+1];
		
		//입력이 n으로 들어오면 b[] 내부를 n-1의 조합들로 초기화
		for(int i=0; i<n; i++) {
			b[i] = T.combi(n-1, i);
		}
		
		//호출
		T.DFS(0, 0);		
	}
}