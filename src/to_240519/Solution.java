package to_240519;

import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
	int a, b;
	Node(int a, int b){
		this.a = a;
		this.b = b;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		if(this.a == o.a) {//a값 같으면
			return this.b - o.b;//b값 오름차순 
		}
		return this.a - o.a;//a 오름 차순 기본
	}
	
}

class Solution{
	static int N, K;
	static int[] arr;//수열 
	static int[] num; //레벨 별 값 담기 
	static boolean[] visited;
	static PriorityQueue<Node> pQ;
	
	//DFS
	static void DFS(int lv) {
		if(lv == 2) {//다 뽑은 거면
			pQ.offer(new Node(num[0], num[1]));
			return;
		}
		
		for(int i=0; i<N; i++) {
			num[lv] = arr[i];
			DFS(lv+1);
		}
	}
	
	//실행 메인 
	public static void main(String args[]) throws Exception{
		Scanner kb = new Scanner(System.in);

		int T = kb.nextInt();
		for (int test_case = 1; test_case <= T; test_case++){
			
			N = kb.nextInt();
			K = kb.nextInt();
			arr = new int[N];
			num = new int[2];//레벨용 
			pQ = new PriorityQueue<>();
			visited = new boolean[N];
			
			//수열 입력 받기 
			for(int i=0; i<N; i++) {
				arr[i]=kb.nextInt();
			}
			
			DFS(0);
			
			//복귀 시점에 정렬된 pQ상에서 K-1번 뽑아놓고 
			for(int i=0; i<K-1; i++) pQ.poll();
			
			//이번이 K번째 정답 노드 뽑아서 
			Node ans = pQ.poll();
			int answer = ans.a + ans.b; //합함
			
			// 표준출력(화면)으로 답안을 출력합니다.
			System.out.println("#" + test_case + " " + answer);
		}

		kb.close(); // 사용이 끝난 스캐너 객체를 닫습니다.
	}
}
