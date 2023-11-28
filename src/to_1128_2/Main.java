package to_1128_2;

import java.util.Scanner;

/**
 * 재귀함수 - DFS
 * @author MYLG
 *
 */
public class Main {
	
	static void DFS(int N) { 
		if(N == 0)return;
		else {
			DFS(N-1); 
			
			System.out.print(N + " ");
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		DFS(N); //최종
	}

}
