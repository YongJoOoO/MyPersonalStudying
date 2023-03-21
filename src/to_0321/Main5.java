package to_0321;

import java.util.LinkedList;
import java.util.Queue;

/* 7-10. Tree 말단 노드까지의 가장 짧은 경로(BFS)*/

class Node2{
	int data;
	Node2 lt, rt;
	public Node2(int val) {
		data = val;
		lt=rt=null;
	}
}

public class Main5 {
	Node2 root;
	
	public int BFS(Node2 root) {
		Queue<Node2> Q = new LinkedList<>();
		//방문
		Q.offer(root);
		int L = 0; //레벨 초기화
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i=0; i<len; i++) {
				Node2 cur = Q.poll();
				//말단 노드인 경우 현재의 레벨 리턴
				if(cur.lt == null && cur.rt == null) return L;
				
				//왼쪾 자식 있는 경우
				if(cur.lt != null ) Q.offer(cur.lt);
				//오른쪽 자식 있는 경우
				if(cur.rt != null) Q.offer(cur.rt);
			}
			L++;
		}
		return 0;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main5 tree = new Main5();
		tree.root = new Node2(1);
		tree.root.lt = new Node2(2);
		tree.root.rt = new Node2(3);
		tree.root.lt.lt = new Node2(4);
		tree.root.lt.rt = new Node2(5);
		//출력
		System.out.println(tree.BFS(tree.root));
	}
}