package to_0804_4;

import java.util.Scanner;

//2018 RE
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		
		int st= 1, ed=1;
		int cnt=1, sum=1;
		
		while(ed != N) {
			if(sum == N) {
				cnt++;
				ed++;
				sum += ed;
			}else if(sum > N) {
				sum -= st;
				st++;
			}else if(sum < N) {
				ed++;
				sum += ed;
			}
		}
		System.out.println(cnt);
	}
}