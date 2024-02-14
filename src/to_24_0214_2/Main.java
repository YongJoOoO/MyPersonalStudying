package to_24_0214_2;

import java.util.Scanner;

/**
 * 2042번. 구간 합 구하기 3 - 세그먼트 트리 문풀 (RE)
 * @author MYLG
 *
 */
public class Main {
	static long[] tree;
	//setTree
	private static void setTree(int idx) {
		while(idx != 1) {
			tree[idx/2] += tree[idx];//자식노드를 부모노드에 누적합
			idx--;
		}
	}
	//changeVal
	private static void changeVal(long idx, long val) {
		long diff = val - tree[(int) idx];
		while(idx > 0) {
			tree[(int) idx] = tree[(int)idx] +  diff;
			idx /= 2;
		}
	}
	//getpartSum
	private static long getPartSum(long st, long ed) {
		long partSum = 0;
		
		while(st <= ed) {
			if(st % 2 == 1) {
				partSum = partSum + tree[(int) st];
				st++;
			}
			
			if(ed % 2 == 0) {
				partSum = partSum + tree[(int) ed];
				ed--;
			}
			st /= 2;
			ed /= 2;
		}
		return partSum;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		int K = kb.nextInt();
		
		//1) 데이터 초기화하기 
		//(a) 데이터 초기화 - 단말부터
		int treeHeight = 0;
		int arr_length = N;//원본 데이터 크기용 
		while (arr_length != 0) {
			arr_length /= 2;//2로 나눈 횟수를 
			treeHeight++;//담고 
		}
		
		int treeSize = (int) Math.pow(2, treeHeight+1);
		int leefStartIdx = (int) Math.pow(2, treeHeight) -1;//2^k -1 
		
		tree = new long[treeSize + 1];
		
		for(int i=leefStartIdx+1; i<= N + leefStartIdx; i++) {
			tree[i] = kb.nextLong();
		}
		
		//(b) 부모 노드 초기화 
		setTree(treeSize-1);
		
		//2) 질의에 따른 데이터 갱신 or 구간합 구하기 
		for(int i=0; i<M+K; i++) {
			long a = kb.nextLong();
			long b = kb.nextLong();
			long c = kb.nextLong();
			
			if(a == 1) {//데이터 값 변경 
				//트리 상의 b 인덱스 값을 c로 변경 
				changeVal(leefStartIdx + b, c);
				
			}else if(a == 2) {//구간합 
				//트리 상의 b ~ c까지의 구간합 
				System.out.println( getPartSum( b + leefStartIdx, c + leefStartIdx));
			}else {
				return;
			}
		}
	}
}