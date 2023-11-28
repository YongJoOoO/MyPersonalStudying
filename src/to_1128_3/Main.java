package to_1128_3;

/**
 * 재귀함수 이용하여 이진수 출력 
 */
import java.util.Scanner;

public class Main {
	//DFS
	static void DFS(int N) {
		if(N == 0) return;
		else {
			DFS(N/2);//몫으로 계속 가주고 
			
			//반환 시점에서 
			System.out.print(N%2+" ");
		}
		
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		DFS(11);
	}
}