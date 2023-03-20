package to_0320;
/* 7-5. 이진트리순회 (DFS)*/
class Node{
	int data;
	Node lt, rt;
	public Node(int val) {
		data = val;
		lt=rt = null;
	}
}
public class Main5 {
	Node root;
	//DFS 함수
	public void DFS(Node root) {
		if(root == null) return;
		else {	
			//L
			DFS(root.lt);
			//R
			DFS(root.rt);
			//Data
			System.out.print(root.data+" ");	
		}
	}
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main5 tree = new Main5();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);
		//호출
		tree.DFS(tree.root);
	}
}