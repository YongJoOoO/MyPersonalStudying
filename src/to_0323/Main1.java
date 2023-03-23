package to_0323;

import java.util.Scanner;

/* 8-1. 합이 같은 부분집합 (DFS)
[입력]
첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.
[출력]
첫 번째 줄에 “YES" 또는 ”NO"를 출력한다.*/
public class Main1 {
	static String answer = "NO";
	static int n, total=0;
	boolean flag = false;
	
	//DFS
	public void DFS(int L, int sum, int[]arr) {
		if(flag == true) return;
		if(L == n) { //레벨이 n렙벨 되면 하나의 부분집합 깊이 탐색 완료된 시점임
			if(total - sum == sum) {
				answer = "YES";
				flag = true;
			}
		}else {
			//왼쪽 사용 O
			DFS(L+1, arr[L]+sum, arr);
			//오른쪽 사용 X
			DFS(L+1, sum, arr);
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		Scanner kb =new Scanner(System.in);
		n= kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = kb.nextInt();
			total += arr[i];
		}
		T.DFS(0, 0, arr);
		System.out.println(answer);
	}	
}