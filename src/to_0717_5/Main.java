package to_0717_5;

import java.util.Arrays;
import java.util.Scanner;

/*1253번. 좋은 수 구하기 */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		long[] A = new long[N];
		for(int i=0; i<N; i++) A[i] = kb.nextLong();
		
		Arrays.sort(A);//오름차순 정렬 시켜놓고 
		
		int cnt=0;
		for(int k=0; k<N; k++) {
			long find = A[k];
			int st = 0;
			int ed = N-1;
			while(st < ed) {
				if(A[st] + A[ed] == find) {
					if(st != k && ed !=k ) {
						cnt++;
						break;
					}else if(st == k) {
						st++;
					}else {
						ed--;
					}
				}else if(A[st]+A[ed] < find) {
					st++;
				}else {
					ed--;
				}
			}
		}
		//정답 출력 
		System.out.println(cnt);
	}
}