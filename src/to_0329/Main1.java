package to_0329;

import java.util.Scanner;

/* 8-9. 조합 구하기 nCm 조합 | DFS */ 
public class Main1 {
	static int[] combi; //조합 뽑은 애들 둘 배열
	static int n, m;
	//DFS
	public void DFS(int L, int s) { //레벨 L, start 번호 s 
		//즉, 각 L 의 단계에 combi[L]번째 수가 뽑혀야 하며
		//중복없기 위해, s번호부터 시작해서 n까지 for문이 돌아야 함
		if(L==m) { //m개 다 뽑아쓰니까 더 깊이 탐색 X
			for(int x : combi) System.out.print(x+" ");
			System.out.println();
		}else {
			for(int i = s; i<=n; i++) {
				combi[L] = i; //L번째 자리에 뽑은 i담기
				DFS(L+1, i+1);// 뽑은 i의 뒤부터 n까지 돌면서 뽑기
			}
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		combi = new int[m];//m개 뽑을 거니까 
		
		T.DFS(0, 1); //0레벨 1번부터 탐색 

	}
}