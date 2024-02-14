package to_24_0214_1;

import java.util.Scanner;

/**
 * 2042번. 구간 합 구하기 - 세그먼트 트리 문풀 
 * @author MYLG
 *
 */
public class Main {
	static long[] tree; //트리용 배열 
	
	//setTree(트리 초기화용)
	private static void setTree(int i) {
		while( i!=1 ) { //1이 아닌 동안 반복 (루트 아닌동안 세팅)
			tree[i/2] += tree[i];//자식노드들 합을 부모에 누적
			i--;
		}
	}
	// changeVal (데이터 변경 질의용)
	private static void changeVal(int idx, long val) {//해당 idx값을 val로 변경
		long diff = val - tree[idx];//차이 구하기 (변경할 값-기존값)
		while(idx > 0) {
			tree[idx] = tree[idx] + diff;//차를 합치는데
			idx = idx/2; //부모노드로 거슬로 올라가면서 갱신처리 
		}
	}
	
	
	//getSum (구간합 질의용)
	private static long getSum(int s, int e) {
		long partSum = 0;
		while(s <= e) {
			if(s % 2 == 1) {
				//현재 노드 선택함 
				partSum = partSum + tree[s];
				s++;//선택하면++
			}
			if(e % 2 == 0) {
				partSum = partSum + tree[e];//선택
				e--;
			}
			//부모로 거슬러 올라감 
			s /= 2;
			e /= 2;
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
		
		int treeHeight = 0; //2^k 구할 용도
		int arr_length = N;//원본 데이터 길이 N
		
		while(arr_length != 0) {
			arr_length /= 2;
			treeHeight++;// 그만큼 ++처리해서 높이 구함 
		}
		//1) 데이터 초기화 (세그먼트 트리 크기 정함)
		int treeSize = (int) Math.pow(2, treeHeight+1);//2^k * 2이니까
		
		//단말노드 시작점 
		int leefNodeStartIdx = treeSize / 2 - 1;
		//OR leefNodeStartIdx = (int) Math.pow(2, treeHeight) -1))
		tree = new long[treeSize];
		//리프노드 시작점부터 처리 
		for(int i=leefNodeStartIdx + 1; i<=leefNodeStartIdx + N; i++) {
			//N개 입력받기 때문
			tree[i] = kb.nextLong();
		}
		
		setTree(treeSize - 1); //끝부터 부모노드도 세팅해줌
		
		//2) 질의에 따른 처리 
		for(int i=0; i<M+K; i++) {
			long a  = kb.nextLong();
			int b = kb.nextInt();
			long c = kb.nextLong();
			
			if(a == 1) {//데이터 변경 질의 
				changeVal(leefNodeStartIdx + b, c);// 기존 트리 idx값을 변경 
			}else if(a == 2) { //구간합 질의
				int s = leefNodeStartIdx + b;
				long e = leefNodeStartIdx + c;
				System.out.println(getSum(s,(int) e));
			}else {
				return;
			}
		}
	}
}