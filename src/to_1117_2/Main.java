package to_1117_2;

import java.util.*;

/*
 * 2668번. 숫자고르기 
 */
public class Main {
	
	static ArrayList<Integer> list;
	static boolean[] visited;
	static int[] num;
	
	//DFS
	static void DFS(int st, int target) {
		
		//시작하는 st의 인덱스 값이 방문 전인상태이면 
		if(visited[num[st]] == false) {
			visited[num[st]] = true;
			DFS(num[st], target);
			visited[num[st]] = false;
		}
		//시작값 == target이면 사이클 발생함 -> 담기 
		if(num[st] == target) list.add(target);
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int N= kb.nextInt();
		num = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			num[i] = kb.nextInt();
		}
		
		//순서대로 사이클 발생 여부 dfs로 판단함 
		list = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			visited[i]= true;
			DFS(i, i);
			visited[i]= false;
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
}