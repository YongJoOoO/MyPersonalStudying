package to_24_0103_2;

import java.util.Scanner;

/**
 * 백준 9095번. 1,2,3 더하기 - 백트래킹 문풀 
 * @author MYLG
 *
 */
public class Main {
	static int TC;
	static int N;
	static int count;
	//DFS
	static void DFS(int sum) {
		if(sum >= N) {
			if(sum == N) count++;
			//더 커진 경우는 탐색 불필요하므로 그냥 리턴
			return;
		}
		
		for(int i=1; i<=3; i++) {
			DFS(sum + i);//더 깊이 탐색 
		}
	}

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		TC = kb.nextInt();
		
		for(int t=0; t<TC; t++) {
			N =kb.nextInt();
			count = 0;
			
			DFS(0);
			System.out.println(count);	
		}
	}
}