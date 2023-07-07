package to_0707_5;

import java.util.Scanner;

/*백준 1991번. 트리 순회 하기 */
public class Main {
	static int[][] tree;
	
	//전위
	static void preOrder(int now) {
		if(now == -1) return;
		System.out.print((char) (now + 'A'));
		preOrder(tree[now][0]);//왼쪽 자식
		preOrder(tree[now][1]);//오르쪽 자식 
	}
	//중위
	static void inOrder(int now) {
		if(now == -1) return;
		inOrder(tree[now][0]);
		System.out.print((char) (now + 'A'));
		inOrder(tree[now][1]);
	}
	
	//후위
	static void postOrder(int now) {
		if(now == -1) return;
		postOrder(tree[now][0]);
		postOrder(tree[now][1]);
		System.out.print((char) (now + 'A'));
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();//개수 
		kb.nextLine();
		
		tree= new int[26][2]; //노드 개수 최대 26 개에 대한 왼,오른쪽 자식 저장용
		for(int i=0; i<n; i++) {
			String[] tmp = kb.nextLine().split(" ");
			int node = tmp[0].charAt(0) - 'A';//숫자 형태로 변형
			char L = tmp[1].charAt(0);
			char R = tmp[2].charAt(0);
			
			if(L == '.') {//왼쪽 자식 노드 없을 경우 
				tree[node][0] = -1;
			}else {
				tree[node][0] = L - 'A';
			}
			
			if(R == '.') {
				tree[node][1] = -1;
			}else {
				tree[node][1] = R - 'A';
			}
		}
		
		//전위
		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);
		System.out.println();
	}

}
