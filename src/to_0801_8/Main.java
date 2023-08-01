package to_0801_8;
//11052번.카드 구매하기 
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr= new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = kb.nextInt();
		}		
		int[] dy = new int[n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				dy[i] = Math.max(dy[i], arr[j] + dy[i-j]);
			}
		}
		System.out.println(dy[n]);
	}
}