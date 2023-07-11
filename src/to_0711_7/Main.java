package to_0711_7;
/*백준 DP 문젣*/
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] D = new int[11];
		
		D[0] = 0;
		D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		

		int a = 0;
		ArrayList<Integer> answer = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			a = sc.nextInt();
			for(int j = 4; j <= a; j++) {
				D[j] = D[j - 1] + D[j - 2] + D[j - 3];
			}
			answer.add(D[a]);
		}	
		for(int x : answer) System.out.println(x);
	}
}