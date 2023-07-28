package to_0728_8;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt(); //동전 종류 
		int[] arr = new int[N]; //동전 종류 받는 배열 
		for(int i=0; i<N; i++) arr[i] = kb.nextInt();
		
		int M = kb.nextInt(); //총 N원 
		
		int[] dy = new int[M+1];//i원을 거스르는데 사용되는 최소 동전 개수 
		
		//일단 최댁값으로 채워넣기 
		Arrays.fill(dy,  Integer.MAX_VALUE);
		//그래도 dy[0] = 0세팅
		dy[0]= 0;
		
		for(int i=0; i<N; i++) {
			int cur = arr[i];//현재 동전을 기준으로 
			for(int j=cur; j<=M; j++) { //현재 동전부터 M원까지 돌면서 
				dy[j] = Math.min(dy[j], dy[j-cur] + 1);
				//기존 값보다 더 작은 개수 발견 시 갱신
			}
		}
		System.out.println(dy[M]);
	}
}