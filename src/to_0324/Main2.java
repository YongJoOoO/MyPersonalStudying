package to_0324;

import java.util.Scanner;

/* 8-6. 순열 구하기*/
public class Main2 {
	static int n, m;
	static int[] ch, pm, arr; 
	//중복 없게 ch[]로 선택값 방문 체크하고, 
	//뽑은 값은 pm[]에 담는다.
	
	//DFS 
	public void DFS(int L) {
		if(L == m) {
			for(int i=0; i<m; i++) System.out.print(pm[i]+ " ");
			System.out.println();
		}else {
			for(int i=0; i<n; i++) {
				//중복 없이 뽑아야 하므로 방문 전인 i 에 대하여 
				if(ch[i] == 0) {
					pm[L] = arr[i];//뽑은 수 pm의 L번째 칸에 담고 
					ch[i] = 1;//i번쨰 수 뽑았음 방문 체크
					DFS(L+1); // 재귀 호출
					//복귀주소
					ch[i]=0;//다음 가지로도 가야하니 이번 가지에ㅔ서 Back
				}
			}
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		arr=new int[n];
		
		for(int i=0; i<n; i++) arr[i] = kb.nextInt();
		ch = new int[n];
		pm = new int[m]; //각각 m개의 숫자 뽑으니까
		
		T.DFS(0);
	}
}