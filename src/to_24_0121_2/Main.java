package to_24_0121_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 10775번. 공항 - 
 * @author MYLG
 *
 */
public class Main {
	/**
	 * parent[i] : gi 비행기가 도킹할 수 있는 가장 큰 게이크 넘버가 담김
	 */
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

		for(int i=0; i<P; i++) {
			//가장 큰 경우만 확인함 
			int gi = list.get(i);
			
			if(find(gi) == 0) break;
			
			union(find(gi)-1, find(gi));
			
			answer++;
		}
		
		System.out.println(answer);
	}
}