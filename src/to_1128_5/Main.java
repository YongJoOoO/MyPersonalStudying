package to_1128_5;
import java.util.Scanner;

/**
 * 팩토리얼 
 * @author MYLG
 *
 */
public class Main {
	static int answer = 1;
	//DFS - 반환 시점에서 답 구하기 
	static void DFS(int val) {
		if(val == 0) return;
		else {
			//호출 시점 
			DFS(val - 1);
			//반환 시점
			answer *= val;
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		
		DFS(N);
		System.out.println(answer);
	}
}