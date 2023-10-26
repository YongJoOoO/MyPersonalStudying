package to_1026_7;
/*13305번. 다시 풀기 */
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int L[] = new int[N];
		int price[] = new int[N];
		long min = 1000000000;
		long ans = 0;

		for (int i = 0; i < N - 1; i++) {
			L[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			price[i] = sc.nextInt();
		}
		
		for (int i = 0; i < N-1; i++) {
			min = Math.min(min, price[i]);
			ans += min*L[i];
		}
		
		System.out.println(ans);
	}
}