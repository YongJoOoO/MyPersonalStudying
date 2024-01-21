package to_24_0121_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 10775번. 공항 - 
 * @author MYLG
 *
 */
public class Main {
	static int[] parent; 
	//find
	static int find(int a) {
		if(a == parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	
	//union
	static void union(int a , int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			parent[b] =a;
		}
	}
	
	//실행 메인 	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int G = kb.nextInt();
		int P = kb.nextInt();
		
		List<Integer> list = new ArrayList<>();
		for(int i =0; i<P; i++) {
			int gi = kb.nextInt();
			list.add(gi);
		}
		
		parent = new int[G+1];
		for(int i=1; i<=G; i++) parent[i] = i;
		
		int answer = 0;
		boolean[] visited = new boolean[G+1];
		for(int i=0; i<P; i++) {
			//가장 큰 경우만 확인함 
			int tmp = list.get(i);
			
			for(int j=tmp; j >= 0; j--) {
				if(j!= 0 && !visited[j]) {
					answer++;
					visited[j] = true;
					break;
				}else if(j != 0 && visited[j]) {
					continue;
				}else if(j == 0) {
					System.out.println(answer);
					return;
				}
			}
		}
		
		System.out.println(answer);
		
	}

}
