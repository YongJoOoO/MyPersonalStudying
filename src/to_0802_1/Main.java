package to_0802_1;

import java.util.Arrays;
import java.util.Scanner;

//1699번. 제곱수의 합 
public class Main {

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		
		int[] dy = new int[N+1];
		
		Arrays.fill(dy, Integer.MAX_VALUE); //일단 최대값을 세팅해두고 
		dy[0]=0;
		dy[1]=1;
		
		int target = (int) Math.sqrt(N);//목표값 
		
		for(int i=1; i<=target; i++) { //얘로 제곱항 구할 거고 .
			
			for(int j=(i*i); j<=N; j++) { //i제곱 ~ N까지 순회하면서 더 작은 항의 개수 세팅 
				dy[j] = Math.min(dy[j], dy[j - (i*i)] + 1); //더 작은 값으로 세팅 
			}
		}
		System.out.println(dy[N]);		
	}
}