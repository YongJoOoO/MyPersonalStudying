package to_1024_2;

import java.util.*;

/**
 * 2023번. 신기한 소수 문풀 
 * @author MYLG
 *
 */
public class Main {
	static int N;//목표 깊이
	//소수 판별 함수 
	static boolean isPrime(int n) {
		for(int i=2; i<= n/2; i++) {
			//나눠지는 수가 있다면 소수 아님 
			if(n % i == 0) return false;
		}
		return true;
	}
	
	//DFS
	static void DFS(int lv, int num) {
		if(lv == N) {
			if(isPrime(num)) {
				System.out.println(num);
			}
			return;
		}
		for(int i=1; i<10; i++) {
			if(i % 2==0) continue;
			
			if((isPrime(num*10 + i))) {
				DFS(lv+1, num*10+i);
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		
		DFS(1, 2);
		DFS(1, 3);
		DFS(1, 5);
		DFS(1, 7);
	}
}