package to_24_0214_5;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 11505번. 구간 곱 구하기 - 세그먼트 트리 문풀
 * @author MYLG
 *
 */
public class Main {	
	static long[] tree;
	static final int MOD = 1000000007;
	
	//changeVal
	private static void changeVal(int idx, long val) {
		tree[idx] = val;//값 갱신
		while(idx > 1) {
			idx /= 2;
			tree[idx] = tree[idx * 2] % MOD * tree[idx * 2 + 1] % MOD;
		}
	}
	
	//setTree
	private static void setTree(int idx) {
		while(idx!=1) {
			tree[idx/2] = tree[idx/2] *tree[idx] % MOD;
			idx--;
		}
	}
	//getMul 구하기 
	private static long getMul(int s, int e) {
		long partMul = 1;
		while(s<=e) {
			if(s % 2 == 1) {
				partMul = partMul * tree[s] % MOD;
				s++;
			}
			if(e % 2 == 0) {
				partMul = partMul * tree[e] % MOD;
				e--;
			}
			s /= 2;
			e /= 2;
		}
		return partMul;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		int K = kb.nextInt();
		
		//1) 데이터 초기화
		int treeHeight = 0;
		int length = N;
		while(length!=0) {
			length/=2;
			treeHeight++;
		}
		
		int treeSize = (int) Math.pow(2, treeHeight+1);
		int leefStartIdx = treeSize/2 - 1;
		tree = new long[treeSize+1];
		//구간곱을 구할 거니까 초기값은 1 갖도록 해두기 
		Arrays.fill(tree, 1);
		
		for(int i= leefStartIdx+1; i<=leefStartIdx+N; i++) {
			tree[i] = kb.nextLong();
		}
		
		setTree(treeSize-1);
		
		//2) 질의 처리하기
		for(int i=0; i<M+K; i++) {
			long a = kb.nextLong();
			int b = kb.nextInt();
			long c = kb.nextLong();
			if(a == 1) {
				//값 변경 
				changeVal((int) b + leefStartIdx, c);
			}else if(a == 2) {
				//구간 곱
				int s = (int) b+ leefStartIdx;
				int e = (int) c+ leefStartIdx;
				System.out.println(getMul(s, e));
			}else {
				return;
			}
		}
	}
	
}