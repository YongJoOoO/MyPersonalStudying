package to_0728_1;
/*1과 2로 N을 만들 수 있는 방법의 수 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int[] D = new int[N+1];
		
		D[1] = 1;
		D[2] = 2;
		
		for(int i=3; i<=N; i++) {
			D[i] = D[i-1] + D[i-2];
		}
		System.out.println(D[N]);
	}
}