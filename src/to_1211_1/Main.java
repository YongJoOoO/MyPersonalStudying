package to_1211_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1697번. 숨바꼭질 - BFS
 * @author MYLG
 *
 */
public class Main {
	static int N, K;
	
	//BFS
	static int BFS(int st) {
		
		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[] {st, 0});
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			int lv = 0;
			
		}
		
		return 0;
	}
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		K = kb.nextInt();
		
		
	}

}
