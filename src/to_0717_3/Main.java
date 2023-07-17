package to_0717_3;

import java.util.Scanner;

/*2018번 수들의 합 */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		
		int st =1, ed =1;
		int sum =1;
		int cnt = 1;
		while(ed != N) {
			if(sum == N) {
				cnt++;
				ed++;
				sum += ed;
			}else if(sum <N) {
				ed++;
				sum += ed;
			}else if(sum > N) {
				sum -= st;
				st++;
			}
		}
		System.out.println(cnt);
	}
}