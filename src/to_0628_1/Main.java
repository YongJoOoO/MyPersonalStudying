package to_0628_1;

import java.util.ArrayList;
import java.util.Scanner;

/*1043번. 거짓말 */
public class Main {
	static int[] parent;//대표 
	static int[] trueP;//진실 아는 애들
	static ArrayList<Integer> [] party; 
	static int result;
	//find
	static int find(int a) {
		if(a == parent[a]) return a;
		else {
			return parent[a] = find(parent[a]);
		}
	}
	
	//union
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[b] = a;
		}
	}
	//chkSame
	static boolean chkSame(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return true;
		else return false;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		//사람 수 N, 파티 개수 M
		int N = kb.nextInt();
		int M = kb.nextInt();
		//진실 아는 사람 수 
		int T= kb.nextInt();
		result=0;
		trueP = new int[T];
		for(int i=0; i<T; i++) trueP[i]=kb.nextInt();
		
		party = new ArrayList[M];
		for(int i=0; i<M; i++) {
			party[i] = new ArrayList<Integer>();
			int party_size = kb.nextInt();
			for(int j=0; j<party_size; j++) {
				party[i].add(kb.nextInt());
			}
		}
		
		parent = new int[N+1];
		for(int i=0; i<=N; i++) {
			parent[i]=i;
		}
		
		for(int i=0; i<M; i++) {
			int firstPeople = party[i].get(0);
			for(int j=1; j<party[i].size(); j++) {
				union(firstPeople, party[i].get(j));
			}
		}
		
		
	}

}
