package to_0321;
/* 7-9. Tree 말단 노드까지의 가장 짧은 경로(DFS)*/
class Node1{ 
    int data; 
    Node1 lt, rt; 
    public Node1(int val) { 
        data=val; 
        lt=rt=null; 
    } 
} 
public class Main4 {
	Node1 root;
	public int DFS(int L, Node1 root) {
		//종료 조건 = 단말노드
		if(root.lt == null && root.rt == null) return L;
		else {
			return Math.min(DFS(L+1, root.lt),DFS(L+1,root.rt));
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main4 tree = new Main4();
		tree.root = new Node1(1);
		tree.root.lt = new Node1(2);
		tree.root.rt = new Node1(3);
		tree.root.lt.lt = new Node1(4);
		tree.root.lt.rt = new Node1(5);
		//출력
		System.out.println(tree.DFS(0, tree.root));
	}
}