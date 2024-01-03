package to_24_0103_1;

import java.util.*;

/**
 * 6603번. 로또 - 백트래킹 문풀
 * @author MYLG
 *
 */
public class Main {
	static int k;
	static int[] arr;
	static boolean[] visited;
	//DFS
	static void DFS(int lv, int st) {
		if(lv == 6) {
			for(int i=0; i<k; i++) {
				if(!visited[i]) continue;
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=st; i<k; i++) {
			if(!visited[i]) {
				visited[i] = true;
				DFS(lv+1, i+1);
				visited[i]= false;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		while(true) {
			k = kb.nextInt();
			if(k ==0)break;
			
			arr = new int[k];
			visited = new boolean[k];
			
			for(int i=0; i<k; i++) arr[i] = kb.nextInt();
			
			DFS(0,0);
			
			System.out.println();//한번 개행
		}
	}
}