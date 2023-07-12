package to_0712_3;

import java.util.Scanner;

/*11727번. 타일링 2 */
public class Main {
	static final long mod = 10007;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();
		long D[] = new long[1001];//N크기 최댓값에 맞춰서 크기 선언
		
		D[1]=1;
		D[2]=3;
		for(int i=3; i<=n; i++) {
			D[i] = (D[i-1]+ 2 * D[i-2]) % mod;
		}
		System.out.println(D[n]);
	}
}