package to_0321;

import java.util.LinkedList;
import java.util.Queue;

/* 7-7. 이진트리 순회 (BFS : 레벨탐색)
 * */
class Node{
	int data;
	Node lt, rt;
	public Node(int val) {
		data = val;
		lt=rt= null;
	}
}
public class Main2 {
	Node root;
	public void BFS(Node root) {
		//큐 사용
		Queue<Node> Q = new LinkedList<>();
		Q.offer(root);
		int L = 0; //레벨 
		while(!Q.isEmpty()) {
			int len = Q.size();
			System.out.print(L+" : ");
			//for()는 각 L에 대한 인ㅇ접 정점들 차례 방문 작업 함
			for(int i =0; i<len; i++) {
				//큐에서 하나 뽑고 
				Node cur = Q.poll();
				//현재 데이터 출력
				System.out.print(cur.data + " ");
				//만약 말단 노드만 아니면 , 
				//현제 데이터에 연결된 인접 정접들 모두
				// 차례로 큐에 담기 
				if(cur.lt != null) Q.offer(cur.lt);
				if(cur.rt != null) Q.offer(cur.rt);
			}
			//레벨 ++ 
			L++;
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 tree = new Main2();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);
		//BFS함수 호출
		tree.BFS(tree.root);
	}
}