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
			party[i] = new ArrayList<Integer>(); //공간 생성 
			//파티 사이즈 입력받고 
			int party_size = kb.nextInt();
			for(int j=0; j<party_size; j++) {
				//각 사이즈별 add()처리 
				party[i].add(kb.nextInt());
			}
		}
		//부모노드 저장용 
		parent = new int[N+1];
		for(int i=0; i<=N; i++) {
			parent[i]=i; //자기 자신으로 초기화
		}
		//파티 M개의 그룹 만들기 
		for(int i=0; i<M; i++) {
			int firstPeople = party[i].get(0);
			for(int j=1; j<party[i].size(); j++) {
				union(firstPeople, party[i].get(j));
			}
		}
		//각 파티 대표 노드 vs 진실 대표 노드 같다면 과장 불가능 
		for(int i=0; i<M; i++) {
			boolean isPossible = true;
			int cur = party[i].get(0);
			for(int j=0; j<trueP.length; j++) {
				if(find(cur ) == find(trueP[j])) {
					isPossible = false;
					break;
				}
			}
			if(isPossible) result++;
		}		
		System.out.println(result);
	}
}