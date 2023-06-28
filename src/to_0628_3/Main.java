package to_0628_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 백준 1516번. 게임 개발하기 
 * */
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		int N = kb.nextInt();
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			A.add(new ArrayList<Integer>());
		}
		
		int[] D = new int[N+1];
		int[] selfBuild = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			int a = kb.nextInt();
			selfBuild[i] = a;//자기 가중치 
			
			while(true) {
				int preTmp = kb.nextInt();
				if(preTmp == -1) break;
				A.get(preTmp).add(i);//현재 애를 향하도록
				D[i]++;
			}
		}

		//위상 정렬
		Queue<Integer> Q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(D[i] == 0) {
				Q.add(i);
			}
		}
		int[] result = new int[N+1];
		while(!Q.isEmpty()) {
			int cur  = Q.poll();
			for(int x : A.get(cur)) {
				D[x]--;
				///시간 업데이트하기
				result[x] = Math.max(result[x], result[cur]+selfBuild[cur]);
				if(D[x]==0) Q.add(x);
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.println(result[i]+selfBuild[i]);
		}
	}

}
