package to_1023_2;

import java.util.Scanner;

/**
 * 2018번. 수들의 합 
 */
public class Main {
	static int N;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();

		int st = 1;
		int ed = 1;
		int cnt = 1;//15만 뽑을 경우 생각
		
		int sum = 1;
		while(ed != N) {
			if(sum == N) { //같은 경우 
				cnt++;
				ed++;
				sum += ed;
			}else if(sum < N) { //작은 경우 
				ed++;
				sum += ed;
			}else if(sum > N) { //큰 경우 
				sum -= st;
				st++;
			}
		}
		
		System.out.println(cnt);
		
	}

}