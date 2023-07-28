package to_0728_9;

import java.util.Arrays;
import java.util.Scanner;

//정수를 1로 만들기 
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner (System.in);
		int N = kb.nextInt(); //목표값 
		int dy[]= new int[N+1];
		
		Arrays.fill(dy, Integer.MAX_VALUE);
		dy[0]= 0;
		dy[1] = 0;
		for(int i=2; i<=N; i++) {
			dy[i]= dy[i-1] + 1;
			if(i% 2==0) {
				dy[i] = Math.min(dy[i], dy[i/2] + 1);
			}else if(i % 3 ==0) {
				dy[i] = Math.min(dy[i], dy[i/3] + 1);
			}
		}
		
	}	

}
