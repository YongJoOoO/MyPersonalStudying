package to_0707_4;

import java.util.ArrayList;
import java.util.Scanner;

/*1068번. 트리 */
public class Main {
	static int N;
	static boolean visited[];
	static int answer= 0;//단말노드 개수 
	static int deleteNode;//삭제 노드 
	static ArrayList<Integer> [] graph;
	//dfs
	static void dfs(int v) {
		visited[v] = true;
		int child=0;//각 v에 대한 자식 카운팅용 
		
		for(int nx : graph[v]) { //인접 정점 뽑아와서 
			if(!visited[nx] && nx != deleteNode) { //삭제노드이면 깊이탐색 중지하여 끊는 효과 담기 
				//여기서 각 노드의 자식 노드 개수 처리 
				child++; //자식 ++ 처리 
				dfs(nx);//더 깊이 탐색 
			}
		}
		
		//탈출 후에도 여전히 자식 =0인 경우 단말 노드이므로 답++
		if(child ==0 ) {
			answer++;
		}	
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		visited = new boolean[N];
		graph = new ArrayList[N];
		for(int i=0; i<N; i++) {
			graph[i] = new ArrayList<Integer>();
		
		}
		int root = 0;
		//입력 데이터 저장하기 
		for(int i=0; i<N; i++) {
			//a는 부모노드이고 i에 저장할거임 
			int x = kb.nextInt();
			if(x != -1) {
				//양방향 
				graph[i].add(x);
				graph[x].add(i);
			}else {
				//부모 세팅 
				root = i;
			}
		}
		
		//삭제노드 입력받기 
		deleteNode = kb.nextInt();
		
		if(deleteNode == root) {//루트 노드가 삭제노드일 경우 
			System.out.println(0);//단말노드는 0개
		}else {
			dfs(root);//호출
			System.out.println(answer);//다남ㄹ 노드 개수 출력 
		}
	}
}