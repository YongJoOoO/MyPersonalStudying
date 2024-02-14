package to_24_0214_6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 11505번. 구간 곱 구하기 - 세그먼트 문풀 
 * @author MYLG
 *
 */
public class Main {	
	static long[] tree;
	static final int MOD = 1000000007;
	
	//setTree
	private static void setTree(int idx) {
		while(idx != 1) {
			tree[idx/2] = tree[idx/2] * tree[idx] % MOD; 
			idx--;
		}
	}
	//changeVal
	private static void changeVal(int idx, long val) {
		tree[idx] = val;//단말 세팅
		while(idx > 1) {
			idx /= 2;
			tree[idx] = tree[idx*2] % MOD * tree[idx*2+1] % MOD;//왼쪽 오른쪽 자식 곱 갱신철
		}
	}
	//getMul
	private static long getPartMul(int s, int e) {
		long partMul = 1;
		while(s <= e) {
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
		
		//1) 데이터 초기화하기
		int length = N;
		int treeHeight = 0;
		
		while(length != 0) {
			length/=2;
			treeHeight++;
		}
		
		int treeSize = (int) Math.pow(2, treeHeight + 1);
		int leefStartIdx = treeSize/2 - 1;
		
		tree = new long[treeSize+1];
		//tree는 구간곱으로 담을 거라 초기는 1로 세팅 
		Arrays.fill(tree, 1);
		//데이터 입력 
		for(int i= leefStartIdx + 1; i<=leefStartIdx + N; i++) {
			tree[i] = kb.nextLong();
		}
		
		//부모 노드도 구간 곲으로 세팅 
		setTree(treeSize-1);
		
		//2) 데이터 질의처리 
		for(int i=0; i<M+K; i++) {
			long a = kb.nextLong();
			int s = kb.nextInt();
			long e = kb.nextLong();
			
			if(a == 1) {
				changeVal(s+leefStartIdx, e);
			}
			if(a == 2) {
				s += leefStartIdx;
				e += leefStartIdx;
				System.out.println(getPartMul(s, (int)e));
			}
		}
	}
}