package to_0824_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		Queue<int[]> Q = new LinkedList<>();
		Q.add(new int[] {1, 1});
		
		
		int[] cur = Q.poll();
		
		for(int i=0; i<4; i++) {
			int nx = cur[0] + dx[i];
			int ny = cur[1] + dy[i];
			System.out.println(i+"번째 : " +nx + " " + ny);
		}
		
		
		
	}

}
