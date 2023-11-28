package to_1128_6;
/**
 * 이진트리 순회 - DFS 탐색
 * @author MYLG
 *
 */
class Node {
	int data;
	Node lt, rt;
	Node(int val){
		data = val;
		lt = rt = null;
	}
}
public class Main {
	Node root;
	
	static void DFS(Node root) {
		if(root == null) return;
		else {
			DFS(root.lt); //L
			System.out.print(root.data+ " "); //U
			DFS(root.rt); //R
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Main tree=new Main(); 
	        tree.root=new Node(1); 
	        tree.root.lt=new Node(2); 
	        tree.root.rt=new Node(3); 
	        tree.root.lt.lt=new Node(4); 
	        tree.root.lt.rt=new Node(5); 
			tree.root.rt.lt=new Node(6); 
	        tree.root.rt.rt=new Node(7);
	        tree.DFS(tree.root); 
	}

}
