package to_24_0214_3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 10868번. 최솟값 - 세그먼트 트리 문풀 
 * @author MYLG
 *
 */
public class Main {
	static int[] tree;
	
	//setTree
	private static void setTree(int idx) {
		while(idx!= 1) { //루트 아닌동안 반복
			tree[idx/2] = Math.min(tree[idx/2], tree[idx]);
			idx--;
		}
	}
	//getMin
	private static int getMin(int st, int ed) {
		int min = Integer.MAX_VALUE;
		
		while(st <= ed) {
			if(st % 2 == 1) {
				min = Math.min(min, tree[st]);
				st++;
			}
			if(ed % 2 == 0) {
				min = Math.min(min, tree[ed]);
				ed--;
			}
			st/=2;
			ed/=2;
		}
		return min;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		
		//1) 데이터 초기화 
		//트리 사이즈, 단말노드 시작 idx 구하기 
		int treeHeight = 0;
		int length = N;
		while(length != 0) {
			length /= 2;
			treeHeight++;
		}
		
		int treeSize = (int) Math.pow(2, treeHeight + 1);
		int leefStartIdx = treeSize/2 - 1;
		
		tree = new int[treeSize + 1];
		//최소값 구할 용도이므로 초기에는 Max로 초기화
		Arrays.fill(tree, Integer.MAX_VALUE);	
		
		for(int i=leefStartIdx+1; i<=leefStartIdx+N; i++) {
			tree[i] = kb.nextInt();
		}
		
		//setTree로 부모노드 min으로 세팅 
		setTree(treeSize-1);
		
		//2) 질의 처리 0> 해당 구간에 대한 최소값 반환하도록 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//트리상의 a,b 인덱스 구한 뒤, 그 사이의 min값 도출해내야 됨
			int s = leefStartIdx + a;
			int e = leefStartIdx + b;
			System.out.println(getMin(s, e));
		}
	}
}