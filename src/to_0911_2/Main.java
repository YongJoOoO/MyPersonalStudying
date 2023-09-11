package to_0911_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int[] parent;
	static int[] trueP;
	static ArrayList<Integer> [] party;
	static int result;
	//find
	static int find(int a) {
		if(a==parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	//union
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!= b) {
			parent[b] = a;
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		int T = kb.nextInt();
		
		result = 0;
		trueP = new int[T];//진실아는 사람들 
		for(int i=0; i<T; i++) {
			trueP[i] = kb.nextInt();
		}
		party = new ArrayList[M];
		
		for(int i=0; i<M; i++) {
			party[i] = new ArrayList<Integer>();
			int party_size = kb.nextInt();
			for(int j=0; j<party_size; j++) {
				party[i].add(kb.nextInt());
			}
		}
		
		parent= new int[N+1];
		for(int i=0; i<=N; i++) parent[i]= i;
		
		for(int i=0; i<M; i++) {
			int firstPeople = party[i].get(0);//대표 사람으로 
			for(int j=1; j<party[i].size(); j++) {
				//첫 번째 인물과, i번쨰 파티 속 각 참가자드릉ㄹ 모두 한 집합으로 묶어주기 
				union(firstPeople, party[i].get(j));
			}
		}
		
		//각 파티 대표 노드와 진실 아는 사람 노드 같담녀 과장 불가 
		for(int i=0; i<M; i++) {
			boolean isPossible = true;
			int cur = party[i].get(0);
			for(int j=0; j<trueP.length; j++) {
				if(find(cur) == find(trueP[j])) {
					isPossible = false;
					break;
				}
			}
			if(isPossible) result++;
		}
		System.out.println(result);
	}
}