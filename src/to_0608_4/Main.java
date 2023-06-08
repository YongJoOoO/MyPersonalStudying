package to_0608_4;

import java.util.*;

/* 2023번. 신기한 소수 
 * */
public class Main {
	static int N;//소수 
	//DFS
	static void DFS(int v, int lv) {//각 레벨별 자릿수 
		if(lv == N) { //탐색 레벨 종료되면 
			if(isPrime(v)) {
				System.out.println(v);
			}
			return;//없으면 그냥 복귀 
		}
		
		for(int i=1; i<10; i++) {//1~9까지의 값들 중 
			if(i % 2 == 0) {
				continue;// 짟수 제외 
			}
			if(isPrime(v * 10 + i)) {//현재 자릿수 밀고 + 홀수로만 연결해서 
				DFS(v*10+i, lv+1);//다음 자릿수에 대한 레벨로 호출
			}
		}
	}
	//소수 판별
	static boolean isPrime(int num) {
		for(int i=2; i<=num/2; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	//메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();//자릿수 
		
		//각 자릿수가 모두 소수여야 하는데.
		
		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
		
	}

}
